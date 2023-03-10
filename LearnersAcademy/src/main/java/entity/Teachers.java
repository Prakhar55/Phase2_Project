package entity;

public class Teachers {
	
	private int id ;
	private String teach_name;

	public Teachers() {
		// TODO Auto-generated constructor stub
	}



	public Teachers(int id, String teach_name) {
		super();
		this.id = id;
		this.teach_name = teach_name;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeach_name() {
		return teach_name;
	}

	public void setTeach_name(String teach_name) {
		this.teach_name = teach_name;
	}


	@Override
	public String toString() {
		return "Teachers [id=" + id + ", teach_name=" + teach_name + "]";
	}

	


}
