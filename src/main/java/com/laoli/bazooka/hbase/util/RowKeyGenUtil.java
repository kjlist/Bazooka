package com.laoli.bazooka.hbase.util;


import com.laoli.bazooka.hbase.entity.User;
import lombok.extern.slf4j.Slf4j;



@Slf4j
public class RowKeyGenUtil {

    /**
     * <h2>根据 User 构造 RowKey</h2>
     * @param user {@link User}
     * @return String RowKey
     * */
    public static String genUserRowKey(User user) {
//        String rowKey = DigestUtils.md5Hex(passInfo);
        //RowKey越分散，数据越分散，可以考虑md5
        //
        return new StringBuilder(String.valueOf(user.getId())).reverse().toString() +
                (Long.MAX_VALUE - System.currentTimeMillis());
    }
}
