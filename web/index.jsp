<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/13
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/upload" method="post" enctype="multipart/form-data">
    文件上传：<input type="file" name="fileUpload">
    <input type="submit" value="上传">
</form>

</body>
</html>
