package com.example.demo1.dao;

import com.example.demo1.entity.ProjectType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TestDao {
    public ProjectType getById(String id);

    public ProjectType getByDr(Integer dr);

//    @Select("select * from project_type")
    public List<ProjectType> selectList();
    @Insert("insert into project_type (id,itemtypeid,code,name) values(#{id,jdbcType=CHAR}, #{itemtypeid,jdbcType=CHAR}, #{code,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR})  ")
    public boolean  saveBatch(ProjectType projectType);

    @Update("update project_type set itemtypeid = #{itemtypeid,jdbcType=CHAR},code = #{code,jdbcType=VARCHAR},name = #{name,jdbcType=VARCHAR} where id = #{id,jdbcType=CHAR}  ")
    public boolean  update(ProjectType projectType);

    @Delete("delete from PROJECT_TYPE where id = #{id,jdbcType=CHAR}  ")
    boolean delete(ProjectType projectType);
}
