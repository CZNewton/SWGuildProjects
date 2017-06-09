/*checklist
1. ready statement for API call
2. Api call needs to receive item info via form /items
3. Still on start-up, item info needs to be written to div class "item"
*. display button of id "changTile" only if (current money var>any price in items)
4. wait for user input
    --case: inserting money
        1. event listener for click on button class "coinTile"
        2. persist variable to store current money while page is up
        3. innerHTML div of id "currentMoney" to display money. CSS will handle the font/size/etc
    --case: purchese item
        1. event listener for click on button class "orderTile"
        2. read number input into input of id "requestedItem"
            --Note: API uses 1-9 range NOT 0-8 for id's
        3. use API form /money/-current money var-/item/-item id-, receive change on success
            --case: out of stock
                1. receive out of stock message from response JSON in a 422 error
                2. output out of stock message to div of id "currentMessage"
            --case: not enough money
                1. receive "please deposit 'x'" from response JSO in a 422 error
                2. display aforementioned message to div of id "currentMessage"
        4. display vending message (possible pause function for theme?)
        5. add change for current money var
        6. check if(current money var > any/lowest item price)
            --case: no
                1. engage change function as if button "changeTile" was pressed
    --case: change return
        1.event listener for button "changeTile"
            --Note: be sure to name this function so it can be called by the purchase path on case of not enough money
        2. get current money var
        3. calculate change via client
        4. display change to div of id "currentChange"*/
   var currentMoney=0.00;        
   
    function refresh() {
//        var ajaxbegin= {
//            method: "GET",
//            url: "http://localhost:8080/items",
//            success: blah,
//            fail: function() {
//                alert("Error on list pull");
//            } 
//        };
//        
//        $.ajax(ajaxbegin);

        $.getJSON('http://localhost:8080/items', function(list) {
            
            console.log(list[0].name);
            console.log(list[3].name);
            console.log(list[5].name);
        
            list.forEach(function(blah) {
                var that = $("#items");
                that.append('<div class="col-md-4">'
                    + '<div class="item">'
                    + '<div class="itemNum">'+ blah.id + '</div><br>'
                    + '<div class="itemName">'+ blah.name + '</div>'
                    + '<div class="itemPrice">'+ blah.price + '</div>'
                    + '<div class="itemQuant">'+ blah.quantity + '</div>'
                    + '</div>'
                    + '</div>');
            });
        });
    }
    
    function getItem(id) {
//        $.getJSON('http://localhost:8080/money/' + currentMoney + '/item/' + id, function(out) {
//            if(out.size===4) {
//                $('#currentChange')[0].innerHTML = "Quarters=" + out.quarters + "\nDimes=" + out.dimes + "\nNickels" + out.nickels + "\nPennies" + out.pennies;
//                refresh();
//            } else {
//                $('#currentMessage')[0].innerHTML = out.message;
//            }
//        });
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/money/" + currentMoney + "/item/" + id,
            fail: function() {
                alert("that fail we hoped for");
            }
        }).always(function(arg1, arg2, arg3) {
            console.log(arg1);
            console.log(arg2);
            console.log(arg3);
                if(arg3 === "Unprocessable Entity") {
                    $('#currentMessage')[0].innerHTML = arg1.responseJSON.message;
                } else {
                    $('#currentChange')[0].innerHTML = "Quarters=" + arg1.quarters + "\nDimes=" + arg1.dimes + "\nNickels" + arg1.nickels + "\nPennies" + arg1.pennies;
                    $('#currentMessage')[0].innerHTML = "THANK YOU!!";
                };
            });
        
    }

    function change(givenChange, natural) {
        
        if(natural) {
        
        //eventually put logic for change (not requiring a purchase) here
        
        }
        
        currentMoney=0;
        
        if (currentMoney<=0) {
            $("#changeTile").hide();
        }
    }

    $(document).ready(function start() {
        refresh();
    });
    
    $(".btn, .btn-default").on("click", function() {
        
        var type = this.id;
        
        if(type==="inDollar") {
            currentMoney+=1.00;
        } else if (type==="inQuarter") {
            currentMoney+=0.25;
        } else if (type==="inDime") {
            currentMoney+=0.10;
        } else if (type==="inNickel") {
            currentMoney+=0.05;
        }
        
        $("#currentMoney")[0].innerHTML = "$" + currentMoney.toPrecision(3);
        
       if (currentMoney>0) {
           $("#changeTile").show();
       } 
    });
    
   
    $("#items").on("click", ".item", function() {
        var item = this.children[0];
        var itemId = Number(item.textContent);
        $("#currentItem")[0].innerHTML = "Item " + itemId;
        var givenChange = getItem(itemId);
        change(givenChange, false);
    });
    
    $("#changeTile").on("click", change(currentMoney, true));
    

    
    