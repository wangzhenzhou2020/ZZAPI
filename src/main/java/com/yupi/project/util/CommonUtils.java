package com.yupi.project.util;

import java.lang.reflect.Field;

/**
 * 算法工具类
 *
 * 
 * 
 */
public class CommonUtils {
    /**
     * 判断对象中除某个字段（比如id）和serialVersion字段外其他字段是否为null
     * @param obj
     * @param idFieldName
     * @return
     */
    public static boolean isOtherFieldsNull(Object obj, String idFieldName) {
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (!field.getName().equals(idFieldName) && !field.getName().equals("serialVersionUID") ) {
                field.setAccessible(true); // 确保我们可以访问private字段
                try {
                    Object value = field.get(obj);
                    if (value != null) {
                        return false;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return true;
    }
}
