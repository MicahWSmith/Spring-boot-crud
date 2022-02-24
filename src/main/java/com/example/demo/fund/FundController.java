package com.example.demo.fund;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
// Importing required classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class FundController {

    private final FundService fundService;

    @Autowired
    public FundController(FundService fundService) {
        this.fundService = fundService;
    }

    // Save operation
    @PostMapping("/funds")
    public Fund saveDepartment(
            @RequestBody Fund fund)
    {
        return fundService.createFund(fund);
    }

    // Read operation
    @GetMapping("/funds")
    public List<Fund> getFunds()
    {
        return fundService.getFunds();
    }

    // Update operation
    @PutMapping("/funds/{id}")
    public Fund
    updateFund(@RequestBody Fund fund,
                     @PathVariable("id") Long id)
    {
        return fundService.updateFund(
                fund, id);
    }

    // Delete operation
    @DeleteMapping("/funds/{id}")
    public String deleteFund(@PathVariable("id")
                                               Long id)
    {
        fundService.deleteFund(
                id);
        return "Deleted Successfully";
    }
}
