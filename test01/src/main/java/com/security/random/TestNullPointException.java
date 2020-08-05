package com.security.random;

import java.util.Collection;
import java.util.Iterator;

/**
 * @Description TODO
 * @Author ex_langqf
 * @Date 2020/7/10 14:31
 */
public class TestNullPointException {

    public static void main(String[] args) {
        countObject(null,null);
    }

    // 判断集合中有几个给定的对象
    public static int countObject(Object obj, final Collection col){
        int count = 0;
        // 方法入口校验对象是否为空
        if(obj == null || col == null){
            LOGGER.error("obj or col is nulll");
            return count;
        }
        Iterator it = col.iterator();
        while(it.hasNext()){
            Object elt = it.next();
            if(obj.equals(elt)){
                count++;
            }
        }
        return count;
    }

}
