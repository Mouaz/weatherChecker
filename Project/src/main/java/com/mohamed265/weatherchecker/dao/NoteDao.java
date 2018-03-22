package com.mohamed265.weatherchecker.dao;

import java.util.Date;
import java.util.List;

import com.mohamed265.weatherchecker.entity.Note;
import com.mohamed265.weatherchecker.exceptions.EntityMergeException;

public interface NoteDao {

	public void save(Note note) throws EntityMergeException;

	public List<Note> getAllNoteByDate(Date date);

	public List<Note> getAllNotesByUser(int id);

}
