package com.bint.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.bint.controller.base.BaseController;
import com.bint.model.ArticleModel;
import com.bint.service.ArticleService;
import com.bint.vo.ArticleVo;
import com.bint.vo.PageVo;

@Controller
public class ArticleController extends BaseController {
	@Autowired
	private ArticleService articleServiceImpl;

	/**
	 * 跳转到分页页面
	 * 
	 * @param pageVo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "getPageArticle")
	public String getPageArticle(PageVo pageVo, Model model) {
		pageVo = articleServiceImpl.getPage(pageVo);
		model.addAttribute("pageVo", pageVo);
		return "jsp/article/manageArticle";
	}

	@RequestMapping(value = "addArticle", method = RequestMethod.POST)
	public @ResponseBody ModelMap save(ArticleVo article) {
		articleServiceImpl.save(article);
		return sucess();
	}

	@RequestMapping(value = "editArtcle")
	public String edit(ArticleVo article, Model model) {
		ArticleModel articleModel = articleServiceImpl.findById(article
				.getArticleId());
		model.addAttribute("article", articleModel);
		return "jsp/article/editArticle";
	}

	@RequestMapping(value = "updateArticle")
	public @ResponseBody ModelMap update(ArticleVo article, Model model) {
		System.err.println("content:"+article.getContent());
		System.err.println("id:"+ article.getArticleId());
		articleServiceImpl.update(article);
		return sucess();
	}
	
	
	@RequestMapping(value = "deleteArticle")
	public @ResponseBody ModelMap delete(ArticleVo article) {
		try{
			articleServiceImpl.delete(article.getArticleId());
		}catch(Exception e){
			e.printStackTrace();
		}
		return sucess();
	}
	
	@RequestMapping(value = "queryArticle")
	public String queryArticle(ArticleVo articleVo, Model model) {
		System.err.println(articleVo.toString());
		PageVo pageVo = articleServiceImpl.fuzzyQuery(articleVo);
		model.addAttribute("pageVo", pageVo);
		return "jsp/article/manageArticle";
	}

	@RequestMapping(value = "uploadImg", method = RequestMethod.POST)
	 public void uploadImage(HttpServletRequest request,
	            HttpServletResponse response)throws Exception{
	        ServletOutputStream out = response.getOutputStream();
	        request.setCharacterEncoding( "utf-8" );
	        response.setHeader("Content-Type" , "text/html");
	        
	        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
	                request.getSession().getServletContext());
	        // 设置编码
	        commonsMultipartResolver.setDefaultEncoding("utf-8");
	        if (commonsMultipartResolver.isMultipart(request)) {
	            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	            MultipartFile image = multipartRequest.getFile("filedata");
	            String url = "images"+File.separator;
	            //这里可以从项目中取得你项目根目录的地址
	            String filePath = "D:/plus_for_eclipse/tomcat_for_demo_eclipse/apache-tomcat-7.0.53/wtpwebapps/bint_blog_manager_system/"+url;
	            Random r = new Random();
	            if(image != null && !image.isEmpty()){
	                InputStream xtins = image.getInputStream();
	                String hj = new String(image.getOriginalFilename().getBytes("ISO-8859-1"),"UTF-8");
	                hj = hj.split("\\.")[1];
	                //这里用来生成文件名
	                String fileName = r.nextInt(1000)+"."+hj;
	                System.err.println(fileName);
	                saveInputStreamToFile(filePath, fileName, xtins);
	                //这里是用来返回给xheditor的
	                out.print("{'err':'','msg':'"+ ("images/" + fileName).replace("\\", "/")+"'}");
	            }
	        }
	    }

	/**
	 * 保存文件流到指定路径
	 * 
	 * @param filePath
	 * @param fileName
	 * @param inputStream
	 * @throws Exception
	 */
	public void saveInputStreamToFile(String filePath, String fileName,
			InputStream inputStream) throws Exception {
		OutputStream os = null;
		try {
			File forder = new File(filePath);
			if (!forder.exists()) {
				forder.mkdir();
			}
			File file = new File(filePath + fileName);
			os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			inputStream.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (os != null) {
				os.close();
			}
		}
	}
}
