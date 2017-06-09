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
            <h3>Editing Super #${editTargetSuper.superID} ${editTargetSuper.name}</h3>
            <div class="form-group" name="inputSuper" id="input">
                <form method="GET" action="newSuper">
                    <div class="col-xs-3 form-group">
                        <select class="form-control" name="isHero">
                            <option>Hero</option>
                            <option>Villian</option>
                        </select>
                    </div>
                    <div class="col-xs-6 form-group">
                        <input type="text" class="form-control" name="name" value="${editTargetSuper.name}">
                    </div>
                    <div class="col-xs-4 form-group">
                        <input name="height" type="number" step="1" class="form-control" value="${editTargetSuper.heightMeters}">
                    </div>
                    <div class="col-xs-6">
                        <input name="weight" type="number" step="1" class="form-control" value="${editTargetSuper.weightkilos}">
                        <span class="input-group-addon"><select class="form-control" name="weightUnit">
                                <option>Kilograms</option>
                                <option>Pounds</option>
                            </select>
                        </span>
                    </div>
                    <textarea class="form-control" rows="5" type="text" name="power">${editTargetSuper.power}</textarea>
                    <input name="PL" type="number" step="1" value="${editTargetSuper.powerLevel}">
                    <button class="btn btn-default" type="submit">Submit</button>
                </form>
            </div>
        </div>
        <div class="col-xs-3 body">
            <table>
            <c:forEach var="currentLatest" items="${latestList}">
                <thead>Latest Sightings</thead>
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