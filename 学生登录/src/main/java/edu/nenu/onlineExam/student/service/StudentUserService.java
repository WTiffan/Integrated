package edu.nenu.onlineExam.StudentUser.service;

import org.springframework.transaction.annotation.Transactional;

import edu.nenu.onlineExam.student.dao.StudentUserDao;
import edu.nenu.onlineExam.studentuser.entity.StudentUser;

public class StudentUserService {
	
	private StudentUserDao studentUserDao;

	public void setStudentUserDao(StudentUserDao studentUserDao) {
		this.studentUserDao = studentUserDao;
	}
	
	public StudentUser login(StudentUser student) {
		return studentUserDao.login(student);
	}

	public void updatePW(Integer uid, String npw) {
		studentUserDao.updatePW(uid,npw);
	}

}
