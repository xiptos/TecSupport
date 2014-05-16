package pt.ipb.ts.entity;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Poi
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = Poi.ALL, query = "Select b From Poi b") })
public class Poi implements Serializable {
	public static final String ALL = "pt.ipb.ts.entity.Poi.ALL";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private double latitude;
	private double longitude;
	private String title;
	private String descr;
	boolean visited;
	private static final long serialVersionUID = 1L;

	public Poi() {
		super();
	}

	public Poi(String title, double latitude, double longitude, String descr) {
		this.title = title;
		this.latitude = latitude;
		this.longitude = longitude;
		this.descr = descr;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Poi) {
			Poi other = (Poi) obj;
			return other.getId()==getId();
		}
		return false;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Override
	public String toString() {
		return getTitle()+" ("+getLatitude()+","+getLongitude()+") - "+getDescr();
	}
}
