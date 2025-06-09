package com.dao;

import com.entity.LishibeijingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LishibeijingVO;
import com.entity.view.LishibeijingView;


/**
 * 历史背景
 * 
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
public interface LishibeijingDao extends BaseMapper<LishibeijingEntity> {
	
	List<LishibeijingVO> selectListVO(@Param("ew") Wrapper<LishibeijingEntity> wrapper);
	
	LishibeijingVO selectVO(@Param("ew") Wrapper<LishibeijingEntity> wrapper);
	
	List<LishibeijingView> selectListView(@Param("ew") Wrapper<LishibeijingEntity> wrapper);

	List<LishibeijingView> selectListView(Pagination page,@Param("ew") Wrapper<LishibeijingEntity> wrapper);
	
	LishibeijingView selectView(@Param("ew") Wrapper<LishibeijingEntity> wrapper);
	
}
