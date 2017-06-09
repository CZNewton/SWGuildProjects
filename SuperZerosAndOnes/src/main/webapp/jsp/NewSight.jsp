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
            <form class="form-group" action="newSight">
                <input type="text" name="Address" placeholder="Address of incident">
                <input type="number" step=".01" name="LatitudeDMS" placeholder="Lat Coordinates">
                <select class="selectpicker" name="LatitudeDir">
                    <option>N</option>
                    <option>S</option>
                </select>
                <input type="number" step=".01" name="LongitudeDMS" placeholder="Long Coordinates">
                <select class="selectpicker" name="LongitudeDir">
                    <option>E</option>
                    <option>W</option>
                </select>
                <input type="date" name="sightDate">
                <input type="time" name="sightTime">
                <div class="col-xs-5">
                    <select class="selectpicker form-control" multiple>
                        <c:forEach var="heroOption" items="${optionsSuper}">
                            <option value="${heroOption.name}">${heroOption.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
        <div class="col-xs-3 body">
            <table>
                <thead>
                    <th colspan="3"><h3>Latest Sightings</h3></th>
                </thead>
                <tbody>
            <c:forEach var="currentLatest" items="${latestList}">
                
                    <tr>
                        <th>${currentLatest.address}</th>
                        <!-- time seen-->
                        <th>${currentLatest.supers}</th>
                    </tr>
                
            </c:forEach>
                </tbody>
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
