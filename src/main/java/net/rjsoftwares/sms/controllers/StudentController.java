package net.rjsoftwares.sms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.rjsoftwares.sms.entities.Student;
import net.rjsoftwares.sms.services.StudentService;

@Controller
public class StudentController {
	// if we have only one field then we can avoid using @Autowired annotation
	// @Autowired
	private StudentService studentService;

	// if we are not using @Autowired annotation we must create a constructor with
	// service arguments(studentService)
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

//	handler method to handle list of students and return model and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";// return the view eg: students.html --> here spring boot creates the view
							// resolver and configure it, we don't need to this view resolver things
							// manually
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		// create student object to hold student data
		Student student = new Student();

		model.addAttribute("student", student);
		return "create_student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {// to store the java form data we have used
																			// @ModelAttribute of student
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	// this is done by my self to handle update button click
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String editSudent(@PathVariable long id, @ModelAttribute("student") Student student, Model model) {// to

		// get student from database by id
		Student existingStudent = studentService.getStudentById(id);
//		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());

		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";

	}

	// handler method to handle delete student request
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}

}
