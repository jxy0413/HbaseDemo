package cn.bjfu.hbaseDemo.model;

import org.junit.Test;

/**
 * @Auther jxy
 * @Date 2020-03-18
 */
public class HbaseTest {
    @Test
    public void test()throws Exception{
        HbaseUtil.createTable("test","info");
    }
}
