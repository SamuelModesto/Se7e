package com.unipampa.sete.services;

import com.unipampa.sete.entities.Internship;
import com.unipampa.sete.entities.Student;
import com.unipampa.sete.entities.User;
import com.unipampa.sete.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteConstraintById(Integer id){
        studentRepository.deleteById(id);
    }

    public Student buildStudyUser(Optional<User> user, Internship internship) {
        Student student = new Student();
        student.setUser(user.get());
        student.setInternship(internship);
        return student;
    }
}
