package com.example.osms.dao;

import com.example.osms.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

  @Autowired
  private SessionFactory sessionFactory;

  private Session currentSession() {
    return sessionFactory.getCurrentSession();
  }

  @Override
  public void save(Student s) {
    currentSession().save(s);
  }

  @Override
  public void update(Student s) {
    currentSession().update(s);
  }

  @Override
  public void delete(Student s) {
    currentSession().delete(s);
  }

  @Override
  public Student findById(Integer id) {
    return currentSession().get(Student.class, id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Student> findAll() {
    return currentSession().createQuery("from Student").list();
  }
}
