package com.sis.test.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

public class CompetitionTest
{
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    @Test
    public void testCompetitionId()
    {
        String title = "Competition Id Test";
        String msg;
        System.out.println(title);
        
        //Create Instance
        Competition competition = new Competition(1L, "name");
        competition.setId(5L);
        Assert.assertEquals(5L, competition.getId().longValue());

        //Null Test
        competition.setId(null);
        Assert.assertNull(competition.getId());

        //Test validations with a value
        competition.setId(null);
        msg = ValidatorHelper.doesErrorExist(competition, "id");
        if(msg != null)
            System.out.println(title + " - annotation message: " + msg);
        else
            Assert.fail(title + " - Unable to find expected error for " + msg);

        //Test validations with a value
        competition.setId(5L);
        msg = ValidatorHelper.doesErrorExist(competition, "id");
        if(msg == null)
            System.out.println(title + " - annotation message: " + msg);
        else
            Assert.fail(title + " - Unable to find expected error for " + msg);
    }

    @Test
    public void testName()
    {
        String title = "Competition Name Test";
        String msg;
        System.out.println(title);

        //Create Instance
        Competition competition = new Competition(1L, "name");
        competition.setName("test1");
        Assert.assertEquals("test1", competition.getName());

        //Null Test
        competition.setName(null);
        Assert.assertEquals(null, competition.getName());

        //Test validations with a value
        competition.setName(null);
        msg = ValidatorHelper.doesErrorExist(competition, "name");
        if(msg != null)
            System.out.println(title + " - annotation message: " + msg);
        else
            Assert.fail(title + " - Unable to find expected error for " + msg);
    }

    @Test
    public void testCreatedDate()
    {
        String title = "Create date Test";
        String msg;
        System.out.println(title);
        Competition competition = new Competition(1L, "name");
        
        //Create date Test
        competition.setCreatedDate(ValidatorHelper.getDateFormat("1-Jan-1945", "dd-MMM-yyyy"));
        Assert.assertEquals(-788922000000L, competition.getCreatedDate().getTime()); //-788922000000L is 1-Jan-1945
        
        //Test Past Date
        competition.setCreatedDate(ValidatorHelper.getDateFormat("1-Jan-1945", "dd-MMM-yyyy"));
        msg = ValidatorHelper.doesErrorExist(competition, "createdDate");
        if(msg != null)
            System.out.println(title + " - annotation message: " + msg);         
        if(msg != null)
            Assert.fail(title + " - Unable to find expected error for " + msg);

        //Test Future Date
        competition.setCreatedDate(ValidatorHelper.getDateFormat("1-Jan-3000", "dd-MMM-yyyy"));
        msg = ValidatorHelper.doesErrorExist(competition, "createdDate");
        if(msg != null)
            System.out.println(title + " - annotation message: " + msg);         
        if(msg == null)
            Assert.fail(title + " - Unable to find expected error for " + msg);
    }
}
