<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="getPageArticle.do">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="currentPage" value="1" />
	<input type="hidden" name="size" value="${pageVo.size}" />
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="queryArticle.do" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					文章标题：<input type="text" name="headline" />
				</td>
				<td>
					概要：<input type="text" name="digest" />
				</td>
				<td>
					发布日期：<input type="text" class="date" readonly="true" />
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
			<li><a class="add" href="jsp/article/addArticle.jsp" target="navTab"><span>添加</span></a></li>
			<li><a class="delete" href="deleteArticle.do?articleId={articleId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="editArtcle.do?articleId={articleId}" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="120">编号</th>
				<th width="150">文章标题</th>
				<th>摘要</th>
				<th width="150">文章上传日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${pageVo.list}" varStatus="status">
				<tr target="articleId" rel="${item.articleId}">
					<%-- <td>${item.id} </td> --%>
					<%-- <td width="120">${status.count}</td> --%>
					<td width="120">${item.articleId}</td>
					<td width="150">${item.headline}</td>
					<td>${item.digest}</td>
					<td width="150" pattern="11/22/2015">${item.time}</td>
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
