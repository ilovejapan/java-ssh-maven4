<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
  <head>
    
    <title>oa</title>
    <jsp:include page="inc.jsp"></jsp:include>
	
  </head>
  
<body>
	<div id="d1" style="width:270px; height:220px; display:none; overflow:hidden;">
		
			<form id="login" method="post">
				
				<table cellspacing="10">
					<tr>
						<th style="text-align: right;">ID</th>
						<td>
							<input name="id" class="easyui-validatebox"
							data-options="required:true,missingMessage:'Enter a id'"
							style="width: 150px;" />
						</td>
					</tr>
					<tr>
						<th style="text-align: right;">USERNAME</th>
						<td>
							<input name="username" class="easyui-validatebox"
							data-options="required:true,missingMessage:'Enter a username'"
							style="width: 150px;" />
						</td>
					</tr>
					<tr>
						<th style="text-align: right;">PASSWORD</th>
						<td>
							<input name="password" type="password"
							class="easyui-validatebox"
							data-options="required:true,missingMessage:'Enter a password'"
							style="width: 150px;" />
						</td>
					</tr>
			        <tr>
			          <td colspan="2" align="center"><input type="submit" value="submit"></td>
			        </tr>
				</table>
				
			</form>
	</div>
	
	
<script>
	$(document).ready(function() {
		$('#d1').show().dialog({
			title : 'Login',
			closed : false,
			cache : false,
			modal : true,
			buttons : [
			{
				text : 'save',
				handler : function() {
					save();
					
					$('#d1').show().dialog({
						closed:true
					});
				}
			},
			{
				text : 'login',
				handler : function() {
					//confirm("Are you sure to quit ?");
					login();
				}
			}
			],
			//onBeforeClose:function(){
				//confirm("Are you sure to close the window ?");
			//}
		});

		function save() {
			$('#login').form('submit', {
			    url:'${pageContext.request.contextPath}/UserAction!save.action',
			    success:function(data){
					//alert(data)
					alert("save.action");
			    }
			});
		}
		
		function login(){
			$('#login').form('submit',{
				url:'${pageContext.request.contextPath}/UserAction!login.action',
				success:function(data){
					//alert(data);
					
					var result = $.parseJSON(data);
					
					if(result.flag){
						$('#d1').dialog('close');
					}
					
					$.messager.progress({
						title:'Progress',
						msg:'Loading please wait ...',
						interval:300
					});
					
					setTimeout(function(){
						$.messager.progress('close');
						
	 					$.messager.show({
						title:'Tips',
						msg:result.message,
						width:270,
						height:120,
						timeout:3000
						});
					}, 3000);
					
				}
			});
		}
		
	
	});
</script>
</body>
  
</html>
