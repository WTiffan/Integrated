package edu.nenu.onlineExam.studentuser.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StudentUserService {
	
	private edu.nenu.onlineExam.studentuser.dao.StudentUserDao studentUserDao;

	public void setAdminUserDao(edu.nenu.onlineExam.studentuser.dao.StudentUserDao studentUserDao) {
		this.studentUserDao = studentUserDao;
	}
	
	//����Ա��¼��֤
	public edu.nenu.onlineExam.studentuser.entity.StudentUser login(edu.nenu.onlineExam.studentuser.entity.StudentUser student) {
		return studentUserDao.login(student);
	}

	public void updatePW(Integer uid, String npw) {
		studentUserDao.updatePW(uid,npw);
	}

}
