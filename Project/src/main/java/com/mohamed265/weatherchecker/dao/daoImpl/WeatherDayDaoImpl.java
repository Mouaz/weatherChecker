package com.mohamed265.weatherchecker.dao.daoImpl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mohamed265.weatherchecker.dao.WeatherDayDao;
import com.mohamed265.weatherchecker.entity.WeatherDay;
import com.mohamed265.weatherchecker.exceptions.EntityMergeException;

/**
 * 
 * @author mohamed265
 *
 */
@Repository("WeatherDayDao")
public class WeatherDayDaoImpl implements WeatherDayDao {

	final private static Logger logger = Logger.getLogger(WeatherDayDaoImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void save(WeatherDay weatherDay) throws EntityMergeException {
		try{
		em.persist(weatherDay);
		}catch(Exception e){
			throw new EntityMergeException("Merge weather day exception: "+e.getMessage());
		}
	}

	@Override
	public WeatherDay getWeatherDayByDate(Date date) {
		Query query = em.createNamedQuery("WeatherDay.getByDate", WeatherDay.class);
		query.setParameter("cdate", date);
		try {
			return (WeatherDay) query.getSingleResult();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
}