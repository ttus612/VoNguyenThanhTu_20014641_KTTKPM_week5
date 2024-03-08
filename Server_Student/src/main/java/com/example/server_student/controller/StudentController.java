package com.example.server_student.controller;

import com.example.server_student.models.Student;
import com.example.server_student.services.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("api/v1/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("students")
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @GetMapping("students/{id}")
    public Student getStudentById(Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student,  HttpSession session) {
        if (session.getAttribute("token") == null){
            // Nếu không có token, in ra lỗi và kết thúc hàm
            System.out.println("Token not found. Please login first.");
            // Sử dụng Scanner để nhập username và password từ người dùng
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            String requestBody = "{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}";
            HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

            try {
                String response = restTemplate.postForObject("http://localhost:8080/login", requestEntity, String.class);
                return studentService.addStudent(student);
            } catch (HttpClientErrorException.BadRequest ex) {
                System.out.println("Login failed: Bad Request");
                return null;
            }
        }
        // Lấy token từ session
        String token = (String) session.getAttribute("token");

        // Tạo một HttpHeaders object và thêm token vào header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        return studentService.addStudent(student);
    }

}
