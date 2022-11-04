package com.school.dao;

import com.school.entity.Area;
import com.school.entity.SaleNote;

import java.util.List;

public interface SaleNoteDao {
    List<SaleNote> querySaleNote();
    SaleNote findById(int id);
    List<SaleNote> findByClientId(int clientId);
    int insertSaleNote(SaleNote saleNote);
    int updateSaleNote(SaleNote saleNote);
    int deleteSaleNote(int id);
}
