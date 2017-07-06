package com.sis.test.controller;

import com.sis.test.model.Competition;
import com.sis.test.model.Owner;
import com.sis.test.model.Team;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(RestfulController.class)
public class ExampleRestClientTest {

    @MockBean
    private RestfulController restfulController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_getTeamsAsEmptyList() throws Exception {
        when(restfulController.getListOfTeams()).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.get("/getTeams"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string("") );
    }

    @Test
    public void test_getTeams() throws Exception {

        Team team = new Team(1L, "name", "city", new Owner(1L, "Owner1"), 80000, 50, new Competition(1l, "Competition1"));
        team.setCreatedDate(null);
        team.getOwners().get(0).setCreatedDate(null);
        team.getCompetitions().get(0).setCreatedDate(null);
        when(restfulController.getListOfTeams()).thenReturn(Arrays.asList(team));

        mockMvc.perform(MockMvcRequestBuilders.get("/getTeams"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string(
                    containsString("[{\"id\":1,\"name\":\"name\",\"city\":\"city\",\"owners\":[{\"id\":1,\"name\":\"Owner1\",\"createdDate\":null}],\"stadiumCapacity\":80000,\"competitions\":[{\"id\":1,\"name\":\"Competition1\",\"createdDate\":null}],\"noOfPlayers\":50,\"createdDate\":null}]")) );
    }

    @Test
    public void test_getTeamsByStadiumCapacityAsEmptyList() throws Exception {

        when(restfulController.getTeamsByStadiumCapacity()).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/getTeamsByStadiumCapacity"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string("") );
    }

    @Test
    public void test_getTeamsByStadiumCapacity() throws Exception {

        Team team = new Team(1L, "name", "city", new Owner(1L, "Owner1"), 80000, 50, new Competition(1l, "Competition1"));
        team.setCreatedDate(null);
        team.getOwners().get(0).setCreatedDate(null);
        team.getCompetitions().get(0).setCreatedDate(null);
        when(restfulController.getTeamsByStadiumCapacity()).thenReturn(Arrays.asList(team));

        mockMvc.perform(MockMvcRequestBuilders.get("/getTeamsByStadiumCapacity"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string(
                        containsString("[{\"id\":1,\"name\":\"name\",\"city\":\"city\",\"owners\":[{\"id\":1,\"name\":\"Owner1\",\"createdDate\":null}],\"stadiumCapacity\":80000,\"competitions\":[{\"id\":1,\"name\":\"Competition1\",\"createdDate\":null}],\"noOfPlayers\":50,\"createdDate\":null}]")) );
    }


    @Test
    public void test_getTeamDetailsAsEmptyList() throws Exception {

        when(restfulController.getTeamDetails(1L)).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/getTeamDetails")
                .param("id", new Long(1L).toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string("") );
    }

    @Test
    public void test_getTeamDetails() throws Exception {

        Team team = new Team(1L, "name", "city", new Owner(1L, "Owner1"), 80000, 50, new Competition(1l, "Competition1"));
        team.setCreatedDate(null);
        team.getOwners().get(0).setCreatedDate(null);
        team.getCompetitions().get(0).setCreatedDate(null);
        when(restfulController.getTeamDetails(1L)).thenReturn(team);

        mockMvc.perform(MockMvcRequestBuilders.get("/getTeamDetails")
                .param("id", new Long(1L).toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string(
                        containsString("{\"id\":1,\"name\":\"name\",\"city\":\"city\",\"owners\":[{\"id\":1,\"name\":\"Owner1\",\"createdDate\":null}],\"stadiumCapacity\":80000,\"competitions\":[{\"id\":1,\"name\":\"Competition1\",\"createdDate\":null}],\"noOfPlayers\":50,\"createdDate\":null}")) );
    }
}