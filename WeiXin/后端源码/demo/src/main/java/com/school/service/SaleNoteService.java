package com.school.service;

import com.school.entity.SaleNote;

import java.util.List;

public interface SaleNoteService {
    List<SaleNote> querySaleNote();
    SaleNote findById(int id);
    List<SaleNote> findByClientId(Integer clientId);

    List<SaleNote> checkList( );
    List<SaleNote> chargeList( );
    List<SaleNote> refundList( );
    List<SaleNote> waitList( );
    int submitSaleNote(SaleNote saleNote);
    int checkSaleNote(SaleNote saleNote);
    int chargeSaleNote(SaleNote saleNote);
    int refundSaleNote(SaleNote saleNote);

    int insertSaleNote(SaleNote saleNote);
    int updateSaleNote(SaleNote saleNote);
    int deleteSaleNote(int id);
}
