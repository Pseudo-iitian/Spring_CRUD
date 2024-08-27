package com.example.rest_api_task.controller;

import com.example.rest_api_task.model.CloudVendor;
import com.example.rest_api_task.service.CloudVendorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;

//    @PostMapping
//    public ResponseEntity<String> createVendor(@RequestBody CloudVendor cloudVendor) {
//        // Handle the POST request
//        return ResponseEntity.ok("Vendor created successfully");
//    }

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    // for reading specific cloud vendor details
    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
//        return new CloudVendor("C1","Vendor 1",
//                "Address 1", "xxxxx");
        return cloudVendorService.getCloudVendor(vendorId);
    }

    // for all cloud vendor details
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails() {
//        return new CloudVendor("C1","Vendor 1",
//                "Address 1", "xxxxx");
        return cloudVendorService.getAllCloudVendors();
    }


    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "cloud vendor created successfully";
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "cloud vendor updated successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud vendor deleted successfully";
    }

}
