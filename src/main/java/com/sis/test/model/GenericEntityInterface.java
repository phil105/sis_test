package com.sis.test.model;

import java.io.Serializable;
import java.util.Date;

public interface GenericEntityInterface extends Serializable {
    Long getId();
    void setId(Long id);
    String getName();
    void setName(String name);
    Date getCreatedDate();
    void setCreatedDate(Date createdDate);
}
