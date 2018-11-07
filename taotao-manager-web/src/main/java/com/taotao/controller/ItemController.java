package com.taotao.controller;

import com.taotao.common.EasyUIDataGridResult;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Author: qiuyk
 * @Date: 2018-11-06
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 返回分页查询的封装为EasyUIDataGridResult的json数据
     */
    @RequestMapping(value = "/item/list", method = RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        //1.引入服务
        //2.注入服务
        //3.调用服务的方法
        return itemService.getItemList(page, rows);
    }

}
