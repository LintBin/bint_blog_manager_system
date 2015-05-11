<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<h2 class="contentTitle">新增标签 </h2>


<div class="pageContent">
	<form method="post" action="label/addLabel.do" class="pageForm required-validate" onsubmit="return validateCallback(this)">
		<div class="pageFormContent nowrap" layoutH="97">
		<dl>
			<dt>标签名:</dt>
			<dd>
				<input type="text" name="labelName" maxlength="50" class="required" size="100"/>
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
