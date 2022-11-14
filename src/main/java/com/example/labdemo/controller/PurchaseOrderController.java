package com.example.labdemo.controller;

import com.example.labdemo.dto.PurchaseUpdateDto;
import com.example.labdemo.result.ResultResponse;
import com.example.labdemo.service.PurchaseOrderService;
import com.example.labdemo.service.StoreService;
import com.example.labdemo.vo.PurchaseDetailVo;
import com.example.labdemo.vo.PurchaseVo;
import com.example.labdemo.vo.StoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-14 18:53
 */
@Controller
public class PurchaseOrderController {
    @Autowired
    private StoreService storeService;
    @Autowired
    private PurchaseOrderService purchaseOrderService;

    /**
     * 进货单管理页面
     *
     * @return 进货单overview页面
     */
    @GetMapping("/product/purchase")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("purchase");
        List<StoreVo> storeVos = storeService.selectAllVo();
        modelAndView.getModelMap().addAttribute("storehouses", storeVos);
        List<PurchaseVo> purchaseVos = purchaseOrderService.getAllVo();
        modelAndView.getModelMap().addAttribute("purchaseOrders", purchaseVos);
        return modelAndView;
    }

    /**
     * 创建进货单
     *
     * @param storeId 所属仓库id
     * @return
     */
    @PostMapping("/product/addPurchase")
    @ResponseBody
    public ResultResponse add(@RequestParam("storeHouse") Long storeId) {
        return ResultResponse.success(purchaseOrderService.add(storeId));
    }

    /**
     * 进货单detail页面
     *
     * @param id 进货单id
     * @return
     */
    @GetMapping("/product/purchaseDetails")
    public ModelAndView getDetail(@PathParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("purchase_details");
        List<StoreVo> storeVos = storeService.selectAllVo();
        modelAndView.getModelMap().addAttribute("storehouses", storeVos);
        PurchaseDetailVo detailVo = purchaseOrderService.getDetail(id);
        modelAndView.getModelMap().addAttribute("purchaseDetails", detailVo);
        return modelAndView;
    }

    /**
     * 进货单信息更新
     *
     * @param purchaseUpdateDto 封装请求
     * @return
     */
    @PostMapping("/product/purchaseUpdate")
    public ResultResponse update(@RequestBody PurchaseUpdateDto purchaseUpdateDto) {
        purchaseOrderService.update(purchaseUpdateDto);
        return ResultResponse.success();
    }

    /**
     * 进货单审核
     *
     * @param id    进货单id
     * @param stage 目标stage
     * @return
     */
    @PostMapping("/product/purchaseAudit")
    public ResultResponse audit(@RequestParam("id") Long id, @RequestParam("stage") String stage) {
        purchaseOrderService.audit(id, stage);
        return ResultResponse.success();
    }
}
