package com.wzs.st.dao;

import com.wzs.st.entity.SubjectInformationEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SubjectInformationDaoImpl implements SubjectInformationDao {
    //创建SQLSessionFactory
    private static SqlSessionFactory sqlSessionFactory;//永远只创建一个实例(对象)

    static {//静态块:永远只执行一次
        InputStream in = StuUserInfoDaoImpl.class.getClassLoader().getResourceAsStream("mybatisConfig.xml");
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(in);
    }

    @Override
    public int insertSubjectInformation(SubjectInformationEntity entity) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        int i=sqlSession.insert("com.wzs.st.dao.SubjectInformationDaoImpl.insertSubjectInformation",entity);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public int deleteSubjectInformation(String subId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        int i=sqlSession.delete("com.wzs.st.dao.SubjectInformationDaoImpl.deleteSubjectInformation",subId);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }
}
