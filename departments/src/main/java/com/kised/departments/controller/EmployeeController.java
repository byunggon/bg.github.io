package com.kised.departments.controller;

import com.kised.departments.dto.EmployeeDTO;
import com.kised.departments.dto.JsTreeDTO;
import com.kised.departments.dto.LoginDTO;
import com.kised.departments.mapper.EmployeeMapper;
import com.kised.departments.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/mypage")
    public String myPage(HttpSession session) {
        // 세션에 데이터가 실제로 있는지 체크 (디버깅용)
        Object loginUser = session.getAttribute("loginUser");

        if (session.getAttribute("loginUser") == null) {
            System.out.println("로그인 세션이 없습니다!");
            return "redirect:/login"; // 로그인 안 되어 있으면 로그인 페이지로 보내기
        }
        return "mypage"; // templates/mypage.html 호출
    }

    @PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String dept, HttpSession session) {
        LoginDTO loginUser = employeeMapper.findLoginUser(name, dept);
        if (loginUser != null) {
            System.out.println("로그인 성공!");
            System.out.println("부서: " + loginUser.getDeptName());
            System.out.println("이름: " + loginUser.getEmpName());
            session.setAttribute("loginUser", loginUser);
            return "redirect:/";
        } else {
            return "redirect:/login?error=true";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 1. 세션 무효화 (모든 세션 데이터 삭제)
        session.invalidate();

        // 2. 로그아웃 후 다시 로그인 페이지로 리다이렉트
        return "redirect:/login";
    }

    @GetMapping("org/admin")
    public String adminUserPage(HttpSession session, RedirectAttributes rttr, Model model) {
        LoginDTO loginUser = (LoginDTO) session.getAttribute("loginUser");
        List<EmployeeDTO> list = employeeService.getOrgList();
        List<EmployeeDTO> deptList = employeeService.getAllDepartments();

        if(!employeeService.isAdmin(loginUser)) {
            rttr.addFlashAttribute("msg", "관리자 권한이 없습니다");
            return "redirect:/";
        }
        model.addAttribute("userList", list);
        model.addAttribute("deptList", deptList);

        return ("org/userList");
    }

    @PostMapping("org/register")
    public String registerEmployee(@RequestParam("deptId") int deptId, @RequestParam("empName") String empName) {
        employeeService.registerEmployee(deptId, empName);

        return "redirect:/org/admin";
    }

    @PostMapping("/org/update")
    @ResponseBody
    public String update(@RequestParam("empId") int empId,
                         @RequestParam("deptId") int deptId) {
        employeeService.updateEmployeeDept(empId, deptId);
        return "ok";
    }

    // 삭제 처리
    @PostMapping("/org/delete")
    @ResponseBody
    public String delete(@RequestParam("empId") int empId) {
        employeeService.deleteEmployee(empId);
        return "ok";
    }

    @GetMapping("org/list")
    public String orgListPage(Model model) {
        List<EmployeeDTO> list = employeeService.getOrgList();
        model.addAttribute("orgList", list);
        return "org/orgList"; // src/main/resources/templates/org/orgList.html 호출
    }

    @GetMapping("org/tree")
    public String orgTreePage(Model model) {
        // jstree용 데이터를 가져오는 서비스 호출
        List<JsTreeDTO> treeList = employeeService.getOrgTree();
        model.addAttribute("treeData", treeList);
        return "org/orgTree";
    }
}