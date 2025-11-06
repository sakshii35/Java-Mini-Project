package com.project;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private String courseName;

  public Course() {}
  public Course(String courseName) { this.courseName = courseName; }

  public int getId() { return id; }
  public String getCourseName() { return courseName; }
  public void setCourseName(String courseName) { this.courseName = courseName; }
}
