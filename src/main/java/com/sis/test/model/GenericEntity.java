package com.sis.test.model;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

public class GenericEntity extends ConstraintViolationAbstract implements Serializable
{
    public static String RESOURCE_BUNDLE_NAME = "validationMessages";
    private final ResourceBundle labelResourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, Locale.getDefault());
}


