package com.wzs.affairs.service;

import com.wzs.affairs.dao.AffairsStudentExamInfoDao;
import com.wzs.affairs.dao.AffairsStudentExamInfoDaoImpl;
import com.wzs.comm.utils.PageUtils;

import java.util.List;
import java.util.Map;

public class AffairsStudentExamInfoServiceImpl implements AffairsStudentExamInfoService {
    @Override
    public List<Map<String, Object>> selectAffirStuExamPageRows(PageUtils utils) {
        AffairsStudentExamInfoDao dao=new AffairsStudentExamInfoDaoImpl();
        List<Map<String,Object>> list=dao.selectAffirStuExamPageRows(utils);
        return list;
    }

    @Override
    public int selectAffirStuExamTotal(PageUtils utils) {
        AffairsStudentExamInfoDao dao=new AffairsStudentExamInfoDaoImpl();
        int total=dao.selectAffirStuExamTotal(utils);
        return total;
    }
}
