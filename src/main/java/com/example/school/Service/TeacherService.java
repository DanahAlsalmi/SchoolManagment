package com.example.school.Service;

import com.example.school.Api.ApiException;
import com.example.school.Model.Teacher;
import com.example.school.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    //get
    public List<Teacher> getAllCustomers() {
        return teacherRepository.findAll();
    }
    //add
    public void addCustomer(Teacher teacher) {
        teacherRepository.save(teacher);
    }
    //update
    public void updateCustomer(Integer id, Teacher teacher) {
        Teacher teacher1 = teacherRepository.findTeacherByid(id);
        if (teacher1 == null) {
            throw new ApiException("Teacher Not Found");
        }
        teacher1.setName(teacher.getName());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setSalary(teacher.getSalary());
        teacherRepository.save(teacher1);
    }
    //Delete
    public void deleteCustomer(Integer id) {
        Teacher teacher = teacherRepository.findTeacherByid(id);
        if (teacher == null) {
            throw new ApiException("Teacher Not Found");
        }
        teacherRepository.delete(teacher);
    }
}