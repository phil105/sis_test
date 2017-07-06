package com.sis.test.model;

import java.util.List;

public interface TeamInterface extends GenericEntityInterface {
    String getCity();
    void setCity(String city);
    List<Owner> getOwners();
    void setOwners(List<Owner> owners);
    int getStadiumCapacity();
    void setStadiumCapacity(int stadiumCapacity);
    int getNoOfPlayers();
    void setNoOfPlayers(int noOfPlayers);
    List<Competition> getCompetitions();
    void setCompetitions(List<Competition> competitions);
}
