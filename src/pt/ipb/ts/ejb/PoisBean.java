package pt.ipb.ts.ejb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pt.ipb.ts.entity.Poi;

/**
 * Session Bean implementation class PoiBean
 */
@SuppressWarnings("serial")
@Stateless
public class PoisBean implements Pois, Serializable {
	@PersistenceContext(unitName="TecSupport")
	EntityManager em;

	@Override
	public Poi create(String title, double latitude, double longitude, String descr) {
		Poi poi = new Poi(title, latitude, longitude, descr);
		this.em.persist(poi);
		return poi;
	}

	@Override
	public void delete(Poi poi) {
		poi = em.merge(poi);
		em.remove(poi);
	}

	@Override
	public Poi update(Poi poi) {
		return em.merge(poi);
	}

	@Override
	public List<Poi> getPois() {
		return em.createNamedQuery(Poi.ALL, Poi.class).getResultList();
	}

	@Override
	public Poi getPoi(long id) {
		return this.em.find(Poi.class, id);
	}

	@Override
	public Poi create(String title, String latitude, String longitude,
			String address) {
		return this.create(title, Double.parseDouble(latitude), Double.parseDouble(longitude), address);
	}

	@Override
	public void delete(long id) {
		Poi poi = em.find(Poi.class, id);
		em.remove(poi);
	}

	@Override
	public Poi update(long id, String title, double latitude, double longitude,
			String descr) {
		Poi poi = em.find(Poi.class, id);
		poi.setTitle(title);
		poi.setLatitude(latitude);
		poi.setLongitude(longitude);
		poi.setDescr(descr);
		return poi;
	}
}
