package com.sis.test.model;

import org.junit.Assert;
import org.junit.Test;
import org.apache.commons.lang3.RandomStringUtils;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

public class TeamTest
{
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    @Test
    public void testTeamId()
    {
        String title = "Team Id Test";
        String msg;
        System.out.println(title);
        
        //Create Instance
        Team team = new Team(1L, "name", "city", null, 80000, 50, null);
        team.setId(5L);
        Assert.assertEquals(5L, team.getId().longValue());

        //Null Test
        team.setId(null);
        Assert.assertNull(team.getId());

        //Test validations with a value
        team.setId(null);
        msg = ValidatorHelper.doesErrorExist(team, "id");
        if(msg != null)
            System.out.println(title + " - annotation message: " + msg);
        else
            Assert.fail(title + " - Unable to find expected error for " + msg);

        //Test validations with a value
        team.setId(5L);
        msg = ValidatorHelper.doesErrorExist(team, "id");
        if(msg == null)
            System.out.println(title + " - annotation message: " + msg);
        else
            Assert.fail(title + " - Unable to find expected error for " + msg);
    }

    @Test
    public void testName()
    {
        String title = "Team Name Test";
        String msg;
        System.out.println(title);

        //Create Instance
        Team team = new Team(1L, "name", "city", null, 80000, 50, null);
        team.setName("test1");
        Assert.assertEquals("test1", team.getName());

        //Null Test
        team.setName(null);
        Assert.assertEquals(null, team.getName());

        //Test validations with a value
        team.setName(null);
        msg = ValidatorHelper.doesErrorExist(team, "name");
        if(msg != null)
            System.out.println(title + " - annotation message: " + msg);
        else
            Assert.fail(title + " - Unable to find expected error for " + msg);
    }

    @Test
    public void testCity()
    {
        String title = "Team city Test";
        String msg;
        System.out.println(title);

        //Create Instance
        Team team = new Team(1L, "name", "city", null, 80000, 50, null);
        team.setCity("test1");
        Assert.assertEquals("test1", team.getCity());

        //Null Test
        team.setCity(null);
        Assert.assertEquals(null, team.getCity());

        //Test validations with a value
        team.setCity(null);
        msg = ValidatorHelper.doesErrorExist(team, "city");
        if(msg != null)
            System.out.println(title + " - annotation message: " + msg);
        else
            Assert.fail(title + " - Unable to find expected error for " + msg);
    }

    @Test
    public void testOwner()
    {
        String title = "Team owner Test";
        String msg;
        System.out.println(title);

        //Create Instance
        Team team = new Team(1L, "name", "city", null, 80000, 50, null);
        Owner owner = new Owner(1L, "Owner");

        //Test empty array
        Assert.assertEquals(0, team.getOwners().size());

        owner.setName("owner");
        team.getOwners().add(owner);
        Assert.assertEquals(1, team.getOwners().size());
    }

    @Test
    public void testStadiumCapacity()
    {
        String title = "Stadium Capacity Tests";
        String msg;
        System.out.println(title);
        Team team = new Team(1L, "name", "city", null, 80000, 50, null);
        
        //positive Age Test
        team.setStadiumCapacity(80000);
        Assert.assertEquals(80000, team.getStadiumCapacity());
        
        //negative Stadium Capacity Test - should fail with message
        team.setStadiumCapacity(-10);
        msg = ValidatorHelper.doesErrorExist(team, "stadiumCapacity");
        if(msg != null)
            System.out.println(title + " - annotation message: " + msg);         
        else
            Assert.fail(title + " - Unable to find expected error for " + msg);
        
        //positive Stadium Capacity Test - should fail with message
        team.setStadiumCapacity(80000);
        msg = ValidatorHelper.doesErrorExist(team, "stadiumCapacity");
        if(msg == null)
            System.out.println(title + " - annotation message: " + msg);         
        else
            Assert.fail(title + " - Unable to find expected error for " + msg);

        //out of range Stadium Capacity Test - should fail with message
        team.setStadiumCapacity(999999999);
        msg = ValidatorHelper.doesErrorExist(team, "stadiumCapacity");
        if(msg != null)
            System.out.println(title + " - annotation message: " + msg);
        else
            Assert.fail(title + " - Unable to find expected error for " + msg);

    }

    @Test
    public void testCompetition()
    {
        String title = "Team competition Test";
        String msg;
        System.out.println(title);

        //Create Instance
        Team team = new Team(1L, "name", "city", null, 80000, 50, null);
        Competition competition = new Competition(1L, "Competition");

        //Test empty array
        Assert.assertEquals(0, team.getOwners().size());

        competition.setName("competition");
        team.getCompetitions().add(competition);
        Assert.assertEquals(1, team.getCompetitions().size());
    }

    @Test
    public void testCreatedDate()
    {
        String title = "Create date Test";
        String msg;
        System.out.println(title);
        Team team = new Team(1L, "name", "city", null, 80000, 50, null);
        
        //Create date Test
        team.setCreatedDate(ValidatorHelper.getDateFormat("1-Jan-1945", "dd-MMM-yyyy"));
        Assert.assertEquals(-788922000000L, team.getCreatedDate().getTime()); //-788922000000L is 1-Jan-1945
        
        //Test Past Date
        team.setCreatedDate(ValidatorHelper.getDateFormat("1-Jan-1945", "dd-MMM-yyyy"));
        msg = ValidatorHelper.doesErrorExist(team, "createdDate");
        if(msg != null)
            System.out.println(title + " - annotation message: " + msg);         
        if(msg != null)
            Assert.fail(title + " - Unable to find expected error for " + msg);

        //Test Future Date
        team.setCreatedDate(ValidatorHelper.getDateFormat("1-Jan-3000", "dd-MMM-yyyy"));
        msg = ValidatorHelper.doesErrorExist(team, "createdDate");
        if(msg != null)
            System.out.println(title + " - annotation message: " + msg);         
        if(msg == null)
            Assert.fail(title + " - Unable to find expected error for " + msg);
    }
}
