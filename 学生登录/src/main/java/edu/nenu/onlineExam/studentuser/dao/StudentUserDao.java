package edu.nenu.onlineExam.studentuser.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;


public class StudentUserDao extends HibernateDaoSupport{
	
	//����Ա��¼��֤
	public edu.nenu.onlineExam.studentuser.entity.StudentUser login(edu.nenu.onlineExam.studentuser.entity.StudentUser student) {
		String hql = "from StudentUser where uid = ? and password = ?";
		List<edu.nenu.onlineExam.studentuser.entity.StudentUser> list = (List<edu.nenu.onlineExam.studentuser.entity.StudentUser>) this.getHibernateTemplate().find(hql, student.getUid(),student.getPassword());
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	public void updatePW(Integer uid, String npw) {
		String hql = "from StudentUser where uid =? ";
		edu.nenu.onlineExam.studentuser.entity.StudentUser admin = null;
		List<edu.nenu.onlineExam.studentuser.entity.StudentUser> list = (List<edu.nenu.onlineExam.studentuser.entity.StudentUser>) this.getHibernateTemplate().find(hql, uid);
		if(list != null && list.size()>0){
			admin = (edu.nenu.onlineExam.studentuser.entity.StudentUser)list.get(0);
		}
		admin.setPassword(npw);
		this.getHibernateTemplate().save(admin);
	}
}
