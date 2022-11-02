package com.school;

import com.school.dao.AreaDao;
import com.school.entity.Area;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    AreaDao areaDao;

    @Test
    void queryArea() {
        areaDao.queryArea().forEach(System.out::println);
    }


    @Test
    void insertrea() {
        Area area=new Area();
        area.setAreaName("南京");
        area.setLastEditTime(new Date());
        area.setPriority(1);
        int result =areaDao.insertArea(area);
        System.out.println(result);
    }

    @Test
    void deleteArea() {

        int result =areaDao.deleteArea(1);
        System.out.println(result);
    }

    @Test
    void updateArea() {
        Area area=new Area();
        area.setAreaName("南京");
        area.setLastEditTime(new Date());
        area.setPriority(1);
        area.setAreaId(5);
        int result =areaDao.insertArea(area);
        System.out.println(result);
    }


}
