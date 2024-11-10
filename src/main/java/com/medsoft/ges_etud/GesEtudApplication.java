package com.medsoft.ges_etud;

import com.medsoft.ges_etud.entities.Payment;
import com.medsoft.ges_etud.entities.Student;
import com.medsoft.ges_etud.enums.PaymentType;
import com.medsoft.ges_etud.repository.PaymentRepository;
import com.medsoft.ges_etud.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class GesEtudApplication {

    public static void main(String[] args) {
        SpringApplication.run(GesEtudApplication.class, args);
    }
    /*

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository studentRepository, PaymentRepository paymentRepository){
        return args -> {
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstname("Abdou")
                    .lastname("Ndiaye").code("111278").programId("GLRS").build()) ;

            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstname("Fatima")
                    .lastname("Sarr").code("331278").programId("GLRS").build()) ;

            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstname("Hamidou")
                    .lastname("Wane").code("221678").programId("GLRS").build()) ;

            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstname("Khadija")
                    .lastname("Ndiaye Deme").code("221908").programId("GLRS").build()) ;

            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstname("Ousmane")
                    .lastname("Diop").code("227878").programId("GLRS").build()) ;

            Random random  =  new Random();
            PaymentType [] paymentType =  PaymentType.values() ;
            studentRepository.findAll().forEach(st->{

                for(int i =0 ;  i < 10 ; i ++)
                {
                    int index = random.nextInt(paymentType.length);
                    Payment payment = Payment.builder()
                            .amount(1000+(int)(Math.random()+20000))
                            .type(paymentType[index])
                            .date(LocalDate.now())
                            .student(st)

                            .build();
                    paymentRepository.save(payment) ;
                }
            });
        };
    }

     */



}
