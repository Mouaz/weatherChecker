package com.mohamed265.weatherchecker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author mohamed265
 *
 */
@Entity
@Table(name = "default_table")
@NamedQueries({
		@NamedQuery(name = "Default.getDefault", query = "SELECT e FROM Default e WHERE e.minValue < :v AND :v1 <= e.maxValue"),
		@NamedQuery(name = "Default.getAllDefaults", query = "SELECT e FROM Default e ") })
public class Default {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "max_value")
	private Integer maxValue;

	@Column(name = "min_value")
	private Integer minValue;

	@Column(name = "text")
	private String text;

	public Default() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the maxValue
	 */
	public Integer getMaxValue() {
		return maxValue;
	}

	/**
	 * @param maxValue
	 *            the maxValue to set
	 */
	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}

	/**
	 * @return the minValue
	 */
	public Integer getMinValue() {
		return minValue;
	}

	/**
	 * @param minValue
	 *            the minValue to set
	 */
	public void setMinValue(Integer minValue) {
		this.minValue = minValue;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

}
