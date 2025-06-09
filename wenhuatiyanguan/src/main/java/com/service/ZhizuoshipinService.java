package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhizuoshipinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhizuoshipinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhizuoshipinView;


/**
 * 制作视频
 *
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
public interface ZhizuoshipinService extends IService<ZhizuoshipinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhizuoshipinVO> selectListVO(Wrapper<ZhizuoshipinEntity> wrapper);
   	
   	ZhizuoshipinVO selectVO(@Param("ew") Wrapper<ZhizuoshipinEntity> wrapper);
   	
   	List<ZhizuoshipinView> selectListView(Wrapper<ZhizuoshipinEntity> wrapper);
   	
   	ZhizuoshipinView selectView(@Param("ew") Wrapper<ZhizuoshipinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhizuoshipinEntity> wrapper);
   	
}

