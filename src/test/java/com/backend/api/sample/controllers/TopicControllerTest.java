package com.backend.api.sample.controllers;

import com.backend.api.sample.model.Topic;
import com.backend.api.sample.services.TopicService;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
public class TopicControllerTest {

    @Mock
    private TopicService topicService;
    @InjectMocks
    private TopicController topicController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        mockMvc = standaloneSetup(topicController)
                .build();
    }

    @Test
    public void shouldReturnAllTopicsWhenGetAllTopicsIsInvoked() throws Exception {
        ArrayList<Topic> topics = new ArrayList<>();
        Topic topic1 = new Topic(1, "Activities", "Its a single screen of user interface");
        Topic topic2 = new Topic(2, "Services", "Its for long running operations in the background");
        topics.add(topic1);
        topics.add(topic2);

        when(topicService.getAllTopics()).thenReturn(topics);

        mockMvc.perform(get("/topics/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(new Gson().toJson(topics)))
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));

        verify(topicService).getAllTopics();
    }

    @Test
    public void shouldReturnATopicWhenGetTopicByIdIsInvoked() throws Exception {
        long id = 2;
        Topic topic = new Topic(id, "Activities", "Its a single screen of user interface");

        when(topicService.getTopicById(id)).thenReturn(topic);

        mockMvc.perform(get("/topics/" + id))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(new Gson().toJson(topic)))
                .andExpect(jsonPath("$.*", Matchers.hasSize(3)));

        verify(topicService).getTopicById(id);
    }

    @Test
    public void shouldCreateNewTopicWhenCreateATopicIsInvoked() throws Exception {
        long id = 1;
        Topic topic = new Topic(id, "Activities", "Its a single screen of user interface");
        String requestBodyJson = new Gson().toJson(topic);

//        doNothing().when(topicService).createNewTopic(topic);

        mockMvc.perform(post("/topics/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBodyJson))
                .andExpect(status().isOk());

//        verify(topicService).createNewTopic(topic);
    }
}