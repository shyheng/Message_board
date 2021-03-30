package com.shy;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shy.model.Diary;
import com.shy.service.DiaryService;
import com.shy.service.UsersService;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SpringTests {
    @Reference(interfaceClass = UsersService.class,version = "1.0.0",check = false,timeout = 15000)
    private UsersService usersService;

    @Reference(interfaceClass = DiaryService.class,version = "1.0.0",check = false,timeout = 15000)
    private DiaryService diaryService;

    @Test
    void log(){
        List<String> diary = new ArrayList<>();
        diary.add("张培恒");
        diary.add("绍");
        List<Diary> list = diaryService.selectAll(diary);
        for (Diary user : list){
            System.out.println(user);
        }
    }
}
