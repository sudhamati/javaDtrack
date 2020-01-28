package CreateDriveData;

public class CreateDrive {
	private int id;
	private String  companyName;
	private int resources;
	private int exprequired;
	private float ctc;
	private int joiningcriteria;
	private float bond;
	private int position;
	private String follow  ;
	private int educriteria;
	@Override
	public String toString() {
		return "CreateDrive [CompanyName=" + companyName + ", resources=" + resources + ", exprequired=" + exprequired
				+ ", ctc=" + ctc + ", joiningcriteria=" + joiningcriteria + ", bond=" + bond + ", position=" + position
				+ ", follow=" + follow + ", educriteria=" + educriteria + "]";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getResources() {
		return resources;
	}
	public void setResources(int resources) {
		this.resources = resources;
	}
	public int getExprequired() {
		return exprequired;
	}
	public void setExprequired(int exprequired) {
		this.exprequired = exprequired;
	}
	public float getCtc() {
		return ctc;
	}
	public void setCtc(float ctc) {
		this.ctc = ctc;
	}
	public int getJoiningcriteria() {
		return joiningcriteria;
	}
	public void setJoiningcriteria(int joiningcriteria) {
		this.joiningcriteria = joiningcriteria;
	}
	public float getBond() {
		return bond;
	}
	public void setBond(float bond) {
		this.bond = bond;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getFollow() {
		return follow;
	}
	public void setFollow(String follow) {
		this.follow = follow;
	}
	public int getEducriteria() {
		return educriteria;
	}
	public void setEducriteria(int educriteria) {
		this.educriteria = educriteria;
	}
	
	
	
	



}
