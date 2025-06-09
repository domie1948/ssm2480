package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszhizuoshipinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszhizuoshipinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszhizuoshipinView;


/**
 * 制作视频评论表
 *
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
public interface DiscusszhizuoshipinService extends IService<DiscusszhizuoshipinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszhizuoshipinVO> selectListVO(Wrapper<DiscusszhizuoshipinEntity> wrapper);
   	
   	DiscusszhizuoshipinVO selectVO(@Param("ew") Wrapper<DiscusszhizuoshipinEntity> wrapper);
   	
   	List<DiscusszhizuoshipinView> selectListView(Wrapper<DiscusszhizuoshipinEntity> wrapper);
   	
   	DiscusszhizuoshipinView selectView(@Param("ew") Wrapper<DiscusszhizuoshipinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszhizuoshipinEntity> wrapper);
   	
}

