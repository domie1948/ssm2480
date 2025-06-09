package com.entity.view;

import com.entity.QuweigushiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 趣味故事
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-02-22 15:48:18
 */
@TableName("quweigushi")
public class QuweigushiView  extends QuweigushiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public QuweigushiView(){
	}
 
 	public QuweigushiView(QuweigushiEntity quweigushiEntity){
 	try {
			BeanUtils.copyProperties(this, quweigushiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
