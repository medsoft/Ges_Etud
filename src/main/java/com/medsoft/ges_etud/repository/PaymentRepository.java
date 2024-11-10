package com.medsoft.ges_etud.repository;

import com.medsoft.ges_etud.entities.Payment;
import com.medsoft.ges_etud.enums.PaymentStatus;
import com.medsoft.ges_etud.enums.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long > {

    public List <Payment> findByStudentCode(String studentCode);
    public List <Payment> findByStatus (PaymentStatus status) ;
    public List <Payment> findByType (PaymentType type);

}
