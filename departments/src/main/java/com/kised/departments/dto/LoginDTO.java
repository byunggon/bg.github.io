package com.kised.departments.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private Long empId;         // emp_id (PK)
    private String empName;     // emp_name (직원명)
    private Long deptId;        // dept_id (부서코드)
    private String deptName;
    private Long roleId;         // role_id (권한 ID)
    private String roleName;     // role_name (권한 이름)
    private Long rankId;        // rank_id (직급 ID)
}
