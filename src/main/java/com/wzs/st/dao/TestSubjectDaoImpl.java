package com.wzs.st.dao;

import com.wzs.st.entity.TestSubjectEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * description: TestSubjectDaoImpl <br>
 * date: 2020/7/22 15:28 <br>
 * author: dell <br>
 * version: 1.0 <br>
 */
public class TestSubjectDaoImpl implements TestSubjectDao {
    private static SqlSessionFactory sqlSessionFactory;//永远只创建一个实例(对象)

    static {//静态块:永远只执行一次
        InputStream in = StuUserInfoDaoImpl.class.getClassLoader().getResourceAsStream("mybatisConfig.xml");
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(in);
    }

    @Override
    public List<TestSubjectEntity> selectExamNames() {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<TestSubjectEntity> list=sqlSession.selectList("com.wzs.st.dao.TestSubjectDaoImpl.selectExamNames");
        sqlSession.close();
        return list;
    }

    @Override
    public List<TestSubjectEntity> selectLevalS(String examName) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<TestSubjectEntity> list=sqlSession.selectList("com.wzs.st.dao.TestSubjectDaoImpl.selectLevalS",examName);
        sqlSession.close();
        return list;
    }
}
