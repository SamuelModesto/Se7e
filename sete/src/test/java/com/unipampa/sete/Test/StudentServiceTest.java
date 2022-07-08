package com.unipampa.sete.Test;


import com.unipampa.sete.entities.Internship;
import com.unipampa.sete.entities.Student;
import com.unipampa.sete.entities.User;
import com.unipampa.sete.repositories.StudentRepository;
import com.unipampa.sete.services.InternshipService;
import com.unipampa.sete.services.StudentService;
import com.unipampa.sete.services.UserServiceImplements;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService service;

    @Autowired
    private UserServiceImplements userService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private InternshipService internshipService;

    @Test
    public void deveSalvarStudentComSucesso(){
        Student student =buildStudent();

        service.saveStudent(student);

        Assertions.assertThat(studentRepository.findById(student.getId()).get().equals(student));

    }

    @Test
    public void deveDeletarUmStudentComSucesso(){
        Student student = buildStudent();

        service.saveStudent(student);

        service.deleteConstraintById(student.getId());

        Assertions.assertThat(studentRepository.findById(student.getId()).equals(null));
    }

    public Student buildStudent(){
        return service.buildStudyUser(buildUser(),buildInternship());

    }

    public Optional<User> buildUser(){
        Optional<User> user =  userService.captureUserLogged("teste@gmail.com");
        return user;
    }
    public Internship buildInternship(){
        Optional<Internship> internship = internshipService.findInternshipById(33);

        return internship.get();
    }
}
