package net.rjsoftwares.sms.services;

import java.util.List;

import net.rjsoftwares.sms.entities.Student;

public interface StudentService {
	List<Student> getAllStudents();

	Student saveStudent(Student student);

//	Student editByStudent(long id, Student student);
	Student updateStudent(Student student);
	
	Student getStudentById(long id);

	void deleteStudentById(long id);
}
