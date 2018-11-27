package com.zhumian.groceryshop.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static Map obj2Map(Object obj){
        if(obj == null){
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        copyProperties(obj, map, true);
        return map;
    }

    public static void copyProperties(Object source, Map target, boolean cascade){
        Field[] fields = source.getClass().getDeclaredFields();
        if (cascade){
            Field[] parentFields = source.getClass().getSuperclass().getDeclaredFields();
            fields = ArrayUtils.addAll(fields, parentFields);
        }
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if(field.get(source) != null){
                    target.put(field.getName(), field.get(source));
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            log.error(e.getMessage(), e);
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
