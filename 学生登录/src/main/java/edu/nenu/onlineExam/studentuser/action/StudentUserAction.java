package edu.nenu.onlineExam.studentuser.action;

import java.util.Map;

import edu.nenu.onlineExam.studentuser.service.StudentUserService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import edu.nenu.onlineExam.studentuser.entity.StudentUser;
//import edu.nenu.onlineExam.studnetuser.service.StudentUserService;
 

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentUserAction extends ActionSupport implements ModelDriven<StudentUser> ,SessionAware{
	private StudentUser student = new StudentUser();
	private StudentUserService studentUserService;
	
	public void setAdminUserService(StudentUserService studentUserService) {
		this.studentUserService = studentUserService;
	}

	public StudentUser getModel() {
		return student;
	}
	
	private String npw;
	public void setNpw(String npw) {
		this.npw = npw;
	}

	//����Ա��¼
	public String alogin(){
		return "alogin";
	}
	
	//��֤����Ա��ź������Ƿ���ȷ
	public String login(){
		//���մ����ݿ��в�ѯ����Ϣ
		StudentUser existStudent = studentUserService.login(student);
		//�ж��û��Ƿ����
		if(existStudent == null){
			this.addActionError("该用户不存在！");
			return "loginFailstudent";
		}else{
			//����û����ڣ����û���Ϣ�浽session��
			ServletActionContext.getRequest().getSession().setAttribute("existStudent", existStudent);
			return "loginSuccessstudent";
		}		
	}
	//�鿴����Ա��Ϣ
	public String ckxx(){
		return "ckxxstudent";
	}
	//�޸�����
	public String upw(){
		return "upwstudent";
	}
	public String updatePW(){
		studentUserService.updatePW(student.getUid(),npw);
		return "updateadminPW";
	}
	//��ȫ�˳����session
	public String sessionDestory(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "sessionDestorystudent";
	}

	public void setSession(Map<String, Object> arg0) {
	}
}
