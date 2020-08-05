package com.example.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author ex_langqf
 * @Date 2020/7/13 16:11
 */
@Api(tags = {"list1,list2"},value="hello")
@RestController
public class HelloWordController {


    @RequestMapping(value="/index",method= RequestMethod.GET)
    public String index(){
        System.out.println("1111111111111111111111111111");
        return "Hello World ! --Spring boot!";
    }

    @ApiOperation(value="abc",notes="字符串",httpMethod = "POST")
    @ApiParam(name="test",value = "任意字符串",required = true)
    @RequestMapping(value="/swag",method= RequestMethod.POST)
    public String swag(@RequestParam String test){
        return "Hello World ! --Spring boot!" + test;
    }

}
