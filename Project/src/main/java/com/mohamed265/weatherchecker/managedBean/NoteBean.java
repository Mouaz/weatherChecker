
package com.mohamed265.weatherchecker.managedBean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mohamed265.weatherchecker.entity.Note;
import com.mohamed265.weatherchecker.service.NoteService;
import com.mohamed265.weatherchecker.util.DateFactory;
import com.mohamed265.weatherchecker.util.jsf.annotation.SpringViewScoped;

@ManagedBean(name = "noteBean")
@SpringViewScoped
@Controller
public class NoteBean extends BaseBean {
	
	@Autowired
	private NoteService noteService;

	private List<Note> notes;

	private Note note;

	@PostConstruct
	public void inti() {

		notes = noteService.getAllNotesByUser(getSessionUser());
		note = new Note();
	}

	public String addNote() {
		note.setUser(getSessionUser());
		note.setDate(DateFactory.getDate());
		if (noteService.save(note)) {
			addInfoMessage("Note Added Successfully");
			notes.add(note);
		} else {
			addErrorMessage("Adding Faild");
		}
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("notes.xhtml");
		} catch (IOException e) {
			logger.error(e); 
		}
		return "";
	}

	public List<Note> getNotes() {
		return notes;
	}

	public Note getNote() {
		return note;
	}

}