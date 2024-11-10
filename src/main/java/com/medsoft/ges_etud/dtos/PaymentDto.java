package com.medsoft.ges_etud.dtos;

import com.medsoft.ges_etud.entities.Student;
import com.medsoft.ges_etud.enums.PaymentStatus;
import com.medsoft.ges_etud.enums.PaymentType;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.MySQLEnumJdbcType;

import java.time.LocalDate;

public class PaymentDto {

    // Au lieu de retourner les entites directement on va retourner uniquement ce dont on a besoin

    public class Payment {

        private Long id;
        private LocalDate date ;
        private double amount;
        private PaymentType type ;
        private PaymentStatus status;
    }

}
