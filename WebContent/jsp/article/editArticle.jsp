<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

	$(document).ready(function(){
		$("#addLabelBt").click(function(){
			var labelId = $("#labelSelect").val();
			var articleId = $("#articleId").val();
			$.ajax({
			   url: 'article/label/add.do',
			   method:"post",
			   data:{
				   labelId:labelId,
				   articleId:articleId
			   },
			   success:function(result){
				   $("#having-labels").empty();
				   $.each(result.havingLabels,function(n,value) { 
					   $("#having-labels").append('&nbsp;<m>'+ value.labelName +'</m>')
				   });
				   alertMsg.correct('您的数据提交成功!');
			   },
			   error:function(result){
				   alertMsg.error('您提交的数据有误，请检查后重新提交!');
			   }
			});
		});
		
		$("#deleteLabelBt").click(function(){
			var labelId = $("#labelSelect").val();
			var articleId = $("#articleId").val();
			$.ajax({
			   url: 'article/label/delete.do',
			   method:"post",
			   data:{
				   labelId:labelId,
				   articleId:articleId
			   },
			   success:function(result){
				   $("#having-labels").empty();
				   $.each(result.havingLabels,function(n,value) { 
					   $("#having-labels").append('<m>'+ value.labelName +'</m>&nbsp;&nbsp;')
				   });
				   alertMsg.correct('您的数据提交成功!');
			   },
			   error:function(result){
				   alertMsg.error('您提交的数据有误，请检查后重新提交!');
			   }
			});
		});
	});
</script>
<h2 class="contentTitle">新增博客</h2>
<div class="pageContent">
	
	<form method="post" action="updateArticle.do" class="pageForm required-validate" onsubmit="return validateCallback(this)">
		<div class="pageFormContent nowrap" layoutH="97">
		<dl>
				<dt>标题(必填)：</dt>
				<dd>
					<input type="text" name="headline" value="${article.headline}" maxlength="50" class="required" size="100"/>
					<input id="articleId" type="hidden" name="id" value="${article.id}" />
				</dd>
			</dl>
			<dl>
				<dd>
					<dt>作者：</dt>
					<input type="text" name="author"  readonly="readonly" class="required" value="${sessionScope.user.username}" />
				</dd>
			</dl>
			<dl>
				<dt>分类：</dt>
				<dd>
					<select class="combox" name="" ref="w_combox_city" >
						<option value="">请选择分类</option>
						<c:forEach var="item" items="${classificationList}">
                  	 		<option value='<c:out value="${item.id}"/>'><c:out value="${item.classificationName}"/></option>
                  	 	</c:forEach>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>标签：</dt>
				<dd>
					<select id="labelSelect" class="combox required" name="" ref="w_combox_city" >
						<c:forEach var="item" items="${allArticleLabelList}">
                  	 		<option value='<c:out value="${item.id}"/>'><c:out value="${item.labelName}"/></option>
                  	 	</c:forEach>
					</select>
					<a id="addLabelBt" class="button" href="#" ><span>添加标签</span></a>
					<a id="deleteLabelBt" class="button" href="#" ><span>删除标签</span></a>
				</dd>
			</dl>
			<dl>
				<dt>所拥有的标签</dt>
				<dd id="having-labels">
					 <c:forEach var="item" items="${articleLabelList}">
                  	 	<m><c:out value="${item.labelName}"/>&nbsp;&nbsp;</m>
                  	 </c:forEach>
				</dd>
			</dl>
			<dl>
				<dt>摘要：</dt>
				<dd>
					<input type="text" name="digest" value="${article.digest}" size="150"/>
				</dd>
			</dl>
			<dl>
				<dt>文章内容：</dt>
				<dd>
					<textarea class="editor" name="content" rows="20" cols="120"
								upLinkUrl="upload.php" upLinkExt="zip,rar,txt" 
								upImgUrl="uploadImg.do" upImgExt="jpg,jpeg,gif,png" 
								upFlashUrl="upload.php" upFlashExt="swf"
								upMediaUrl="upload.php" upMediaExt:"avi">
									${article.content}
					</textarea>
				</dd>
			</dl>
			
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>

