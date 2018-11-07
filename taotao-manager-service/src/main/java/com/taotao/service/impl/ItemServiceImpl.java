package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: qiuyk
 * @Date: 2018-11-06
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public EasyUIDataGridResult getItemList(Integer page, Integer row) {
        //1.设置分页信息，使用pagehelper
        if (page == null) {
            page = 1;
        }
        if (row == null) {
            row = 30;
        }
        PageHelper.startPage(page, row);
        //2.注入mapper
        //3.创建example对象，不需要设置查询条件
        TbItemExample example = new TbItemExample();
        //4.根据mapper调用查询所有数据的方法
        List<TbItem> list = tbItemMapper.selectByExample(example);
        //5.获取分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        //6.封装到EasyUIDataGridResult
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(pageInfo.getList());
        result.setTotal((int) pageInfo.getTotal());
        //7.返回
        return result;
    }
}
