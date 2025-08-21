package resources;

public enum APIResources {
	AddPlaceAPI("maps/api/place/add/json"),
	GetPlaceAPI("maps/api/place/get/json"),
	DeletePlaceAPI("maps/api/place/delete/json");
	
	public String resource;
	APIResources(String name) {
		this.resource = name;
	}

}
