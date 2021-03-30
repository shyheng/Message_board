package com.shy.service;

import com.shy.model.Diary;

import java.util.List;

public interface DiaryService {
    int insetDiary(Diary diary);
    int deleteDiary(String dateDay);
    Diary selectDiary(String name);
    List<Diary> selectAll(List<String> name);
}
