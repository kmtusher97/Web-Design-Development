package com.ptype.test.service;

import com.ptype.test.model.Student;

import java.util.List;

public interface StudentInfoService {
  public List<Student> getAllStudents();
  public Student getStudentById( int id );
  public void saveOrUpdate( Student student );
  public void deleteStudent( int id );
}
