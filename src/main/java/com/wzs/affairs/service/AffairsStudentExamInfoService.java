package com.wzs.affairs.service;

import com.wzs.comm.utils.PageUtils;

import java.util.List;
import java.util.Map;

public interface AffairsStudentExamInfoService {
    //分页查询考生以及其报考信息表
    public List<Map<String,Object>> selectAffirStuExamPageRows(PageUtils utils);
    //查询考生报考记录总数
    public int selectAffirStuExamTotal(PageUtils utils);
}
