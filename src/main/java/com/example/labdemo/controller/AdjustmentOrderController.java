package com.example.labdemo.controller;

import com.example.labdemo.dto.AdjustmentUpdateDto;
import com.example.labdemo.result.ResultResponse;
import com.example.labdemo.service.AdjustmentOrderService;
import com.example.labdemo.service.StoreService;
import com.example.labdemo.vo.adjustment.AdjustmentDetailVo;
import com.example.labdemo.vo.adjustment.AdjustmentVo;
import com.example.labdemo.vo.store.StoreItemVo;
import com.example.labdemo.vo.store.StoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
 * @create: 2022-11-14 15:38
 */
@Controller
public class AdjustmentOrderController {

    @Autowired
    StoreService storeService;
    @Autowired
    AdjustmentOrderService adjustmentOrderService;

    /**
     * 获取所有调货单
     *
     * @return 调货单overview页面
     */
    @PreAuthorize("hasAuthority('adjustment:read')")
    @GetMapping("/product/adjust")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("adjustment");
        List<StoreVo> storeVos = storeService.selectAllVo();
        List<AdjustmentVo> adjustments = adjustmentOrderService.getAllVo();
        modelAndView.getModelMap().addAttribute("storeHouses", storeVos);
        modelAndView.getModelMap().addAttribute("adjustments", adjustments);
        return modelAndView;
    }

    /**
     * 添加调货单
     *
     * @param srcId  源仓库
     * @param destId 目的仓库
     * @return 添加成功的调货单
     */
    @PreAuthorize("hasAuthority('adjustment:insert')")
    @PostMapping("/product/addAdjustment")
    @ResponseBody
    public ResultResponse add(@RequestParam("srcStoreHouseId") Long srcId, @RequestParam("destStoreHouseId") Long destId) {
        return ResultResponse.success(adjustmentOrderService.add(srcId, destId));
    }

    /**
     * 调货单detail页面
     *
     * @param id 调货单id
     * @return 调货单detail页面
     */
    @PreAuthorize("hasAuthority('adjustment:read')")
    @GetMapping("/product/adjustmentDetails")
    public ModelAndView getDetails(@PathParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("adjustment_details");

        List<StoreItemVo> productList = storeService.getStoreItemById(adjustmentOrderService.selectById(id).getSrcStoreId());
        modelAndView.getModelMap().addAttribute("productList", productList);
        AdjustmentDetailVo adjustmentDetailVo = adjustmentOrderService.getDetail(id);
        modelAndView.getModelMap().addAttribute("adjustmentDetails", adjustmentDetailVo);
        return modelAndView;
    }

    /**
     * 更新调货单内容
     * @param adjustmentUpdateDto
     * @return
     */
    @PreAuthorize("hasAuthority('adjustment:edit')")
    @PostMapping("/product/adjustmentUpdate")
    @ResponseBody
    public ResultResponse update(@RequestBody AdjustmentUpdateDto adjustmentUpdateDto) {
        adjustmentOrderService.update(adjustmentUpdateDto);
        return ResultResponse.success();
    }

    /**
     * 审核调货单
     * @param id 审核单id
     * @param stage 目标stage
     * @return
     */
    @PreAuthorize("hasAuthority('adjustment:audit')")
    @PostMapping("/product/adjustmentAudit")
    @ResponseBody
    public ResultResponse audit(@RequestParam("id") Long id, @RequestParam("stage") String stage) {
        adjustmentOrderService.audit(id, stage);
        return ResultResponse.success();
    }
}
