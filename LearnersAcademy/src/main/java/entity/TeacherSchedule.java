package entity;

public class TeacherSchedule {
	
	private String teach_name ;
	private String class_name ;
	private String sub_name ;
	
	public TeacherSchedule() {
		// TODO Auto-generated constructor stub
	}

	public TeacherSchedule(String teach_name, String class_name, String sub_name) {
		super();
		this.teach_name = teach_name;
		this.class_name = class_name;
		this.sub_name = sub_name;
	}

	public String getTeach_name() {
		return teach_name;
	}

	public void setTeach_name(String teach_name) {
		this.teach_name = teach_name;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getSub_name() {
		return sub_name;
	}

	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}

	@Override
	public String toString() {
		return teach_name +"," +class_name + "," + sub_name ;
	}
	
}
