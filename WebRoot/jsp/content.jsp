<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<script type="text/javascript">
	$(document).ready(function(){
		
		var index = 0;
		
		$('#tabs').tabs({
			width:200,
			tools:
				[
					{
						iconCls:'icon-add',
						handler:function(node){
							
								index++;
								
								$('#tabs').tabs('add',{
									title:'new tag '+index,
									content:'<p>This is content' +index+ '</p>',
									selected:true,
									closable:true
								});

							
						}
					} 
					,
					{
						iconCls:'icon-remove',
						handler:function(){
							var selected = $('#tabs').tabs('getSelected');
							
							if(selected){
								var index = $('#tabs').tabs('getTabIndex',selected);
								
								$('#tabs').tabs('close',index);
							}
						}
					}
				]
		});
		
		
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
							add();
						}
					}
					 ,
					{
						iconCls:'icon-remove',
						title:'Remove',
						handler:function(){
							/* alert('remove'); */
							remove();
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
					width : 160,
					sortable : true,
				}, {
					title : 'nickname',
					field : 'cname',
					width : 160,
					sortable : true
				} ] ],
				columns : [ [ {
					title : 'password',
					field : 'cpwd',
					width : 160,
					align:'center',
					formatter : function(value, rowData, rowIndex) {
						return '******';
					}
				},{
					title : 'birth-time',
					field : 'ccreatedatetime',
					sortable : true,
					width : 200,
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
					width : 200,
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
		
		function add(){
			$('#dlg').dialog({
				iconCls:'icon-man',
				title:'Create New User',
				width:270,
				height:270,
				closed:false,
				cache:false,
				modal:true,
				padding:10,
				
				toolbar:
					[
						{
							text:'save',
							iconCls:'icon-save',
							handler:function(){
								alert('save');
							}
						}
						,
						{
							text:'remove',
							iconCls:'icon-reload',
							handler:function(){
								alert('remove');
							}
						}
					],
				
				buttons: [{
					text:'Ok',
					iconCls:'icon-ok',
					handler:function(){
						alert('Are you sure to save this ?');
					}
				},
				{
					text:'Cancel',
					handler:function(){
						alert('cancel');;
					}
				}],
				
				onBeforeClose:function(){
					return confirm("Are you sure to leave this window ?");
				}
			});
		}
		
		function remove(){
			$('#removedlg').dialog({
				iconCls:'icon-man',
				title:'Create New User',
				width:270,
				height:270,
				closed:false,
				cache:false,
				modal:true,
				padding:10,
				
				toolbar:
					[
						{
							text:'save',
							iconCls:'icon-save',
							handler:function(){
								alert('save');
							}
						}
						,
						{
							text:'remove',
							iconCls:'icon-reload',
							handler:function(){
								alert('remove');
							}
						}
					],
				
				buttons: [{
					text:'Ok',
					iconCls:'icon-ok',
					handler:function(){
						alert('Are you sure to save this ?');
					}
				},
				{
					text:'Cancel',
					handler:function(){
						alert('cancel');;
					}
				}],
				
				onBeforeClose:function(){
					return confirm("Are you sure to leave this window ?");
				}
			});
		}
	});
</script>

	<div style="margin: 20px 0 10px 0"></div>
	
	<div id="tabs" class="easyui-tabs" data-options="fit:true">
		<div title="Human Resource" style="padding: 10px;">
		
			<div id="dlg" class="easyui-dialog" data-options="closed:true">
			    <form name="f1" id="f1" action="${pageContext.request.contextPath}/UserAction!insert.action" method="post">
			    
			      <table style="margin:0 auto;padding-top:20px">
			        <tr>
			          <td>cid:</td>
			          <td>
			          <input id="cid" name="cid" class="easyui-validatebox textbox" style="width:160px;"
			          data-options="prompt:'Please enter your username',missingMessage:'cid',invalidMessage:'length between 6 to 20',required:true,validType:'length[1,3]'">
			          </td>
			        </tr>
			        <tr>
			          <td>cname:</td>
			          <td>
			          <input id="cname" name="cname" class="easyui-validatebox textbox" style="width:160px;"
			          data-options="prompt:'Please enter your password',missingMessage:'cname',required:true,validType:'length[3,10]'">
			          </td>
			        </tr>
			        <tr>
			          <td>cpwd:</td>
			          <td>
			          <input id="cpwd" name="cpwd" type="password" class="easyui-validatebox textbox" style="width:160px;"
			          data-options="prompt:'Please enter your password',missingMessage:'cpwd',required:true,validType:'length[3,10]'">
			          </td>
			        </tr>
			        <tr><td></td></tr>
			        <tr style="text-align:center;">
			          <td colspan="2"><input type="submit" value="submit"> <input type="submit" value="regist"></td>
			        </tr>
			        <tr>
			          <td colspan="2" align="center">
			          	<label>
			          		${message}
			          	</label>
			          </td>
			        </tr>
			      </table>
			      
			    </form>
			</div>
			
			<div id="removedlg" class="easyui-dialog" data-options="closed:true">
			    <form name="f1" id="f1" action="${pageContext.request.contextPath}/UserAction!delete.action" method="post">
			    
			      <table style="margin:0 auto;padding-top:20px">
			        <tr>
			          <td>cid:</td>
			          <td>
			          <input id="cid" name="cid" class="easyui-validatebox textbox" style="width:160px;"
			          data-options="prompt:'Please enter your username',missingMessage:'cid',invalidMessage:'length between 6 to 20',required:true,validType:'length[1,3]'">
			          </td>
			        </tr>
			        <tr>
			          <td>cname:</td>
			          <td>
			          <input id="cname" name="cname" class="easyui-validatebox textbox" style="width:160px;"
			          data-options="prompt:'Please enter your password',missingMessage:'cname',required:true,validType:'length[3,10]'">
			          </td>
			        </tr>
			        <tr>
			          <td>cpwd:</td>
			          <td>
			          <input id="cpwd" name="cpwd" type="password" class="easyui-validatebox textbox" style="width:160px;"
			          data-options="prompt:'Please enter your password',missingMessage:'cpwd',required:true,validType:'length[3,10]'">
			          </td>
			        </tr>
			        <tr><td></td></tr>
			        <tr style="text-align:center;">
			          <td colspan="2"><input type="submit" value="submit"> <input type="submit" value="regist"></td>
			        </tr>
			        <tr>
			          <td colspan="2" align="center">
			          	<label>
			          		${message}
			          	</label>
			          </td>
			        </tr>
			      </table>
			      
			    </form>
			</div>
		
			<table id="datagrid" class="easyui-datagrid" title="Employee Document" data-options="fit:true,singleSelect:true,collapsible:true,method:'get'">
				<!-- 			
				<thead>
					<tr>
						<th data-options="field:'itemid',width:80,align:'center'">ID</th>
						<th data-options="field:'productid',width:100,align:'center'">Name</th>
						<th data-options="field:'listprice',width:80,align:'center'">Age</th>
						<th data-options="field:'unitcost',width:80,align:'center'">Sex</th>
						<th data-options="field:'attr1',width:250,align:'center'">Department</th>
						<th data-options="field:'status',width:60,align:'center'">Job</th>
					</tr>
				</thead>
				 -->
			</table>
		
		</div>
		
		<div  class="easyui-calendar" data-options="closable:true" title="Department Issues" style="padding: 10px;">
			
		</div>
		
		<div title="Commercial Management" style="padding: 10px;"></div>
	</div>
