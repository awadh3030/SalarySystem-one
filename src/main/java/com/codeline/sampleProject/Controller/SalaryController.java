package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Salary;
import com.codeline.sampleProject.ResponseObjects.GetSalaryResponse;
import com.codeline.sampleProject.Service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;




    @RestController
    public class SalaryController {
        @Autowired
        SalaryService salaryService;

        @RequestMapping("salary/create")
        public void saveSalary(Salary salary) {
            createSalary();
        }

        @RequestMapping("salary/get/{salaryId}")
        public GetSalaryResponse createSalary (@PathVariable Long salaryId) {
            return salaryService.getSalaryById(salaryId);
        }



        @RequestMapping("salary/get")
        public List<Salary> getSalary() {return salaryService.getSalary();}


        public void createSalary() {

            Salary salary = new Salary();

            salary.setAmount(1000.00);
            salary.setCurrency("OMR");
            salary.setOverTimeAmount(50.00);
            salary.setDeductions(00.00);
            salary.setHealthCareContribution(70.00);
            salary.setAllowances(200.00);
            salary.setBonus(30.00);
            salary.setPerDiem(35.00);
            salaryService.saveSalary(salary);


        }
    }
