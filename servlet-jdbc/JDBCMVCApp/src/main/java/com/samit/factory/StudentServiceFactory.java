package com.samit.factory;

import com.samit.service.IStudentService;
import com.samit.service.StudentServiceImpl;

public class StudentServiceFactory {

	private static IStudentService studentServiceImpl;

	private StudentServiceFactory() {
		// TODO Auto-generated constructor stub
	}

	public static IStudentService getStudentService() {
		if (studentServiceImpl == null)
			studentServiceImpl = new StudentServiceImpl();

		return studentServiceImpl;
	}
}