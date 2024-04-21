package com.example.demo;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DevSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevSpringProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner-> {
			//createStudent(studentDAO);
			//createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//readAllStudent(studentDAO);
			//readStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO){
		int studentId = 3;
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//get student
		int studentId = 3;
		Student student = studentDAO.findById(studentId);
		System.out.println("Found student: "+student);
		//update the student
		student.setFirstName("Alen");
		student.setLastName("Walker");
		studentDAO.update(student);
		//display the updated student
		System.out.println("Updated student: "+studentDAO.findById(studentId));
	}

	private void readStudentByLastName(StudentDAO studentDAO) {
		List<Student> list = studentDAO.findStudentByLastName("Gowda");
		list.forEach(System.out::println);
	}

	private void readAllStudent(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAllStudents();
		studentList.forEach(System.out::println);
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a new student
		Student student=new Student();
		student.setFirstName("Alex");
		student.setLastName("Tailor");
		student.setAge(22);
		student.setEmail("alex@gamil.com");
		//save the student
		studentDAO.save(student);
		//display the id of the student
		System.out.println("Student id: "+student.getId());
		//retrive the id from DB
		Student retrivedStudent = studentDAO.findById(student.getId());
		//display the student
		System.out.println("Retrived student: "+retrivedStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		Student student1=createNewStudent("Student3", "stu", 10, "student3@gmail.com");
		Student student2=createNewStudent("Student4", "stu", 15, "student4@gmail.com");

		studentDAO.save(student1);
		studentDAO.save(student2);
		System.out.println("Student id is: "+student1.getId());
		System.out.println("Student id is: "+student2.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
		//create new student
		Student tempStudent = new Student();
		tempStudent.setFirstName("Nithesh");
		tempStudent.setLastName("Gowda");
		tempStudent.setAge(20);
		tempStudent.setEmail("nithesh123@gmail.com");
		//Save the student
		studentDAO.save(tempStudent);
		//print the id
		System.out.println("Student id is: "+tempStudent.getId());
	}

	private Student createNewStudent(String firstName, String lastName, int age, String email){
		Student tempStudent = new Student();
		tempStudent.setFirstName(firstName);
		tempStudent.setLastName(lastName);
		tempStudent.setAge(age);
		tempStudent.setEmail(email);
		return tempStudent;
	}

}
