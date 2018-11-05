package com.backend.api.sample.repositories;

import com.backend.api.sample.model.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TopicRepository extends MongoRepository<Topic, Long> {


}
