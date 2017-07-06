package com.sis.test.model;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ConstraintViolationInterface
{       
    Set<ConstraintViolation<ConstraintViolationInterface>> getConstraintViolations(ConstraintViolationInterface obj);
    int getConstraintViolationsCount(ConstraintViolationInterface obj);
    boolean checkConstraintViolations(ConstraintViolationInterface obj);
}