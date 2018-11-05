package com.backend.api.sample.controllers;

import com.backend.api.sample.model.Topic;
import com.backend.api.sample.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Topic getTopicById(@PathVariable long id) {
        return topicService.getTopicById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void createNewTopic(@RequestBody Topic topic) {
        topicService.createNewTopic(topic);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateTopicById(@PathVariable long id, @RequestBody Topic topic) {
        topicService.updateTopicById(id, topic);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTopicById(@PathVariable Long id) {
        topicService.deleteTopicById(id);
    }
}