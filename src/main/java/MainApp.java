package com.project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;

public class MainApp {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    StudentService service = ctx.getBean(StudentService.class);
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("\n1. Add Student\n2. View All\n3. Delete\n4. Exit");
      int ch = sc.nextInt(); sc.nextLine();
      switch (ch) {
        case 1 -> {
          System.out.print("Enter name: ");
          String name = sc.nextLine();
          System.out.print("Enter course: ");
          String course = sc.nextLine();
          System.out.print("Enter balance: ");
          double balance = sc.nextDouble();
          service.addStudent(name, course, balance);
          System.out.println("Student added!");
        }
        case 2 -> {
          service.listStudents().forEach(s ->
            System.out.println(s.getId() + " | " + s.getName() + " | " + s.getCourse() + " | " + s.getBalance()));
        }
        case 3 -> {
          System.out.print("Enter ID to delete: ");
          int id = sc.nextInt();
          service.removeStudent(id);
          System.out.println("Deleted!");
        }
        case 4 -> {
          ctx.close();
          System.exit(0);
        }
        default -> System.out.println("Invalid choice!");
      }
    }
  }
}
