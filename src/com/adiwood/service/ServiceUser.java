package com.adiwood.service;

import com.adiwood.entity.Entity;

public interface ServiceUser {
	
	Entity loginService(Entity entity);
	
	Entity save(Entity entity);
	
	Entity serviceTusers();
	
	Entity serviceInsert(Entity entity);
	
	Entity serviceDelete(Entity entity);

}
