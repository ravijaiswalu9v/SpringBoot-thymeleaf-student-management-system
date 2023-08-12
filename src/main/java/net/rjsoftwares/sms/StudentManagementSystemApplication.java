package net.rjsoftwares.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.rjsoftwares.sms.entities.Student;
import net.rjsoftwares.sms.repositories.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	// this is only for testing purpose
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
//		Student s1 = new Student( 12,"Ravi","jaiswal", "ravijaiswalu9v@gmail.com");
//		Student s2 = new Student( 24,"Neha","jaiswal", "nehajaiswalu9v@gmail.com");
//		Student s3 = new Student( 36,"Nisha","jaiswal", "nishajaiswalu9v@gmail.com");
//		
//		studentRepository.save(s1);
//		studentRepository.save(s2);
//		studentRepository.save(s3);
	}

}
