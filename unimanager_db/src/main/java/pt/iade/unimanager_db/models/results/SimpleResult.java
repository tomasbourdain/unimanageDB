package pt.iade.unimanager_db.models.results;

public class SimpleResult {
	public String string;
	public Object object;

	public SimpleResult(String string, Object object) {
		this.string = string;
		this.object = object;
	}
	public String getString(){
		return string;
	}
	public Object getObject(){
		return object;
	}


}
