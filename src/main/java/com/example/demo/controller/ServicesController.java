package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entity.Services;
import com.example.demo.Service.servicesservice;

@RestController
public class ServicesController {

    @Autowired
    servicesservice s;

    @PostMapping("/addservice")
    public ResponseEntity<Services> addService(@RequestBody Services service) {
        Services addedService = s.addservice(service);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedService);
    }

    @PutMapping("/updateservice")
    public ResponseEntity<String> updateService(@RequestBody Services serviceDetails) {
        try {
            s.updateservice(serviceDetails);
            return ResponseEntity.ok("Service updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update service");
        }
    }

    @GetMapping("/listservices")
    public ResponseEntity<List<Services>> listServices() {
        List<Services> services = s.listingservices();
        return ResponseEntity.ok(services);
    }

    @DeleteMapping("/deleteservice")
    public ResponseEntity<String> deleteService(@RequestBody Services serviceDetails) {
        try {
            s.deleteservices(serviceDetails);
            return ResponseEntity.ok("Service deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete service");
        }
    }
}
