package com.example.demo.Controller;

import com.example.demo.Entity.EmployeeMaster;
import com.example.demo.Repository.EmployeeMasterRepository;
import com.example.demo.Request.CreateEmployeeMasterRequest;
import com.example.demo.Request.UpdateEmployeeMasterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/employee")
public class EmployeeMasterController {

    @Autowired
    private EmployeeMasterRepository employeeMasterRepository;

    @PostMapping(path="/create")
    public @ResponseBody String create (@RequestBody CreateEmployeeMasterRequest createEmployeeMasterRequest) {

        // assuming there is no egde cases to take care of as of now
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setFirstname(createEmployeeMasterRequest.getFirstname());
        employeeMaster.setLastname(createEmployeeMasterRequest.getLastname());
        employeeMaster.setDesignationMasterId(createEmployeeMasterRequest.getDesignationMasterId());
        employeeMaster.setDateOfJoining(createEmployeeMasterRequest.getDateOfJoining());
        employeeMaster.setSalary(createEmployeeMasterRequest.getSalary());
        employeeMasterRepository.save(employeeMaster);
        return "Employee Added to Employee Master";
    }

    @PutMapping(path="/update/{id}")
    public @ResponseBody String update (@PathParam(value = "id") Integer employeeId, @RequestBody UpdateEmployeeMasterRequest updateEmployeeMasterRequest) {

        // assuming there is no egde cases to take care of as of now
        Optional<EmployeeMaster> employeeMasterOptional = employeeMasterRepository.findById(employeeId);
        if(employeeMasterOptional.isPresent()){
            EmployeeMaster employeeMaster = employeeMasterOptional.get();
            employeeMaster.setFirstname(updateEmployeeMasterRequest.getFirstname());
            employeeMaster.setLastname(updateEmployeeMasterRequest.getLastname());
            employeeMaster.setDesignationMasterId(updateEmployeeMasterRequest.getDesignationMasterId());
            employeeMaster.setDateOfJoining(updateEmployeeMasterRequest.getDateOfJoining());
            employeeMaster.setSalary(updateEmployeeMasterRequest.getSalary());
            employeeMasterRepository.save(employeeMaster);
            return "Employee Updated Successfully";
        }
        return "Improper values passed";
    }

    @GetMapping(path="/get")
    public @ResponseBody Iterable<EmployeeMaster> get(@RequestParam(value = "startAt") Integer startAt, @RequestParam(value = "maxResults") Integer maxResults) {
        Iterable<EmployeeMaster> employeeMasters = employeeMasterRepository.findAll();
        List<EmployeeMaster> employeeMasterList = new ArrayList<>();
        int count = 0;
        for(EmployeeMaster employeeMaster: employeeMasters){
            if(count>=startAt && employeeMasterList.size()<maxResults){
                employeeMasterList.add(employeeMaster);
            }
            count++;
        }
        System.out.println("Hello World");
        return employeeMasterList;
    }

    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody void delete(@PathParam(value = "id") Integer employeeId) {
        employeeMasterRepository.deleteById(employeeId);
    }

}
