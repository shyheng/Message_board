package com.shy.web.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shy.model.Diary;
import com.shy.service.DiaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DiaryController {
    @Reference(interfaceClass = DiaryService.class,version = "1.0.0",check = false,timeout = 15000)
    private DiaryService diaryService;

    @RequestMapping("/day")
    public String Diary(String dateDay,String name, String text, Model model){
        Diary diary = new Diary();
        diary.setDateDay(dateDay);
        diary.setName(name);
        diary.setText(text);
        int i = diaryService.insetDiary(diary);
        List<String> diaryS = new ArrayList<>();
        diaryS.add(name);
        List<Diary> list = diaryService.selectAll(diaryS);
        model.addAttribute("list",list);
        return "date";
    }

    @RequestMapping("/dayName")
    public String dayName(String name,Model model){
        List<String> diarys = new ArrayList<>();
        diarys.add(name);
        List<Diary> list = diaryService.selectAll(diarys);
        model.addAttribute("list",list);
        return "date";
    }
}