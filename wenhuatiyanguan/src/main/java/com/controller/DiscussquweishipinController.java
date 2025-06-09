package com.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.entity.YonghuEntity;
import com.service.YonghuService;
import com.utils.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussquweishipinEntity;
import com.entity.view.DiscussquweishipinView;

import com.service.DiscussquweishipinService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 趣味视频评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
@RestController
@RequestMapping("/discussquweishipin")
public class DiscussquweishipinController {
    @Autowired
    private DiscussquweishipinService discussquweishipinService;

    @Autowired
    private YonghuService yonghuService;



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussquweishipinEntity discussquweishipin, HttpServletRequest request){

        EntityWrapper<DiscussquweishipinEntity> ew = new EntityWrapper<DiscussquweishipinEntity>();
		PageUtils page = discussquweishipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussquweishipin), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussquweishipinEntity discussquweishipin, HttpServletRequest request){
        EntityWrapper<DiscussquweishipinEntity> ew = new EntityWrapper<DiscussquweishipinEntity>();
		PageUtils page = discussquweishipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussquweishipin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussquweishipinEntity discussquweishipin){
       	EntityWrapper<DiscussquweishipinEntity> ew = new EntityWrapper<DiscussquweishipinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussquweishipin, "discussquweishipin")); 
        return R.ok().put("data", discussquweishipinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussquweishipinEntity discussquweishipin){
        EntityWrapper< DiscussquweishipinEntity> ew = new EntityWrapper< DiscussquweishipinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussquweishipin, "discussquweishipin")); 
		DiscussquweishipinView discussquweishipinView =  discussquweishipinService.selectView(ew);
		return R.ok("查询趣味视频评论表成功").put("data", discussquweishipinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussquweishipinEntity discussquweishipin = discussquweishipinService.selectById(id);
        return R.ok().put("data", discussquweishipin);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussquweishipinEntity discussquweishipin = discussquweishipinService.selectById(id);
        return R.ok().put("data", discussquweishipin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussquweishipinEntity discussquweishipin, HttpServletRequest request){
    	discussquweishipin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        Long userId = (Long) request.getSession().getAttribute("userId");
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);
        Object role = request.getSession().getAttribute("role");
        if(!role.equals("用户")){
            return R.error();
        }
        if(yonghuEntity.getBanned() != 0){
            return R.error("你已经被禁言");
        }
        discussquweishipinService.insert(discussquweishipin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussquweishipinEntity discussquweishipin, HttpServletRequest request){
    	discussquweishipin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussquweishipin);

        discussquweishipinService.insert(discussquweishipin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscussquweishipinEntity discussquweishipin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussquweishipin);
        discussquweishipinService.updateById(discussquweishipin);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussquweishipinService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DiscussquweishipinEntity> wrapper = new EntityWrapper<DiscussquweishipinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussquweishipinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
