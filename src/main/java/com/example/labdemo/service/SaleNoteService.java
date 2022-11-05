package com.example.labdemo.service;

import com.example.labdemo.domain.SaleNote;
import com.example.labdemo.dto.SaleNoteDetailDto;
import com.example.labdemo.util.BaseException;
import com.example.labdemo.vo.SaleNoteDetailVo;
import com.example.labdemo.vo.SaleNoteVo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface SaleNoteService {

    public List<SaleNote> getAll();

    public List<SaleNoteVo> getAllVo();

    public List<SaleNoteVo> find(String keyword);

    public SaleNoteVo add(Long clientId);

    public SaleNoteDetailVo getDetail(Long id);

    public void update(SaleNoteDetailDto saleNoteDetailDto);

    public void audio(Long id,  String stage) throws BaseException;

    public void collectMoney(Long id,  String stage) throws BaseException;
    public void returnGoods(Long id,  String stage) throws BaseException;
}
