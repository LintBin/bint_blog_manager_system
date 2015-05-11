package com.bint.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bint.controller.base.BaseController;
import com.bint.model.CommentModel;
import com.bint.model.UserModel;
import com.bint.service.CommentService;
import com.bint.vo.CommentVo;
import com.bint.vo.PageVo;

@Controller
public class CommentController extends BaseController{
	@Autowired
	private CommentService commentServiceImpl;
	
	@RequestMapping(value = "front/commentAdd",method = RequestMethod.POST)
	public @ResponseBody ModelMap add(HttpSession httpSession,CommentModel comment){
		UserModel user = (UserModel) httpSession.getAttribute("user");
		comment.setUserId(user.getId());
		comment.setCommentTime(new Date());
		CommentVo returnComment = commentServiceImpl.saveAndReturn(comment);
		return success("comment",returnComment);
	}
	
	@RequestMapping(value = "comment/commentListByBlogId" , method=RequestMethod.GET)
	public @ResponseBody ModelMap list(Long blogId){
		List<CommentVo> result = commentServiceImpl.listCommentByBlogId(blogId);
		return success(result);
	}
	
	@RequestMapping(value = "comment/getPageComment" , method=RequestMethod.GET)
	public String getPageComment(PageVo pageVo, Model model){
		pageVo = commentServiceImpl.getPage(pageVo);
		model.addAttribute("pageVo", pageVo);
		return "jsp/comment/manageComment";
	}
	
	@RequestMapping(value = "comment/commentQuery" , method=RequestMethod.POST)
	public String commentQuery(PageVo pageVo , CommentVo commentVo,Model model){
		if(commentVo == null){
			commentVo = new CommentVo();
		}
		pageVo.setObject(commentVo);
		pageVo = commentServiceImpl.getPage(pageVo);
		System.err.println(pageVo.getCurrentPage());
		model.addAttribute("pageVo", pageVo);
		return "jsp/comment/manageComment";
	}
	@RequestMapping(value = "comment/deleteComment")
	public @ResponseBody ModelMap deleteCommnet(Long commentId){
		commentServiceImpl.delete(commentId);
		return success();
	}
	
	
	
}
