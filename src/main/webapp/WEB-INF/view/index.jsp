<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	* {
		padding: 0px;
		margin: 0px;
	}
	
	form input {
		width: 100%;
		box-sizing: border-box;
		border: solid #DCDCDC; 20px;
		border-left-width: 50px;
		border-right-width: 50px;
		height: 35px;
		border-radius: 10%;
		padding: 10px;
		outline:none;
	}
	form button{
		margin-top: 20px;
		width: 100%;
		box-sizing: border-box;
		border: solid #DCDCDC; 20px;
	    border-width: 0;
	    border-left-width: 100px;
	    border-right-width: 100px;
	    cursor: pointer;
	    text-align: center;
	    display: inline-block;
	    font-size: 1em;
	    background-color: #adc708;
	    color: white;
   		-webkit-appearance: none;
       	transition: background-color 300ms ease-out;
      		box-shadow: 0 0px 0 rgba(0,0,0,0.2) inset !important;
      		height: 35px;
      		outline:none;
	}
</style>
</head>
<body style="background: #DCDCDC;">

<div >
	<form action="create" method="get">
		<h1 style="text-align: center;">Create Account</h1>
		<input type="text"  name="username" value="李" placeholder="Account UserName" />
		<input type="text" name="password" value="809753" placeholder="Account Password" />
		<input type="text" name="email" value="1032303977@qq.com" placeholder="Account Eamil" />
		<input type="text"name="phone" value="15066127532" placeholder="Account Phone" />
		<button type="submit" value="Submit">Submit</button>
	</form>
</div>

<div style="margin-top: 100px;">
	<form action="queryAccountByKey" method="get">
		<h1 style="text-align: center;">Query Account By Key</h1>
		<input type="text" name="id" value="1" placeholder="Account Key" />
		<button type="submit" value="Submit">Submit</button>
	</form>
</div>


</body>
</html>