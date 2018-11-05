package com.backend.api.sample.config;

import com.backend.api.sample.model.Topic;
import com.backend.api.sample.repositories.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = TopicRepository.class)
@Configuration
public class MongoDBConfig {
    @Bean
    CommandLineRunner commandLineRunner(TopicRepository topicRepository) {
        return strings -> {
            topicRepository.save(new Topic(1, "Activities"));
            topicRepository.save(new Topic(2, "Services"));
            topicRepository.save(new Topic(3, "Broadcast Receivers"));
            topicRepository.save(new Topic(4, "Content Providers"));
        };
    }
}
