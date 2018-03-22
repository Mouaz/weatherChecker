package com.mohamed265.weatherchecker.dao;

import java.util.List;

import com.mohamed265.weatherchecker.entity.Default;
import com.mohamed265.weatherchecker.exceptions.EntityMergeException;

public interface DefaultDao {

	public void save(Default theDefault) throws EntityMergeException;

	public Default getAllDefaultByValue(int value);

	public List<Default> getAllDefaults();

}
