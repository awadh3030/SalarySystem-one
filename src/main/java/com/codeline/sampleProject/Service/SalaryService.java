package com.codeline.sampleProject.Service;

import com.codeline.sampleProject.Models.Account;
import com.codeline.sampleProject.Models.Salary;
import com.codeline.sampleProject.Repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {




    @Autowired
    SalaryRepository salaryRepository;



    public List<Salary> getSalary() {return salaryRepository.findAll();}


    public void saveSalary(Salary salary) {salaryRepository.save(salary);}
}






