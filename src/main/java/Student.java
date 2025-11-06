package com.project;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private String name;

  @Column
  private String course;

  @Column
  private double balance;

  public Student() {}
  public Student(String name, String course, double balance) {
    this.name = name;
    this.course = course;
    this.balance = balance;
  }

  // Getters and Setters
  public int getId() { return id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getCourse() { return course; }
  public void setCourse(String course) { this.course = course; }
  public double getBalance() { return balance; }
  public void setBalance(double balance) { this.balance = balance; }
}
