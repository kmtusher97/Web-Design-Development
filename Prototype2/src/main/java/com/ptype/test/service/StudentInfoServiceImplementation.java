package com.ptype.test.service;

import com.ptype.test.model.Student;
import com.ptype.test.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentInfoServiceImplementation implements StudentInfoService {

  @Autowired
  StudentRepository studentRepository;

  @Override
  public List<Student> getAllStudents() {
    return ( List<Student> ) studentRepository.findAll();
  }

  @Override
  public Student getStudentById( int id ) {
    return studentRepository.findById( id ).get();
  }

  @Override
  public void saveOrUpdate( Student student ) {
    studentRepository.save( student );
  }

  @Override
  public void deleteStudent( int id ) {
    studentRepository.deleteById( id );
  }

}
