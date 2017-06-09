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
            <div class="form-group">
                <form method="GET" action="SearchSight">
                    <div class="col-xs-2">
                        <select name="searchParam" class="form-control selectpicker" title="Search by...">
                            <option>All</option>
                            <option>Date</option>
                            <option>Address</option>
                            <option>Super</option>
                        </select>
                    </div>
                    <div class="col-xs-4">
                        <input type="text" class="form-control" name="searchValue">
                    </div>
                    <div class="col-xs-4">
                        <button type="submit" class="btn btn-default">Search</button>
                    </div>
                </form>
            </div>
            <br>
            <table class="searchList">
                <thead><h3>Search Results</h3></thead>
            <tr>
                <th><h4>ID#</h4></th>
                <th><h4>ADDRESS</h4></th>
                <th><h4>DATE</h4></th>
            </tr>
            <c:forEach var="SightItem" items="${SightList}">
            
            <tr>
                <th>${SightItem.sightingID}</th>
                <th>${SightItem.address}</th>
                <th>${SightItem.dateSeen}</th>
            <form method="GET" action='editSight'>
                <input type="hidden" name="ID" value="${SightItem.sightingID}">
                <th><button class="btn btn-default">edit</button></th>
            </form>
            <form method="POST" action="removeSight">
                <input type="hidden" name="ID" value="${SightItem.sightingID}">
                <th><button class="btn btn-default">delete</button></th>
            </form>
            </tr>
            </c:forEach>
            </table>
        </div>
        <div class="col-xs-3 body">
            <table>
                <thead><h3>Latest Sightings</h3></thead>
            <c:forEach var="currentLatest" items="${latestList}">
                
                <tr>
                    <th>${currentLatest.address}</th>
                    <!--time seen-->
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