package com.dao;

import com.entity.DiscussquweishipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussquweishipinVO;
import com.entity.view.DiscussquweishipinView;


/**
 * 趣味视频评论表
 * 
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
public interface DiscussquweishipinDao extends BaseMapper<DiscussquweishipinEntity> {
	
	List<DiscussquweishipinVO> selectListVO(@Param("ew") Wrapper<DiscussquweishipinEntity> wrapper);
	
	DiscussquweishipinVO selectVO(@Param("ew") Wrapper<DiscussquweishipinEntity> wrapper);
	
	List<DiscussquweishipinView> selectListView(@Param("ew") Wrapper<DiscussquweishipinEntity> wrapper);

	List<DiscussquweishipinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussquweishipinEntity> wrapper);
	
	DiscussquweishipinView selectView(@Param("ew") Wrapper<DiscussquweishipinEntity> wrapper);
	
}
