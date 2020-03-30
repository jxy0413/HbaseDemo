package cn.bjfu.hbaseDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther jxy
 * @Date 2020-03-20
 */
@RestController
@RequestMapping("hbase/test")
public class TestController {

    @RequestMapping("/list")
    public void test(){
        System.out.println("hhhh");
    }
}
