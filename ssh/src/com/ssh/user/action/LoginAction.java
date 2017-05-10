package com.ssh.user.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.user.model.User;
import com.ssh.user.service.UserService;

/**     
 * 类名称：LoginAction   
 * 类描述：用户控制器的实现
 * 创建人：anan   
 * 创建时间：2012-12-21 下午11:17:36   
 * 修改人：anan  
 * 修改时间：2012-12-21 下午11:17:36   
 * 修改备注：   
 * @version        
 * */
@Action(value = "loginAction", results = {
		@Result(name = "loginSuccess", location = "/loginSuss.jsp"),
		@Result(name = "loginFailer", location = "/loginFailer.jsp") })
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -2266695172069461659L;
	
	private Logger log = Logger.getLogger(com.ssh.user.action.LoginAction.class);
	
	@Autowired
	private UserService userService;
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String login(){
		log.debug("start to login...");
		boolean flag = userService.isExitByNameAndPass(user);
		if(flag){
			log.info("suss");
			return "loginSuccess";
		}
		log.info("fail");
		return "loginFailer";
	}
}
