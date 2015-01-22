<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<h2 class="contentTitle">添加用户</h2>


<div class="pageContent">
	
	<form method="post" action="addUser.do" class="pageForm required-validate" onsubmit="return validateCallback(this)" >
		<div class="pageFormContent nowrap" layoutH="97">

		<dl>
				<dt>用户名：</dt>
				<dd>
					<input type="text" name="username" maxlength="50" class="required" size="50"/>
				</dd>
		</dl>
		<dl>
				<dt>密码：</dt>
				<dd>
					<input type="password" name="password" maxlength="50" class="required" size="50"/>
				</dd>
		</dl>
		<dl>
				<dt>地址：</dt>
				<dd>
					<input type="text" name="address" maxlength="50" class="required" size="50"/>
				</dd>
		</dl>
		<dl>
				<dt>性别：</dt>
				<select name="gender" class="required combox">
					<option value="">请选择</option>
					<option value="男" selected>男</option>
					<option value="女">女</option>
				</select>
		</dl>
		
		<dl>
		</dl>
			
		<dl>
		</dl>
		
		<dl>
		</dl>
		
		<dl>
		</dl>
		
		<dl>
		</dl>
			
		<dl>
		</dl>
		
		<dl>
		</dl>
		
		<dl>
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
