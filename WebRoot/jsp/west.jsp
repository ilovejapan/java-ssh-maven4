<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 	<script type="text/javascript">
		$(document).ready(function(){
			
			$('#tree').tree({
				onClick:function(node){

					if($('#tabs').tabs('exists',node.text)){
						$('#tabs').tabs('select',node.text);
					}else{
						if(node.attributes.url!=null && node.attributes.url.length>0){
							$('#tabs').tabs('add',{
								title:node.text,
								content:'<iframe src="${pageContext.request.contextPath}'+node.attributes.url+'" frameborder="0" style="border=0;width:100%;height:100%;"></iframe>',
								selected:true,
								closable:true
							});
						}else{
							$('#tabs').tabs('add',{
								title:node.text,
								content:'<p>This is content : ' +node.text+ '</p>',
								selected:true,
								closable:true
							});
						}
					}
					
				},
				onContextMenu:function(e,node){
					e.preventDefault();
					
					$('#tree').tree('select',node.target);
					
					$('#menu').menu('show',{left:e.pageX,top:e.pageY});
				}
			});
			
			
			function append(){
				alert('This is append method');
			}
			
		});
	</script>

	<ul id="tree" class="easyui-tree" style="padding:10px;color:royalblue;" data-options="checkbox:true,onlyLeafCheck:true,lines:true,
	url:'${pageContext.request.contextPath}/TreeAction!actionTree.action'"></ul>
	
		<div id="menu" class="easyui-menu" style="width:120px">
		
			<div onclick="append()" data-options="iconCls:'icon-add'">Append</div>
			<div onclick="remove()" data-options="iconCls:'icon-remove'">Remove</div>
			
		</div>
