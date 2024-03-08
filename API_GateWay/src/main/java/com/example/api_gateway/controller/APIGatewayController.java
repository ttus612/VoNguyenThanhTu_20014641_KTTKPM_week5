package com.example.api_gateway.controller;

import com.example.api_gateway.service.APIGatewatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class APIGatewayController {
    @Autowired
    private APIGatewatService apiGateWayService;
    //Phần API GATEWAY cho teacher
    @GetMapping("/listTeacher")
    public List<Map<String, Object>> getAllTeacher(){
        List<Map<String, Object>> teachers = apiGateWayService.getAllTeacher();
        return teachers;
    }

    @GetMapping("/teacher/{id}")
    public Map<String, Object> findTeacher(@PathVariable String id){
        Map<String, Object> teacher = apiGateWayService.findTeacher(id);
        return teacher;
    }

    @PostMapping("/teacher")
    public void addTeacher(@RequestBody Map<String, Object> teacher){
        System.out.println(teacher);
        apiGateWayService.addTeacher(teacher);
    }

    @PostMapping("/teacher/addStudent")
    public void addStudent(@RequestBody Map<String, Object> student){
        System.out.println(student);
        apiGateWayService.addStudent(student);
    }



    //Phần API GATEWAY cho student
    @GetMapping("/listTeacher/searchListStudent")
    public List<Map<String, Object>> getAllStudent(){
        List<Map<String, Object>> students = apiGateWayService.getAllStudent();
        return students;
    }

}
