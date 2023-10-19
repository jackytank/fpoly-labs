package com.demo.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.domain.Student;
import com.demo.utils.CookiesUtil;

@Controller
@RequestMapping("student")
public class StudentController {
	@Autowired
	HttpServletRequest req;

	@Autowired
	HttpServletResponse resp;

	@GetMapping("create")
	public String create() {
		String id = CookiesUtil.get("id", req);
		req.setAttribute("cookies", id);
		return "createStudent";
	}

	@PostMapping("create")
	public String createPost() {
		Student student = new Student();
		try {
			BeanUtils.populate(student, req.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// add cookie
		if (student.isRemember()) {
			CookiesUtil.add("id", student.getStudentId(), 2, resp);
		}

		req.setAttribute("student", student);

		return "detailStudent";
	}
}
