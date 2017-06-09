<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Document   : About
    Created on : Mar 23, 2017, 12:22:32 PM
    Author     : Zack
--%>

<html>
    <head>
        <title>The Super Registry - About</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        
    </head>
    <body>
        <jsp:include page="home.jsp"/>
        
        <div class="col-xs-7 body">
            <h3>Editing Organization #${editTargetOrg.orgID}: ${editTargetOrg.name}</h3>
            <div class="form-group">
                <form method="GET" action="newOrg">
                    <div class="col-xs-12">
                        <input name="name" type="text" class="form-control" value="${editTargetOrg.name}">
                    </div>
                    <div class="col-xs-5">
                        <select name="AlignPre" class="selectpicker form-control">
                            <option>Neutral</option>
                            <option>Chaotic</option>
                        </select>
                    </div>
                    <div class="col-xs-5">
                        <select name="AlignAff" class="selectpicker form-control">
                            <option>Good</option>
                            <option>Neutral</option>
                            <option>Evil</option>
                        </select>
                    </div>
                    <textarea name="Descrip" class="form-control">${editTargetOrg.description}</textarea> 
                    <textarea name="Address" class="form-control">"${editTargetOrg.mailingAddress}"</textarea> 
                    <textarea name="HQ" class="form-control">"${editTargetOrg.hqLocation}"</textarea> 
                <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </div>
        
        <div class="col-xs-3 body">
            <table>
                <thead><h3>Latest Sightings</h3></thead>
            <c:forEach var="currentLatest" items="${latestList}">
                
                <tr>
                    <th>${currentLatest.address}</th>
                    <!-- time seen-->
                    <th>${currentLatest.supers}</th>
                </tr>
            </c:forEach>
            </table>
        </div>
        <!--jQuery 2.2.4-->
        <script
        src="https://code.jquery.com/jquery-2.2.4.js"
        integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
        crossorigin="anonymous">
        </script>
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/mainFunction.js">
        </script>
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
        
    </body>
</html>
