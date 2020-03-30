package cn.bjfu.hbaseDemo.model;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @Auther jxy
 * @Date 2020-03-18
 */
public class TestHbase {
    private Configuration conf = null;
    private Connection conn = null;
    private Admin admin = null;
    private Table table = null;
    @Before
    public void createConf() throws IOException {
        conf = HBaseConfiguration.create();
        //设置zk集群地址,这里需要修改windows下的hosts文件
        conf.set("hbase.zookeeper.quorum", "10.10.18.56,10.10.18.57,10.10.18.58");
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        //建立连接
        conn = ConnectionFactory.createConnection(conf);
    }

    @Test
    public void createTable() throws IOException{
        //获取表管理类
        admin = conn.getAdmin();
        //定义表
        HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf("person"));
        //定义列族
        HColumnDescriptor hColumnDescriptor = new HColumnDescriptor("info");
        //将列族添加到表中
        hTableDescriptor.addFamily(hColumnDescriptor);
        //执行建表操作
        admin.createTable(hTableDescriptor);

    }

}
