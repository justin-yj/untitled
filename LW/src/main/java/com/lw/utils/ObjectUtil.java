package com.lw.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/15.
 */
public class ObjectUtil {
    private static Logger logger = LoggerFactory.getLogger(ObjectUtil.class);
    /**
     * 拷贝对象
     * @param source
     * @param copyTo
     * @param <T>
     * @return
     */
    public static <T> T copyObject(Object source, Class<T> copyTo){
        if(source==null){
            return null;
        }
        T t= BeanUtils.instantiate(copyTo);
        BeanUtils.copyProperties(source,t);
        return t;
    }

    /**
     * 复制对象
     * @param source
     * @param copyTo
     */
    public static void copyObjectProperties(Object source, Object copyTo){
        BeanUtils.copyProperties(source,copyTo);
    }

    public static <T> T[] copyArray(Object[] source, Class<T> copyTo){
        if(source==null){
            return null;
        }
        if(source.length==0){
            return null;
        }
        T[] ts=(T[])Array.newInstance(copyTo, source.length);
        for(int i=0;i<source.length;i++){
            Object obj=source[i];
            T t= BeanUtils.instantiate(copyTo);
            BeanUtils.copyProperties(obj,t);
            ts[i]=t;
        }
        return ts;
    }

    public static <T,N> List<T> copyList(List<N> source, Class<T> copyTo){
        if(source==null){
            return null;
        }
        if(source.size()==0){
            return new ArrayList<T>();
        }
        List<T> list=new ArrayList<T>();
        for(int i=0;i<source.size();i++){
            Object obj=source.get(i);
            T t= BeanUtils.instantiate(copyTo);
            BeanUtils.copyProperties(obj,t);
            list.add(t);
        }
        return list;
    }

    public static Object getFieldValue(final Object obj, final String fieldName) {
        Field field = getAccessibleField(obj, fieldName);

        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
        }

        Object result = null;
        try {
            result = field.get(obj);
        } catch (IllegalAccessException e) {
            logger.error("不可能抛出的异常{}", e.getMessage());
        }
        return result;
    }

    /**
     * 直接设置对象属性值, 无视private/protected修饰符, 不经过setter函数.
     */
    public static void setFieldValue(final Object obj, final String fieldName, final Object value) {
        Field field = getAccessibleField(obj, fieldName);

        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
        }

        try {
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            logger.error("不可能抛出的异常:{}", e.getMessage());
        }
    }

    /**
     * 循环向上转型, 获取对象的DeclaredField, 并强制设置为可访问.
     *
     * 如向上转型到Object仍无法找到, 返回null.
     */
    public static Field getAccessibleField(final Object obj, final String fieldName) {
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                Field field = superClass.getDeclaredField(fieldName);
                makeAccessible(field);
                return field;
            } catch (NoSuchFieldException e) {//NOSONAR
                // Field不在当前类定义,继续向上转型
                continue;// new add
            }
        }
        return null;
    }

    public static void makeAccessible(Field field) {
        if ((!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers()) || Modifier
                .isFinal(field.getModifiers())) && !field.isAccessible()) {
            field.setAccessible(true);
        }
    }


    public static Map ConvertObjToMap(Object obj){
        Map<String,Object> reMap = new HashMap<String,Object>();
        if (obj == null)
            return null;
        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for(int i=0;i<fields.length;i++){
                try {
                    Field f = obj.getClass().getDeclaredField(fields[i].getName());
                    f.setAccessible(true);
                    Object o = f.get(obj);
                    reMap.put(fields[i].getName(), o);
                } catch (NoSuchFieldException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return reMap;
    }
}
