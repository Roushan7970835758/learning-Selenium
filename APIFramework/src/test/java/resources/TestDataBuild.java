package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild  {
	public AddPlace addPlacePayload() {
		AddPlace p = new AddPlace();
		p.setName("Frontline house");
		p.setPhone_number("(+91) 983 893 3937");
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setWebsite( "https://rahulshettyacademy.com");
		p.setAccuracy(50);
		List<String> l1 = new ArrayList<>();
		l1.add("house");
		l1.add("Resedential");
		p.setTypes(l1);
		
		Location l = new Location();
		l.setLatitude(-38.383494);
		l.setLongitude(33.427362);
		
		p.setLocation(l);
		
		return p;
	}
	
}
