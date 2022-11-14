//Donation
$('#submit-donation').click(function(){
    var amount = $('#donation').val();
    var confirmation = $('#donation-confirmation');
    if(amount<100){
        alert("Thank you");
        confirmation.addClass("alert alert-primary").html("Thank you!");
    } else if (amount<1000){
        if(confirm("That's a generous sum! Are you sure?")){
            confirmation.addClass("alert alert-primary").html("Thanks for confirming!");
        } else {
            confirmation.addClass("alert alert-primary").html("It's OK to change one's mind");
        }
    } else {
        var response = prompt("Please confirm you're serious by typing in 'YES'");
        if(response === "Yes" ){
            confirmation.addClass("alert alert-primary").html("Thank you for your generosity");
        }

    } 

});