package com.zhumian.groceryshop.util;

import com.zhumian.groceryshop.annotation.FuzzyQuery;
import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.entity.Example;

import javax.persistence.Transient;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

@Slf4j
public class ExampleUtil {

    public static Example createExample(Object obj, boolean isFuzzyQuery, Class entityClass){
        Example example = new Example(entityClass);
        Example.Criteria criteria = example.createCriteria();
        Field[] fields = ReflectUtil.getAllDeclaredFieldsOnlyPrivate(entityClass);
        Field field;
        for(int i = 0; i < fields.length; i++){
            field = fields[i];

            //不持久化的字段
            Transient annotation = field.getAnnotation(Transient.class);
            if(annotation != null){
                continue;
            }

            //忽略null值
            Object fieldValue = getFieldValueByName(field.getName(), obj, entityClass);
            if(fieldValue == null){
                continue;
            }

            if(isFuzzyQuery){
                fuzzyQuery(criteria, field, fieldValue);
            }else{
                criteria.andEqualTo(field.getName(), fieldValue);
            }
        }

        return example;
    }

    private static void fuzzyQuery(Example.Criteria criteria, Field field, Object fieldValue) {
        FuzzyQuery fuzzyQuery = field.getAnnotation(FuzzyQuery.class);
        if (fuzzyQuery != null) {
            // 双向模糊查询
            criteria.andLike(field.getName(), "%" + fieldValue + "%");
        }
    }

    private static Object getFieldValueByName(String fieldName, Object obj, Class entityClass) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase(Locale.ENGLISH);
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = entityClass.getMethod(getter);
            return method.invoke(obj);
        } catch (Exception e) {
            // 没有该方法，返回空值
            log.error("fileName: {}, Object: {}", fieldName, obj, e);
            return null;
        }
    }
}
