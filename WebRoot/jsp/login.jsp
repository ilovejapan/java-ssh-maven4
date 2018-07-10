<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%-- <jsp:include page="../inc.jsp"></jsp:include> --%><!-- new -->
</head>

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
					
// 					$.messager.prompt({
// 						title:'Prompt',
// 						msg:'This is prompt',
// 						fn:function(input){
							
// 							if(input == '123'){
// 								alert('Your message is '+input);
// 							}else{
// 								alert('Nothing');
// 							}
							
// 						}
// 					});
					
// 					$.messager.confirm({
// 						title:'Confirm',
// 						msg:'This is confirm',
// 						fn:function(flag){
// 							if(flag){
// 								alert('Click ok');
// 							}else{
// 								alert('Click no');
// 							}
// 						}
// 					});
					
// 					$.messager.alert({
// 						title:'Alert',
// 						msg:'This is alert',
// 						icon:'info',// info warning question error
// 						fn:function(){
// 							alert('fn');
// 						}
// 					});
					
// 					$.messager.show({
// 						title:'Tips',
// 						msg:result.message,
// 						width:270,
// 						height:120,
// 						timeout:0
// 					});
				}
			});
		}
		
		
/* 		$('#login').form('submit',{
			url:'${pageContext.request.contextPath}/UserAction!login.action',
			onSubmit:function(){
				
			},
			success:function(data){
				
			}
		}); */
	});
</script>

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
</body>
</html>