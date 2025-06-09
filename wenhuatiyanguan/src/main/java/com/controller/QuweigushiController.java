package com.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

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

import com.entity.QuweigushiEntity;
import com.entity.view.QuweigushiView;

import com.service.QuweigushiService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 趣味故事
 * 后端接口
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
@RestController
@RequestMapping("/quweigushi")
public class QuweigushiController {
    @Autowired
    private QuweigushiService quweigushiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QuweigushiEntity quweigushi, HttpServletRequest request){

        EntityWrapper<QuweigushiEntity> ew = new EntityWrapper<QuweigushiEntity>();
		PageUtils page = quweigushiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quweigushi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QuweigushiEntity quweigushi, HttpServletRequest request){
        EntityWrapper<QuweigushiEntity> ew = new EntityWrapper<QuweigushiEntity>();
		PageUtils page = quweigushiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quweigushi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QuweigushiEntity quweigushi){
       	EntityWrapper<QuweigushiEntity> ew = new EntityWrapper<QuweigushiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( quweigushi, "quweigushi")); 
        return R.ok().put("data", quweigushiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QuweigushiEntity quweigushi){
        EntityWrapper< QuweigushiEntity> ew = new EntityWrapper< QuweigushiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( quweigushi, "quweigushi")); 
		QuweigushiView quweigushiView =  quweigushiService.selectView(ew);
		return R.ok("查询趣味故事成功").put("data", quweigushiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QuweigushiEntity quweigushi = quweigushiService.selectById(id);
        return R.ok().put("data", quweigushi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QuweigushiEntity quweigushi = quweigushiService.selectById(id);
        return R.ok().put("data", quweigushi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QuweigushiEntity quweigushi, HttpServletRequest request){
    	quweigushi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(quweigushi);

        quweigushiService.insert(quweigushi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QuweigushiEntity quweigushi, HttpServletRequest request){
    	quweigushi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(quweigushi);

        quweigushiService.insert(quweigushi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody QuweigushiEntity quweigushi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quweigushi);
        quweigushiService.updateById(quweigushi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        quweigushiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<QuweigushiEntity> wrapper = new EntityWrapper<QuweigushiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = quweigushiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
