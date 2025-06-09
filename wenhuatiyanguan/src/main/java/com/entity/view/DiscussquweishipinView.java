package com.entity.view;

import com.entity.DiscussquweishipinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 趣味视频评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
@TableName("discussquweishipin")
public class DiscussquweishipinView  extends DiscussquweishipinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussquweishipinView(){
	}
 
 	public DiscussquweishipinView(DiscussquweishipinEntity discussquweishipinEntity){
 	try {
			BeanUtils.copyProperties(this, discussquweishipinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
