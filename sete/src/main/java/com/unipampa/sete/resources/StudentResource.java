package com.unipampa.sete.resources;

import com.unipampa.sete.dto.InternshipDTO;
import com.unipampa.sete.entities.Company;
import com.unipampa.sete.entities.RegisteredCompany;
import com.unipampa.sete.entities.Internship;
import com.unipampa.sete.entities.UnregisteredCompany;
import com.unipampa.sete.services.CompanyService;
import com.unipampa.sete.services.InternshipService;
import com.unipampa.sete.services.TceService;
import com.unipampa.sete.services.UserServiceImplements;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/")
@CrossOrigin(origins = "*")
public class StudentResource {

    @Autowired
    InternshipService internshipService;

    @Autowired
    TceService tceService;

    @Autowired
    UserServiceImplements userServiceImplements;

    @Autowired
    CompanyService companyService;

    @GetMapping("tce/{id}")
    public void generateTCE(@PathVariable Integer id, HttpServletResponse response) throws JRException, IOException {
        Optional<Internship> internship = internshipService.findInternshipById(id);
        Optional<RegisteredCompany> registeredCompany = null;
        Optional<UnregisteredCompany> unregisteredCompany = null;
        InternshipDTO internshipDTO = new InternshipDTO();
        if (internship.get().getRegisteredCompanyRegistered() != null) {
            registeredCompany = companyService.findCompanyById(internship.get().getRegisteredCompanyRegistered().getId());
            internshipDTO.setCompany(registeredCompany.get());
        } else if (internship.get().getUnregisteredCompany() != null) {
            unregisteredCompany = companyService.findUnregisteredCompany(internship.get().getUnregisteredCompany().getId());
            internshipDTO.setCompany(unregisteredCompany.get());
        }

        internshipDTO.setIntern(internship.get().getIntern());
        tceService.buildDocument(internshipDTO);
        String s = tceService.getHtmlReportAsString();
        response.setHeader("Content-disposition", "attachment; filename=Blank_A4.html");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(s);
    }


}
