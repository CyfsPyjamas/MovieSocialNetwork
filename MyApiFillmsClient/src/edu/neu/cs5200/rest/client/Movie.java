package edu.neu.cs5200.rest.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Movie {
	private String idIMDB;
	private String plot;
	private String poster;
	private String title;
	public String getIdIMDB() {
		return idIMDB;
	}
	public void setIdIMDB(String idIMDB) {
		this.idIMDB = idIMDB;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
