<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../base/base.jsp"%>
<html>
<head>
    <meta charset="utf-8" />
    <title>电影分类页</title>

    <link href="${ctx}/static/pro/style/style.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/static/pro/style/prodList.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${ctx}/static/pro/js/public.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery-1.6.2.js"></script>
    <script type="text/javascript" src="${ctx}/static/pro/js/jqpublic.js"></script>



</head>
<body>
<form method="post" name="icform">
    <%--头--%>
    <jsp:include page="../base/head.jsp"></jsp:include>
    <!--Start content-->
    <section class="Psection">


        <div id="content">
            <div id="search_div">
                <form method="post" action="findProductByCondition2">
                    <span class="input_span">电影名：<input type="text" name="product_name" value=""/></span>
                    <span class="input_span">电影种类：<input type="text" name="name" value=""/></span>
				<span class="input_span">个性化电影推荐价格区间：
					<input type="text" name="minprice" value=""/> -
					<input type="text" name="maxprice" value=""/></span>
                    <input type="submit" value="查 询" >
                    <input type="reset" id="reset" value="重 置">
                </form>
            </div>
        </div>


        <section class="Fsl">
            <ul>
                <c:set var="num" value="0"></c:set>
                <c:forEach items="${productList}" var="product" varStatus="status">
                        <li>
                            <a href="/toDetail?id=${product.id}"  title="电影名"><img src="${ctx}${product.imageUrl}"></a>

                            <p>电影名：${product.productName}</p>
                            <hr>
                            <p>价格:${product.price}</p>
                            <hr>
                            <p>库存:${product.buyCount}</p>
                            <p>
                                <span class="DSBUTTON" style="float: right"><a href="/toDetail?id=${product.id}"  class="Fontfff">电影详情</a></span>
                            </p>
                        </li>
                </c:forEach>
            </ul>
                      <!--将买的最多的电影放到此处，两个既好-->
            <aside>
                <div class="title">热门电影</div>
                <c:forEach items="${HotProductList}" var="hotProduct" varStatus="status">
                    <div class="C-list">
                        <a href="/toDetail?productId=${hotProduct.id}" title="电影名"><img src="${ctx}${hotProduct.imageUrl}" width="100%" height="30%"></a>
                        <p><a href="/toDetail?productId=${hotProduct.id}" >${hotProduct.productName}</a></p>
                        <p>
                            <span>价格：${hotProductList.price}</span>
                        </p>
                    </div>

                </c:forEach>
            </aside>
            <div class="TurnPage">
                <span class="Prev"><i></i>一共${pages.pages}页</span>
                <a href="findProductByCategory?page=${pages.navigateFirstPage}&kindId=${kindId}">
                    <span class="Prev"><i></i>首页</span>
                </a>
                <c:if test="${page.pageNum > 1}"><a href="findProductByCategory?page=${pages.prePage}&kindId=${kindId}"><span class="PNumber">上一页</span></a></c:if>
                <c:if test="${page.pageNum != page.navigateLastPage}"><a href="findProductByCategory?page=${pages.nextPage}&kindId=${kindId}"><span class="PNumber">下一页</span></a></c:if>
                <a href="findProductByCategory?page=${pages.navigateLastPage}&kindId=${kindId}">
                    <span class="Next">最后一页<i></i></span>
                </a>
            </div>



        </section>
    </section>

    <%--头--%>
    <jsp:include page="../base/foot.jsp"></jsp:include>
    <!--End content-->
</form>
</body>

</html>
