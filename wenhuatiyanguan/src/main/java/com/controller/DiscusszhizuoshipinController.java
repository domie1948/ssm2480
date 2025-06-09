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

import com.entity.YonghuEntity;
import com.service.YonghuService;
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

import com.entity.DiscusszhizuoshipinEntity;
import com.entity.view.DiscusszhizuoshipinView;

import com.service.DiscusszhizuoshipinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 制作视频评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
@RestController
@RequestMapping("/discusszhizuoshipin")
public class DiscusszhizuoshipinController {
    @Autowired
    private DiscusszhizuoshipinService discusszhizuoshipinService;
    @Autowired
    private YonghuService yonghuService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusszhizuoshipinEntity discusszhizuoshipin, HttpServletRequest request){

        EntityWrapper<DiscusszhizuoshipinEntity> ew = new EntityWrapper<DiscusszhizuoshipinEntity>();
		PageUtils page = discusszhizuoshipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhizuoshipin), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusszhizuoshipinEntity discusszhizuoshipin, HttpServletRequest request){
        EntityWrapper<DiscusszhizuoshipinEntity> ew = new EntityWrapper<DiscusszhizuoshipinEntity>();
		PageUtils page = discusszhizuoshipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhizuoshipin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusszhizuoshipinEntity discusszhizuoshipin){
       	EntityWrapper<DiscusszhizuoshipinEntity> ew = new EntityWrapper<DiscusszhizuoshipinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusszhizuoshipin, "discusszhizuoshipin")); 
        return R.ok().put("data", discusszhizuoshipinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusszhizuoshipinEntity discusszhizuoshipin){
        EntityWrapper< DiscusszhizuoshipinEntity> ew = new EntityWrapper< DiscusszhizuoshipinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusszhizuoshipin, "discusszhizuoshipin")); 
		DiscusszhizuoshipinView discusszhizuoshipinView =  discusszhizuoshipinService.selectView(ew);
		return R.ok("查询制作视频评论表成功").put("data", discusszhizuoshipinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusszhizuoshipinEntity discusszhizuoshipin = discusszhizuoshipinService.selectById(id);
        return R.ok().put("data", discusszhizuoshipin);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusszhizuoshipinEntity discusszhizuoshipin = discusszhizuoshipinService.selectById(id);
        return R.ok().put("data", discusszhizuoshipin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusszhizuoshipinEntity discusszhizuoshipin, HttpServletRequest request){
    	discusszhizuoshipin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        Long userId = (Long) request.getSession().getAttribute("userId");
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);
        Object role = request.getSession().getAttribute("role");
        if(!role.equals("用户")){
            return R.error();
        }
        if(yonghuEntity.getBanned() != 0){
            return R.error("你已经被禁言");
        }
        discusszhizuoshipinService.insert(discusszhizuoshipin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusszhizuoshipinEntity discusszhizuoshipin, HttpServletRequest request){
    	discusszhizuoshipin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszhizuoshipin);

        discusszhizuoshipinService.insert(discusszhizuoshipin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscusszhizuoshipinEntity discusszhizuoshipin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusszhizuoshipin);
        discusszhizuoshipinService.updateById(discusszhizuoshipin);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusszhizuoshipinService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DiscusszhizuoshipinEntity> wrapper = new EntityWrapper<DiscusszhizuoshipinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discusszhizuoshipinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
