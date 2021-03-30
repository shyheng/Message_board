package com.shy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.shy.mapper.DiaryMapper;
import com.shy.model.Diary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service(interfaceClass = DiaryService.class,version = "1.0.0",timeout = 15000)
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryMapper diaryMapper;

    @Override
    public int insetDiary(Diary diary) {
        return diaryMapper.insert(diary);
    }

    @Override
    public int deleteDiary(String dateDay) {
        return diaryMapper.deleteByPrimaryKey(dateDay);
    }

    @Override
    public Diary selectDiary(String name) {
        return diaryMapper.selectByPrimaryKey(name);
    }

    @Override
    public List<Diary> selectAll(List<String> name) {
        return diaryMapper.selectAll(name);
    }


}
