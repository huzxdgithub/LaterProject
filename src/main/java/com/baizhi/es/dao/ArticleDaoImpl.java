package com.baizhi.es.dao;

import com.baizhi.entity.Article;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class ArticleDaoImpl implements  ArticleDAO{
   @Autowired
   private ElasticsearchTemplate elasticsearchTemplate;
   @Override
   public List<Article> userSearch(String term) {
       AggregatedPage<Article> users = elasticsearchTemplate.queryForPage(
                new NativeSearchQueryBuilder()
                        .withQuery(QueryBuilders.termQuery("content", term))
                        .withFields("content")
                        .withPageable(PageRequest.of(0, 2))
                        .withHighlightFields(new HighlightBuilder.Field("*")
                                .preTags("<span style='color:red'>")
                                .postTags("<span>")
                                .requireFieldMatch(false))
                        .build(), Article.class, new SearchResultMapper() {
                    @Override
                    public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                        SearchHits hits = searchResponse.getHits();
                        List<Article> list = new ArrayList<Article>();
                        for (SearchHit hit : hits) {
                            Article user = new Article();
                            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                            user.setContent(sourceAsMap.containsKey("content") ? sourceAsMap.get("content").toString() : "");
                            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                            if (sourceAsMap.containsKey("content")) {
                                if (highlightFields.containsKey("content")) {
                                    user.setContent(highlightFields.get("content").getFragments()[0].toString());
                                }
                            }
                            list.add(user);
                        }
                        return new AggregatedPageImpl<T>((List<T>) list);
                    }
                }
        );

        return users.getContent();
    }

    @Override
    public List<Article> searchTileAndContent(String term) {
        AggregatedPage<Article> articles = elasticsearchTemplate.queryForPage(new NativeSearchQueryBuilder()
                //多字段分词查询   根据传过来的词 分词  查询tile 和 content 只要包含分词的 全部返回
                .withQuery(QueryBuilders.queryStringQuery(term).field("title").field("content"))
                //根据日期降序排序
                .withSort(SortBuilders.fieldSort("createDate").order(SortOrder.DESC))
                //高亮    全字段搜索高亮
                .withHighlightFields(new HighlightBuilder.Field("*")
                        //搜索到加前缀
                        .preTags("<span style='color:red'>")
                        //搜索到加后缀
                        .postTags("</span>")
                        //开启多字段的高亮 默认true 为true只能是给某一个字段加高亮
                        .requireFieldMatch(false)
                )
                .build(), Article.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                //获取搜索到的所有值
                SearchHit[] hits = searchResponse.getHits().getHits();
                List<Article> list = new ArrayList<>();
                for (SearchHit hit : hits) {
                    //获取原始map
                    Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                    //获取加完高亮的Map
                    Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                    Article article = new Article();
                    //这里全部判断是为了 防止用户指定只返回某些字段  当作以后的参考模板 这里的业务逻辑 原始Map的没有必要判断
                    //三元运算符 sourceAsMap.containsKey("id")是否存在该key

                    boolean content = highlightFields.get("content") == null || ("").equals(highlightFields.get("content"));
                    article.setId(sourceAsMap.containsKey("id") ? sourceAsMap.get("id").toString() : "")
                            .setTitle(sourceAsMap.containsKey("title") ? sourceAsMap.get("title").toString() : "")
                            .setStatus(sourceAsMap.containsKey("status") ? sourceAsMap.get("status").toString() : "")
                            .setAuthor(sourceAsMap.containsKey("author") ? sourceAsMap.get("author").toString() : "")
                            .setCreateDate(sourceAsMap.containsKey("createDate") ? new Date(Long.valueOf(sourceAsMap.get("createDate").toString())) : null)
                            .setContent(sourceAsMap.containsKey("content") ? sourceAsMap.get("content").toString() : "")
                            .setGuRuId(sourceAsMap.containsKey("guRuId") ? sourceAsMap.get("guRuId").toString() : "")
                            .setTitle(highlightFields.containsKey("title") ? highlightFields.get("title").getFragments()[0].toString() : "")
                            .setContent(!content ? highlightFields.get("content").getFragments()[0].toString() : sourceAsMap.containsKey("content") ? sourceAsMap.get("content").toString() : "");

                    list.add(article);
                    System.out.println(article);
                }
                return new AggregatedPageImpl<T>((List<T>) list);
            }
        });
        return articles.getContent();
    }
}
