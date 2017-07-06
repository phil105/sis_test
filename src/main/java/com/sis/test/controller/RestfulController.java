package com.sis.test.controller;

import com.sis.test.model.Team;
import com.sis.test.service.CompetitionService;
import com.sis.test.service.OwnerService;
import com.sis.test.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class RestfulController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired private TeamService teamService;
	@Autowired private OwnerService ownerService;
	@Autowired private CompetitionService competitionService;

	@RequestMapping(value = "/getTeams", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Team> getListOfTeams() {
		log.debug("RestfulController.getListOfTeams()");
		return teamService.getTeams();
	}

	@RequestMapping(value = "/getTeamsByStadiumCapacity")
	public List<Team> getTeamsByStadiumCapacity() {
		log.debug("RestfulController.getTeamsByStadiumCapacity() - Started");
		List<Team> teams = new ArrayList<>();
		teams.addAll(teamService.getTeams());
		Collections.sort(teams, new Comparator<Team>() {
			@Override
			public int compare(Team team1, Team team2) {
				return Integer.valueOf(team1.getStadiumCapacity()).compareTo(team2.getStadiumCapacity());

			}
		});
		log.debug("RestfulController.getTeamsByStadiumCapacity() - Ended");
		return teams;
	}

	@RequestMapping(value = "/getTeamDetails")
	public Team getTeamDetails(@RequestParam(value = "id",required=false) Long id) {
		log.debug("RestfulController.getTeam() - Started");
		List<Team> teams = teamService.getTeams();
		for(Team team : teams) {
			if(team.getId() == id)
				return team;
		}
		log.debug("RestfulController.getTeam() - Ended");
		return null;
	}


}