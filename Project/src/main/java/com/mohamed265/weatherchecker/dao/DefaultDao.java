package com.mohamed265.weatherchecker.dao;

import java.util.List;

import com.mohamed265.weatherchecker.entity.Default;

public interface DefaultDao {

	public void save(Default Default) throws Exception;

	public Default getAllDefaultByValue(int value);

	public List<Default> getAllDefaults();

}
