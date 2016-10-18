<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="walichin" uri="/struts-tags" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title>New User - Struts/Hibernate</title>
        <walichin:head/>
    </head>
 
    <body>
        <h1><walichin:text name="title" /></h1>
        <walichin:if test="hasActionErrors()">
            <div id="fieldErrors">
                <walichin:actionerror/>
            </div>
        </walichin:if>
        <walichin:form action="testAction" namespace="/" method="get" name="myForm" theme="xhtml">
			<walichin:textfield name="name" size="50" maxlength="100" key="name-label"/>
			<walichin:textfield name="login" size="20" maxlength="8" key="login-label"/>
			<walichin:submit key="submit" />
        </walichin:form>
    </body>
</html>
