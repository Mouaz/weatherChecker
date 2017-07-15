package com.mohamed265.weatherchecker.service;

import java.util.List;

import com.mohamed265.weatherchecker.entity.Default;
import com.mohamed265.weatherchecker.entity.Note;
import com.mohamed265.weatherchecker.entity.User;

public interface NoteService {

	public boolean save(Note note);

	public List<Note> getCurrentNotes(int value);

	public boolean save(Default default1);

	public List<Note> getAllNotesByUser(User user);

	public List<Default> getAllDefault();

	public boolean saveDefaultsBatch(List<Default> defaults);

}