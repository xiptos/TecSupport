package pt.ipb.ts.jsf;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import pt.ipb.ts.ejb.Pois;
import pt.ipb.ts.entity.Poi;

import com.googlecode.gmaps4jsf.component.common.Position;
import com.googlecode.gmaps4jsf.component.map.Map;
import com.googlecode.gmaps4jsf.component.marker.Marker;
import com.googlecode.gmaps4jsf.services.GMaps4JSFServiceFactory;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class MapBean implements Serializable {

	@Inject Pois pois;

	public List<Poi> getPois() {
		List<Poi> poiList = pois.getPois();
		return poiList;
	}

	public void addMarkerHere(ActionEvent actionEvent) {
        Map map = (Map) actionEvent.getComponent();
        
        Marker marker = new Marker();
        
        marker.setLongitude(((Position) map.getValue()).getLongitude());
        marker.setLatitude(((Position) map.getValue()).getLatitude());
        
        String address = MapBean.addressGenerator(Double.parseDouble(marker.getLatitude()), Double.parseDouble(marker.getLongitude()));
        pois.create(marker.getLatitude()+","+marker.getLongitude(), marker.getLatitude(), marker.getLongitude(), address);
        map.getChildren().add(marker);
    }
    
	public static String addressGenerator(Double latitude, Double longitude){
	    String address = "";
	    try{
	        address = GMaps4JSFServiceFactory.getReverseGeocoderService().
	                getPlaceMark(latitude.toString(), longitude.toString()).getAddress();
	        address = new String(address.getBytes(), "UTF-8");      
	    } catch (Exception e){
	        e.printStackTrace();
	    }
	    return address;
	}
}
