package net.rjsoftwares.sms.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.rjsoftwares.sms.entities.Student;
import net.rjsoftwares.sms.repositories.StudentRepository;
import net.rjsoftwares.sms.services.StudentService;

@Service			// to show this class is a service layer for auto detection by spring Boot
public class StudentServiceImpl implements StudentService{
					//if we have only one field in spring bean, then we can avoid using @Autowired annotation
	//@Autowired
	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	//get all students
	@Override
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	//this part is done by me
//	@Override
//	public Student editByStudent(long id, Student student) {
//		Student  s= studentRepository.findById(id).get();
//		s.setFirstName(student.getFirstName());
//		s.setLastName(student.getLastName());
//		s.setEmail(student.getEmail());
//		return studentRepository.save(s);
//	}
	
	@Override
	public Student getStudentById(long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(long id) {
		studentRepository.deleteById(id);
	}
	
}
