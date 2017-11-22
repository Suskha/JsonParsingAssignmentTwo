package assignmentTwo.jsonParse;

public class KeyPeople {

	private String name;
	private String position;
	private String url;
	
	public KeyPeople() {
		
	}
	
	public KeyPeople(String name, String position, String url) {
		this.name = name;
		this.position = position;
		this.url = url;
	}

	@Override
	public String toString() {
		return "KeyPeople [name=" + name + ", position=" + position + ", url=" + url + "]";
	}
	
}
