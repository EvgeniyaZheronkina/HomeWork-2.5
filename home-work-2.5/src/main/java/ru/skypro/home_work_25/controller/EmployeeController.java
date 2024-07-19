package ru.skypro.home_work_25.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.home_work_25.Employee;
import ru.skypro.home_work_25.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private  final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping ("/add")
    public Employee addEmployee(
            @RequestParam ("firstName") String firstName,
            @RequestParam ("lastName") String lastName
    ){
        return employeeService.add(firstName, lastName);
    }

    @GetMapping (value="/remove")
    public Employee removeEmployee(
            @RequestParam ("firstName: ") String firstName,
            @RequestParam ("lastName") String lastName
    ){
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping (value="/find")
    public Employee findEmployee(
            @RequestParam ("firstName: ") String firstName,
            @RequestParam ("lastName") String lastName
    ){
        return employeeService.find(firstName, lastName);
    }

    @GetMapping(value="/allEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAll();
    }

}



