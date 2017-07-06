package com.sis.test.service.impl;

import com.sis.test.model.Competition;
import com.sis.test.service.CompetitionService;
import com.sis.test.service.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    Logger log = LoggerFactory.getLogger(this.getClass());

	private List<Competition> competitionsStaticList = new ArrayList<Competition>() {
		{
			add(new Competition(1L, "Premier-league"));
			add(new Competition(2l, "FA-cup"));
		}
	};
	private List<Competition> competitionList = competitionsStaticList;

	public List<Competition> getCompetitions() {
		log.debug("OwnerService.getCompetitions() - started");
		return competitionList;
    }

	public Competition getCompetition(Long Id) {
		log.debug("OwnerService.getCompetition() - started");
		for(Competition competition: competitionList) {
			if(competition.getId().compareTo(Id) ==0)
				return competition;
		}
		return null;
	}
}
