package com.example.osms.dao;

import com.example.osms.model.Student;
import java.util.List;

public interface StudentDAO {
  void save(Student s);
  void update(Student s);
  void delete(Student s);
  Student findById(Integer id);
  List<Student> findAll();
}
