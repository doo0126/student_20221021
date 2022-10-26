package com.icia.ex1.controller;

import com.icia.ex1.DTO.StudentDTO;
import com.icia.ex1.repository.StudentRepository;
import com.icia.ex1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeStudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/save")
    public String save() {
        System.out.println("세이브jsp이동");
        return "studentSave";

    }

    @PostMapping("/studentSave")
    public String studentSave(@ModelAttribute StudentService studentService, Model model) {
        System.out.printf("%s\n", studentService);
        StudentService ss = new StudentService();
        String result = ss.save(studentService);
        model.addAttribute("result", result);
        return "saveResult";
    }

//    public String studentSave(@RequestParam("studentNumber") String studentNumber, @RequestParam("studentMajor") String studentMajor,
//                             @RequestParam("studentName") String studentName , @RequestParam("studentMobile") String studentMobile, Model model) {
//
//        com.icia.ex1.service.HomeStudentDTO ss = new com.icia.ex1.service.HomeStudentDTO();
//        ss.setStudentNumber(studentNumber);
//        ss.setStudentMajor(studentMajor);
//        ss.setStudentName(studentName);
//        ss.setStudentMobile(studentMobile);
//
//        String result=studentService.save(ss);
//        model.addAttribute("result" ,result);


    //        return "saveResult";
    //  }
    @GetMapping("/dbSave")
    public String dbsaveForm() {
        return "dbSave";
    }

    @PostMapping("/db-Save")
    public String dbSave(@RequestParam("param1") String param1) {
        studentService.dbSave(param1);

        return "index";
        //param1 변수 값을 dbSave() -> Repository.dbSave()메서드로 넘겨주세요
        //Repository 빈 등록할려면 @Repository

    }

    @GetMapping("/db2")
    public String db2() {
        return "dbSave2";
    }

    @PostMapping("/dbSave2")
    public String dbSave2(@RequestParam("param2") String param2) {
        boolean result = studentService.dbSave2(param2);
        if (result) {
            return "index";

        } else {
            return "false";
        }
    }

    @GetMapping("/db-save3")
    public String dbSave3() {
        return "dbSave3";
    }

    @PostMapping("/db-save3")
    public String dbSave3(@ModelAttribute StudentDTO studentDTO) {
        boolean saveResult = studentService.dbSave3(studentDTO);
        if (saveResult) {
            return "index";
        } else {
            return "false";
        }
    }
}




