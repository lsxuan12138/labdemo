package com.school.dao;

import com.school.entity.SaleNoteItem;

import java.util.List;

public interface SaleNoteItemDao {
    SaleNoteItem findById(int id);
    List<SaleNoteItem> findBySaleNoteId(int saleNoteId);
    int insertSaleNoteItem(SaleNoteItem saleNoteItem);
    int updateSaleNoteItem(SaleNoteItem saleNoteItem);
    int deleteSaleNoteItem(int id);
}
