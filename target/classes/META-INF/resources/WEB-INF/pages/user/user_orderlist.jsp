<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>用户中心--购票列表</title>
    <link href="${pageContext.request.contextPath}/static/pro/style/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${ctx}/static/pro/js/public.js"></script>
    <script type="text/javascript" src="${ctx}/static/pro/js/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/static/pro/js/jqpublic.js"></script>
</head>
<body>
<jsp:include page="../base/head.jsp"></jsp:include>
<!--Start content-->
<section class="Psection MT20">
    <nav class="U-nav Font14 FontW">
        <ul>
            <li><i></i><a href="" target="_self">用户中心首页</a></li>
            <li><i></i><a href="toUserOrder" target="_self">我的电影票</a></li>
            <li><i></i><a href="userAddress" target="_self">详细信息</a></li>
            <li><i></i><a href="userAccount" target="_self">账户管理</a></li>
            <li><i></i><a href="userLogout" target="_self">安全退出</a></li>
        </ul>
    </nav>
    <article class="U-article Overflow">
        <!--user order list-->
        <section>
            <table class="Myorder">
                <th class="Font14 FontW">编号</th>
                <th class="Font14 FontW">电影详情</th>
                <th class="Font14 FontW">购票时间</th>
                <th class="Font14 FontW">购票人</th>
                <th class="Font14 FontW">总金额</th>
                <th class="Font14 FontW">状态</th>
                <c:forEach items="${orderList}" var="order">
                    <tr>
                        <td class="FontW"><a href="userOrder">${order.orderId}</a></td>
                        <td align="center" style="HEIGHT: 22px">
                            <table width="100%">
                                <c:forEach items="${order.productOrders}" var="productOrder">
                                    <tr>
                                        <td>电影名称：${productOrder.product.productName}</td>
                                        <td>电影单价：${productOrder.product.price}</td>
                                        <td>购票数量：${productOrder.buyNum}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                        <td>${order.orderDate}</td>
                        <td>
                            <c:if test="${!not empty user.userInfo.realName}">
                                尚未填写用户名
                            </c:if>
                            <c:if test="${not empty user.userInfo.realName}">
                                ${user.userInfo.realName}
                            </c:if>

                        </td>
                        <td>${order.money}</td>
                        <c:if test="${order.orderStatus == 4}">
                            <td>已完成</td>
                        </c:if>
                        <c:if test="${order.orderStatus == 3}">
                            <td>待回复评论</td>
                        </c:if>
                        <c:if test="${order.orderStatus == 2}">
                            <td><a href="toEvaluate?orderId=${order.orderId}&status=3">去评价</a></td>
                        </c:if>
                        <c:if test="${order.orderStatus == 1}">
                            <td><a href="updateOrderStatus?status=2&orderId=${order.orderId}">已观影，点击结束</a></td>
                        </c:if>
                        <c:if test="${order.orderStatus == 0}">
                            <td>已支付，待观影</td>
                        </c:if>
                        <%--<c:if test="${order.orderStatus == -1}">
                            <td>待付款</td>
                        </c:if>--%>
                    </tr>
                </c:forEach>
            </table>
            <div class="TurnPage">
                    <span class="Prev"><i></i>一共${page.pages}页</span>
                <a href="toUserOrder?page=${page.navigateFirstPage}">
                    <span class="Prev"><i></i>首页</span>
                </a>
                <c:if test="${page.pageNum > 1}"><a href="toUserOrder?page=${page.prePage}"><span class="PNumber">上一页</span></a></c:if>
                <c:if test="${page.pageNum != page.navigateLastPage}"><a href="toUserOrder?page=${page.nextPage}"><span class="PNumber">下一页</span></a></c:if>
                <a href="toUserOrder?page=${page.navigateLastPage}">
                    <span class="Next">最后一页<i></i></span>
                </a>
            </div>
        </section>
    </article>
</section>
<!--End content-->
<jsp:include page="../base/foot.jsp"></jsp:include>

</body>
</html>
