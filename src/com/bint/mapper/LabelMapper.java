package com.bint.mapper;

import java.util.List;

import com.bint.mapper.base.BaseMapper;
import com.bint.model.LabelModel;
import com.bint.vo.PageVo;

public interface LabelMapper extends BaseMapper<LabelModel>{
	public List<LabelModel> getList(PageVo pageVo);
}
