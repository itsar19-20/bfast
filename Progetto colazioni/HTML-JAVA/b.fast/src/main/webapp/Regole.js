function validazione (e){
    e.preventDefault();
    var emailUser = document.getElementById('emailV').value;
    var emailRGEX =/^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;
    var emailResult = emailRGEX.test(emailUser);
    alert ("email:"+emailResult );

    if(emailResult == false)
    {
        alert('Please enter a valid email address');
        return false;
    }
    return document.forms[0].submit();
}