package com.richard.infrastructure.resources.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Blog {

    private String title;
    private String description;
    private boolean published;
    private int code;
    private long type;

}
