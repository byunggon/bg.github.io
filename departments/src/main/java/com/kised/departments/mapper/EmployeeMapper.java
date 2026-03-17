package com.kised.departments.mapper;

import com.kised.departments.dto.EmployeeDTO;
import com.kised.departments.dto.JsTreeDTO;
import com.kised.departments.dto.LoginDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<EmployeeDTO> getOrgList();
    List<JsTreeDTO> getOrgTree();
    List<EmployeeDTO> selectAllDepartments();

    LoginDTO findLoginUser (
            @Param("name") String name,
            @Param("dept") String dept
    );
    void insertEmployee(
            @Param("deptId") int deptId,
            @Param("empName") String empName
    );
    void updateEmployeeDept(
            @Param("empId") int empId,
            @Param("deptId") int deptId
    );
    void deleteEmployee(
            @Param("empId") int empId
    );
}
