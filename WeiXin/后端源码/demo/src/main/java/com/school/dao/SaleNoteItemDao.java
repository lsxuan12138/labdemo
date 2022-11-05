package com.school.dao;

import com.school.entity.Area;
import com.school.entity.SaleNoteItem;

import java.util.List;

public interface SaleNoteItemDao {
    List<SaleNoteItem> FindbyNoteId();
    SaleNoteItem findById(int areaId);
    int insertArea(Area area);
    int updateArea(Area area);
    int deleteArea(int areaId);
}
