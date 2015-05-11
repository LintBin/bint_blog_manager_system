package com.bint.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bint.mapper.CommentMapper;
import com.bint.model.CommentModel;
import com.bint.service.CommentService;
import com.bint.service.base.impl.BaseServiceImpl;
import com.bint.util.DateUtil;
import com.bint.vo.CommentVo;
import com.bint.vo.PageVo;



@Transactional
@Component
public class CommentServiceImpl extends BaseServiceImpl<CommentModel> implements CommentService{
	private CommentMapper commentMapper;
	
	@Resource
	public void setCommentMapper(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
		this.setBaseMapper(commentMapper);
	}

	@Override
	public List<CommentVo> listCommentByBlogId(Long blogId) {
		List<CommentVo> result = commentMapper.listCommentByBlogId(blogId);
		for(int i=0;i<result.size();i++){
			Date date = result.get(i).getCommentTime();
			String dateStr = DateUtil.getDateStr(date);
			result.get(i).setCommentTimeStr(dateStr);
		}
		return result;
	}
	
	/*添加并返回这条评论信息*/
	@Override
	public CommentVo saveAndReturn(CommentModel commentModel) {
		commentMapper.add(commentModel);
		return commentMapper.getLatestCommentByUserId(commentModel.getUserId());
	}
	
	
	@Override
	public PageVo getPage(PageVo pageVo){
		List<CommentVo> result = commentMapper.getPageComment(pageVo);
		pageVo.setAmount(baseMapper.getAmount(pageVo));
		for(int i=0;i<result.size();i++){
			Date date = result.get(i).getCommentTime();
			String dateStr = DateUtil.getDateStr(date);
			result.get(i).setCommentTimeStr(dateStr);
		}
		pageVo.setList(result);
		pageVo.setCurrentPage(pageVo.getPageNum());
		return pageVo;
	}
}
