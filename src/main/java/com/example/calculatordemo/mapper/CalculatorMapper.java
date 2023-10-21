package com.example.calculatordemo.mapper;

import com.example.calculatordemo.bean.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CalculatorMapper {

    int insertData(Record record);

    List<Record> getData();
}
