package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QuweishipinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QuweishipinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QuweishipinView;


/**
 * 趣味视频
 *
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
public interface QuweishipinService extends IService<QuweishipinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QuweishipinVO> selectListVO(Wrapper<QuweishipinEntity> wrapper);
   	
   	QuweishipinVO selectVO(@Param("ew") Wrapper<QuweishipinEntity> wrapper);
   	
   	List<QuweishipinView> selectListView(Wrapper<QuweishipinEntity> wrapper);
   	
   	QuweishipinView selectView(@Param("ew") Wrapper<QuweishipinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QuweishipinEntity> wrapper);
   	
}

