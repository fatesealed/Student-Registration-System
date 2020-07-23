package com.wzs.st.dao;

import com.wzs.st.entity.TestDetailEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * description: TestDetailDaoImpl <br>
 * date: 2020/7/23 11:50 <br>
 * author: dell <br>
 * version: 1.0 <br>
 */
public class TestDetailDaoImpl implements TestDetailDao {
    //创建SQLSessionFactory
    private static SqlSessionFactory sqlSessionFactory;//永远只创建一个实例(对象)

    static {//静态块:永远只执行一次
        InputStream in = StuUserInfoDaoImpl.class.getClassLoader().getResourceAsStream("mybatisConfig.xml");
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(in);

    }

    @Override
    public List<TestDetailEntity> selectExamcourseAddr(String examId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<TestDetailEntity> list=sqlSession.selectList("com.wzs.st.dao.TestDetailDaoImpl.selectExamcourseAddr",examId);
        sqlSession.close();
        return list;
    }

    @Override
    public List<TestDetailEntity> selectExamcourseTime(TestDetailEntity entity) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<TestDetailEntity> list=sqlSession.selectList("com.wzs.st.dao.TestDetailDaoImpl.selectExamcourseTime",entity);
        sqlSession.close();
        return list;
    }
}
