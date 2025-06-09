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


import com.dao.DiscussquweishipinDao;
import com.entity.DiscussquweishipinEntity;
import com.service.DiscussquweishipinService;
import com.entity.vo.DiscussquweishipinVO;
import com.entity.view.DiscussquweishipinView;

@Service("discussquweishipinService")
public class DiscussquweishipinServiceImpl extends ServiceImpl<DiscussquweishipinDao, DiscussquweishipinEntity> implements DiscussquweishipinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussquweishipinEntity> page = this.selectPage(
                new Query<DiscussquweishipinEntity>(params).getPage(),
                new EntityWrapper<DiscussquweishipinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussquweishipinEntity> wrapper) {
		  Page<DiscussquweishipinView> page =new Query<DiscussquweishipinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussquweishipinVO> selectListVO(Wrapper<DiscussquweishipinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussquweishipinVO selectVO(Wrapper<DiscussquweishipinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussquweishipinView> selectListView(Wrapper<DiscussquweishipinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussquweishipinView selectView(Wrapper<DiscussquweishipinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
