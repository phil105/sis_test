package com.sis.test.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

public class OwnerTest
{
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    @Test
    public void testOwnerId()
    {
        String title = "Owner Id Test";
        String msg;
        System.out.println(title);
        
        //Create Instance
        Owner owner = new Owner(1L, "name");
        owner.setId(5L);
        Assert.assertEquals(5L, owner.getId().longValue());

        //Null Test
        owner.setId(null);
        Assert.assertNull(owner.getId());

        //Test validations with a value
        owner.setId(null);
        msg = ValidatorHelper.doesErrorExist(owner, "id");
        if(msg != null)
            System.out.println(title + " - annotation message: " + msg);
        else
            Assert.fail(title + " - Unable to find expected error for " + msg);

        //Test validations with a value
        owner.setId(5L);
        msg = ValidatorHelper.doesErrorExist(owner, "id");
        if(msg == null)
            System.out.println(title + " - annotation message: " + msg);
        else
            Assert.fail(title + " - Unable to find expected error for " + msg);
    }

    @Test
    public void testName()
    {
        String title = "Owner Name Test";
        String msg;
        System.out.println(title);

        //Create Instance
        Owner owner = new Owner(1L, "name");
        owner.setName("test1");
        Assert.assertEquals("test1", owner.getName());

        //Null Test
        owner.setName(null);
        Assert.assertEquals(null, owner.getName());

        //Test validations with a value
        owner.setName(null);
        msg = ValidatorHelper.doesErrorExist(owner, "name");
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
        Owner owner = new Owner(1L, "name");
        
        //Create date Test
        owner.setCreatedDate(ValidatorHelper.getDateFormat("1-Jan-1945", "dd-MMM-yyyy"));
        Assert.assertEquals(-788922000000L, owner.getCreatedDate().getTime()); //-788922000000L is 1-Jan-1945
        
        //Test Past Date
        owner.setCreatedDate(ValidatorHelper.getDateFormat("1-Jan-1945", "dd-MMM-yyyy"));
        msg = ValidatorHelper.doesErrorExist(owner, "createdDate");
        if(msg != null)
            System.out.println(title + " - annotation message: " + msg);         
        if(msg != null)
            Assert.fail(title + " - Unable to find expected error for " + msg);

        //Test Future Date
        owner.setCreatedDate(ValidatorHelper.getDateFormat("1-Jan-3000", "dd-MMM-yyyy"));
        msg = ValidatorHelper.doesErrorExist(owner, "createdDate");
        if(msg != null)
            System.out.println(title + " - annotation message: " + msg);         
        if(msg == null)
            Assert.fail(title + " - Unable to find expected error for " + msg);
    }
}
