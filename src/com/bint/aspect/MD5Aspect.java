package com.bint.aspect;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.bint.model.UserModel;
import com.bint.util.MD5Util;
import com.bint.vo.UserVo;
@Component
@Aspect
public class MD5Aspect {
	int i = 0;
	//@Around("execution(* com.bint.service.impl..*.*(..))")
	//@Around("execution(* com.bint.service.impl.UserServiceImpl.listAll(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		Object[] args = joinPoint.getArgs();
		//UserVo userVo = (UserVo) args[0];
		System.out.println("aspect is running");
		//System.out.println("in the aspect:" + userVo.getPassword());
		//UserModel userModel = (UserModel) joinPoint.proceed();
		//System.out.println("MD5Aspect is running");
		List<UserModel> result = (List<UserModel>) joinPoint.proceed();
		return result;
	}
	
	@Around("execution(* com.bint.service.impl.UserServiceImpl.login(..))")
	public Object loginAround(ProceedingJoinPoint joinPoint) throws Throwable{
		i++;
		System.out.println("aspect start " + i);
		Object[] args =  joinPoint.getArgs();
		UserVo user = (UserVo) args[0];
		//System.out.println("in the aspect : username is " + user.getUsername());
		System.out.println("in the aspect : password is " + user.getPassword());
		user.setPassword(MD5Util.encrypt(user.getPassword()));
		args[0] = user;
		System.out.println("in the aspect : password is " + user.getPassword());
		UserModel userModel = (UserModel) joinPoint.proceed(args);
		System.out.println("aspect is finished");
		return userModel;
	}
//	@Around("execution(* com.bint.service.impl.UserServiceImpl.save(..))")
	public void aroundSave(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("aspect start");
		Object[] args =  joinPoint.getArgs();
		UserModel user = (UserModel) args[0];
		user.setPassword(MD5Util.encrypt(user.getPassword()));
		args[0] = user;
		joinPoint.proceed(args);
	}
	
	//@Around("execution(* com.bint.service.impl.UserServiceImpl..update(..))")
	public void aroundUpdate(ProceedingJoinPoint joinPoint) throws Throwable{
		Object[] args =  joinPoint.getArgs();
		UserModel user = (UserModel) args[0];
		user.setPassword(MD5Util.encrypt(user.getPassword()));
		args[0] = user;
		joinPoint.proceed(args);
	}
	
}
