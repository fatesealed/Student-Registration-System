package com.wzs.affairs.dao;

import com.wzs.comm.utils.PageUtils;
import com.wzs.st.dao.StuUserInfoDaoImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class AffairsStudentExamInfoDaoImpl implements AffairsStudentExamInfoDao {
    //创建SQLSessionFactory
    private static SqlSessionFactory sqlSessionFactory;//永远只创建一个实例(对象)

    static {//静态块:永远只执行一次
        InputStream in = StuUserInfoDaoImpl.class.getClassLoader().getResourceAsStream("mybatisConfig.xml");
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(in);
    }

    @Override
    public List<Map<String, Object>> selectAffirStuExamPageRows(PageUtils utils) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<Map<String,Object>> list=sqlSession.selectList("com.wzs.affairs.dao.AffairsStudentExamInfoDaoImpl.selectAffirStuExamPageRows",utils);
        sqlSession.close();
        return list;
    }

    @Override
    public int selectAffirStuExamTotal(PageUtils utils) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        int total=sqlSession.selectOne("com.wzs.affairs.dao.AffairsStudentExamInfoDaoImpl.selectAffirStuExamTotal",utils);
        sqlSession.close();
        return total;
    }
}
