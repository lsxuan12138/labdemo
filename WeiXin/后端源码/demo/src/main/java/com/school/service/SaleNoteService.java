package com.school.service;

import com.school.entity.SaleNote;

import java.util.List;

public interface SaleNoteService {
    List<SaleNote> querySaleNote();
    SaleNote findById(int id);
    List<SaleNote> findByClientId(Integer clientId);
    int insertSaleNote(SaleNote saleNote);
    int updateSaleNote(SaleNote saleNote);
    int deleteSaleNote(int id);
}
