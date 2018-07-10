package com.adiwood.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adiwood.dao.DaoUser;
import com.adiwood.entity.Entity;
import com.adiwood.entity.Tuser;
import com.adiwood.service.ServiceUser;

@Service("UserService")
public class ServiceUserImplement implements ServiceUser {
	
	DaoUser ud;
	
	public DaoUser getUd() {
		return ud;
	}
	@Autowired
	public void setUd(DaoUser ud) {
		this.ud = ud;
	}

	
	@Override
	public Entity loginService(Entity entity) {
		
		System.out.println("ServiceUserImplement : login");
		
		Tuser inputUser = (Tuser) entity.getObject();
		entity.setObject(inputUser);
		
		entity = ud.query(entity);
		
		Tuser outputUser = (Tuser) entity.getObject();
		
		if(outputUser != null){
			if(outputUser.getCpwd() != null && outputUser.getCpwd().equals(inputUser.getCpwd()) ){
				
				entity.setObject(outputUser);
				entity.setFlag(true);
				entity.setMessage("success");
			}else{
				entity.setFlag(false);
				entity.setMessage("password error");
			}
		}else{
			entity.setFlag(false);
			entity.setMessage("account error");
		}
		
		return entity;
	}

	@Override
	public Entity save(Entity entity) {
		
		System.out.println("ServiceUserImplement : save");
		
		ud.save(entity);
		
		return null;
	}
	
	
	@Override
	public Entity serviceTusers() {
		
		System.out.println("ServiceUserImplement : serviceTusers");
		
		return ud.queryTusers();
	}
	
	
	@Override
	public Entity serviceInsert(Entity entity) {
		
		Tuser tuser = (Tuser) entity.getObject();
		System.out.println("serviceInsert : tuser cid is " +tuser.getCid());
		
		entity.setObject(tuser);
		
		ud.daoInsert(entity);
		
		return null;
	}
	
	
	@Override
	public Entity serviceDelete(Entity entity) {
		
		Tuser tuser = (Tuser) entity.getObject();
		System.out.println("serviceDelete : tuser cid is " +tuser.getCid());
		
		entity.setObject(tuser);
		
		ud.daoDelete(entity);
		
		return null;
	}

}
