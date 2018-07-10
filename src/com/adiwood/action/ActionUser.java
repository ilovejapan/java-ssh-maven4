package com.adiwood.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.SessionAware;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;

import com.adiwood.entity.Entity;
import com.adiwood.entity.Tuser;
import com.adiwood.service.ServiceUser;
import com.alibaba.fastjson.JSONObject;

@ParentPackage("basePackage")
@Namespace("/")
@Action(value="userAction")
public class ActionUser extends ActionBase implements SessionAware {
	
	private static final Logger LOGGER = Logger.getLogger(ActionUser.class);
	
	ServiceUser us;
	private String id;
	private String username;
	private String password;
	Map<String, Object> session;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ServiceUser getUs() {
		return us;
	}
	@Autowired
	public void setUs(ServiceUser us) {
		this.us = us;
	}

	
	public String login() throws IOException, ServletException{
		
		System.out.println("ActionUser : login");
		
//		HttpServletRequest request = ServletActionContext.getRequest();
//		
//		HttpSession session = request.getSession();
//		
//		HttpServletResponse response = ServletActionContext.getResponse();
		
//		String id = request.getParameter("id");
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
		
		Entity entity = new Entity();
		
		Tuser tuser = new Tuser(id, username, password);
		
		entity.setObject(tuser);
		
		entity = us.loginService(entity);
		
//		JSONObject jsonObject = new JSONObject();
		
		writeJson(entity);
		
		if(entity!=null && entity.isFlag()){
//			session.put("user", entity.getObject());
			
//			session.put("flag", true);
			
			session.put("message", entity.getMessage());
			
			
//			session.setAttribute("message", entity.getMessage());
//			response.sendRedirect("login.jsp");
			
			return "success";
		}else{
			
			session.put("message", entity.getMessage());
			
//			session.setAttribute("message", entity.getMessage());
//			request.getRequestDispatcher("error.jsp").forward(request, response);
			
			return "error";
		}
		
//		return "success";
	}
	/*
	 * Note : HttpServlet request&response could using on setAttribute&sendRedirect&getParameter , higher than Struts
	 */
	
	public String save(){
		System.out.println("ActionUser : save ");
		
		Entity entity = new Entity();
		
		Tuser tuser = new Tuser(id, username, password);
		
		entity.setObject(tuser);
		
		us.save(entity);
		
		return "save";
	}
	
	
	@Override
	public void setSession(Map<String, Object> map) {
		
		session = map;
		
	}
	
	
	Tuser tuser;

	public Tuser getTuser() {
		return tuser;
	}
	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}
	
	
	public void datagrid() throws IOException{
		Entity entity = new Entity();
		
		entity = us.serviceTusers();
		
		List<Tuser> list = (List<Tuser>) entity.getObject();
		
//		Tuser t1 = new Tuser("1", "adiwood", "ilovejapan");
//		Tuser t2 = new Tuser("2", "james", "ilovetaiwan");
//		Tuser t3 = new Tuser("3", "joe", "iloveamerica");
//		Tuser t4 = new Tuser("1", UUID.randomUUID().toString(), "ilovejapan");
		
//		list.add(t1);
//		list.add(t2);
//		list.add(t3);

		super.writeJson(list);
	}
	
	
	public String insert(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String cid = request.getParameter("cid");
		String cname = request.getParameter("cname");
		String cpwd = request.getParameter("cpwd");
		
		Tuser tuser = new Tuser(cid, cname, cpwd);
		
		Entity entity = new Entity();
		entity.setObject(tuser);
		
		entity = us.serviceInsert(entity);
		
		return "updated";
	}
	
	
	public String delete(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String cid = request.getParameter("cid");
		String cname = request.getParameter("cname");
		String cpwd = request.getParameter("cpwd");
		
		Tuser tuser = new Tuser(cid, cname, cpwd);
		
		Entity entity = new Entity();
		entity.setObject(tuser);
		
		entity = us.serviceDelete(entity);
		
		return "dismissed";
	}

}
