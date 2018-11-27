package com.zhumian.groceryshop.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Slf4j
public class BeanUtil {

    public static void obj2obj(Object source, Object target){
        if(source == null || target == null){
            return;
        }

        BeanUtils.copyProperties(source, target);
    }

    public static void list2list(List sourceList, List targetList, Class targetClass){
        if(!CollectionUtils.isEmpty(sourceList) && targetList != null){
            for(Object source : sourceList){
                Object target = getInstanceByReflect(targetClass);
                BeanUtils.copyProperties(source, target);
                targetList.add(target);
            }
        }

    }

    public static Object getInstanceByReflect(Class clazz){
        return getInstanceByReflect(clazz.getName());
    }

    private static Object getInstanceByReflect(String className){
        Object target = null;
        try {
            target = Class.forName(className).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }
        return target;
    }
}
