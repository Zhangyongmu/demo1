package com.example.demo1.service;

import com.example.demo1.dao.TestDao;
import com.example.demo1.entity.ProjectType;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestDao testDao ;

    public ProjectType getById(String id){
        return testDao.getById(id);
    }
    public List<ProjectType> selectList(){
        return testDao.selectList();
    }
    public ProjectType getByDr(Integer dr){
        return testDao.getByDr(dr);
    }

    public boolean saveBatch(ProjectType projectType) {

        return testDao.saveBatch(projectType);
    }

    public boolean update (ProjectType projectType){
        return testDao.update(projectType);
    }
    public boolean delete (ProjectType projectType){
        return testDao.delete(projectType);
    }
}
