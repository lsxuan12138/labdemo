package com.school.service;

import com.school.entity.SaleNoteItem;

import java.util.List;

public interface SaleNoteItemService {

    SaleNoteItem findById(int id);
    List<SaleNoteItem> findBySaleNoteId(int saleNoteId);
    int insertSaleNoteItem(SaleNoteItem saleNoteItem);
    int updateSaleNoteItem(SaleNoteItem saleNoteItem);
    int deleteSaleNoteItem(int id);
}
