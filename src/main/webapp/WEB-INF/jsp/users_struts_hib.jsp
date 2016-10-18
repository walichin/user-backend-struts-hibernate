<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Users List</title>
</head>
<body>

	<%@ taglib uri="/struts-tags" prefix="s"%>

	<h3>Users List - Struts/Hibernate</h3>
	<s:iterator value="list">
		<fieldset>
			<s:property value="user_Name" />
			<br />
			<s:property value="user_Login" />
			<br />
		</fieldset>
	</s:iterator>

</body>
</html>
