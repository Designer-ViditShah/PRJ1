package com.example.demo.Controller;

import com.example.demo.Entity.DesignationMaster;
import com.example.demo.Entity.LoginEntity;
import com.example.demo.Repository.DesignationMasterRepository;
import com.example.demo.Repository.LoginRepository;
import com.example.demo.Request.CreateDesignationMasterRequest;
import com.example.demo.Request.CreateLogInRequest;
import com.example.demo.Request.UpdateDesignationMasterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@Controller
@RequestMapping(path = "/designation")
public class DesignationMasterController {

    @Autowired
    private DesignationMasterRepository designationMasterRepository;

    @PostMapping(path="/create")
    public @ResponseBody String create (@RequestBody CreateDesignationMasterRequest createdesignationMasterRequest) {

        // assuming there is no egde cases to take care of as of now
        DesignationMaster designationMaster = new DesignationMaster();
        designationMaster.setDesignation(createdesignationMasterRequest.getDesignation());
        designationMasterRepository.save(designationMaster);
        return "Designation Added Successfully";
    }

    @PutMapping(path="/update/{id}")
    public @ResponseBody String update (@PathParam(value = "id") Integer designationId, @RequestBody UpdateDesignationMasterRequest updateDesignationMasterRequest) {

        // assuming there is no egde cases to take care of as of now
        Optional<DesignationMaster> designationMasterOptional = designationMasterRepository.findById(designationId);
        if(designationMasterOptional.isPresent()){
            DesignationMaster designationMaster = designationMasterOptional.get();
            designationMaster.setDesignation(updateDesignationMasterRequest.getDesignation());
            designationMasterRepository.save(designationMaster);
            return "Designation Updated Successfully";
        }
        return "Improper values passed";
    }

    @GetMapping(path="/get")
    public @ResponseBody Iterable<DesignationMaster> get() {
        return designationMasterRepository.findAll();
    }

    @DeleteMapping(path="/delete/{id}")
    public @ResponseBody void delete(@PathParam(value = "id") Integer designationId) {
        designationMasterRepository.deleteById(designationId);
    }

}
