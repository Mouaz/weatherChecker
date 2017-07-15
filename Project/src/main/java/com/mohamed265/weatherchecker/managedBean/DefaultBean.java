
package com.mohamed265.weatherchecker.managedBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mohamed265.weatherchecker.entity.Default;
import com.mohamed265.weatherchecker.service.NoteService;
import com.mohamed265.weatherchecker.util.jsf.annotation.SpringViewScoped;

@ManagedBean(name = "defaultBean")
@SpringViewScoped
@Controller
public class DefaultBean extends BaseBean {

	@Autowired
	private NoteService noteService;

	private List<Default> defaults;

	@PostConstruct
	public void inti() {
		defaults = noteService.getAllDefault();
	}

	public String save() {
		if (noteService.saveDefaultsBatch(defaults)) {
			addInfoMessage("Updating done succesffully");
		} else {
			addInfoMessage("Updating faild");
		}
		return "";
	}

	public List<Default> getDefaults() {
		return defaults;
	}

}