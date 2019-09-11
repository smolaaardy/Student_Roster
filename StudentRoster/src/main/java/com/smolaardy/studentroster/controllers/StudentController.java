package com.smolaardy.studentroster.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smolaardy.studentroster.entities.ContactInfo;
import com.smolaardy.studentroster.entities.Student;
import com.smolaardy.studentroster.services.ContactInfoService;
import com.smolaardy.studentroster.services.StudentService;

@Controller
public class StudentController {
	
	private final StudentService studentService;
	private final ContactInfoService contactInfoService; 

	public StudentController(StudentService studentService , ContactInfoService contactInfoService) {
		this.studentService = studentService;
		this.contactInfoService = contactInfoService;
	}
	
	@RequestMapping("/students")
	public String allStudent(Model model) {
		model.addAttribute("students", studentService.findAllStudents());
		return "view/allStudents.jsp";
	}
	
	@RequestMapping("/student/new")
	public String newStudent(@ModelAttribute("student") Student student) {
		return "view/StudentForm.jsp";
	}
	
	@PostMapping("/student/new")
	public String addStudent(@Valid @ModelAttribute("student") Student student , BindingResult bindingResult , RedirectAttributes errorRedirect) {
		if(bindingResult.hasErrors()) {
			errorRedirect.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "view/StudentForm.jsp";
		}else {
			studentService.saveStudent(student);
			return "redirect:/students";
		}
	}
	
	@RequestMapping("/student/contact")
	public String newContact(@ModelAttribute("contact") ContactInfo contactInfo , Model model) {
		model.addAttribute("students", studentService.findStudentsWithoutContactInfo());
		return "view/ContactForm.jsp";
	}
	
	@PostMapping("/student/contact")
	public String addContact(@Valid @ModelAttribute("contact") ContactInfo contactInfo , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "redirect:/students";
		}else {
			contactInfoService.saveContactInfo(contactInfo);
			return "redirect:/students";
		}
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
}