package com.taotao.controller;

import com.taotao.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Author: qiuyk
 * @Date: 2018-11-03
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test/queryNow")
    @ResponseBody
    public String queryNow() {
        //1.引用服务
        //2.注入服务
        //3.调用服务方法
        return testService.queryNow();
    }

}
