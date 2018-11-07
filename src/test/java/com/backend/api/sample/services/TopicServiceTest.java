package com.backend.api.sample.services;

import com.backend.api.sample.model.Topic;
import com.backend.api.sample.repositories.TopicRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class TopicServiceTest {

    @Mock
    private TopicRepository topicRepository;
    @InjectMocks
    private TopicService topicService;

    @Test
    public void shouldReturnAllTopicsWhenGetAllTopicsIsInvoked()throws Exception {
        ArrayList<Topic> topics = new ArrayList<>();
        Topic topic1 = new Topic(1, "Activities", "Its a single screen of user interface");
        Topic topic2 = new Topic(2, "Services", "Its for long running operations in the background");
        topics.add(topic1);
        topics.add(topic2);

        when(topicRepository.findAll()).thenReturn(topics);

        topicService.getAllTopics();

        verify(topicRepository).findAll();
    }

    @Test
    public void shouldReturnATopicWhenGetTopicByIdIsInvoked() throws Exception {
        ArrayList<Topic> topics = new ArrayList<>();
        long id1 = 1;
        long id2 = 2;
        Topic topic1 = new Topic(id1, "Activities", "Its a single screen of user interface");
        Topic topic2 = new Topic(id2, "Services", "Its for long running operations in the background");
        topics.add(topic1);
        topics.add(topic2);

        when(topicRepository.findById(id1)).thenReturn(java.util.Optional.ofNullable(topic1));

        topicService.getTopicById(id1);

        verify(topicRepository).findById(id1);
    }

    @Test
    public void shouldCreateNewTopicWhenCreateNewTopicIsInInvoked() throws Exception{
        long id1 = 1;
        Topic topic1 = new Topic(id1, "Activities", "Its a single screen of user interface");

        when(topicRepository.save(topic1)).thenReturn(null);

        topicService.createNewTopic(topic1);

        verify(topicRepository).save(topic1);
    }

    @Test
    public void shouldUpdateATopicByIdWhenUpdateMethodIsInvoked() throws Exception {
        long id1 = 1;
        Topic topic1 = new Topic(id1, "Activities", "Its a single screen of user interface");

        when(topicRepository.save(topic1)).thenReturn(null);

        topicService.updateTopicById(id1, topic1);

        verify(topicRepository).save(topic1);
    }

    @Test
    public void shouldDeleteATopicWhenDeleteTopicsByIdIsInvoked() throws Exception{
        ArrayList<Topic> topics = new ArrayList<>();
        long id1 = 1;
        long id2 = 2;
        Topic topic1 = new Topic(id1, "Activities", "Its a single screen of user interface");
        Topic topic2 = new Topic(id2, "Services", "Its for long running operations in the background");
        topics.add(topic1);
        topics.add(topic2);

        topicService.deleteTopicById(id1);

        verify(topicRepository).deleteById(id1);

    }
}