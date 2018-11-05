package com.backend.api.sample.services;

import com.backend.api.sample.model.Topic;
import com.backend.api.sample.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    private TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Topic getTopicById(long id) {
        return topicRepository.findById(id).orElse(null);
    }

    public void createNewTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopicById(long id, Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopicById(Long id) {
        topicRepository.deleteById(id);
    }
}

