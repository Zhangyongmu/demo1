package com.example.demo1.controller;

import com.example.demo1.entity.ProjectType;
import com.example.demo1.service.TestService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/SpringBoot/demo1")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ProjectType test(@PathVariable("id") String id){
        System.out.println("id:" + id);
        return testService.getById(id);
    }

    /**
     * 查询
     * @return
     */
    @RequestMapping(value = "/selectList",method = RequestMethod.GET)
    @ResponseBody
    public List<ProjectType> selectList(){
        return testService.selectList();
    }

    @RequestMapping(value = "/getByDr/{dr}",method = RequestMethod.GET)
    @ResponseBody
    public ProjectType test(@PathVariable("dr") Integer dr){
        System.out.println("id:" + dr);
        return testService.getByDr(dr);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save/saveOne" , method = RequestMethod.POST)
    public String saveTest(@RequestBody ProjectType projectType){
//        JSONObject json = JSONObject.fromObject(josn);
//        JSONObject details=JSONObject.fromObject(json.get("Date"));      //转为JSON
//        ProjectType projectType = (ProjectType) JSONObject.toBean(details,ProjectType.class);
        boolean sb=testService.saveBatch(projectType);
        if(sb){
            JSONObject json = new JSONObject();
            json.put("result",1);
            json.put("msg","保存成功");
            json.put("data",projectType);
            return json.toString();
        }else{
            JSONObject json = new JSONObject();
            json.put("result",-1);
            json.put("msg","保存失败");
            json.put("data",null);
            return json.toString();
        }
    }
    /**
     * 保存
     */
    @RequestMapping(value = "/save/saveBatch" , method = RequestMethod.POST)
    public String saveTest1(@RequestBody String jsonDate){
        JSONObject date = JSONObject.fromObject(jsonDate);
        System.out.println("date:" + date.get("data"));
        JSONObject details=JSONObject.fromObject(date.get("data"));      //转为JSON
        ProjectType projectType = (ProjectType) JSONObject.toBean(details,ProjectType.class);
        boolean sb=testService.saveBatch(projectType);
        if(sb){
            JSONObject json = new JSONObject();
            json.put("result",1);
            json.put("msg","保存成功");
            json.put("data",projectType);
            return json.toString();
        }else{
            JSONObject json = new JSONObject();
            json.put("result",-1);
            json.put("msg","保存失败");
            json.put("data",null);
            return json.toString();
        }
    }
    /**
     * 更新
     */
    @RequestMapping(value = "/update/updateById" , method = RequestMethod.POST)
    public String updateTest(@RequestBody ProjectType projectType){
        boolean sb=testService.update(projectType);
        if (sb){
            return "更新成功！";
        }else{
            return "更新失败！";
        }

    }
    /**
     * 删除
     */
    @RequestMapping(value = "/delete/deleteById" , method = RequestMethod.POST)
    public String deleteTest(@RequestBody ProjectType projectType){
        boolean sb=testService.delete(projectType);
        if (sb){
            return "删除成功！";
        }else{
            return "删除失败！";
        }

    }
}
