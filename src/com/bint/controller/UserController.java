package com.bint.controller;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bint.controller.base.BaseController;
import com.bint.exception.NotDealtException;
import com.bint.model.UserModel;
import com.bint.service.UserService;
import com.bint.util.MD5Util;
import com.bint.vo.PageVo;
import com.bint.vo.UserVo;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

@Controller
public class UserController extends BaseController{
	@Resource
	private UserService userServiceImpl;
	
	/**
	 * 验证码
	 */
	private Producer captchaProducer = null;  
	  
    @Autowired  
    public void setCaptchaProducer(Producer captchaProducer) {  
        this.captchaProducer = captchaProducer;  
    }
    
	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public @ResponseBody ModelMap save(UserVo userVo) {
		userVo.setPermissionCode(1);
		UserModel userModel = new UserModel();
		userVo.setPassword(MD5Util.encrypt(userVo.getPassword()));
		BeanUtils.copyProperties(userVo, userModel);
		try{
			userServiceImpl.save(userModel);
		}catch(Exception e){
			e.printStackTrace();
			return failed();
		}
		return sucess();
	}
	/**
	 * 跳转到编辑页面
	 * @param uid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "editUser")
	public String edit(Long uid ,Model model) {
		UserModel user = userServiceImpl.findById(uid);
		model.addAttribute("editUserInfo", user);
		return "jsp/user/editUser";
	}
	
	
	@RequestMapping(value = "updateUser", method = RequestMethod.POST)
	public @ResponseBody ModelMap update(UserVo userVo) {
		userVo.setPermissionCode(1);
		UserModel userModel = new UserModel();
		userVo.setPassword(MD5Util.encrypt(userVo.getPassword()));
		BeanUtils.copyProperties(userVo, userModel);
		userServiceImpl.update(userModel);
		return sucess();
	}
	
	@RequestMapping("captcha-image")  
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {  
        response.setDateHeader("Expires", 0);  
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
        response.setHeader("Pragma", "no-cache");  
        response.setContentType("image/jpeg");  
        String capText = captchaProducer.createText();  
        System.err.println("capText:" + capText);
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);  
        BufferedImage bi = captchaProducer.createImage(capText);  
        ServletOutputStream out = response.getOutputStream();  
        ImageIO.write(bi, "jpg", out);  
        try {  
            out.flush();  
        } finally {  
            out.close();  
        }  
        return null;  
    }  
  
	
	
	@RequestMapping(value = "userList")
	public String list(Model model) {
		List<UserModel> list = userServiceImpl.listAll();
		model.addAttribute("userList", list);
		return "jsp/user/manageUser";
	}
	/**
	 * 管理员登录
	 * @param userVo
	 * @param code
	 * @param httpSession
	 * @return
	 * @throws NotDealtException
	 */
	@RequestMapping(value = "adminLogin", method = RequestMethod.POST)
	public String login(UserVo userVo,String code ,HttpSession httpSession) throws NotDealtException {
		String codeReal = (String)httpSession.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if(!codeReal.equals(code)){
			return "login";
		}
		UserModel userModel = userServiceImpl.login(userVo);
		if (userModel == null){
			return "login";
		}else{
			httpSession.setAttribute("user", userModel);
		}
		return "WEB-INF/adminIndex";
	}
	
	
	@RequestMapping(value = "userLogin", method = RequestMethod.POST)
	public String loginUser(UserVo userVo,HttpSession httpSession) throws NotDealtException {
		
		
		UserModel userModel = userServiceImpl.login(userVo);
		if (userModel == null){
			//TODO 返回登陆错误的信息
			return "userLogin";
		}else{
			//TODO 把用户的信息存放到session域
			httpSession.setAttribute("user", userModel);
		}
		return "WEB-INF/userIndex";
	}
	
	@RequestMapping(value = "deleteUser")
	public @ResponseBody ModelMap delete(Long uid){
		this.userServiceImpl.delete(uid);
		return sucess();
	}
	/**
	 * 分页
	 * @param pageVo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "getPageUser")
	public String getPage(PageVo pageVo , Model model){
		System.err.println(pageVo.toString());
		userServiceImpl.getPage(pageVo);
		model.addAttribute("pageVo", pageVo);
		List<UserModel> list = (List<UserModel>) pageVo.getList();
		return "jsp/user/manageUser";
	}
	
}
