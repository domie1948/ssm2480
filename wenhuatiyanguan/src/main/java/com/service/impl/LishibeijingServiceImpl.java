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


import com.dao.LishibeijingDao;
import com.entity.LishibeijingEntity;
import com.service.LishibeijingService;
import com.entity.vo.LishibeijingVO;
import com.entity.view.LishibeijingView;

@Service("lishibeijingService")
public class LishibeijingServiceImpl extends ServiceImpl<LishibeijingDao, LishibeijingEntity> implements LishibeijingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LishibeijingEntity> page = this.selectPage(
                new Query<LishibeijingEntity>(params).getPage(),
                new EntityWrapper<LishibeijingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LishibeijingEntity> wrapper) {
		  Page<LishibeijingView> page =new Query<LishibeijingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LishibeijingVO> selectListVO(Wrapper<LishibeijingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LishibeijingVO selectVO(Wrapper<LishibeijingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LishibeijingView> selectListView(Wrapper<LishibeijingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LishibeijingView selectView(Wrapper<LishibeijingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
