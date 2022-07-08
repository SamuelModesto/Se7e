package com.unipampa.sete.resources;

import com.unipampa.sete.dto.CompanyDTO;
import com.unipampa.sete.entities.RegisteredCompany;
import com.unipampa.sete.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/company/")
@CrossOrigin (origins = "*")
public class CompanyResource {

    @Autowired
    private CompanyService companyService;

    @PostMapping(value = "save")
    public void createNewCompany(@RequestBody CompanyDTO dto) {
        RegisteredCompany registeredCompany = companyService.buildCompanyRegistered(dto);
        companyService.saveCompany(registeredCompany);
    }

    @GetMapping("get/{id}")
    public ResponseEntity getCompanyById(@PathVariable("id") Integer id) {
        Optional<RegisteredCompany> company = companyService.findCompanyById(id);
        return ResponseEntity.ok(company);
    }

    @GetMapping("get/all")
    public List<RegisteredCompany> findAllCompanies() {
        return companyService.findAllCompanies();
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateCompanyById(@PathVariable Integer id, @RequestBody CompanyDTO dto) {
        return companyService.findCompanyById(id).map(entity -> {
            RegisteredCompany registeredCompany = companyService.buildCompanyRegistered(dto);
            registeredCompany.setId(entity.getId());
            companyService.updateCompany(registeredCompany);
            return ResponseEntity.ok(registeredCompany);
        }).orElseGet(() -> new ResponseEntity("Lancamento não encontrado na base de dados",
                HttpStatus.BAD_REQUEST));
    }
}
