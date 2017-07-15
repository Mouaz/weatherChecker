package com.mohamed265.weatherchecker.entity;

import java.util.Date;

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
@Table(name = "weather_day")
@NamedQueries({
		@NamedQuery(name = "WeatherDay.getByDate", query = "SELECT e FROM WeatherDay e WHERE e.date = :cdate") })
public class WeatherDay {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "date")
	private Date date;

	@Column(name = "source")
	private String source;

	@Column(name = "value")
	private Integer value;

	@Column(name = "min_value")
	private Integer minValue;

	@Column(name = "max_value")
	private Integer maxValue;

	@Column(name = "description")
	private String description;

	public WeatherDay() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Integer getMinValue() {
		return minValue;
	}

	public void setMinValue(Integer minValue) {
		this.minValue = minValue;
	}

	public Integer getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WeatherDay [id=" + id + ", date=" + date + ", source=" + source + ", value=" + value + ", minValue="
				+ minValue + ", maxValue=" + maxValue + ", description=" + description + "]";
	}

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

}
