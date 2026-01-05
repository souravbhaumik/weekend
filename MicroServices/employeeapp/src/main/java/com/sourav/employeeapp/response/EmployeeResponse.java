package com.sourav.employeeapp.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

    private int id;
    
    private String name;
    
    private String email;
    
    private String bloodGroup;

}
