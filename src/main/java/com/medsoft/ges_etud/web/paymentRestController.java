package com.medsoft.ges_etud.web;

import com.medsoft.ges_etud.entities.Payment;
import com.medsoft.ges_etud.entities.Student;
import com.medsoft.ges_etud.enums.PaymentStatus;
import com.medsoft.ges_etud.enums.PaymentType;
import com.medsoft.ges_etud.repository.PaymentRepository;
import com.medsoft.ges_etud.repository.StudentRepository;
import com.medsoft.ges_etud.services.PaymentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@RestController
public class paymentRestController {

    private StudentRepository studentRepository ;
    private PaymentRepository paymentRepository ;

    private PaymentService paymentService ;


    public paymentRestController(StudentRepository studentRepository, PaymentRepository paymentRepository)
    {
        this.studentRepository = studentRepository ;
        this.paymentRepository = paymentRepository ;

    }
    @GetMapping("payments")
    public List<Payment> getAllPayments()
    {
        return paymentRepository.findAll();
    }
    @GetMapping("students/{code}/payments")
    public List<Payment> getPaymentsByStudentCode(@PathVariable String code)
    {
        return paymentRepository.findByStudentCode(code);
    }
    @GetMapping("/paymentsByStatus")
    public List<Payment> getPaymentsByStatus(@RequestParam PaymentStatus status)
    {
        return paymentRepository.findByStatus (status);
    }

    @GetMapping("/paymentsByType")
    public List<Payment> getPaymentsByType(@RequestParam PaymentType type)
    {
        return paymentRepository.findByType(type);
    }

    @GetMapping("/payments/{id}")
    public  Payment getPaymentById(@PathVariable  Long id )
    {
        return paymentRepository.findById(id).get();
    }

    @PutMapping("payment/update/status")
    public  Payment updatePaymentStatus (@RequestParam PaymentStatus status , @PathVariable Long id )
    {
       return this.paymentService.updatePaymentStatus(status,id);
    }

    @PostMapping(path = "/payments/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Payment savePayment (@RequestParam MultipartFile file,LocalDate date, double amount , String studentCode ) throws IOException {

       return  this.paymentService.savePayment(file, date, amount, studentCode);
    }

    @GetMapping(value = "paymentFile/{paymentId}", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte []  getPaymentFile (@PathVariable  Long paymentId) throws IOException {
        return  this.paymentService.getPaymentFile(paymentId);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents ()
    {
        return studentRepository.findAll();
    }
    @GetMapping("/student/{code}")
    public Student getStudentByCode (@PathVariable String code)
    {
        return studentRepository.findByCode(code);
    }

    @GetMapping("/studentByprogramId")
    public List<Student> findByProgramId(@RequestParam String programId)
    {
        return studentRepository.findByProgramId(programId);
    }


}
