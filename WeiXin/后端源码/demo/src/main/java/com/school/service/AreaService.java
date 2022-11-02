package com.school.service;

import com.school.entity.Area;

import java.util.List;

public interface AreaService {
    List<Area> queryArea();
    Area findByAreaId(int areaId);
    int insertArea(Area area);
    int updateArea(Area area);
    int deleteArea(int areaId);
}
