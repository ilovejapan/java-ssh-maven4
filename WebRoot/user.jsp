<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <jsp:include page="../inc.jsp"></jsp:include>
    
    <script type="text/javascript" charset="utf-8">
    	$(document).ready(function(){
    		
			$('#datagrid').datagrid({
				url : '${pageContext.request.contextPath}/UserAction!datagrid.action',
				iconCls : 'icon-save',
				pageSize : 10,
				pageList : [ 10, 20, 30, 40 ],
				fit:true,
				striped:true,
				nowrap:true,
				pagination:true,
				rownumbers:true,
				checkOnSelect:true,
				selectOnCheck:true,
				pagePosition:"bottom",
				pageNumber:1,
				toolbar:
					[
						 {
							iconCls:'icon-edit',
							title:'Edit',
							handler:function(){
								alert('edit');
							}
						}
						 ,
						{
							iconCls:'icon-add',
							title:'Add',
							handler:function(){
								/* add(); */
							}
						}
						 ,
						{
							iconCls:'icon-remove',
							title:'Remove',
							handler:function(){
								alert('remove');
							}
						}
						 ,
						{
							iconCls:'icon-reload',
							title:'Refresh',
							handler:function(){
								
							}
						}
					],
					frozenColumns : [ [ {
						checkbox : true,
						title : '',
						field : ''
					},{
						title : 'username',
						field : 'cid',
						width : 120,
						sortable : true,
					}, {
						title : 'nickname',
						field : 'cname',
						width : 120,
						sortable : true
					} ] ],
					columns : [ [ {
						title : 'password',
						field : 'cpwd',
						width : 50,
						align:'center',
						formatter : function(value, rowData, rowIndex) {
							return '******';
						}
					},{
						title : 'birth-time',
						field : 'ccreatedatetime',
						sortable : true,
						width : 150,
						align:'center'
					},{
						title : 'new account',
						field : 'ccreateid',
						sortable : true,
						width : 150,
						align:'center',
						hidden : true
					},{
						title : 'last modified',
						field : 'cmodifydatetime',
						sortable : true,
						width : 150,
						align:'center'
					},{
						title : 'edit account',
						field : 'cmodifyid',
						sortable : true,
						width : 150,
						align:'center',
						hidden : true
					} ] ]
			});
    	});
	</script>

  </head>
  
  <body class="easyui-layout" data-options="fit:true">
  	<div data-options="region:'center',border:false" style="overflow: hidden;">
  	
		<table id="datagrid" class="easyui-datagrid" title="Employee Document" data-options="fit:true,singleSelect:true,collapsible:true,method:'get'">
		</table>
		
	</div>
  </body>
</html>
