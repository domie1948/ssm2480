package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.LishibeijingEntity;
import com.entity.view.LishibeijingView;

import com.service.LishibeijingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 历史背景
 * 后端接口
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
@RestController
@RequestMapping("/lishibeijing")
public class LishibeijingController {
    @Autowired
    private LishibeijingService lishibeijingService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LishibeijingEntity lishibeijing, HttpServletRequest request){

        EntityWrapper<LishibeijingEntity> ew = new EntityWrapper<LishibeijingEntity>();
		PageUtils page = lishibeijingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lishibeijing), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LishibeijingEntity lishibeijing, HttpServletRequest request){
        EntityWrapper<LishibeijingEntity> ew = new EntityWrapper<LishibeijingEntity>();
		PageUtils page = lishibeijingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lishibeijing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LishibeijingEntity lishibeijing){
       	EntityWrapper<LishibeijingEntity> ew = new EntityWrapper<LishibeijingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lishibeijing, "lishibeijing")); 
        return R.ok().put("data", lishibeijingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LishibeijingEntity lishibeijing){
        EntityWrapper< LishibeijingEntity> ew = new EntityWrapper< LishibeijingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lishibeijing, "lishibeijing")); 
		LishibeijingView lishibeijingView =  lishibeijingService.selectView(ew);
		return R.ok("查询历史背景成功").put("data", lishibeijingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LishibeijingEntity lishibeijing = lishibeijingService.selectById(id);
        return R.ok().put("data", lishibeijing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LishibeijingEntity lishibeijing = lishibeijingService.selectById(id);
        return R.ok().put("data", lishibeijing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LishibeijingEntity lishibeijing, HttpServletRequest request){
    	lishibeijing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lishibeijing);

        lishibeijingService.insert(lishibeijing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LishibeijingEntity lishibeijing, HttpServletRequest request){
    	lishibeijing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lishibeijing);

        lishibeijingService.insert(lishibeijing);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody LishibeijingEntity lishibeijing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lishibeijing);
        lishibeijingService.updateById(lishibeijing);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lishibeijingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<LishibeijingEntity> wrapper = new EntityWrapper<LishibeijingEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = lishibeijingService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
