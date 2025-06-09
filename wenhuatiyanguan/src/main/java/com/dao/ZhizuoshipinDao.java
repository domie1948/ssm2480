package com.dao;

import com.entity.ZhizuoshipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhizuoshipinVO;
import com.entity.view.ZhizuoshipinView;


/**
 * 制作视频
 * 
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
public interface ZhizuoshipinDao extends BaseMapper<ZhizuoshipinEntity> {
	
	List<ZhizuoshipinVO> selectListVO(@Param("ew") Wrapper<ZhizuoshipinEntity> wrapper);
	
	ZhizuoshipinVO selectVO(@Param("ew") Wrapper<ZhizuoshipinEntity> wrapper);
	
	List<ZhizuoshipinView> selectListView(@Param("ew") Wrapper<ZhizuoshipinEntity> wrapper);

	List<ZhizuoshipinView> selectListView(Pagination page,@Param("ew") Wrapper<ZhizuoshipinEntity> wrapper);
	
	ZhizuoshipinView selectView(@Param("ew") Wrapper<ZhizuoshipinEntity> wrapper);
	
}
