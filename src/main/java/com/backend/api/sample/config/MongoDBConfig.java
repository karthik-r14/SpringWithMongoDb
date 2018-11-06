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
            topicRepository.save(new Topic(1, "Activities", "Its a single screen of user interface"));
            topicRepository.save(new Topic(2, "Services", "Its for long running operations in the background"));
            topicRepository.save(new Topic(3, "Broadcast Receivers", "It is used when you want your app to respond to system defined intents"));
            topicRepository.save(new Topic(4, "Content Providers", "Its used when you want to access the database of another app"));
        };
    }
}
