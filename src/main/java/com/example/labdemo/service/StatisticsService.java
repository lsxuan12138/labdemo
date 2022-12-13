package com.example.labdemo.service;

import com.example.labdemo.vo.statics.ClientStaticsVo;
import com.example.labdemo.vo.statics.SalesmanStatisticVo;

import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-12-13 20:25
 */
public interface StatisticsService {
    List<SalesmanStatisticVo> selectSalesmanStaticsVo();

    List<ClientStaticsVo> selectClientStaticsVo();
}
