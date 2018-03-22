package com.mohamed265.weatherchecker.dao.daoImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mohamed265.weatherchecker.dao.DefaultDao;
import com.mohamed265.weatherchecker.entity.Default;
import com.mohamed265.weatherchecker.exceptions.EntityMergeException;

/**
 * 
 * @author mohamed265
 *
 */
@Repository("DefaultDao")
public class DefaultDaoImpl implements DefaultDao {

	final private static Logger logger = Logger.getLogger(DefaultDaoImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void save(Default theDefault) throws EntityMergeException{
		try{
		em.merge(theDefault);
		}catch(Exception e){
			throw new EntityMergeException("Save Default Exception: "+e.getMessage());
		}
	}

	@Override
	public Default getAllDefaultByValue(int value) {
		Query query = em.createNamedQuery("Default.getDefault", Default.class);
		query.setParameter("v", value);
		query.setParameter("v1", value);
		try {
			return (Default) query.getSingleResult();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public List<Default> getAllDefaults() {
		Query query = em.createNamedQuery("Default.getAllDefaults", Default.class);
		try {
			return query.getResultList();
		} catch (Exception e) {
			logger.error(e);
			return Collections.emptyList();
		}
	}
}