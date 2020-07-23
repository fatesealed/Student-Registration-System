package com.wzs.st.dao;

import com.wzs.st.entity.StuUserInfoEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author dell
 * @date 2020/7/18 11:55 StuUserInfoDaoImpl
 */

public class StuUserInfoDaoImpl implements StuUserInfoDao {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        InputStream in= StuUserInfoDaoImpl.class.getClassLoader().getResourceAsStream("mybatisConfig.xml");
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
    }

    @Override
    public int insertStuUserInfo(StuUserInfoEntity entity) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        int i=sqlSession.insert("com.wzs.st.dao.StuUserInfoDaoImpl.insertStuUserInfo",entity);
        //insert第一个参数 mapper文件中的namespace.insert标签id
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public List<StuUserInfoEntity> selectStudentIdInfoList() {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<StuUserInfoEntity> list=sqlSession.selectList("com.wzs.st.dao.StuUserInfoDaoImpl.selectStudentIdInfoList");
        sqlSession.close();
        return list;
    }

    @Override
    public int deleteStudentIdInformation(String studentId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        int i=sqlSession.delete("com.wzs.st.dao.StuUserInfoDaoImpl.deleteStudentIdInformation",studentId);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public int updateStudentIdInformation(StuUserInfoEntity entity) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        int i=sqlSession.update("com.wzs.st.dao.StuUserInfoDaoImpl.updateStudentIdInformation",entity);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public StuUserInfoEntity selectStudentIdInfoById(String stuId) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        StuUserInfoEntity entity=sqlSession.selectOne("com.wzs.st.dao.StuUserInfoDaoImpl.selectStudentIdInfoById",stuId);
        sqlSession.close();
        return entity;
    }

    @Override
    public List<StuUserInfoEntity> selectStuByUsernamePwd(StuUserInfoEntity entity) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<StuUserInfoEntity> list=sqlSession.selectList("com.wzs.st.dao.StuUserInfoDaoImpl.selectStuByUsernamePwd",entity);
        sqlSession.close();
        return list;
    }

    @Override
    public List<StuUserInfoEntity> selectStuByUsername(String username) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<StuUserInfoEntity> list=sqlSession.selectList("com.wzs.st.dao.StuUserInfoDaoImpl.selectStuByUsername",username);
        sqlSession.close();
        return list;
    }
}
