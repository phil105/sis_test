package com.sis.test.service.impl;

import com.sis.test.model.Owner;
import com.sis.test.model.Team;
import com.sis.test.service.OwnerService;
import com.sis.test.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    Logger log = LoggerFactory.getLogger(this.getClass());

	private List<Owner> ownerStaticList = new ArrayList<Owner>() {
		{
			add(new Owner(new Long(1L), "Stan Kroenke"));
			add(new Owner(new Long(2l), "Uzbek Alisher Usmanov"));
		}
	};
	private List<Owner> ownerList = ownerStaticList;

	public List<Owner> getOwners() {
		log.debug("OwnerService.getOwners() - started");
		return ownerList;
	}

	public Owner getOwner(Long Id) {
		log.debug("OwnerService.getOwner() - started");
		for(Owner owner: ownerList) {
			if(owner.getId().compareTo(Id) ==0)
				return owner;
		}
		return null;
	}
}
