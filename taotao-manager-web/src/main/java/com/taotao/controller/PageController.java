package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 显示页面
 * @Author: qiuyk
 * @Date: 2018-11-03
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    /**
     * 显示商品的查询页面
     * url: /item-list
     *
     * PathVariable 表示从url路径中截取
     *
     * 如果大括号中的page和形参不一致，则可以用@PathVariable("page") String page3 接收参数
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }

}
