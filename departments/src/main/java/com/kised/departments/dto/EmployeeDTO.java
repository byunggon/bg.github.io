package com.kised.departments.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private String deptHier;
    private String fullPath;
    private int deptId;
    private String deptName; // dept_name (부서명)
    private int empId;
    private String empName;    // emp_name (이름)

}
