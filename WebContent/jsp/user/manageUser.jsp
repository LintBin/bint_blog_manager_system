  <%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="get" action="getPageUser.do">
	<input type="hidden" name="currentPage" value="${pageVo.currentPage}" />
	<input type="hidden" name="size" value="${pageVo.size}" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="search.do" method="get">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					用户名：<input type="text" name="username" />
				</td>
				<td>
					地址：<input type="text" name="address" />
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
				<li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="jsp/user/addUser.jsp" target="navTab"><span>添加</span></a></li>
			<li><a class="delete" href="deleteUser.do?uid={user_id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="editUser.do?uid={user_id}" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table id="userListTable"  class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="50">编号</th>
				<th width="200">用户名</th>
				<th width="400">密码</th>
				<th width="200">地址</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${pageVo.list}" varStatus="status">
				<tr target="user_id" rel="${item.id}">
					<%-- <td>${status.count}</td> --%>
					<td>${item.id}</td>
					<td>${item.username}</td>
					<td>${item.password}</td>
					<td>${item.address}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="200">200</option>
			</select>
			<span>条，共${pageVo.amount}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="${pageVo.amount}" numPerPage="20" pageNumShown="10" currentPage="${pageVo.currentPage}"></div>
	</div>
	${pageVo.amount}
</div>
