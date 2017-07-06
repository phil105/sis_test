package com.sis.test.service;

import com.sis.test.model.Competition;
import com.sis.test.model.Owner;

import java.util.List;

public interface CompetitionService {
    List<Competition> getCompetitions();
    Competition getCompetition(Long Id);
}
