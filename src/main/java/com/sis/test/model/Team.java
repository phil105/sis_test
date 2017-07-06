package com.sis.test.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Team extends GenericEntity implements TeamInterface {

    @NotNull(message="{team.id.notnull}")
    private Long id;

    @NotNull(message="{team.name.notnull}")
    @Length(min = 1, message="{team.name.length}")
    private String name;

    @NotNull(message="{team.city.notnull}")
    @Length(min = 1, message="{team.city.length}")
    private String city;

    private List<Owner> owners = new ArrayList<>();

    @Min(value=1, message="{team.stadiumCapacity.min}")
    @Max(value=200000, message="{team.stadiumCapacity.max}")
    private int stadiumCapacity;

    private List<Competition> competitions = new ArrayList<>();

    @Min(value=7, message="{team.noOfPlayers.min}")
    private int noOfPlayers;

    @Past(message="{team.createdDate.past}")
    private Date createdDate = new Date();

    public Team() {

    }

    public Team(Long id,
                String name,
                String city,
                Owner owner,
                int stadiumCapacity,
                int noOfPlayers,
                Competition competition){
        this.id                 = id;
        this.name               = name;
        this.city               = city;
        if(owner != null)
            this.owners.add(owner);
        this.stadiumCapacity    = stadiumCapacity;
        this.noOfPlayers        = noOfPlayers;
        if(competition != null)
            this.competitions.add(competition);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public List<Owner> getOwners() {
        return owners;
    }

    @Override
    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    @Override
    public int getStadiumCapacity() {
        return stadiumCapacity;
    }

    @Override
    public void setStadiumCapacity(int stadiumCapacity) {
        this.stadiumCapacity = stadiumCapacity;
    }

    @Override
    public int getNoOfPlayers() {
        return noOfPlayers;
    }

    @Override
    public void setNoOfPlayers(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
    }

    @Override
    public List<Competition> getCompetitions() {
        return competitions;
    }

    @Override
    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}

