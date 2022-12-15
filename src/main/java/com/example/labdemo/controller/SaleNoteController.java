package com.example.labdemo.controller;

import com.example.labdemo.domain.Client;
import com.example.labdemo.dto.SaleNoteDetailDto;
import com.example.labdemo.result.ResultResponse;
import com.example.labdemo.service.ClientService;
import com.example.labdemo.service.ProductService;
import com.example.labdemo.service.SaleNoteService;
import com.example.labdemo.service.StoreService;
import com.example.labdemo.vo.salenote.SaleNoteDetailVo;
import com.example.labdemo.vo.salenote.SaleNoteVo;
import com.example.labdemo.vo.store.StoreItemVo;
import com.example.labdemo.vo.store.StoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/saleNote")
public class SaleNoteController {
    @Autowired
    private SaleNoteService saleNoteService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private StoreService storeService;

    @Autowired
    private ProductService productService;

    /**
     * 获取所有销售单
     * @return 销售单overview页面
     */
    @PreAuthorize("hasAuthority('saleNote:read')")
    @GetMapping("/all")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("sale_note_manage");
        List<SaleNoteVo> saleNotes = saleNoteService.getAllVo();
        List<Client> clients = clientService.getAll();
        List<StoreVo> storeVos = storeService.selectAllVo();
        modelAndView.getModelMap().addAttribute("storeHouses", storeVos);
        modelAndView.getModelMap().addAttribute("clients", clients);
        modelAndView.getModelMap().addAttribute("saleNotes", saleNotes);
        return modelAndView;
    }
    /**
     * 增加销售单
     * @param clientId 客户id
     * @param storeHouseId 仓库id
     * @return 增加的销售单
     */
    @PreAuthorize("hasAuthority('saleNote:insert')")
    @PostMapping("/add")
    @ResponseBody
    public ResultResponse add(@RequestParam("clientId")Long clientId,@RequestParam("storeHouseId") Long storeHouseId){
        return ResultResponse.success(saleNoteService.add(clientId,storeHouseId));
    }

    /**
     * 销售单detail
     * @param id 销售单id
     * @return 销售单detail页面
     */
    @PreAuthorize("hasAuthority('saleNote:read')")
    @GetMapping("/detail")
    public ModelAndView getDetail(@RequestParam("id")Long id){
        List<StoreItemVo> productList = storeService.getStoreItemById(saleNoteService.selectById(id).getStoreId());
        SaleNoteDetailVo detail = saleNoteService.getDetail(id);
        ModelAndView modelAndView = new ModelAndView("order_details");
        modelAndView.getModelMap().addAttribute("productList",productList);
        modelAndView.getModelMap().addAttribute("detail",detail);
        return modelAndView;
    }

    /**
     * 更新销售单信息
     * @param saleNoteDetailDto 封装请求
     * @return
     */
    @PreAuthorize("hasAuthority('saleNote:edit')")
    @PostMapping("/update")
    @ResponseBody
    public ResultResponse update(@RequestBody SaleNoteDetailDto saleNoteDetailDto){
        saleNoteService.update(saleNoteDetailDto);
        return ResultResponse.success();
    }

    /**
     * 审核销售单
     * @param id 销售单id
     * @param stage 目标stage
     * @return
     */
    @PreAuthorize("hasAuthority('saleNote:read')")
    @PostMapping("/audit")
    @ResponseBody
    public ResultResponse audit(@RequestParam("id")Long id,@RequestParam("stage") String stage){
        saleNoteService.audio(id,stage);
        return ResultResponse.success();
    }
    /**
     * 销售单收款
     * @param id 销售单id
     * @param stage 目标stage
     * @return
     */
    @PreAuthorize("hasAuthority('saleNote:collect')")
    @PostMapping("/collectMoney")
    @ResponseBody
    public ResultResponse collectMoney(@RequestParam("id")Long id,@RequestParam("stage") String stage){
        saleNoteService.collectMoney(id,stage);
        return ResultResponse.success();
    }
    /**
     * 整单退货
     * @param id 销售单id
     * @param stage 目标stage
     * @return
     */
    @PreAuthorize("hasAuthority('saleNote:return')")
    @PostMapping("/returnGoods")
    @ResponseBody
    public ResultResponse returnGoods(@RequestParam("id")Long id,@RequestParam("stage") String stage){
        saleNoteService.returnGoods(id,stage);
        return ResultResponse.success();
    }
}
