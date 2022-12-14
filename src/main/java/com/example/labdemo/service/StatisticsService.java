package com.example.labdemo.service;

import com.example.labdemo.vo.statistic.*;

import java.util.Date;
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

    BusinessStatisticsVo selectBusinessStatisticsVo();
}
