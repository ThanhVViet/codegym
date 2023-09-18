<%--
  Created by IntelliJ IDEA.
  User: thanhviet
  Date: 15/09/2023
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap');
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }
        body{
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            background: #4D59FB;
        }
        ::selection{
            color: #fff;
            background: #4D59FB;
        }
        .wrapper{
            width: 420px;
            border-radius: 7px;
            background: #fff;
            padding: 25px 28px 45px;
            box-shadow: 7px 7px 20px rgba(0, 0, 0, 0.05);
        }
        .wrapper header{
            font-size: 28px;
            font-weight: 500;
            text-align: center;
        }
        .wrapper .search{
            position: relative;
            margin: 35px 0 18px;
        }
        .search input{
            height: 53px;
            width: 100%;
            outline: none;
            font-size: 16px;
            border-radius: 5px;
            padding: 0 42px;
            border: 1px solid #999;
        }
        .search input:focus{
            padding: 0 41px;
            border: 2px solid #4D59FB;
        }
        .search input::placeholder{
            color: #B8B8B8;
        }
        .search :where(i, span){
            position: absolute;
            top: 50%;
            color: #999;
            transform: translateY(-50%);
        }
        .search i{
            left: 18px;
            pointer-events: none;
            font-size: 16px;
        }
        .search input:focus ~ i{
            color: #4D59FB;
        }
        .search span{
            right: 15px;
            cursor: pointer;
            font-size: 18px;
            display: none;
        }
        .search input:valid ~ span{
            display: block;
        }
    </style>
</head>
<body>
<form action="/dictionary" method="post">
    <div class="wrapper">
        <header>English Dictionary</header>
        <div class="search">
            <input type="text" name="word" placeholder="Search a word" required spellcheck="false">
            <i class="fas fa-search"></i>
            <span class="material-icons">close</span>
        </div>

        <div>
            <p>${word}</p>
        </div>
    </div>

</form>
</body>
</html>
