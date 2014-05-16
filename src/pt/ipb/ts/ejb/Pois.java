package pt.ipb.ts.ejb;

import java.util.List;

import javax.ejb.Local;

import pt.ipb.ts.entity.Poi;

@Local
public interface Pois {

	Poi create(String title, double latitude, double longitude, String descr);

	Poi create(String title, String latitude, String longitude, String address);

	void delete(Poi poi);

	void delete(long id);

	Poi update(Poi poi);

	Poi update(long id, String title, double latitude, double longitude,
			String descr);

	List<Poi> getPois();

	Poi getPoi(long id);


}
