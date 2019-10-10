<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/9/29
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>订单详情页面</title>
</head>
<body bgcolor="#faebd7">
<center>
    <div style="margin-top: 30px;border-color: #5bc0de;width: 700px;" >
    <h3 style="font-size: 18px;font-family: Helvetica Neue, Helvetica, Arial, sans-serif">确认订单</h3>
        <div style="margin-top: 15px">
            <table bgcolor="white" style="margin: auto" border="0" width="580px">
                <c:forEach items="${goodsList}" var="goods" >
                    <tr>
                        <td colspan="3">${goods.gStore}</td>
                    </tr>
                    <tr>
                        <td rowspan="2" style="width: 240px"><img src="${goods.gImage}" style="width:160px;height: 98px;"></td>
                        <td rowspan="2" >${goods.gName}</td>
                        <td style="font-size: 16px">￥${goods.gPrice}</td>
                    </tr>
                    <tr>
                        <td style="color: #9d9d9d">x${map.get(goods.gId)}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div style="margin-top: 10px;float: right;margin-right: 64px;">
           <span style="color: #A9A9A9; font-size: 12px;">共${selectTotal}件,</span> &nbsp;
            <span style="color: black;font-size: 16px;">合计:<span style="color: red;font-size: 18px;">￥${total}</span></span>&nbsp;
            <a href="#" style="text-decoration: none; font-size:20px">提交订单</a>
        </div>
    </div>
</center>
</body>
</html>
