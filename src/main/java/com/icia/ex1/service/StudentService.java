package com.icia.ex1.service;

import com.icia.ex1.DTO.StudentDTO;
import com.icia.ex1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String save(StudentService studentService) {
        String result = "";


        result = studentService != null ? "가입성공" : "가입실패";
        System.out.printf("%s", studentService);

        return result;
    }


    public void dbSave(String param1) {
        studentRepository.dbSave(param1);

        System.out.printf("data:%s\n", param1);


    }

    public boolean dbSave2(String param2) {

        int insertResult = studentRepository.dbSave2(param2);
        if (insertResult > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean dbSave3(StudentDTO studentDTO){
        int insertResult =  studentRepository.dbSave3(studentDTO);
    if(insertResult >0){
        return true;
    }
    else{
        return false;
    }

    }
}



