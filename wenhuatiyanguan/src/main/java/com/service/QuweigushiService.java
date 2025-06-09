package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QuweigushiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QuweigushiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QuweigushiView;


/**
 * 趣味故事
 *
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
public interface QuweigushiService extends IService<QuweigushiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QuweigushiVO> selectListVO(Wrapper<QuweigushiEntity> wrapper);
   	
   	QuweigushiVO selectVO(@Param("ew") Wrapper<QuweigushiEntity> wrapper);
   	
   	List<QuweigushiView> selectListView(Wrapper<QuweigushiEntity> wrapper);
   	
   	QuweigushiView selectView(@Param("ew") Wrapper<QuweigushiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QuweigushiEntity> wrapper);
   	
}

