package com.fshtank.sanbox.service.impl;

import com.fshtank.sanbox.service.ListService;

import java.util.List;

public class ListServiceImpl implements ListService {

    List<List<String>> listOfLists = List.of(
            List.of("24", "16", "1", "2", "1"),
            List.of("43", "42", "31", "3", "3"),
            List.of("24", "22", "31", "2", "1")
    );

}
