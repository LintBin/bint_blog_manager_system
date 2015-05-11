<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.bint.model.ArticleModel"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link href="front_style/bootstrap.css" rel="stylesheet">
    <link href="front_style/front_app.css"  rel="stylesheet">
    <script src="js/jquery-1.7.2.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <title>鸿彬的主页</title>
    <script type="text/javascript">
    	$(document).ready(function(){
    		var currentpage = '<c:out value="${articleList.pageNum}"/>';
    		var previousPage =new Number(currentpage)-1;
	    	var nextPage = new Number(currentpage)+1;
			if(previousPage <= 0){
	    		blank($("#pre-page"));
	    	}
	    	
	    	if(nextPage > '<c:out value="${articleList.pageAmount}"/>'){
	    		blank($("#next-page"));
	    	}
	    	 
	    	$("#next-page").click(function(){
	    		if(nextPage > '<c:out value="${articleList.pageAmount}"/>'){
	    			return ;
	    		}
	    		window.location.href='front_page_article.do?pageNum='+nextPage;
	    	})
	    	
	    	$("#pre-page").click(function(){
	    		if(previousPage <= 0){
	    			return ;
	    		}
	    		window.location.href='front_page_article.do?pageNum='+previousPage;
	    	})
	    	
	    	function blank(obj){
	    		obj.attr("disable","disable")
	    		obj.removeAttr("href");
	    	}
	    	
	    	
    	});
    </script>
</head>
<body class="home-template">
    <!--头部开始-->
    <header class="main-header">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <a class="branding" href="#" title="这是鸿彬的博客">
                        <img src="http://static.ghostchina.com/image/b/46/4f5566c1f7bc28b3f7ac1fada8abe.png#">
                    </a>
                </div>
            </div>
        </div>
    </header>
    <!--头部结束-->
    <nav class="main-navigation">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="navbar-header">
                        <span class="nav-toggle-button collapse" data-target="#main-menu">
                            <span class="sr-only">这是导航标签</span>
                            <i class="fa fa-bars"></i>
                        </span>
                    </div>
                    <!--导航内容-->
                    <div class="collapse navbar-collapse" id="main-menu">
                        <ul class="menu">
                            <li class="nav-current" role="presentation">
                                <a href="front_page_article.do">首页</a>
                            </li>
                            <li role="presentation">
                                <a href="#">技术</a>
                            </li>
                            <li role="presentation">
                                <a href="#">读书</a>
                            </li>
                            <li role="presentation">
                                <a href="#">生活感悟</a>
                            </li>
                            <li role="presentation">
                                <a href="#">关于</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </nav>
    <section class="content-wrap">
        <div class="container">
            <div class="row">
                <main class="col-md-8 main-content" >
                	<c:forEach var="item" items="${articleList.list}">
	                	<article  class="post tag-about-ghost tag-ghost-in-depth tag-lin-hong-bin">
	                        <div class="post-header">
	                            <h1 class="post-title">
	                                <a href='getArticleById.do?id=<c:out value="${item.articleId}"/>'><c:out value="${item.headline}"/></a>
	                            </h1>
	                            <div class="post-meta">
	                                <span class="author">
	                                                                                                          作者:<a href="#"><c:out value="${item.athorName}"/></a>
	                                </span>
	                                <time class="date" datetime="2015-1-15">2015-1-15</time>
	                            </div>
	                            <div class="post-content">
	                                <p>
	                                	<c:out value="${item.digest}"/>
	                                </p>
	                            </div>
	                            <div class="post-permalink">
	                                <a href='getArticleById.do?id=<c:out value="${item.articleId}"/>' class="btn btn-default">阅读全文</a>
	                            </div>
	                            <div class="footer clearfix">
	                                <hr>
	                                <div class="pull-left tag-list">
	                                    <c:forEach var="articleLabels" items="${item.articleLabelList}">
                  	 						<a href='front_page_article.do?labelId=<c:out value="${articleLabels.labelId}"/>'><c:out value="${articleLabels.labelName}"/></a>
                  	 					</c:forEach>
	                                </div>
	                            </div>
	                        </div>
	                    </article>
					</c:forEach>
                    <nav class="pagination">
                        <a id="pre-page" class="newer-posts" href="#">
                            <i class="fa fa-angle-left">
                                	上一页
                            </i>
                        </a>
                        <span class="page-number">第<c:out value="${articleList.currentPage}"/>页/共<c:out value="${articleList.pageAmount}"/>页</span>
                        <a id="next-page" class="newer-posts" href="#">
                            <i class="fa fa-angle-right">
                                	下一页
                            </i>
                        </a>
                    </nav>
                </main>
                <aside class="col-md-4 sidebar">
                    <div class="widget">
                        <h4 class="title">作者：</h4>
                        <div class="content community">
                            <p>QQ:312763889</p>
                            <p>
                                <a href="https://github.com/LintBin">GitHub地址  :https://github.com/LintBin</a>
                            </p>
                            <p>
                                <a href="http://weibo.com/u/1628612985/home?wvr=5">新浪微博:weibo.com/u/1628612985/home?wvr=5</a>
                            </p>
                        </div>
                    </div>
                    <div class="widget">
                        <h4 class="title">下载系统</h4>
                        <div class="content download">
                            <a href="#" class="btn btn-default btn-block">下载</a>
                        </div>
                    </div>
                    <div class="widget">
                        <h4 class="title">标签云</h4>
                        <div class="content tag-cloud">
                            <c:forEach var="item" items="${labelList}">
                            	<a href="#"><c:out value="${item.labelName}"/></a>
                            </c:forEach>
                        </div>
                    </div>
                </aside>
            </div>
        </div>
    </section>
    <div class="main-footer">
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="widget">
                        <h4 >最新文章</h4>
                        <div class="conten recent-post">
                            <div class="rent-single-post">
                                <a href="#" class="post-title">反射的乐趣</a>
                                <div class="date">2015-1-15</div>
                            </div>
                            <div class="rent-single-post">
                                <a href="#" class="post-title">反射的乐趣</a>
                                <div class="date">2015-1-15</div>
                            </div>
                            <div class="rent-single-post">
                                <a href="#" class="post-title">反射的乐趣</a>
                                <div class="date">2015-1-15</div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="widget">
                        <h4 class="title">标签云</h4>
                        <div class="content tag-cloud">
                            <a href="#">Java</a>
                            <a href="#">MySQL</a>
                            <a href="#">反射</a>
                            <a href="#">Oracle</a>
                            <a href="#">Python</a>
                            <a href="#">爬虫</a>
                            <a href="#">感悟</a>
                            <a href="#">翻译</a>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="widget">
                        <h4 class="title">合作伙伴</h4>
                        <div class="content tag-cloud frend-link">
                            <a href="#">格隆汇</a>
                            <a href="#">格隆汇</a>
                            <a href="#">格隆汇</a>
                            <a href="#">格隆汇</a>
                            <a href="#">格隆汇</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>