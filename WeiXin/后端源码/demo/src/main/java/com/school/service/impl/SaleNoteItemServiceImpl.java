package com.school.service.impl;

import com.school.dao.SaleNoteItemDao;
import com.school.entity.SaleNoteItem;
import com.school.service.SaleNoteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SaleNoteItemServiceImpl implements SaleNoteItemService {

    @Autowired
    private SaleNoteItemDao saleNoteItemDao;

    @Override
    public SaleNoteItem findById(int id) {
        return saleNoteItemDao.findById(id);
    }

    @Override
    public List<SaleNoteItem> findBySaleNoteId(int saleNoteId) {
        return saleNoteItemDao.findBySaleNoteId(saleNoteId);
    }

    @Override
    public int insertSaleNoteItem(SaleNoteItem saleNoteItem) {
        if(saleNoteItem.getId()!=null&&!"".equals(saleNoteItem.getId())){
            try {
                int result=saleNoteItemDao.insertSaleNoteItem(saleNoteItem);
                if (result>0){
                    return 1;
                }else {
                    throw  new RuntimeException("插入失败");
                }
            }catch (Exception e){
                throw  new RuntimeException("插入取余信息失败失败"+e.getMessage());
            }
        }else {
            throw  new RuntimeException("插入的值有空的");
        }
        /*  return areaDao.insertArea(area);*/
    }

    @Override
    public int updateSaleNoteItem(SaleNoteItem saleNoteItem) {
        return saleNoteItemDao.updateSaleNoteItem(saleNoteItem);
    }

    @Override
    public int deleteSaleNoteItem(int id) {
        return saleNoteItemDao.deleteSaleNoteItem(id);
    }
}
