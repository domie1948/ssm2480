package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZhizuoshipinDao;
import com.entity.ZhizuoshipinEntity;
import com.service.ZhizuoshipinService;
import com.entity.vo.ZhizuoshipinVO;
import com.entity.view.ZhizuoshipinView;

@Service("zhizuoshipinService")
public class ZhizuoshipinServiceImpl extends ServiceImpl<ZhizuoshipinDao, ZhizuoshipinEntity> implements ZhizuoshipinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhizuoshipinEntity> page = this.selectPage(
                new Query<ZhizuoshipinEntity>(params).getPage(),
                new EntityWrapper<ZhizuoshipinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhizuoshipinEntity> wrapper) {
		  Page<ZhizuoshipinView> page =new Query<ZhizuoshipinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhizuoshipinVO> selectListVO(Wrapper<ZhizuoshipinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhizuoshipinVO selectVO(Wrapper<ZhizuoshipinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhizuoshipinView> selectListView(Wrapper<ZhizuoshipinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhizuoshipinView selectView(Wrapper<ZhizuoshipinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
