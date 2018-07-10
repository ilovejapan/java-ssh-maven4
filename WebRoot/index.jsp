<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
  <head>
    
    <title>oa</title>
    <jsp:include page="inc.jsp"></jsp:include>
	
  </head>
  
  <body class="easyui-layout">
	<div data-options="region:'north',href:'${pageContext.request.contextPath}/jsp/north.jsp'" style="height: 50px;overflow: hidden;" class="logo"></div>
	<div data-options="region:'west',title:'Employee',iconCls:'icon-man',href:'${pageContext.request.contextPath}/jsp/west.jsp'" style="width: 200px;overflow: hidden;"></div>
	<div data-options="region:'east',title:'Help',split:true,iconCls:'icon-help',href:'${pageContext.request.contextPath}/jsp/east.jsp'" style="width: 200px;overflow: hidden;"></div>
	<div data-options="region:'center',title:'Menu',iconCls:'icon-ok',href:'${pageContext.request.contextPath}/jsp/content.jsp'" style="overflow: hidden;"></div>
	<div data-options="region:'south',href:'${pageContext.request.contextPath}/jsp/south.jsp'" style="height: 20px;overflow: hidden;"></div>
	
	<jsp:include page="jsp/login.jsp"></jsp:include><!-- new -->
</body>
  
</html>
