package com.sourav.employeeapp.service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourav.employeeapp.repository.EmployeeRepo;
import com.sourav.employeeapp.response.EmployeeResponse;
import com.sourav.employeeapp.entity.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    public EmployeeResponse getEmployeeById( int id ) {

        Employee employee = employeeRepo.findById(id).get();

        return modelMapper.map(employee, EmployeeResponse.class);

    }

    public EmployeeResponse createEmployee( Employee employee ) {
        
        employee.setId(0);
        return modelMapper.map(employeeRepo.save(employee), EmployeeResponse.class);

    }

}
