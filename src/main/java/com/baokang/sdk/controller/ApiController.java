package com.baokang.sdk.controller;

import com.baokang.sdk.param.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {


    @PostMapping("/get")
    public String get(@RequestBody ApiParam param) {


        return "";
    }
}