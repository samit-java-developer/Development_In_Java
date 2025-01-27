package com.samit.factory;

import com.samit.dao.IStudentDao;
import com.samit.dao.StudentDaoImpl;

public class StudentDaoFactory {

	private static IStudentDao studentDao = null;

	private StudentDaoFactory() {
	}

	public static  IStudentDao getStudentDao() {
		if (studentDao == null)
			studentDao = new StudentDaoImpl();

		return studentDao;
	}
}
