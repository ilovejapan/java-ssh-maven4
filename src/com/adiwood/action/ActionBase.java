package com.adiwood.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class ActionBase {
	
	public void writeJson(Object objectJson) throws IOException{
		
		String json = JSON.toJSONStringWithDateFormat(objectJson, "yyyy-MM-dd HH:mm:ss");
//		String json2 = JSON.toJSONString(objectJson,SerializerFeature.WriteDateUseDateFormat);
		/*! This json2 could run */
		System.out.println(json);
		
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		ServletActionContext.getResponse().getWriter().flush();
		ServletActionContext.getResponse().getWriter().close();
//		Without this flush & close , it could jump to result in struts
//		However , it couldn't work in browser
	}

}
