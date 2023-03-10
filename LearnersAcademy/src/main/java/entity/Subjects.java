package entity;

public class Subjects {

	private String sub_name;
	
	public Subjects() {
		// TODO Auto-generated constructor stub
	}



	public Subjects(String sub_name) {
		super();
		this.sub_name = sub_name;
	}


	public String getSub_name() {
		return sub_name;
	}

	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}



	@Override
	public String toString() {
		return "Subjects [sub_name=" + sub_name + "]";
	}


	
}
