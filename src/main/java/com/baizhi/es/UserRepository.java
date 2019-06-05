package com.baizhi.es;
import com.baizhi.es.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
public interface UserRepository extends ElasticsearchRepository<User,String> {


}
