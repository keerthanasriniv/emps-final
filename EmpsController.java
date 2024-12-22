package com.example.demo.controller;

import com.example.demo.model.EmpsModel;
import com.example.demo.service.EmpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmpsController {
   @Autowired
   private EmpsService empsService;
   @GetMapping("/")
    public List<EmpsModel> getALlEmps() {
       return empsService.getAllEmps();
   }
   @GetMapping("/{id}")
    public Optional<EmpsModel> getEmpById(@PathVariable int id) {
       return empsService.getEmployeeById(id);
   }
   @PostMapping("/")
    public EmpsModel createEmpsRecord(@RequestBody EmpsModel empsModel) {
       return empsService.createEmpsRecord(empsModel);
   }
   @PutMapping("/{id}")
    public EmpsModel updateEmpsRecord(@PathVariable int id, @RequestBody EmpsModel empsModel) {
       return empsService.updateEmpsRecord(id, empsModel);
   }
   @DeleteMapping("/{id}")
    public String  deleteEmpsRecord(@PathVariable int id) {
       return empsService.deleteEmpsRecord(id);

   }


}
