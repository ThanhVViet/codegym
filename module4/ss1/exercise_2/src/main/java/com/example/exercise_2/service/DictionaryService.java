package com.example.exercise_2.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService {
    static Map<String, String> list = new HashMap<>();

    static {
        list.put("cat", "mèo");
        list.put("dog", "con chó");
        list.put("duck", "vịt");
    }

    public String search(String word) {
        String result = list.get(word);
        return result;
    }
}
