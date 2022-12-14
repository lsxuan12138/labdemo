package com.example.labdemo.service;

import com.example.labdemo.vo.statistic.ClientPaymentStatisticsVo;
import com.example.labdemo.vo.statistic.ClientStatisticsVo;
import com.example.labdemo.vo.statistic.ProductStatisticsVo;
import com.example.labdemo.vo.statistic.SalesmanStatisticsVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-12-13 20:25
 */
public interface StatisticsService {
    List<SalesmanStatisticsVo> selectSalesmanStaticsVo();

    List<ClientStatisticsVo> selectClientStaticsVo();

    List<ProductStatisticsVo> selectProductStatisticsVo();

    List<ClientPaymentStatisticsVo> selectClientPaymentStatisticsVos();

    List<BigDecimal[]> selectBusinessStatisticsVo();
}
