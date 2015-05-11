package com.bint.service;

import java.util.List;

import com.bint.model.CommentModel;
import com.bint.service.base.BaseService;
import com.bint.vo.CommentVo;

public interface CommentService extends BaseService<CommentModel>{
	public List<CommentVo> listCommentByBlogId(Long blogId);
	public CommentVo saveAndReturn(CommentModel commentModel);
}
