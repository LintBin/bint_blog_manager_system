<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="comment/commentQuery.do">
	<input type="hidden" name="pageNum" value="1">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="size" value="${pageVo.size}" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="comment/commentQuery.do" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					文章标题：<input type="text" name="articleTittle" />
				</td>
				<td>
					用户名：<input type="text" name="username" />
				</td>
				<td>
					评论发布日期：<input type="text" class="date" readonly="true" />
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
			<li><a class="delete" href="comment/deleteComment.do?commentId={commentId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="120">评论编号</th>
				<th>评论内容</th>
				<th width="150">文章标题</th>
				<th width="150">发表人</th>
				<th width="150">发表日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${pageVo.list}" varStatus="status">
				<tr target="commentId" rel="${item.comemntId}">
					<td width="120">${item.comemntId}</td>
					<td>${item.content} </td>
					<td width="150">${item.articleTittle}</td>
					<td width="150">${item.username}</td>
					<td width="150" pattern="11/22/2015">${item.commentTimeStr}</td>
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
