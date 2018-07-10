package com.adiwood.dao.implement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adiwood.dao.DaoTree;
import com.adiwood.entity.Tmenu;
import com.adiwood.entity.TreeNode;

@Repository("TreeDao")
public class DaoTreeImplement implements DaoTree {
	
	private SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	
	@Override
	public Tmenu queryTree() {
		
		System.out.println("DaoTreeImplement : queryTree()");
			
		String hql = "from Tmenu where cid='0'";
		
		Session session = factory.openSession();
		
		Query query = session.createQuery(hql);
		System.out.println("Tmenu query " +query);
	
		List<Tmenu> list = query.list();
		
		if(list!=null && list.size()>0){
			Tmenu tmenu = list.get(0);
			
			System.err.println("DaoTreeImplement Tmenu cname is " +tmenu.getCname());
			
			return list.get(0);
		}else{
			System.out.println("Tmenu is null !");
			
			return null;
		}
		
	}

}
