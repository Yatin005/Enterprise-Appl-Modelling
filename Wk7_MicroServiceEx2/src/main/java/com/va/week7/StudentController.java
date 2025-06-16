package com.va.week7;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public Student create() {

		Student s1 = new Student();

		Student.Address address = new Student.Address("Decker Street", "97", "Creditview");
		s1.setStudentID("1");
		s1.setFname("Yatin");
		s1.setLname("Parulkar");
		s1.setPhone("437-578-3995");
		s1.setDob(new Date());
		s1.setAddress(address);
		return s1;

	}

}
