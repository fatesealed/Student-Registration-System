package com.wzs.affairs.dao;

import com.wzs.affairs.entity.AffairEntity;
import com.wzs.st.dao.StuUserInfoDaoImpl;
import com.wzs.st.entity.StuUserInfoEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class AffairInfDaoImpl implements AffairInfDao {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        InputStream in= StuUserInfoDaoImpl.class.getClassLoader().getResourceAsStream("mybatisConfig.xml");
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
    }
    @Override
    public List<AffairEntity> selectAffByUsernamePwd(AffairEntity entity) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<AffairEntity> list=sqlSession.selectList("com.wzs.affairs.dao.AffairInfDaoImpl.selectAffByUsernamePwd",entity);
        sqlSession.close();
        return list;
    }
}
