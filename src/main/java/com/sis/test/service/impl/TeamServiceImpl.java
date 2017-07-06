package com.sis.test.service.impl;

import com.sis.test.model.Competition;
import com.sis.test.model.Owner;
import com.sis.test.model.Team;
import com.sis.test.service.CompetitionService;
import com.sis.test.service.OwnerService;
import com.sis.test.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    private List<Team> teamStaticList = new ArrayList<Team>() {
        {
            add(new Team(1L,
                    "Arsenal Football Club",
                    "Highbury, London, England",
                    new Owner(1L, "Stan Kroenke"),
                    80000,
                    65,
                    new Competition(1L, "Premier-league")));

            add(new Team(2L,
                    "Manchester City",
                    "Manchester, England",
                    new Owner(2l, "Uzbek Alisher Usmanov"),
                    55000,
                    87,
                    new Competition(1L, "Premier-league")));
        }
    };
    private List<Team> teams = teamStaticList;

    public List<Team> getTeams() {
        log.debug("TeamService.getTeams()");
        return teams;
    }
}
