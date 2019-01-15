package com.ptype.test.controller;

import com.ptype.test.model.Student;
import com.ptype.test.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

  @Autowired
  StudentInfoService studentInfoService;

  @RequestMapping( value = "/all", method = RequestMethod.GET )
  public ModelAndView allStudentInfo() {
    ModelAndView modelAndView = new ModelAndView( "index" );
    List<Student> studentList = studentInfoService.getAllStudents();
    modelAndView.addObject("studentlist", studentList );
    return modelAndView;
  }

  @RequestMapping( value = "/insert", method = RequestMethod.GET )
  public ModelAndView insertStudentInfo() {
    ModelAndView modelAndView = new ModelAndView("edit_form");
    Student student = new Student();
    modelAndView.addObject("studentForm", student );
    return modelAndView;
  }

  @RequestMapping( value = "/update/{roll}", method = RequestMethod.GET )
  public ModelAndView updateStudentInfo( @PathVariable( "roll" ) int roll ) {
    ModelAndView modelAndView = new ModelAndView("edit_form");
    Student student = new Student();
    student = studentInfoService.getStudentById( roll );
    modelAndView.addObject("studentForm", student );
    return modelAndView;
  }

  @RequestMapping( value = "/save", method = RequestMethod.POST )
  public ModelAndView saveStudentInfo( @ModelAttribute( "studentForm" ) Student student ) {
    studentInfoService.saveOrUpdate( student );
    return new ModelAndView( "redirect:/all" );
  }

  @RequestMapping( value = "/delete/{roll}", method = RequestMethod.GET )
  public ModelAndView deleteStudentInfo( @PathVariable("roll") int roll ) {
    studentInfoService.deleteStudent( roll );
    return new ModelAndView( "redirect:/all" );
  }
}
