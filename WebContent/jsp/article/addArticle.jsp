<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<h2 class="contentTitle">新增博客</h2>


<div class="pageContent">
	
	<form method="post" action="addArticle.do" class="pageForm required-validate" onsubmit="return validateCallback(this)">
		<div class="pageFormContent nowrap" layoutH="97">

		<dl>
				<dt>标题(必填)：</dt>
				<dd>
					<input type="text" name="headline" maxlength="50" class="required" size="100"/>
				</dd>
			</dl>
			<dl>
				<%-- <dt>作者：</dt>
				<dd>
					<input type="text" name="" class="required" value="${session.user.username}" />
				</dd> --%>
				<dd>
					<dt>作者：</dt>
					<input type="text" name=""  readonly="readonly" class="required" value="${sessionScope.user.username}" />
					<input type="hidden" name="authorId"   value="${sessionScope.user.id}" />
				</dd>
			</dl>
			<dl>
				<dt>分类：</dt>
				<dd>
					<select class="combox required" name="classification" ref="w_combox_city" >
						<option value="">请选择分类</option>
						<option value="all">Java</option>
						<option value="bj">Python</option>
						<option value="sh">生活</option>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>摘要：</dt>
				<dd>
					<input type="text" name="digest" size="150"/>
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
								upLinkUrl="upLinkUrl.php" upLinkExt="zip,rar,txt" 
								upImgUrl="uploadImg.do" upImgExt="jpg,jpeg,gif,png" 
								upFlashUrl="upload.php" upFlashExt="swf"
								upMediaUrl="upMediaUrl.php" upMediaExt:"avi">
										
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


<script type="text/javascript">
function customvalidXxx(element){
	if ($(element).val() == "xxx") return false;
	return true;
}
</script>
