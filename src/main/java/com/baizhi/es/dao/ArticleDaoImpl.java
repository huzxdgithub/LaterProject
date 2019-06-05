package com.baizhi.es.dao;

import com.baizhi.es.entity.User;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
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
import java.util.List;
import java.util.Map;

@Repository
public class ArticleDaoImpl implements  ArticleDAO{
   @Autowired
   private ElasticsearchTemplate elasticsearchTemplate;
   @Override
    public List<User> userSearch(String term) {

        AggregatedPage<User> users = elasticsearchTemplate.queryForPage(
                new NativeSearchQueryBuilder()
                        .withQuery(QueryBuilders.termQuery("content", term))
                        .withFields("content")
                        .withPageable(PageRequest.of(0, 2))
                        .withHighlightFields(new HighlightBuilder.Field("*")
                                .preTags("<span style='color:red'>")
                                .postTags("<span>")
                                .requireFieldMatch(false))
                        .build(), User.class, new SearchResultMapper() {
                    @Override
                    public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                        SearchHits hits = searchResponse.getHits();
                        List<User> list = new ArrayList<User>();

                        for (SearchHit hit : hits) {
                            User user = new User();
                            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                            user.setContent(sourceAsMap.containsKey("content") ? sourceAsMap.get("content").toString() : "");
                            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                            if (sourceAsMap.containsKey("content")) {
                                if (highlightFields.containsKey("content")) {
                                    user.setContent(highlightFields.get("content").getFragments()[0].toString());
                                }
                            }
                            System.out.println(user+"=========");
                            list.add(user);
                        }
                        return new AggregatedPageImpl<T>((List<T>) list);
                    }
                }
        );

        return users.getContent();
    }
}
