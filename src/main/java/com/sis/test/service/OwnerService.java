package com.sis.test.service;

import com.sis.test.model.Owner;

import java.util.List;

public interface OwnerService {
    List<Owner> getOwners();
    Owner getOwner(Long Id);
}
