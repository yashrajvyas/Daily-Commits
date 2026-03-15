package com.springbootwebtutorial.mvcarchitecture.controllers;

import com.springbootwebtutorial.mvcarchitecture.dto.EmployeeDTO;
import com.springbootwebtutorial.mvcarchitecture.exceptions.ResourceNotFoundException;
import com.springbootwebtutorial.mvcarchitecture.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController{

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable (name ="employeeId") Long id){
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElseThrow(()-> new ResourceNotFoundException("Employee Not Found with id " + id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam (required = false) Integer age,
                                                @RequestParam (required = false) String sortBy){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee){
        EmployeeDTO savedEmployee = employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long id){
        return  ResponseEntity.ok(employeeService.updateEmployeeById(employeeDTO, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long id){
        boolean gotDeleted = employeeService.deleteEmployeeById(id);
        if (gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path ="/{id}")
    ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String, Object> updates,
                                          @PathVariable Long id) {
        EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeById(updates, id);
        if (employeeDTO == null)return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }
}
