package com.laoli.bazooka.hbase;

public class Constants {
    /**
     * <h2>User HBase Table</h2>
     * */
    public class UserTable {

        /** User HBase 表名 */
        public static final String TABLE_NAME = "pb:user";

        /** 基本信息列族 */
        public static final String FAMILY_B = "b";

        /** 用户名 */
        public static final String NAME = "name";

        /** 用户年龄 */
        public static final String AGE = "age";

        /** 用户性别 */
        public static final String SEX = "sex";

        /** 额外信息列族 */
        public static final String FAMILY_O = "o";

        /** 电话号码 */
        public static final String PHONE = "phone";

        /** 住址 */
        public static final String ADDRESS = "address";
    }

}
