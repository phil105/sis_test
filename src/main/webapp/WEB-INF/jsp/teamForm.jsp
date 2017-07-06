<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Team Registration</title>>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
    <div align="center">
        <div class="container">

            <form:form class="form-horizontal" method="post" modelAttribute="teamFormModel" action="/addTeam?${_csrf.parameterName}=${_csrf.token}">

                <form:hidden path="id" />

                <spring:bind path="name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="col-sm-2 control-label">Name</label>
                        <div class="col-sm-10">
                            <form:input path="name" type="text" class="form-control " id="name" placeholder="Name" />
                            <form:errors path="name" />
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="city">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="col-sm-2 control-label">Name</label>
                        <div class="col-sm-10">
                            <form:input path="city" type="text" class="form-control " id="city" placeholder="City" />
                            <form:errors path="city" /></font>
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="stadiumCapacity">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="col-sm-2 control-label">Stadium Capacity</label>
                        <div class="col-sm-10">
                            <form:input path="stadiumCapacity" type="text" class="form-control " id="stadiumCapacity" placeholder="StadiumCapacity" />
                            <FONT color="red"><form:errors path="stadiumCapacity" /></font>
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="owners">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="col-sm-2 control-label">Owners</label>
                        <div class="col-sm-5">

                            <form:select path="owners" class="form-control">
                                <form:option value="NONE" label="--- Select ---" />
                                <form:options items="${ownerList}" itemValue="Id" itemLabel="Name" />
                            </form:select>

                            <FONT color="red"><form:errors path="owners" /></font>
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="competitions">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="col-sm-2 control-label">Competitions</label>
                        <div class="col-sm-5">

                            <form:select path="competitions" class="form-control">
                                <form:option value="NONE" label="--- Select ---" />
                                <form:options items="${competitionList}" itemValue="Id" itemLabel="Name" />
                            </form:select>

                            <FONT color="red"><form:errors path="competitions" /></font>
                        </div>
                    </div>
                </spring:bind>

               <spring:bind path="noOfPlayers">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="col-sm-2 control-label">Number of Players</label>
                        <div class="col-sm-10">
                            <form:input path="noOfPlayers" type="text" class="form-control " id="noOfPlayers" placeholder="noOfPlayers" />
                            <FONT color="red"><form:errors path="noOfPlayers" /></font>
                        </div>
                    </div>
                </spring:bind>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn-lg btn-primary pull-right">Add</button>
                    </div>
                </div>

            </form:form>

        </div>

    </div>
    <script src="resources/js/bootstrap.min.js"></script>
</body>
</html>