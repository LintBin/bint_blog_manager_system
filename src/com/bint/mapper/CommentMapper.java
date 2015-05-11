package com.bint.mapper;

import java.util.List;

import com.bint.mapper.base.BaseMapper;
import com.bint.model.CommentModel;
import com.bint.vo.CommentVo;
import com.bint.vo.PageVo;

public interface CommentMapper extends BaseMapper<CommentModel>{
	public List<CommentVo> listCommentByBlogId(Long blogId);
	/*获得指定用户的最新的一条评论*/
	public CommentVo getLatestCommentByUserId(Long userId);
	public List<CommentVo> getPageComment(PageVo pageVo);
}
