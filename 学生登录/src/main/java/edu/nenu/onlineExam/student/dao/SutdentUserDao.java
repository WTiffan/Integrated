package edu.nenu.onlineExam.student.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import edu.nenu.onlineExam.studentuser.entityStudentUser;


public class StudentUserDao extends HibernateDaoSupport{
	
//	学生登录验证
	public StudentUser login(StudentUser student) {
		String hql = "from StudentUser where uid = ? and password = ?";
		List<StudentUser> list = (List<SutdentUser>) this.getHibernateTemplate().find(hql, student.getUid(),student.getPassword());
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	public void updatePW(Integer uid, String npw) {
		String hql = "from StudentUser where uid =? ";
		StudentUser sutdent = null;
		List<StudentUser> list = (List<StudentUser>) this.getHibernateTemplate().find(hql, uid);
		if(list != null && list.size()>0){
			student = (StudentUser)list.get(0);
		}
		student.setPassword(npw);
		this.getHibernateTemplate().save(student);
	}
}
