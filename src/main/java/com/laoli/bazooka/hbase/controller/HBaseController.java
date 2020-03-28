package com.laoli.bazooka.hbase.controller;


import com.laoli.bazooka.gc.entity.Greeting;
import com.laoli.bazooka.hbase.Constants;
import com.laoli.bazooka.hbase.entity.User;
import com.laoli.bazooka.hbase.mapper.UserRowMapper;
import com.laoli.bazooka.hbase.util.RowKeyGenUtil;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.mortbay.util.ajax.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HBaseController {

    @Autowired
    private HbaseTemplate hbaseTemplate;

    @RequestMapping("/initData")
    public void initData() {
        User user = new User();
        user.setId(666L);
        user.setBaseInfo(new User.BaseInfo("name666",18,"sex"));
        user.setOtherInfo(new User.OtherInfo("phone","address"));
        String rowKey = RowKeyGenUtil.genUserRowKey(user);
        try {
            if (hbaseTemplate.getConnection().getTable(TableName.valueOf(Constants.UserTable.TABLE_NAME))
                    .exists(new Get(Bytes.toBytes(rowKey)))) {
                log.warn("RowKey {} is already exist!", rowKey);
                return;
            }
        } catch (Exception ex) {
            log.error("DropUserToHBase Error: {}", ex.getMessage());
            return;
        }


        Put put = new Put(Bytes.toBytes(rowKey));

        put.addColumn(
                Bytes.toBytes(Constants.UserTable.FAMILY_B),
                Bytes.toBytes(Constants.UserTable.NAME),
                Bytes.toBytes(user.getBaseInfo().getName())
        );
        put.addColumn(
                Bytes.toBytes(Constants.UserTable.FAMILY_B),
                Bytes.toBytes(Constants.UserTable.AGE),
                Bytes.toBytes(user.getBaseInfo().getAge())
        );
        put.addColumn(
                Bytes.toBytes(Constants.UserTable.FAMILY_B),
                Bytes.toBytes(Constants.UserTable.SEX),
                Bytes.toBytes(user.getBaseInfo().getSex())
        );
        put.addColumn(
                Bytes.toBytes(Constants.UserTable.FAMILY_O),
                Bytes.toBytes(Constants.UserTable.PHONE),
                Bytes.toBytes(user.getOtherInfo().getPhone())
        );
        put.addColumn(
                Bytes.toBytes(Constants.UserTable.FAMILY_O),
                Bytes.toBytes(Constants.UserTable.ADDRESS),
                Bytes.toBytes(user.getOtherInfo().getAddress())
        );

        hbaseTemplate.saveOrUpdate(Constants.UserTable.TABLE_NAME, put);
        log.info("成功");
    }



    @RequestMapping("/getByUserId")
    public void getByUserId(long id) {
        User user = new User();
        user.setId(id);
        String userRowKey = RowKeyGenUtil.genUserRowKey(user);
        User result;
        try {
            result = hbaseTemplate.get(
                    Constants.UserTable.TABLE_NAME,
                    userRowKey,
                    new UserRowMapper()
            );
            log.info("Gain PassTemplate {}",result);
        } catch (Exception ex) {
            log.info("Gain PassTemplate Error: {}",id);
            return;
        }

    }



}
