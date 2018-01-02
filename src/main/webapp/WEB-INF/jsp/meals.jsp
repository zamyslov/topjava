<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<%--<jsp:include page="fragments/headTag.jsp"/>--%>
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">--%>
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">--%>
<%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css" />--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.13.0/moment.min.js" defer></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"--%>
        <%--defer></script>--%>
<%--<script type="text/javascript" src="resources/js/datatablesUtil.js" defer></script>--%>
<%--<script type="text/javascript" src="resources/js/mealDatatables.js" defer></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>--%>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>--%>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>--%>

<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>--%>
<%--<body>--%>

<%--<html>--%>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css" />

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>

<body>

<%--<jsp:include page="fragments/bodyHeader.jsp"/>--%>

<%--<div class="jumbotron">--%>
    <%--<div class="container">--%>
        <%--<div class="row">--%>
            <%--<h3><spring:message code="meal.title"/></h3>--%>
            <%--<form class="form-horizontal" id="filterForm">--%>
                <%--&lt;%&ndash;<form id = "filterForm">&ndash;%&gt;--%>
                <%--<div class="form-group">--%>
                    <%--<label for="startDate" class="control-label col-xs-2"><spring:message--%>
                            <%--code="meal.startDate"/></label>--%>
                    <%--<div class="col-xs-3">--%>
                        <%--&lt;%&ndash;<input type="date" class="form-control" id="startDate" name="startDate"&ndash;%&gt;--%>
                        <%--<div class='input-group date' id='startDate'>--%>
                            <%--<input type='text' class="form-control"/>--%>
                            <%--<span class="input-group-addon">--%>
                                   <%--<span class="glyphicon glyphicon-calendar"></span>--%>
                        <%--</span>--%>
                        <%--</div>--%>
                        <%--&lt;%&ndash;placeholder="<spring:message code="meal.startDate"/>">&ndash;%&gt;--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="clearfix"></div>--%>
                <%--<div class="form-group">--%>
                    <%--<label for="endDate" class="control-label col-xs-2"><spring:message code="meal.endDate"/></label>--%>
                    <%--<div class="col-xs-3">--%>
                        <%--<input type="date" class="form-control" id="endDate" name="endDate"--%>
                               <%--placeholder="<spring:message code="meal.endDate"/>">--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="clearfix"></div>--%>
                <%--<div class="form-group">--%>
                    <%--<label for="startTime" class="control-label col-xs-2"><spring:message--%>
                            <%--code="meal.startTime"/></label>--%>
                    <%--<div class="col-xs-3">--%>
                        <%--<input type="time" class="form-control" id="startTime" name="startTime"--%>
                               <%--placeholder="<spring:message code="meal.startTime"/>">--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="clearfix"></div>--%>
                <%--<div class="form-group">--%>
                    <%--<label for="endTime" class="control-label col-xs-2"><spring:message code="meal.endTime"/></label>--%>
                    <%--<div class="col-xs-3">--%>
                        <%--<input type="time" class="form-control" id="endTime" name="endTime"--%>
                               <%--placeholder="<spring:message code="meal.endTime"/>">--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="clearfix"></div>--%>
                <%--<hr>--%>
                <%--<a class="btn btn-primary" type="button" onclick="filter()">--%>
                    <%--<span class="glyphicon glyphicon-filter" aria-hidden="true"></span>--%>
                    <%--<spring:message code="meal.filter"/>--%>
                <%--</a>--%>
                <%--<a class="btn btn-primary" type="button" onclick="cleanFilter()">--%>
                    <%--<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>--%>
                    <%--<spring:message code="meal.clean"/>--%>
                <%--</a>--%>
                <%--<hr>--%>
            <%--</form>--%>
            <%--<hr>--%>
            <%--<a class="btn btn-primary" onclick="add()">--%>
                <%--<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>--%>
                <%--<spring:message code="meal.add"/>--%>
            <%--</a>--%>
            <%--&lt;%&ndash;<a href="meals/create"><spring:message code="meal.add"/></a>&ndash;%&gt;--%>
            <%--<hr>--%>
            <%--<table class="table table-striped display" id="datatable">--%>
                <%--<thead>--%>
                <%--<tr>--%>
                    <%--<th><spring:message code="meal.dateTime"/></th>--%>
                    <%--<th><spring:message code="meal.description"/></th>--%>
                    <%--<th><spring:message code="meal.calories"/></th>--%>
                    <%--<th></th>--%>
                    <%--<th></th>--%>
                <%--</tr>--%>
                <%--</thead>--%>
                <%--<c:forEach items="${meals}" var="meal">--%>
                    <%--<jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.to.MealWithExceed"/>--%>
                    <%--<tr id="${meal.id}" class="${meal.exceed ? 'exceeded' : 'normal'}">--%>
                        <%--<td>${fn:formatDateTime(meal.dateTime)}</td>--%>
                        <%--<td>${meal.description}</td>--%>
                        <%--<td>${meal.calories}</td>--%>
                            <%--&lt;%&ndash;<td><a href="meals/update?id=${meal.id}"><spring:message code="common.update"/></a></td>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<td><a href="meals/delete?id=${meal.id}"><spring:message code="common.delete"/></a></td>&ndash;%&gt;--%>
                        <%--<td><a><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>--%>
                        <%--<td><a class="delete"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                <%--</c:forEach>--%>
            <%--</table>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

<div class="container">
    <div class='col-md-5'>
        <div class="form-group">
            <div class='input-group date' id='datetimepicker6'>
                <input type='text' class="form-control" />
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
        $(function () {
            $('#datetimepicker6').datetimepicker();
        });
</script>


<%--<div class="modal fade" id="editRow">--%>
    <%--<div class="modal-dialog">--%>
        <%--<div class="modal-content">--%>
            <%--<div class="modal-header">--%>
                <%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>--%>
                <%--<h2 class="modal-title"><spring:message code="meal.add"/></h2>--%>
            <%--</div>--%>
            <%--<div class="modal-body">--%>
                <%--<form class="form-horizontal" id="detailsForm">--%>
                    <%--<input type="hidden" id="id" name="id">--%>

                    <%--<div class="form-group">--%>
                        <%--<label for="description" class="control-label col-xs-3"><spring:message--%>
                                <%--code="meal.description"/></label>--%>

                        <%--<div class="col-xs-9">--%>
                            <%--<input type="text" class="form-control" id="description" name="description"--%>
                                   <%--placeholder="<spring:message code="meal.description"/>">--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <%--<div class="form-group">--%>
                        <%--<label for="dateTime" class="control-label col-xs-3"><spring:message--%>
                                <%--code="meal.dateTime"/></label>--%>

                        <%--<div class="col-xs-9">--%>
                            <%--<input type="datetime-local" class="form-control" id="dateTime" name="dateTime"--%>
                                   <%--placeholder="<spring:message code="meal.dateTime"/>">--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <%--<div class="form-group">--%>
                        <%--<label for="calories" class="control-label col-xs-3"><spring:message--%>
                                <%--code="meal.calories"/></label>--%>

                        <%--<div class="col-xs-9">--%>
                            <%--<input type="number" class="form-control" id="calories" name="calories"--%>
                                   <%--placeholder="<spring:message code="meal.calories"/>">--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <%--<div class="form-group">--%>
                        <%--<div class="col-xs-offset-3 col-xs-9">--%>
                            <%--<button type="submit" class="btn btn-primary">--%>
                                <%--<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>--%>
                            <%--</button>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</form>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<%--<jsp:include page="fragments/footer.jsp"/>--%>
</body>
</html>