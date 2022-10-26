package com.icia.ex1.repository;

import com.icia.ex1.DTO.StudentDTO;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    //rep ->mapper 호출 하기 위해서는
    @Autowired
    private SqlSessionTemplate sql;


    public void dbSave(String param1) {
        sql.insert("Student.dbSave", param1);


    }

    public int dbSave2(String param2) {
      return  sql.insert("Student.dbSave2", param2);

    }
    public int dbSave3(StudentDTO studentDTO){
        return  sql.insert("Student.dbSave3",studentDTO);
    }
}
