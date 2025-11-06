package com.example.osms.service;

import com.example.osms.dao.StudentDAO;
import com.example.osms.dao.PaymentDAO;
import com.example.osms.model.Payment;
import com.example.osms.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentDAO studentDAO;

  @Autowired
  private PaymentDAO paymentDAO;

  @Override
  @Transactional
  public void addStudent(Student s) {
    studentDAO.save(s);
  }

  @Override
  @Transactional
  public void updateStudent(Student s) {
    studentDAO.update(s);
  }

  @Override
  @Transactional
  public void deleteStudent(Integer id) {
    Student s = studentDAO.findById(id);
    if (s != null) studentDAO.delete(s);
  }

  @Override
  public Student getStudent(Integer id) {
    return studentDAO.findById(id);
  }

  @Override
  public List<Student> getAllStudents() {
    return studentDAO.findAll();
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void makePayment(Integer studentId, BigDecimal amount) {
    Student s = studentDAO.findById(studentId);
    if (s == null) throw new RuntimeException("Student not found");
    s.setBalance(s.getBalance().subtract(amount));
    studentDAO.update(s);
    Payment p = new Payment();
    p.setStudent(s);
    p.setAmount(amount);
    p.setPaymentDate(LocalDateTime.now());
    paymentDAO.save(p);
    // If any exception occurs here, whole transaction will roll back
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void refund(Integer studentId, BigDecimal amount) {
    Student s = studentDAO.findById(studentId);
    if (s == null) throw new RuntimeException("Student not found");
    s.setBalance(s.getBalance().add(amount));
    studentDAO.update(s);
    Payment p = new Payment();
    p.setStudent(s);
    p.setAmount(amount.negate()); // negative amount or separate refund table
    p.setPaymentDate(LocalDateTime.now());
    paymentDAO.save(p);
  }
}
