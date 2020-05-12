<%-- 
    Document   : registerpage.jsp
    Created on : 28-Apr-2020, 8:36:52 AM
    Author     : aerus02
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%--<f:view>--%>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Register</title>
        </head>
        <body>
            <h1>"Welcome to register page"</h1>
            <div>
                <form class="formSubmit" action="register" method="GET">
                <input type="text" name="id" placeholder="id"/>
                <input type="text" name="username" placeholder="username"/>
                <input type="password" name="password" placeholder="password"/>
                
                <button>submit</button>
                
                </form>
            </div>
        </body>
    </html>
<%--</f:view>--%>
