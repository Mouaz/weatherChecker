
package com.mohamed265.weatherchecker.managedBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Controller;

import com.mohamed265.weatherchecker.util.jsf.annotation.SpringRequestScoped;

@ManagedBean(name = "logoutBean")
@SpringRequestScoped
@Controller
public class LogoutBean extends BaseBean {

	@PostConstruct
	public void inti() {
		//initializing the bean
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		redirectToIndexPage();
		return "index.xhtml?faces-redirect=true";
	}

}