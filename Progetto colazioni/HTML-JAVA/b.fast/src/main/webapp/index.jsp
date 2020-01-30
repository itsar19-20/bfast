<!doctype html>
<html lang="it-it">
<meta charset="utf-8">

<head>
    <title>Bfast</title>



    <meta charset="utf-8">

    <!-- Serve per ottimizzare prima i dispositi mobili e poi in base alla necessità utilizzando 
                le query multimediali CSS. 
                Per garantire il rendering corretto e lo zoom tattile per tutti i dispositivi  -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <!-- Collegamento con Style.css -->
    <link rel="stylesheet" type="text/css" href="Style.css">

</head>






<body>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>

    <script src="Regole.js"></script>


    <div class="btn-group">
        <button id="Ristorante" type="button" class="btn btn-primary">Bar</button>
    </div>
    
    <img src="logo.png" alt="Bfast" style="width:250px;height:250px;display: block; margin-left: auto; margin-right: auto;">

    <form class="form-signin" action="login" method="get">
        <div class="login">
            <div class="login-screen">
                <div class="app-title">
                    <h1>Login</h1>
                </div>

                <div class="login-form">
                    <!--UserName-->
                    <div class="control-group">
                        <input type="text" id="ID" class="login-field"  placeholder="ID" name="ID" required autofocus name="ID" style="width: 100%;">
                    </div>
                    <!--Password-->
                    <div class="control-group">
                        <input type="password" id="password" class="login-field" placeholder="password" name="password" required name="password" style="width: 100%;"> 
                    </div>
                    <input type="submit" value="Log in" class="btn btn-primary btn-large btn-block">

                </div>




            </div>
        </div>
    </form>
    <a href="registrazione.html" style="text-align: center;display: block;margin-left: auto; margin-right: auto;">Non sei ancora registrato?</a>
    <a href="mail.html" style="text-align: center;display: block;margin-left: auto; margin-right: auto;">Hai dimenticato la password?</a>




</body>

</html>