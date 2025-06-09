package com.dao;

import com.entity.QuweigushiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QuweigushiVO;
import com.entity.view.QuweigushiView;


/**
 * 趣味故事
 * 
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
public interface QuweigushiDao extends BaseMapper<QuweigushiEntity> {
	
	List<QuweigushiVO> selectListVO(@Param("ew") Wrapper<QuweigushiEntity> wrapper);
	
	QuweigushiVO selectVO(@Param("ew") Wrapper<QuweigushiEntity> wrapper);
	
	List<QuweigushiView> selectListView(@Param("ew") Wrapper<QuweigushiEntity> wrapper);

	List<QuweigushiView> selectListView(Pagination page,@Param("ew") Wrapper<QuweigushiEntity> wrapper);
	
	QuweigushiView selectView(@Param("ew") Wrapper<QuweigushiEntity> wrapper);
	
}
