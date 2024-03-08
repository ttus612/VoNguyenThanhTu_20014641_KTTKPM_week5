package com.example.server_teacher.services;

import com.example.server_teacher.models.Teacher;
import com.example.server_teacher.repositories.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getListTeacher(){
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(long id){
        return teacherRepository.findById(id).orElse(null);
    }
    public Teacher addTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
}
