package com.adiwood.dao;

import com.adiwood.entity.Entity;

public interface DaoUser {
	
	Entity query(Entity entity);
	
	Entity save(Entity entity);
	
	Entity queryTusers();
	
	Entity daoInsert(Entity entity);
	
	Entity daoDelete(Entity entity);

}
