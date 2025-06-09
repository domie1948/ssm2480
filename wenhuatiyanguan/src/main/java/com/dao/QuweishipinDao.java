package com.dao;

import com.entity.QuweishipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QuweishipinVO;
import com.entity.view.QuweishipinView;


/**
 * 趣味视频
 * 
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
public interface QuweishipinDao extends BaseMapper<QuweishipinEntity> {
	
	List<QuweishipinVO> selectListVO(@Param("ew") Wrapper<QuweishipinEntity> wrapper);
	
	QuweishipinVO selectVO(@Param("ew") Wrapper<QuweishipinEntity> wrapper);
	
	List<QuweishipinView> selectListView(@Param("ew") Wrapper<QuweishipinEntity> wrapper);

	List<QuweishipinView> selectListView(Pagination page,@Param("ew") Wrapper<QuweishipinEntity> wrapper);
	
	QuweishipinView selectView(@Param("ew") Wrapper<QuweishipinEntity> wrapper);
	
}
