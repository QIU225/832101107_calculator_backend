package com.example.calculatordemo.controller;

import com.example.calculatordemo.bean.Record;
import com.example.calculatordemo.domain.GetDataParam;
import com.example.calculatordemo.domain.ResultBean;
import com.example.calculatordemo.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;


    /**
     * 写入数据
     * @param record
     * @return
     */
    @PostMapping("/insertData")
    public ResultBean insertData(@RequestBody Record record) {
        return calculatorService.insertData(record);
    }

    /**
     * 查询数据
     * @param getDataParam
     * @return
     */
    @PostMapping("/getData")
    public ResultBean getData(@RequestBody GetDataParam getDataParam) {
        return calculatorService.getData(getDataParam);
    }
}
