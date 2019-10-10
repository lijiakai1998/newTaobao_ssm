<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/9/16
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误信息</title>
</head>
<body>
<c:if test="${meg=='no'}">
    <script type="text/javascript">
        alert("添加失败!!!")
    </script>
</c:if>
</body>
</html>
