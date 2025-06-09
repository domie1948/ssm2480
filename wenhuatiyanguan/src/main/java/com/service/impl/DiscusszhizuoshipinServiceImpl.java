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


import com.dao.DiscusszhizuoshipinDao;
import com.entity.DiscusszhizuoshipinEntity;
import com.service.DiscusszhizuoshipinService;
import com.entity.vo.DiscusszhizuoshipinVO;
import com.entity.view.DiscusszhizuoshipinView;

@Service("discusszhizuoshipinService")
public class DiscusszhizuoshipinServiceImpl extends ServiceImpl<DiscusszhizuoshipinDao, DiscusszhizuoshipinEntity> implements DiscusszhizuoshipinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszhizuoshipinEntity> page = this.selectPage(
                new Query<DiscusszhizuoshipinEntity>(params).getPage(),
                new EntityWrapper<DiscusszhizuoshipinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszhizuoshipinEntity> wrapper) {
		  Page<DiscusszhizuoshipinView> page =new Query<DiscusszhizuoshipinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusszhizuoshipinVO> selectListVO(Wrapper<DiscusszhizuoshipinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszhizuoshipinVO selectVO(Wrapper<DiscusszhizuoshipinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszhizuoshipinView> selectListView(Wrapper<DiscusszhizuoshipinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszhizuoshipinView selectView(Wrapper<DiscusszhizuoshipinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
