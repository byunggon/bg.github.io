package com.kised.departments.service;

import com.kised.departments.dto.EmployeeDTO;
import com.kised.departments.dto.JsTreeDTO;
import com.kised.departments.dto.LoginDTO;
import com.kised.departments.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper; // DB 쿼리가 들어있는 Mapper(또는 Repository)

    public boolean isAdmin(LoginDTO loginUser) {
        if(loginUser == null) {
            return false;
        }
        return loginUser.getRoleId() == 1;
    }

    public void registerEmployee(int deptId, String empName) {
        employeeMapper.insertEmployee(deptId, empName);
    }

    public List<EmployeeDTO> getAllDepartments() {
        return employeeMapper.selectAllDepartments();
    }

    @Transactional
    public void updateEmployeeDept(int empId, int deptId) {
        employeeMapper.updateEmployeeDept(empId, deptId);
    }

    // 직원 삭제
    @Transactional
    public void deleteEmployee(int empId) {
        employeeMapper.deleteEmployee(empId);
    }

    public List<EmployeeDTO> getOrgList() {
        return employeeMapper.getOrgList();
    }

    public List<JsTreeDTO> getOrgTree() {
        return employeeMapper.getOrgTree();
    }
}
