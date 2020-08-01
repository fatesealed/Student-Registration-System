package com.wzs.affairs.dao;

import com.wzs.comm.utils.PageUtils;

import java.util.List;
import java.util.Map;

public interface AffairsStudentExamInfoDao {
    public List<Map<String, Object>> selectAffirStuExamPageRows(PageUtils utils);

    public int selectAffirStuExamTotal(PageUtils utils);
}
