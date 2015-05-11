<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.bint.model.ArticleModel"%>
<%@ page import="com.bint.model.UserModel"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link href="front_style/bootstrap.css" rel="stylesheet">
    <link href="front_style/front_app.css" rel="stylesheet">
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script>
		$(document).ready(function(){
			$("#commentBt").click(function(){
				var userId = "${user.id}";
				if(userId==""){
					alert("请先登录");
					return ;
				}
				var content = $("#commentTextare").val();
				var blogId = "${article.id}";
				$.ajax({
				   url: 'front/commentAdd.do',
				   method:"POST",
				   data:{
					   content:content,
					   blogId:blogId
				   },
				   success:function(result){
					   appendCommentTag(result);
					   alert("评论成功");
					   $("#commentTextare").val("");
				   }
				});
			});
			
			
			//设置返回的url 
			$("#loginUrl").click(function(){
				var url = window.location.href;
				$.ajax({
				   url: 'system/url.do',
				   method:"POST",
				   data:{
					   url:url
				   },
				   success:function(result){
				       	
				   }
				});
			})
			
			function appendCommentTag(result){
				date = dealDate(result.comment.commentTime);
				html = "<div class='commnet-single'>"+
					"<a href='#'>" + 
					result.comment.username +
					"</a>:"+result.comment.content+"<div class='comment-publish-time'>"+date+"</div></div >"
				$('#comment-list').append(html);
				
			}
			
			function dealDate(date){
				var date = new Date(date);
				Y = date.getFullYear() + '-';
				M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
				D = date.getDate() + ' ';
				return Y+M+D;
			}
    	});
    </script>
    <title>鸿彬的主页</title>
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
                    <article class="post tag-about-ghost tag-ghost-in-depth tag-lin-hong-bin">
                        <div class="post-header">
                            <h1 class="post-title">
                                <a href="#">Java “反射”的乐趣</a>
                            </h1>
                            <div class="post-meta">
                                <span class="author">
                                   	 作者:
                                    <a href="#"><c:out value="${article.author}"/></a>
                                </span>
                                <time class="date" datetime="2015-1-15">2015-1-15</time>
                            </div>
                            <div class="post-content">
                                <p>
                             		<c:out value="${article.content}"/>
                                </p>
                            </div>
                            <div class="footer clearfix">
                                <hr>
                                <div class="pull-left tag-list">
                                    <a href="#">Java</a>
                                    <a href="#">反射</a>
                                    <a href="#">学习</a>
                                </div>
                            </div>
                        </div>
                    </article>
					<div class="main-comment">
						<div id="comment-list" class="comment-list">
	                        <strong>评论:</strong>
		                    <c:forEach var="item" items="${commemtList}">
	                   			<div class="commnet-single">
		                            <a href="#"><c:out value="${item.username}"/>:</a>
		                            <c:out value="${item.content}"/>
		                            <div class="comment-publish-time"><c:out value="${item.commentTimeStr}"/></div>
		                            <hr/>
	                        	</div>
		                  	</c:forEach>
	                  	</div>
						<div class="comment-header">
						<!-- 判断当前用户是否已经登录 -->
						<c:if test="${user==null}" var="flag" scope="page">
							回复请先<a id="loginUrl" href="front_login.jsp">登录</a><br/>
						</c:if>
						<c:if test="${user!=null}" var="flag" scope="page">
							回复:
						</c:if>
						
						</div>
						<textarea id="commentTextare" class="form-control comment-edit"></textarea>
						
						<div class="comment-send">
							<input id="commentBt" type="button" value="评论">
						</div>
						
						
					</div>
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
                </aside>
            </div>
        </div>
    </section>
    
    <!-- 页脚 -->
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

