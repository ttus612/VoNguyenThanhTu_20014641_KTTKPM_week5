package com.example.api_gateway.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class APIGatewatService {
    RestTemplate restTemplate = new RestTemplate();

    //Phần API GATEWAY cho teacher
    private final String urlAllTeacher = "http://localhost:8081/api/v1/teachers";
    public List<Map<String, Object>> getAllTeacher(){
        String url = urlAllTeacher;
        ResponseEntity<List<Map<String, Object>>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Map<String,Object>>>() {}
        );
        return responseEntity.getBody();
    }

    private  final  String urlFindTeacher = "http://localhost:8081/api/v1/teacher/{id}";
    public Map<String, Object> findTeacher(String id){
        String url = urlFindTeacher.replace("{id}", id);
        ResponseEntity<Map<String, Object>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map<String,Object>>() {}
        );
        return responseEntity.getBody();
    }

    private  final  String urlAddTeacher = "http://localhost:8081/api/v1/teacher";
    public void addTeacher(Map<String, Object> teacher){
        String urlAdd = urlAddTeacher;
        restTemplate.postForObject(urlAdd, teacher, Map.class);
        System.out.println(teacher);
    }




    //Phần API GATEWAY cho student
    private final String urlAllStudent = "http://localhost:8083/api/v1/students";
    public List<Map<String, Object>> getAllStudent(){
        String url = urlAllStudent;
        ResponseEntity<List<Map<String, Object>>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Map<String,Object>>>() {}
        );
        return responseEntity.getBody();
    }

    private  final  String urlAddStudent = "http://localhost:8083/api/v1/student";
    public void addStudent(Map<String, Object> student){
        String urlAdd = urlAddStudent;
        restTemplate.postForObject(urlAdd, student, Map.class);
    }



}
