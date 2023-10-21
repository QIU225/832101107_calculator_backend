package com.example.calculatordemo.service;

import com.example.calculatordemo.bean.Record;
import com.example.calculatordemo.domain.GetDataParam;
import com.example.calculatordemo.domain.ResultBean;

public interface CalculatorService {

    ResultBean insertData(Record record);

    ResultBean getData(GetDataParam getDataParam);
}
