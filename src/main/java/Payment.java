package com.example.osms.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="payments")
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer paymentId;

  @ManyToOne
  @JoinColumn(name="student_id", nullable=false)
  private Student student;

  @Column(nullable=false, precision=10, scale=2)
  private BigDecimal amount;

  @Column(name="payment_date")
  private LocalDateTime paymentDate;

  // constructors, getters, setters, prePersist to set paymentDate
}
