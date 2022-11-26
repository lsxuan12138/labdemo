package com.school.service.impl;

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
    private com.school.dao.SaleNoteDao saleNoteDao;

    @Override
    public List<SaleNote> querySaleNote() {
        return saleNoteDao.querySaleNote();
    }

    @Override
    public SaleNote findById(int id) {
        return saleNoteDao.findById(id);
    }

    @Override
    public List<SaleNote> findByClientId(Integer clientId) {
        return saleNoteDao.findByClientId(clientId);
    }

    @Override
    public List<SaleNote> checkList() {
        return saleNoteDao.checkList();
    }

    @Override
    public List<SaleNote> chargeList() {
        return saleNoteDao.chargeList();
    }

    @Override
    public List<SaleNote> refundList() {
        return saleNoteDao.refundList();
    }

    @Override
    public List<SaleNote> waitList() {
        return saleNoteDao.waitList();
    }

    @Override
    public int submitSaleNote(SaleNote saleNote) {
        return saleNoteDao.submitSaleNote(saleNote);
    }

    @Override
    public int checkSaleNote(SaleNote saleNote) {
        return saleNoteDao.checkSaleNote(saleNote);
    }

    @Override
    public int chargeSaleNote(SaleNote saleNote) {
        return saleNoteDao.chargeSaleNote(saleNote);
    }

    @Override
    public int refundSaleNote(SaleNote saleNote) {
        return saleNoteDao.refundSaleNote(saleNote);
    }

    @Transactional
    @Override
    public int insertSaleNote(SaleNote saleNote) {
        if(saleNote.getId()!=null&&!"".equals(saleNote.getId())){
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
        }else if(saleNote.getId()==null){
            throw  new RuntimeException("saleNote.getId()!=null插入的值有空的");
        }else {
            throw  new RuntimeException("!\"\".equals(saleNote.getId())插入的值有空的");
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
