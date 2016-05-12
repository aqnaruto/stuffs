<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/appapi/save"  method="post">
<input type="text" name="blog.title">
<br>
<textarea style="width:500px; height:200px" name="blog.content"></textarea>
<br>
<input type="submit"value=“submit-form” >


</form>
</body>
</html>