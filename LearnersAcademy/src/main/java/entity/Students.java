package entity;

public class Students {
	
	private int id ;
	private String stud_name;
	private String class_name;
	
	public Students() {
		// TODO Auto-generated constructor stub
	}


	public Students(int id, String stud_name, String class_name) {
		super();
		this.id = id;
		this.stud_name = stud_name;
		this.setClass_name(class_name);
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStud_name() {
		return stud_name;
	}

	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}

	public String getClass_name() {
		return class_name;
	}


	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}


	@Override
	public String toString() {
		return "Students [id=" + id + ", stud_name=" + stud_name + ", class_name=" + class_name + "]";
	}
	
	
	
}
