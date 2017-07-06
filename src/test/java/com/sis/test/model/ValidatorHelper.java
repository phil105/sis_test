package com.sis.test.model;

import javax.validation.ConstraintViolation;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.fail;

public class ValidatorHelper 
{
    public static String doesErrorExist(ConstraintViolationInterface obj, String propertyPath)
    {
        for (ConstraintViolation<ConstraintViolationInterface> violation : obj.getConstraintViolations(obj))
        {
            String _propertyPath     = violation.getPropertyPath().toString();
            String _messageTemplate = violation.getMessageTemplate();
            if(propertyPath.compareTo(_propertyPath) == 0)
                return violation.getMessage();
        }
        return null;
    }     
   
    public static Field getField(ConstraintViolationInterface obj, String fieldName)
    {   //returns error message if 
        Field[] fields = obj.getClass().getDeclaredFields();        
        for (Field field : fields)
        {
            String test = field.getName();
            if(fieldName.compareToIgnoreCase(field.getName()) == 0)
            {    
                return field; 
            }
        }
        return null;
    }

    public static Date getDateFormat(String dateInString, String dateFormat )
    {
        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
            return formatter.parse(dateInString);
        } 
        catch (ParseException e) 
        {
           fail("Invalid Date Format for " + dateInString + " - " + dateFormat);
           return null;
        }        
    }

}

 
