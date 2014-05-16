package pt.ipb.ts.rs;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import pt.ipb.ts.ejb.Pois;
import pt.ipb.ts.entity.Poi;

@Path("/ps")
@Produces({ "text/xml", "application/json" })
@RequestScoped
public class PoiService {
	@Inject Pois pois;

	@Path("/create")
	@PUT
	public Poi create(@QueryParam("title") String title,
			@QueryParam("latitude") double latitude,
			@QueryParam("longitude") double longitude,
			@QueryParam("descr") String descr) {
		return pois.create(title, latitude, longitude, descr);
	}

	@Path("/list")
	@GET
	public List<Poi> list() {
		return pois.getPois();
	}

	@Path("/delete/{id}")
	@DELETE
	public void delete(@PathParam("id") long id) {
		pois.delete(id);
	}

	@Path("/update/{id}")
	@POST
	public Poi update(@PathParam("id") long id,
			@QueryParam("title") String title,
			@QueryParam("latitude") double latitude,
			@QueryParam("longitude") double longitude,
			@QueryParam("descr") String descr) {
		return pois.update(id, title, latitude, longitude, descr);
	}
}
