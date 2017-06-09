<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Document   : home
    Created on : Mar 23, 2017, 12:22:32 PM
    Author     : Zack
--%>

<html>
    <head>
        <title>The Super Registry</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" id="About" href="About">H.E.R.O</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a id="newSight" label="newSight" href="NavSight">New Sighting</a></li>
                    <li class="active"><a id="newSuper" label="newSuper" href="NavSup">Register a Super</a></li>
                    <li class="active"><a id="newOrg" label="newOrg" href="NavOrg">Register an Organization</a></li>
                </ul>
                <form class="navbar-form navbar-right" method="GET" action="SearchDir">
                    <div class="form-group">
                        <select name="searchParam" id="searchParam" class="form-control">
                            <option>Sightings</option>
                            <option>Organizations</option>
                            <option>Super</option>
                        </select>  
                        <button id="search" type="submit" class="btn btn-default">Search!</button>
                    </div>
                </form>
            </div>
        </nav>
        
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
