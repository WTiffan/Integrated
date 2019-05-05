package edu.nenu.onlineExam.student.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import edu.nenu.onlineExam.studentuser.entity.StudentUser;
import edu.nenu.onlineExam.studentuser.service.StudentUserService;
 

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentUserAction extends ActionSupport implements ModelDriven<StudentUser> ,SessionAware{
	private StudentUser student = new StudentUser();
	private StudentUserService studnetUserService;
	
	public void setStudentUserService(StudentUserService studentUserService) {
		this.studentUserService = studentUserService;
	}

	public StudentUser getModel() {
		return student;
	}
	
	private String npw;
	public void setNpw(String npw) {
		this.npw = npw;
	}

	public String alogin(){
		return "alogin";
	}
	
	public String login(){
		StudentUser existStudent = studentUserService.login(student);
		if(existStudent == null){
			this.addActionError("该用户未注册！");
			return "loginFailadmin";
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("existSutdent", existSutdent);
			return "loginSuccessstudent";	
		}		
	}
	public String ckxx(){
		return "ckxxsutdent";
	}
	public String upw(){
		return "upwsutdent";
	}
	public String updatePW(){
		studentUserService.updatePW(student.getUid(),npw);
		return "updatestudentPW";
	}
	public String sessionDestory(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "sessionDestorystudent";
	}

	public void setSession(Map<String, Object> arg0) {
	}
}
