package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussquweishipinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussquweishipinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussquweishipinView;


/**
 * 趣味视频评论表
 *
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
public interface DiscussquweishipinService extends IService<DiscussquweishipinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussquweishipinVO> selectListVO(Wrapper<DiscussquweishipinEntity> wrapper);
   	
   	DiscussquweishipinVO selectVO(@Param("ew") Wrapper<DiscussquweishipinEntity> wrapper);
   	
   	List<DiscussquweishipinView> selectListView(Wrapper<DiscussquweishipinEntity> wrapper);
   	
   	DiscussquweishipinView selectView(@Param("ew") Wrapper<DiscussquweishipinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussquweishipinEntity> wrapper);
   	
}

