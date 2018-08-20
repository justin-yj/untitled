<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<%@ include file="/static/include/taglib.jsp"%>
<html>
<head>
	<title>会员信息管理</title>
	<meta name="decorator" content="default"/>
	<link rel="shortcut icon" href="favicon.ico">
	<link href="static/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
	<link href="static/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
	<link href="static/css/animate.min.css" rel="stylesheet">
	<link href="static/css/style.min862f.css?v=4.1.0" rel="stylesheet">

	<!--<script src="/static/js/atzhixiao.js"></script>-->

	<script type="text/javascript">

	</script>
</head>
<body class="hideScroll">
		<form id="inputForm" method="post" class="form-horizontal">
		<input type="hidden" name='id' id="id" value=''/>
		<input type="hidden" name='cardId' value=''/>
		<table class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
		   		<tr>
					<td class="width-15 active" colspan="4"><label class="pull-left">会员信息</label></td>
				</tr>
					
					<tr>
						<td class="width-15 active"><label class="pull-right"><font color="red">*</font>姓名：</label></td>
						<td class="width-35">
							<input name="studentName" id="studentName" value="123333"     class="form-control required"/>
							<input type="hidden" name="studentId" id="studentId" value="">
						</td>
						
						<td class="width-15 active"><label class="pull-right"><font color="red">*</font>昵称：</label></td>
						<td class="width-35">
							<input name="nickName" id="nickName"  value="" class="form-control"/>
						</td>
					</tr>
					
					<tr>
						<td class="width-15 active"><label class="pull-right"><font color="red">*</font>性别：</label></td>
						<td class="width-35">
							<select name="sex" class="form-control" id="sex">

							</select>
						</td>
						
						<td class="width-15 active"><label class="pull-right"><font color="red">*</font>出生：</label></td>
						<td class="width-35" > 
						        <input id="brithday" name="brithday" type="text" maxlength="20"  class="laydate-icon form-control layer-date required"
								value="">
						</td>
					</tr>
				

				
					<tr>	
						<td class="width-15 active"><label class="pull-right">

						<font color="red">*</font>起始日：</label></td>
						<td class="width-35">
						        <input name="parentName" id="parentName"  value="123"   class="form-control required"/>
						        <input type="hidden" name="accountId" value="">
						</td>
						
						<td class="width-15 active"><label class="pull-right"><font color="red">*</font>终止日:</label></td>
						<td class="width-35">
							    <input name="mobile"  value=""  readonly="true"  class="form-control required"/>
						</td>
					</tr>
					<tr>	
						<td class="width-15 active"><label class="pull-right"><font color="red">*</font>状态：</label></td>
						<td class="width-35">
							<select name="parentSex" class="form-control">

							</select>
						</td>
						
						<td class="width-15 active"><label class="pull-right"><font color="red">*</font>待定：</label></td>
						<td class="width-35">
							    <input name="relation"  value="" class="form-control required"/>
						</td>
					</tr>

				<!-- <tr>
				    <td colspan="4"><label class="pull-right" onclick="addParent(this);"><i class="fa fa-plus"></i> 添加家长</label></td>
				</tr> -->
				<!--<tr>
					<td class="width-15 active" colspan="4"><label class="pull-left">家庭信息</label></td>
				</tr>-->
				<tr>	
					<td class="width-15 active"><label class="pull-right">地址：</label></td>
					<td class="width-35" colspan="4"> 
						 <input name="address" id="address" value=""  class="form-control"/>
					</td>
				</tr>
		 	</tbody>
		</table>
	</form>
</body>
</html>