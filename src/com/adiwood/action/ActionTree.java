package com.adiwood.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.adiwood.entity.Entity;
import com.adiwood.entity.Tmenu;
import com.adiwood.entity.TreeNode;
import com.adiwood.service.ServiceTree;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@ParentPackage("basePackage")
@Namespace("/")
//@Action(value="TreeAction")
public class ActionTree extends ActionBase {
	
	ServiceTree ts;

	public ServiceTree getTs() {
		return ts;
	}
	@Autowired
	public void setTs(ServiceTree ts) {
		this.ts = ts;
	}
	
	
	public void actionTree() throws IOException{
		
		System.out.println("ActionTree : actionTree()");
		
		Entity entity = new Entity();
		entity = ts.serviceTree(entity);
		
//		Tmenu tmenu = (Tmenu) entity.getObject();
//		TreeNode node = (TreeNode) entity.getObject();
		List<TreeNode> list = (List<TreeNode>) entity.getObject();
		
//		System.out.println("ActionTree : tmenu cname is "+tmenu.getCname());
		
		
		/*
		 * Since easyui tree data format is objects in list
		 */
//		List<TreeNode> list = new ArrayList<TreeNode>();
//		
//		list.add(node);
		
		
		/*
		 * It's necessary to write or there would be nothing to show
		 */
		super.writeJson(list);
		
	}

}
