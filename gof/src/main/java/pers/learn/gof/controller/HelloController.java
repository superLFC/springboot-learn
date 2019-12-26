package pers.learn.gof.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.learn.gof.bridge.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class HelloController {

    @RequestMapping("/test")
    public String test() {
        SmallPen smallPen = new SmallPen();
        MiddlePen middlePen = new MiddlePen();
        BigPen bigPen = new BigPen();

        smallPen.setColor(new RedColor());
        middlePen.setColor(new WhiteColor());
        bigPen.setColor(new BlackColor());

        //新增笔或者颜色对原有代码逻辑没有影响
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("smallPen", smallPen.draw("apple"));
        resultMap.put("middlePen", middlePen.draw("banana"));
        resultMap.put("bigPen", bigPen.draw("pear"));
        return JSON.toJSONString(resultMap);
    }
}
