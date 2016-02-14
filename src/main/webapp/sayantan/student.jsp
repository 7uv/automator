<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 14-02-2016
  Time: 05:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Hello World</title>
    <s:head />
</head>
<body>
<s:form action="addStudent">
    <s:textfield name="firstName" label="First Name"/>
    <s:textfield name="lastName" label="Last Name"/>
    <s:textfield name="marks" label="Marks"/>
    <s:submit/>
    <hr/>
    <table>
        <tr>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Marks</td>
        </tr>
        <s:iterator value="students">
            <tr>
                <td><s:property value="firstName"/></td>
                <td><s:property value="lastName"/></td>
                <td><s:property value="marks"/></td>
            </tr>
        </s:iterator>
    </table>
</s:form>
</body>
</html>
