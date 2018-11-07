package com.taotao.test.pagehelp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.pojo.TbItem;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItemExample;

import java.util.List;

/**
 * @Description:
 * @Author: qiuyk
 * @Date: 2018-11-03
 */
public class TestPageHelper {
    @Test
    public void testhelper() {
        //1.初始化spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");

        //2.获取mapper代理对象
        TbItemMapper mapper = context.getBean(TbItemMapper.class);

        //设置查询条件和排序字段,不设置相当于没有条件
        TbItemExample example = new TbItemExample();
        //3.设置分页信息 紧跟着它的第一个查询才会被分页
        PageHelper.startPage(1, 30);

        //4.调用mapper方法查询数据
        List<TbItem> list = mapper.selectByExample(example);
//        List<TbItem> list2 = mapper.selectByExample(example);

        //5.取分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);

        //遍历结果集 打印
        System.out.println("list查询总记录数："+pageInfo.getSize());

        for (TbItem ite : pageInfo.getList()) {
            System.out.println(ite.getCid() + ">>>" + ite.getTitle());
        }

       /* //2.初始化spring 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        //3.获取mapper的代理对象
        TbItemMapper itemMapper = context.getBean(TbItemMapper.class);
        //1.设置分页信息
        PageHelper.startPage(1, 3);//3行  紧跟着的第一个查询才会被分页
        //4.调用mapper的方法查询数据
        TbItemExample example = new TbItemExample();//设置查询条件使用
        List<TbItem> list = itemMapper.selectByExample(example);
        System.out.println("查询的总记录数数："+list.size());*/
    }
}
