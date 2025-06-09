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


import com.dao.QuweishipinDao;
import com.entity.QuweishipinEntity;
import com.service.QuweishipinService;
import com.entity.vo.QuweishipinVO;
import com.entity.view.QuweishipinView;

@Service("quweishipinService")
public class QuweishipinServiceImpl extends ServiceImpl<QuweishipinDao, QuweishipinEntity> implements QuweishipinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QuweishipinEntity> page = this.selectPage(
                new Query<QuweishipinEntity>(params).getPage(),
                new EntityWrapper<QuweishipinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QuweishipinEntity> wrapper) {
		  Page<QuweishipinView> page =new Query<QuweishipinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QuweishipinVO> selectListVO(Wrapper<QuweishipinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QuweishipinVO selectVO(Wrapper<QuweishipinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QuweishipinView> selectListView(Wrapper<QuweishipinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QuweishipinView selectView(Wrapper<QuweishipinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
