package com.sis.test.model;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class ConstraintViolationAbstract implements ConstraintViolationInterface
{
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    
    @Override
    public Set<ConstraintViolation<ConstraintViolationInterface>> getConstraintViolations(ConstraintViolationInterface obj) 
    {
        Set<ConstraintViolation<ConstraintViolationInterface>> constraintViolations = validator.validate(obj);
        return constraintViolations;
    }
    
    @Override
    public int getConstraintViolationsCount(ConstraintViolationInterface obj)
    {
        Set<ConstraintViolation<ConstraintViolationInterface>> constraintViolations = validator.validate(obj);
        if(constraintViolations != null)
            return constraintViolations.size();
        else
            return 0;
    }
    
    @Override
    public boolean checkConstraintViolations(ConstraintViolationInterface obj)
    {
        Set<ConstraintViolation<ConstraintViolationInterface>> constraintViolations = validator.validate(obj);
        if(constraintViolations != null && constraintViolations.size() > 0)
            return true;
        else
            return false;
    }    
}