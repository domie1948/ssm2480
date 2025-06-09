package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LishibeijingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LishibeijingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LishibeijingView;


/**
 * 历史背景
 *
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
public interface LishibeijingService extends IService<LishibeijingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LishibeijingVO> selectListVO(Wrapper<LishibeijingEntity> wrapper);
   	
   	LishibeijingVO selectVO(@Param("ew") Wrapper<LishibeijingEntity> wrapper);
   	
   	List<LishibeijingView> selectListView(Wrapper<LishibeijingEntity> wrapper);
   	
   	LishibeijingView selectView(@Param("ew") Wrapper<LishibeijingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LishibeijingEntity> wrapper);
   	
}

