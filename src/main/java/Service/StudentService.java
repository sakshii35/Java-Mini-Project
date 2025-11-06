package com.example.osms.service;

import com.example.osms.model.Student;
import java.util.List;

public interface StudentService {
  void addStudent(Student s);
  void updateStudent(Student s);
  void deleteStudent(Integer id);
  Student getStudent(Integer id);
  List<Student> getAllStudents();

  // Payment/refund methods
  void makePayment(Integer studentId, java.math.BigDecimal amount);
  void refund(Integer studentId, java.math.BigDecimal amount);
}
