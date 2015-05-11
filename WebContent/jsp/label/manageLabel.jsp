<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="label/getList.do">
	<input type="hidden" name="pageNum" value="1">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="size" value="${pageVo.size}" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="label/getList.do" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					标签名：<input type="text" name="labelName" />
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
			<li><a class="add" href="jsp/label/addLabel.jsp" target="navTab"><span>添加</span></a></li>
			<li><a class="delete" href="label/deleteLabel.do?labelId={labelId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="120">编号</th>
				<th >标签名</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${pageVo.list}" varStatus="status">
				<tr target="labelId" rel="${item.id}">
					<td width="120">${item.id}</td>
					<td>${item.labelName} </td>
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
</div>
