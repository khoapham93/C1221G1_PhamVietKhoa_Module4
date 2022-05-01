package com.khoapham.service.impl;

import com.khoapham.service.ITranslateService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslateServiceImpl implements ITranslateService {
     private static Map<String, String> dictionary;

     static {
         dictionary = new HashMap<>();
         dictionary.put("hello", "Xin chào");
         dictionary.put("world", "Thế giới");
         dictionary.put("how", "Thế nào");
         dictionary.put("book", "Quyển vở");
         dictionary.put("computer", "Máy tính");
     }

    @Override
    public String translate(String english) {
        String[] englishArr = english.split(" ");
        String vietnamese = "";
        String result = null;
        if (englishArr.length != 0) {
            for (String s : englishArr) {
                result = dictionary.get(s);
                if (result!= null){
                    vietnamese += result + " ";
                }else {
                    vietnamese += s + " ";
                }
            }
        }
        return vietnamese;
    }
}
