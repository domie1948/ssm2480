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


import com.dao.QuweigushiDao;
import com.entity.QuweigushiEntity;
import com.service.QuweigushiService;
import com.entity.vo.QuweigushiVO;
import com.entity.view.QuweigushiView;

@Service("quweigushiService")
public class QuweigushiServiceImpl extends ServiceImpl<QuweigushiDao, QuweigushiEntity> implements QuweigushiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QuweigushiEntity> page = this.selectPage(
                new Query<QuweigushiEntity>(params).getPage(),
                new EntityWrapper<QuweigushiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QuweigushiEntity> wrapper) {
		  Page<QuweigushiView> page =new Query<QuweigushiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QuweigushiVO> selectListVO(Wrapper<QuweigushiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QuweigushiVO selectVO(Wrapper<QuweigushiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QuweigushiView> selectListView(Wrapper<QuweigushiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QuweigushiView selectView(Wrapper<QuweigushiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
