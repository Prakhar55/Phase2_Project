package entity;


public class ClassCurriculum {
	
	private String class_name;
	private String subjects;
	
	public ClassCurriculum() {
		// TODO Auto-generated constructor stub
	}

	public ClassCurriculum(String class_name, String subjects) {
		super();
		this.class_name = class_name;
		this.subjects = subjects;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "ClassCurriculum [class_name=" + class_name + ", subjects=" + subjects + "]";
	}
	
	

}
