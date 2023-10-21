package com.example.calculatordemo.service.imp;

import com.example.calculatordemo.bean.Record;
import com.example.calculatordemo.domain.GetDataParam;
import com.example.calculatordemo.domain.ResultBean;
import com.example.calculatordemo.mapper.CalculatorMapper;
import com.example.calculatordemo.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CalculatorServiceImp implements CalculatorService {

    private static final Logger log = LoggerFactory.getLogger(CalculatorServiceImp.class);
    @Autowired
    private CalculatorMapper calculatorMapper;

    @Override
    @Transactional
    public ResultBean insertData(Record record) {
        ResultBean resultBean = new ResultBean();
        try {
            int raw = calculatorMapper.insertData(record);
            if (raw > 0) {
                resultBean.setCode(200);
            } else {
                resultBean.setCode(500);
                resultBean.setMessage("写入失败");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resultBean.setCode(500);
            resultBean.setMessage(e.getMessage());
        }
        return resultBean;
    }


    @Override
    public ResultBean getData(GetDataParam getDataParam) {
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCode(200);
            List<Record> recordList = calculatorMapper.getData();
            if (getDataParam.getIndex() < recordList.size()) {
                Record record = recordList.get(getDataParam.getIndex());
                resultBean.setMessage(record.getFormula() + "=" + record.getAnswer());
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resultBean.setCode(500);
            resultBean.setMessage(e.getMessage());
        }
        return resultBean;
    }
}
