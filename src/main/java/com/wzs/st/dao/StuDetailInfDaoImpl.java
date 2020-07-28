package com.wzs.st.dao;

import com.wzs.st.entity.StuDetailInfEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * description: StuDetailInfDaoImpl <br>
 * date: 2020/7/21 17:17 <br>
 * author: dell <br>
 * version: 1.0 <br>
 */
public class StuDetailInfDaoImpl implements StuDetailInfDao {
    //创建SQLSessionFactory
    private static SqlSessionFactory sqlSessionFactory;//永远只创建一个实例(对象)

    static {//静态块:永远只执行一次
        InputStream in = StuDetailInfDaoImpl.class.getClassLoader().getResourceAsStream("mybatisConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }

    @Override
    public StuDetailInfEntity selectStuDetailInfById(String stuId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StuDetailInfEntity entity = sqlSession.selectOne("com.wzs.st.dao.StuDetailInfDaoImpl.selectStuDetailInfById", stuId);
        sqlSession.close();
        return entity;
    }

    @Override
    public int insertStuInf(StuDetailInfEntity entity) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        int i=sqlSession.insert("com.wzs.st.dao.StuDetailInfDaoImpl.insertStuInf",entity);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }
}
