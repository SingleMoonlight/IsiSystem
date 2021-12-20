package com.wyx.isisystem.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Wuyuxiang
 * @create 2021-12-17-18:09
 */
public class StaffExcelDataListener<T> extends AnalysisEventListener<T> {

    private List<T> data = new ArrayList<>();

    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        data.add(t);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
