package com.medsoft.ges_etud.entities;

import com.medsoft.ges_etud.enums.PaymentStatus;
import com.medsoft.ges_etud.enums.PaymentType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.dialect.MySQLEnumJdbcType;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString @Builder
@Table(name="payment")
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date ;
    private double amount;
    @Enumerated(EnumType.STRING)
    @JdbcType(MySQLEnumJdbcType.class)
    @Column(name = "type")
    private PaymentType type ;
    @Enumerated(EnumType.STRING)
    @JdbcType(MySQLEnumJdbcType.class)
    @Column(name = "status")
    private PaymentStatus status;
    private String file  ;
    @ManyToOne
    private Student student;
}
