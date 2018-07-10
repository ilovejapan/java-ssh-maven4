package com.adiwood.service.implement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adiwood.dao.DaoTree;
import com.adiwood.entity.Entity;
import com.adiwood.entity.Tmenu;
import com.adiwood.entity.TreeNode;
import com.adiwood.service.ServiceTree;

@Service("TreeService")
public class ServiceTreeImplement implements ServiceTree {
	
	DaoTree td;

	public DaoTree getTd() {
		return td;
	}
	@Autowired
	public void setTd(DaoTree td) {
		this.td = td;
	}

	
	@Override
	public Entity serviceTree(Entity entity) {
		
		System.out.println("ServiceTreeImplement : serviceTree()");
	
		Tmenu tmenu = td.queryTree();
		
		System.out.println("ServiceTreeImplement cid is : " +tmenu.getCid());
		System.out.println("ServiceTreeImplement cname is :" +tmenu.getCname());
		System.out.println("ServiceTreeImplement tmenus are :" +tmenu.getTmenus().size());
		
		TreeNode treeNode = new TreeNode();
		treeNode.setId(tmenu.getCid());
		treeNode.setText(tmenu.getCname());
		treeNode.setIconCls(tmenu.getCiconcls());
		
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("url", tmenu.getCurl());
		treeNode.setAttributes(attributes);
		
		if(tmenu.getTmenus()!=null && tmenu.getTmenus().size()>0){
			treeNode.setState("open");
		}else{
			treeNode.setState("open");
		}
		
		
		/*
		 * The process transfer Tmenus into TreeNodes (set to list)
		 */
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		
		Set<Tmenu> set = tmenu.getTmenus();
		
		/*
		 * Solution 1
		 */
		List<Tmenu> list = new ArrayList<Tmenu>(set);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println("tt 3 cname is " +list.get(i).getCname());
			
			TreeNode node = new TreeNode();
			node.setId(list.get(i).getCid());
			node.setText(list.get(i).getCname());
//			node.setChildren(list.get(i).getTmenus());
			/*
			 * 
			 */
			List<TreeNode> treeNodes2 = new ArrayList<TreeNode>();
			Set<Tmenu> set2 = list.get(i).getTmenus();
			List<Tmenu> list2 = new ArrayList<Tmenu>(set2);
			for (int j = 0; j < list2.size(); j++) {
				TreeNode node2 = new TreeNode();
				node2.setId(list2.get(j).getCid());
				node2.setText(list2.get(j).getCname());
				node2.setIconCls(list2.get(j).getCiconcls());
				
				Map<String, Object> attributes2 = new HashMap<String, Object>();
				attributes2.put("url", list2.get(j).getCurl());
				node2.setAttributes(attributes2);
				
				treeNodes2.add(node2);
			}
			node.setChildren(treeNodes2);
			/*
			 * 
			 */
			
			if(node.getChildren()!=null && node.getChildren().size()>0){
				node.setState("open");
			}else{
				node.setState("open");
			}
			
			treeNodes.add(node);
		}
		/*
		 * The process
		 */
//		for (Tmenu tt : list2) {
//		System.out.println("tt 4 cname" +tt.getCname());// ok
//	}
		
		/*
		 * Solution 2
		 */
//		List<Tmenu> list = new ArrayList<Tmenu>();
//		
//		list.addAll(set);
		
//		for (Tmenu tt : list) {
//			System.out.println("tt cname" +tt.getCname());// ok
//		}
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println("tt 2 cname is " +list.get(i).getCname());
//			
//			TreeNode node = new TreeNode();
//			node.setId(list.get(i).getCid());
//			node.setText(list.get(i).getCname());
//			node.setState("open");
//			
//			treeNodes.add(node);
//		}
		/*
		 * Separator = = = = =
		 */
		
		treeNode.setChildren(treeNodes);
		
		
		List<TreeNode> lists = new ArrayList<TreeNode>();
		lists.add(treeNode);
		
		entity.setObject(lists);
		
		return entity;
	}

}
