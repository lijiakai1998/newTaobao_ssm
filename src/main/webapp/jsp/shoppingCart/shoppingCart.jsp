<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/9/16
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/jQuery/jquery-1.12.3.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<html>
<head>
    <title>购物车</title>
    <style type="text/css">
        #top{
            height:150px;
            width:100%;
            background-color: #FFFFFF;
        }
        #topbar{
            height:150px;
            width:70%;
            margin:auto;
            background-color:#FFFFFF;
        }
        .logo01{
            width:200px;
            height:136px;
            position:relative;
            float:left;
        }
        .logo02{
            width:160px;
            height:90px;
            position:relative;
            float:left;
            top:50px;
        }

        .find input{
            width:250px;
            height:30px;
            position:relative;
            top:50px;
            float:right;
            border-style:solid;
            border-color: darkorange;
            border-width:3px;
        }
        .sousuo input{
            width:60px;
            height:37px;
            position:relative;
            top:50px;
            float:right;
            background-color: darkorange;
            border-width:3px;
            border-color: darkorange;
            font-size: medium;
            font-family: Arabic Typesetting ;
        }
        #nav{
            height:35px;
            width:70%;
            background-color:#FFFFFF;
            margin:5px auto;
            border-bottom: 2px double #666666;
        }
        .nav table{
            width:70%;
            height:35px;
            margin:0 auto;
            border-bottom: 2px solid #666666;
            position:relative;
            float:left;
        }
        .nav td{
            width:100px;
            height:35px;
            font-weight:bolder;
            text-align: center;
            position:relative;
            float:left;
        }
        .nav table td:hover :visited{
            border-bottom: 2px solid darkorange;
        }
        .button {
            background-color: #ff740a;
            width:60px;
            height:25px;
            border: none;
            color: white;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }
        #content{
            width:70%;
            height:100%;

            margin:5px auto;
        }
        .one{
            width:150px;
            height:70px;

        }
        .two{
            width:250px;
            height:70px;

        }
        .three{
            width:180px;
            height:70px;

        }
        .four{
            width:170px;
            height:70px;


        }
        .five{
            width:230px;
            height:70px;

        }
        .view table{
            border:3px solid #999999;
            width:100%;
            height:100px ;
        }
        .item-content .text-amount {
            width: 20px;
            height: 15px;
            line-height: 15px;
            border: 1px solid #aaa;
            color: #343434;
            text-align: center;
            padding: 4px 0;
            background-color: #fff;
            background-position: -75px -375px;
            position: absolute;
            z-index: 2;
            left: 18px;
            top: 0;
        }
        .item-content .item-amount a {
            display: block;
            height: 23px;
            width: 10px;
            border: 1px solid #e5e5e5;
            background: #f0f0f0;
            text-align: center;
            line-height: 23px;
            color: #444;
            position: absolute;
            top: 0;
        }
        .item-content .item-amount a, .item-content .text-amount {
            float: left;
        }
        .item-content .item-amount {
            height: 25px;
            overflow: hidden;
            position: relative;
            z-index: 1;
        }
        .item-content .item-amount {
            width: 19px;}

        .item-content .item-amount .no-minus {
            color: #e5e5e5;
        }

        .item-amount .no-minus {
            border-right-color: transparent;
            left: 0;
        }
        .item-amount .plus, .item-content .item-amount .no-plus {
            border-left-color: transparent;
            right: 0;
        }
    </style>
</head>
<body>




<div id="top"><div id="topbar">
    <div class="logo01"><img src="${pageContext.request.contextPath}/img/01.png"> </div>
    <div class="logo02"><img src="${pageContext.request.contextPath}/img/02.png"></div>

    <form action="#" method="post">
        <div class="sousuo"></div>
        <div class="find">
        </div>
    </form>
</div>
</div>
<div id="nav">
    <table class="nav">
        <tr style="position: absolute;">
            <td class="nav">
                <span style="color:#ff740a;font-weight:bold;font-family: 宋体; font-size: x-large" >全部商品</span>
            </td>
            <td class="nav"></td>
            <td class="nav"></td>
            <td class="nav"></td>
            <td class="nav"></td>
            <td class="nav "></td>
            <td class="nav"></td>
            <td class="nav"></td>
            <td class="nav"></td>
        </tr>
    </table>
</div>
<!--<hr color="#666666" width="70%" size="2px" align="center"/>-->
<div id="content">
    <table>
        <tr>
            <td class="one">
                <input type="checkbox"/>全选
            </td>
            <td class="two">
                商品信息
            </td>
            <td class="three" style="width: 140px;"></td>
            <td class="four">单价</td>
            <td class="five">数量</td>
            <td class="four">金额</td>
            <td class="four">操作</td>
        </tr>
    </table>
    <form action="${pageContext.request.contextPath}/shoppingCart/delShoppingGoodsByGid" method="post" id="form">
    <table border="1"rules="none"width="100%"height="120px" align="center" border-color="#cccccc" id="cartTable">
        <c:forEach items="${good}" var="goods">
        <tr>
            <td style="width: 89px;"> <div style="width:30px;height: 119px;margin-left: 55px;">
                <input type="checkbox" style="margin-top: 59px;" name="id" value="${goods.gId}"/>
                </div>
            </td>
            <td class="one" style="margin-left: 35px;">
                <img  style="width: 160px;height: 98px;" src="${goods.gImage} ">
            </td>
            <td class="three">
                <span style="font-size: small;color: #666666;margin-right: 40px">${goods.gName}</span>
            </td>
            <td class="four">
                <div style="margin-left: 75px;" >
                   ${goods.gPrice}
                </div>
            </td>
            <td class="five">
                <div class="amount-wrapper">
                    <div class="item-amount " style="margin-left: 55px;">

                            <a href="#" style="text-decoration: none"><span class="add"  style="width: 20px;height: 20px; border: 1px solid #bfbcc2;">+</span></a>

                        <input type="text" class="count" value="1" style="width: 40px; text-align: center"/>

                        <a href="#" style="text-decoration: none"><span class="reduce"  style="width: 20px;height: 20px; border: 1px solid #bfbcc2;">-</span></a>

                    </div>
                </div>

            </td>
            <td class="four">
                <div style="margin-left: 28px;">
                    ${goods.gPrice}
                </div>

            </td>
            <td class="four">
             <a href="#" onclick="del(${goods.gId})" style="text-decoration:none">移出购物车</a>
            </td>
        </tr>
        </c:forEach>
    </table>
        <div style="margin-top: 20px;margin-left:50px;">
            <input type="checkbox"  id="selectAll"/> 全选 &nbsp;&nbsp; <a href="javascript:delSeclet()" style="text-decoration: none;" >删除选中</a>
        </div>
    </form>
            <div style="float: right;margin-right: 10px;margin-top: -50px;">
                已选商品:<span id="selectTotal" style="color: #28a4c9;font-size: 16px;">0</span>件&nbsp;&nbsp;&nbsp;
                合计: ￥<span id="priceTotal"style="color: red;font-size: 22px;">0.00</span>
                &nbsp;&nbsp;&nbsp;
                <a href="javascript:jiesuan()" class="btn btn-primary" >结算</a>
            </div>



</div>
</body>

<script type="text/javascript">

    // window.onload=function () {
    //
    // };






        var cartTable = document.getElementById('cartTable');
        var selectTotal=document.getElementById("selectTotal");
        var priceTotal=document.getElementById("priceTotal");
        console.log(cartTable);
        var tr = cartTable.children[0].rows;    //获取表格的所有表体内容，默认从0开始，包括表头内容
        console.log(tr);

        /*改变商品数量* */
        for(var i=0;i<tr.length;i++)
        {
            tr[i].onclick=function (e) {
                e=e||window.event;
                var el=e.srcElement;
                var cls=el.className;
                var input=this.getElementsByTagName('input')[1]; //获得每一行中使用此标签的元素，默认从0开始
                var val=parseInt(input.value);
                console.log(val);
                switch (cls) {
                    case 'add':
                        input.value=val+1;
                        getsubTotal(this);
                        break;
                    case 'reduce':
                        if(val>1)
                        {
                            input.value=val-1;
                        }else{
                            alert("商品数量不能小于1！");
                        }
                        getsubTotal(this);
                        break;
                    default:
                        break;

                }
                getTotal();

            };
            //从键盘上输入数量
            tr[i].getElementsByTagName('input')[1].onkeyup=function (ev) {
                var val=this.value;
                var tr=this.parentNode.parentNode;
                getsubTotal(tr);
                getTotal()
            }
        }
        //小计
        function getsubTotal(tr) {
            var tds=tr.cells;
            console.log(tds);
            var price=parseFloat(tds[3].innerText); //获得此行默认从0开始的第几列元素文本内容
            var count=parseInt(tr.getElementsByTagName('input')[1].value);
            console.log(count);
            var subTotal=parseFloat(price*count);
            tds[5].innerHTML=subTotal.toFixed(2);
        }
        //总计
        function getTotal() {
            var select=0;
            var price=0;
            for(var i=0;i<tr.length;i++)
            {
                if(tr[i].getElementsByTagName('input')[0].checked)
                {
                    select+=parseInt(tr[i].getElementsByTagName('input')[1].value);
                    price+=parseFloat(tr[i].cells[5].innerText);
                }
            }
            selectTotal.innerHTML=select.toFixed(0);
            priceTotal.innerHTML=parseFloat(price).toFixed(2);

        }

    //删除操作
    function del(data) {
        console.log(data);
        if(confirm("您确定要移除此商品！"))
        {
            window.location.href="${pageContext.request.contextPath}/shoppingCart/delShoppingGoodsByGid?id="+data;
        }
    }
    function delSeclet() {
        var falg=false;
        var bcs=document.getElementsByName("id");
        var form=document.getElementById("form");
        if(confirm("确定要移除选中的商品！！！"))
        {
            for(var i=0;i<bcs.length;i++)
            {
                if(bcs[i].checked)
                {
                    falg=true;
                }
            }
            form.submit();
        }
    }
    document.getElementById("selectAll").onclick=function () {
        var bcs=document.getElementsByName("id");
        for(var i=0;i<bcs.length;i++)
        {
            bcs[i].checked=this.checked;

        }
        getTotal();
    };

        //结算跳转
    function jiesuan() {
            var bcs=document.getElementsByName("id");
            var total=document.getElementById("priceTotal");
            var selectTotal=document.getElementById("selectTotal");
            var arr=[];
            var count=[];
           for(var i=0;i<bcs.length;i++)
           {
               if(bcs[i].checked)
               {
                   arr[i]=bcs[i].value;
                   count[i]=tr[i].getElementsByTagName('input')[1].value;
               }
           }
           if(arr.length==0)
           {
               alert("你还没有选择宝贝！！！");
           }
        else {
           console.log(arr);
           console.log((count));
           console.log(total.innerText);
           console.log(selectTotal.innerText);
           console.log(JSON.stringify(arr));
           console.log(JSON.stringify(count));

           $.ajax({
               type:'GET',
               dataType:'json',
               url:'${pageContext.request.contextPath}/shoppingCart/jieSuanByGoodsId',
               data: {'json' : JSON.stringify(arr),
               'count':JSON.stringify(count),
                   'total':total.innerText,
                   'selectTotal':selectTotal.innerText
               },
               async : false,//先执行AJAx再执行下面的代码
               /*
               当async设置为true时，点击按钮后，先执行下面的代码,最后执行success函数操作
               * */
              contentType: "application/json; charset=utf-8",
               success:function (data) {
                if(data.msg=="true")
                {
                  location.href='${pageContext.request.contextPath}/shoppingCart/dingDan'
                }
               },
               fail:function () {
                   alert("操作异常！！！");
               }

           });



           }

    }


</script>


</html>
