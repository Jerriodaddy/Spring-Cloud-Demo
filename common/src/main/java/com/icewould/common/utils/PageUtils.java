package com.icewould.common.utils;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;

public class PageUtils{
    /**
         * 将PageInfo对象泛型中的Po对象转化为Vo对象
         * @param pageInfoPo PageInfo<Po>对象</>
         * @param <P> Po类型
         * @param <V> Vo类型
         * @return
         * @author jerrio
     */
	
     public static <P, V> PageInfo<V> PageInfo2PageInfoVo(PageInfo<P> pageInfoPo) {
         
    	 PageInfo<V> pageInfoVo= new PageInfo<>();
         BeanUtils.copyProperties(pageInfoPo, pageInfoVo, "list");
         return pageInfoVo;
     }


}