package com.mohamed265.weatherchecker.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mohamed265.weatherchecker.dao.DefaultDao;
import com.mohamed265.weatherchecker.dao.NoteDao;
import com.mohamed265.weatherchecker.entity.Default;
import com.mohamed265.weatherchecker.entity.Note;
import com.mohamed265.weatherchecker.entity.User;
import com.mohamed265.weatherchecker.service.NoteService;
import com.mohamed265.weatherchecker.util.DateFactory;

@Service("NoteService")
public class NoteServiceImpl implements NoteService {

	private final static Logger logger = Logger.getLogger(NoteServiceImpl.class);

	@Autowired
	private NoteDao noteDao;

	@Autowired
	private DefaultDao defaultDao;

	@Override
	public boolean save(Note note) {

		try {
			noteDao.save(note);
			return true;
		} catch (Exception e) {
			logger.error(e);
		}
		return false;
	}

	@Override
	public List<Note> getCurrentNotes(int value) {
		List<Note> notes = noteDao.getAllNoteByDate(DateFactory.getDate());
		if (notes != null && notes.size() != 0)
			return notes;
		else {
			notes = new ArrayList<>();

			Default default1 = defaultDao.getAllDefaultByValue(value);
			if (default1 != null) {
				Note note = new Note();
				note.setText(default1.getText());
				note.setDate(DateFactory.getDate());
				notes.add(note);
			}
			return notes;
		}
	}

	@Override
	public boolean save(Default default1) {
		try {
			defaultDao.save(default1);
			return true;
		} catch (Exception e) {
			logger.error(e);
		}
		return false;
	}

	@Override
	public List<Note> getAllNotesByUser(User user) {
		return noteDao.getAllNotesByUser(user.getId());
	}

	@Override
	public List<Default> getAllDefault() {
		return defaultDao.getAllDefaults();
	}

	@Transactional
	@Override
	public boolean saveDefaultsBatch(List<Default> defaults) {
		try {
			for (Default default1 : defaults) {
				save(default1);
			}
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

}
