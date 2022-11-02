package com.school.service.impl;

import com.school.dao.AreaDao;
import com.school.dao.SaleNoteDao;
import com.school.entity.SaleNote;
import com.school.service.SaleNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class SaleNoteServiceImpl implements SaleNoteService {

    @Autowired
    private SaleNoteDao saleNoteDao;

    @Override
    public List<SaleNote> querySaleNote() {
        return saleNoteDao.querySaleNote();
    }

    @Override
    public SaleNote findById(int id) {
        return saleNoteDao.findById(id);
    }
    @Transactional
    @Override
    public int insertSaleNote(SaleNote saleNote) {
        if(saleNote.getId()!=null&&!"".equals(saleNote.getId())){
            saleNote.setCreateTime((java.sql.Date) new Date());
            try {
                int result=saleNoteDao.insertSaleNote(saleNote);
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
    public int updateSaleNote(SaleNote saleNote) {
        return saleNoteDao.updateSaleNote(saleNote);
    }

    @Override
    public int deleteSaleNote(int id) {
        return saleNoteDao.deleteSaleNote(id);
    }
}
