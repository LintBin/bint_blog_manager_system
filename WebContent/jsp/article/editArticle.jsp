<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<h2 class="contentTitle">新增博客</h2>
<div class="pageContent">
	
	<form method="post" action="updateArticle.do" class="pageForm required-validate" onsubmit="return validateCallback(this)">
		<div class="pageFormContent nowrap" layoutH="97">

		<dl>
				<dt>标题(必填)：</dt>
				<dd>
					<input type="text" name="headline" value="${article.headline}" maxlength="50" class="required" size="100"/>
					<input type="hidden" name="articleId" value="${article.id}" />
				</dd>
			</dl>
			<dl>
				<dd>
					<dt>作者：</dt>
					<input type="text" name=""  readonly="readonly" class="required" value="${sessionScope.user.username}" />
					<input type="hidden" name="authorId" value="${sessionScope.user.id}" />
				</dd>
			</dl>
			<dl>
				<dt>分类：</dt>
				<dd>
					<select class="combox required" name="" ref="w_combox_city" >
						<option value="">请选择分类</option>
						<option value="Java">Java</option>
						<option value="Python">Python</option>
						<option value="生活">生活</option>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>摘要：</dt>
				<dd>
					<input type="text" name="digest" value="${article.digest}" size="150"/>
				</dd>
			</dl>
			<dl>
				<dt>标签：</dt>
				<dd>
					<input type="text" name="label" size="150"/>
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

