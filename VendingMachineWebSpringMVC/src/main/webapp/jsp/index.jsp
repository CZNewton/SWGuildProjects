<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Vending Machine</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="newcss.css" type="text/css">

    </head>
    <body>
        <div class="PageHeader">
            <h1>Vending Machine</h1>
            <h4>Come get some!</h4>
        </div>
        <hr>
        <div id="items" class="col-xs-8">
            <form method="GET" action="buyItem">
                <c:forEach var="currentItem" items="${inventory}">
                    <div class="item" role="button">
                        <button class="btn btn-default" type ="submit" name="itemName" value="${currentItem.name}">
                            ${currentItem.name}
                        </button>
                        <div class="itemName">
                            ${currentItem.price}
                        </div>
                        <div class="itemQuant">
                            ${currentItem.quantity}
                        </div>
                    </div>
                </c:forEach>
            </form>
        </div>
        
        <div id="menu" class="col-xs-4">
            <div id="moneyTile">
                <div class="sub-header">Total $</div>
                <div id="currentMoney" class="display">
                    $<c:out value="${money}"/>
                </div>
                <form method="POST" action="addMuns">
                    <button id="inDollar" class="coinTile" name="coin" value="dollar">Add Dollar</button>      <!--Needs padding or forced even spacing-->
                    <button id="inQuarter" class="coinTile" name="coin" value="quarter">Add Quarter</button>
                    <button id="inDime" class="coinTile" name="coin" value="dime">Add Dime</button>
                    <button id="inNickel" class="coinTile" name="coin" value="nickel">Add Nickel</button>
                </form>
            </div>
            <div id="logTile">
                <hr>
                <div class="sub-header">Messages</div>
                <div id="currentMessage" class="display"><c:out value="${message}"/></div> <!--needs to be able to display if more money is needed-->
                <div class="sub-header">Item: </div><div id="currentItem" class="display"></div>
                <button id="orderTile">Make Purchase</button>
            </div>
            <div id="changeGroup">
                <hr>
                <div class="sub-header">Change</div>
                <div id="currentChange" class="display">Quarters:<c:out value="${change.quarters}"/> Dimes:<c:out value="${change.dimes}"/> Nickels:<c:out value="${change.nickels}"/> Pennies:<c:out value="${change.pennies}"/></div>
                <form method="GET" action="dispenseChange">
                    <button id="changeTile">Change Return</button> <!--needs to be shown only when change is possible-->
                </form>
            </div>
        </div>
        
        <!--jQuery 2.2.4-->
        <script
        src="https://code.jquery.com/jquery-2.2.4.js"
        integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
        crossorigin="anonymous"></script>    
    </body>
</html>
