package com.adiwood.dao.implement;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.adiwood.dao.DaoUser;
import com.adiwood.entity.Entity;
import com.adiwood.entity.Tuser;

@Repository("UserDao")// Repository is same with Service
public class DaoUserImplement implements DaoUser {
	
	private SessionFactory factory;
	
	public SessionFactory getFactory() {
		return factory;
	}
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	
	@Override
	public Entity query(Entity entity) {
		
		System.out.println("DaoUserImplement : login");
		
		Tuser inputUser = (Tuser) entity.getObject();
		
		String id = inputUser.getCid();
		
		String hql = "from Tuser where cid ='"+id+"'";
		System.out.println(hql);
		
		Session session = factory.openSession();
		
//		org.hibernate.Query query = factory.getCurrentSession().createQuery(hql);
		org.hibernate.Query query = session.createQuery(hql);
		System.out.println(query);
		
		List<Tuser> list = query.list();
		System.out.println("user list "+list);
		
		Tuser outputUser = null;
		
		if(list.size() > 0){
			outputUser = list.get(0);
			
			System.out.println("output user "+outputUser);
		}
		
		entity.setObject(outputUser);
		
		return entity;
	}

	@Override
	public Entity save(Entity entity) {
		
		System.out.println("DaoUserImplement : save");
		
		Tuser tuser = (Tuser) entity.getObject();
		
		factory.getCurrentSession().save(tuser);
		
		return null;
	}
	
	
	@Override
	public Entity queryTusers() {
		
		System.out.println("DaoUserImplement : queryTusers");
		
		String hql = "from Tuser";
		System.out.println("hql : " +hql);
		
		Session session = factory.openSession();
		
		org.hibernate.Query query = session.createQuery(hql);
		System.out.println("query : " +query);
		
		List<Tuser> list = query.list();
		
		Entity entity = new Entity();
		entity.setObject(list);
		
		return entity;
	}
	
	
	@Override
	public Entity daoInsert(Entity entity) {
		
		Tuser tuser = (Tuser) entity.getObject();
		System.out.println("daoInsert : tuser cid is " +tuser.getCid());
		
		String cid = tuser.getCid();
		String cname = tuser.getCname();
		String cpwd = tuser.getCpwd();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
//		String hql = "insert into Tuser(cid,cname,cpwd) values ('"+cid+"','"+cname+",'"+cpwd+")";
		Tuser tuser2 = new Tuser(cid, cname, cpwd);
		
		session.save(tuser2);
//		session.saveOrUpdate(tuser2);
		
		transaction.commit();
		
		session.close();
		
		return null;
	}
	
	
	@Override
	public Entity daoDelete(Entity entity) {
		
		Tuser tuser = (Tuser) entity.getObject();
		System.out.println("daoDelete : tuser cid is " +tuser.getCid());
		
		String cid = tuser.getCid();
		String cname = tuser.getCname();
		String cpwd = tuser.getCpwd();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Tuser tuser2 = new Tuser(cid, cname, cpwd);
		
		session.delete(tuser2);
		
		transaction.commit();
		
		session.close();
		
		return null;
	}

}
