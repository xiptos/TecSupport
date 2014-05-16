package pt.ipb.ts.jsf;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pt.ipb.ts.ejb.Pois;
import pt.ipb.ts.entity.Poi;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class PoiBean implements Serializable {

	@Inject Pois pois;
	double latitude;
	double longitude;
	String title;
	String descr;
	
	Poi editingPoi;
	
	boolean formVisible = false;
	
	public void setFormVisible(boolean formVisible) {
		this.formVisible = formVisible;
	}
	
	public boolean isFormVisible() {
		return formVisible;
	}

	public String toggleFormVisible() {
		this.formVisible = !this.formVisible;
		return null;
	}


	public List<Poi> getPois() {
		List<Poi> poiList = pois.getPois();
		return poiList;
	}

	public void edit(Poi poi) {
		setEditingPoi(poi);
	}

	public Poi getEditingPoi() {
		return editingPoi;
	}
	
	public void setEditingPoi(Poi editingPoi) {
		this.editingPoi = editingPoi;
	}
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String create() {
		pois.create(getTitle(), getLatitude(), getLongitude(), getDescr());
		return null;
	}
	
	public String cancel() {
		setEditingPoi(null);
		return null;
	}
	
	public String remove(Poi poi) {
		pois.delete(poi);
		return null;
	}
	
	public String save() {
		pois.update(getEditingPoi());
		setEditingPoi(null);
		return null;
	}
}
