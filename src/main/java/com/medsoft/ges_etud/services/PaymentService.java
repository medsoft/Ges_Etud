package com.medsoft.ges_etud.services;

import com.medsoft.ges_etud.entities.Payment;
import com.medsoft.ges_etud.entities.Student;
import com.medsoft.ges_etud.enums.PaymentStatus;
import com.medsoft.ges_etud.repository.PaymentRepository;
import com.medsoft.ges_etud.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

@Service
@Transactional
public class PaymentService {

    private PaymentRepository paymentRepository ;
    private StudentRepository studentRepository ;

    public PaymentService(PaymentRepository paymentRepository, StudentRepository studentRepository) {
        this.paymentRepository = paymentRepository ;
        this.studentRepository = studentRepository ;
    }

    public  Payment updatePaymentStatus ( PaymentStatus status , Long id )
    {
        Payment payment =  paymentRepository.findById(id).get() ;
        payment.setStatus(status);
        return paymentRepository.save(payment) ;
    }

    public Payment savePayment ( MultipartFile file, LocalDate date, double amount , String studentCode ) throws IOException {
        Path folderPath = Paths.get(System.getProperty("user.home"),"ges","payments");
        if(!Files.exists(folderPath)) {
            Files.createDirectories(folderPath) ;
        }
        String fileName = UUID.randomUUID().toString();
        Path filepath = Paths.get(System.getProperty("user.home"),"ges","payments",fileName+".pdf");
        Files.copy(file.getInputStream(), filepath) ;
        Student student = studentRepository.findByCode(studentCode) ;
        Payment payment = Payment.builder()
                .date(date)
                .student(student)
                .amount(amount)
                .file(filepath.toUri().toString())
                .build() ;
        return paymentRepository.save(payment) ;
    }

    public byte []  getPaymentFile (Long paymentId) throws IOException {
        Payment payment = paymentRepository.findById(paymentId).get();
        return  Files.readAllBytes(Path.of(URI.create(payment.getFile()))) ;
    }
}
