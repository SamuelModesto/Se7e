package com.unipampa.sete.resources;

import com.unipampa.sete.dto.InternshipDTO;
import com.unipampa.sete.entities.*;
import com.unipampa.sete.repositories.UserRepository;
import com.unipampa.sete.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/internship")
@CrossOrigin (origins = "*")
public class InternshipResource {

    @Autowired
    private InternshipService internshipService;

    @Autowired
    private InternService internService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserServiceImplements userService;


    @PostMapping(value = "/save")
    public ResponseEntity<Internship> saveInternshipForm(@RequestBody InternshipDTO dto,
                                                         @RequestParam("email") String email) {

        Intern intern = internService.buildIntern(dto);
        internService.saveIntern(intern);

        Optional<RegisteredCompany> company = companyService.findCompanyById(dto.getCompany().getId());
        Internship internship = companyService.checkCompanyRegistration(company, dto, intern);

        internshipService.saveInternship(internship);

        Optional<User> user = userService.captureUserLogged(email);
        Student student = studentService.buildStudyUser(user, internship);
        studentService.saveStudent(student);

        return ResponseEntity.ok(internship);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Internship>> getInternshipById(@PathVariable("id") Integer id) {
        Optional<Internship> internship = internshipService.findInternshipById(id);
        return ResponseEntity.ok(internship);
    }

    @PutMapping("/update")
    public ResponseEntity<Internship> updateInternship(@RequestBody Internship internship) {
        Internship updatedInternship = internshipService.updateInternship(internship);
        return ResponseEntity.ok(updatedInternship);
    }
  

    @GetMapping("/get/all")
    public ResponseEntity <List<InternshipDTO>> findAllInternshipsByUser(@RequestParam("email") String email) {
        List<InternshipDTO> internships = internshipService.findAll(email);
        return ResponseEntity.ok(internships);

    }

    @DeleteMapping("/del/{id}")
    public void deleteInternshipById(@PathVariable("id") Integer id) {
        studentService.deleteConstraintById(id);
        internshipService.deleteInternshipById(id);
    }

}
