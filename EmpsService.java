package com.example.demo.service;

import com.example.demo.model.EmpsModel;
import com.example.demo.repo.EmpsRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmpsService {
    @Autowired
    private  EmpsRepo empsRepo;
    public List<EmpsModel> getAllEmps()
    {
        return empsRepo.findAll();
    }
    public Optional<EmpsModel> getEmployeeById(int id)
    {
        return empsRepo.findById(id);
//        EmpsModel employee = empsRepo.findById(id).get();
//        if(employee == null)throw new RuntimeException("No employee found with id "+id);
//         return employee;
    }
    public EmpsModel createEmpsRecord(EmpsModel employee)
    {
        return empsRepo.save(employee);
    }
    public EmpsModel updateEmpsRecord(int id,EmpsModel updatedEmployee)
    {
        EmpsModel existingEmployee = empsRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with ID: " + id));

        existingEmployee.setEmp_name(updatedEmployee.getEmp_name());
        existingEmployee.setEmp_dept(updatedEmployee.getEmp_dept());
        existingEmployee.setEmp_job(updatedEmployee.getEmp_job());
        existingEmployee.setEmp_salary(updatedEmployee.getEmp_salary());
        existingEmployee.setEmp_email(updatedEmployee.getEmp_email());

        return empsRepo.save(existingEmployee);
    }
    public String deleteEmpsRecord(int id)
    {
        if(empsRepo.existsById(id))
        {
            empsRepo.deleteById(id);
            return "Deleted employee with id "+id;
        }
        return "Employee with id "+id+" not found";


    }



}