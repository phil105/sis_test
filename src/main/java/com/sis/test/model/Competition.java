package com.sis.test.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

public class Competition extends GenericEntity implements GenericEntityInterface {

    @NotNull(message="{competition.id.notnull}")
    private Long id;

    @NotNull(message="{competition.name.notnull}")
    @Length(min = 1, message="{competition.name.length}")
    private String name;

    @Past(message="{competition.createdDate.past}")
    private Date createdDate = new Date();

    public Competition() {

    }

    public Competition(Long id, String name) {
        this.id   = id;
        this.name = name;
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
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
