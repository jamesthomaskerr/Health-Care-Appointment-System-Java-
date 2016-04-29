
public class Patient extends ObjectMapper {
    static String classname = "Patient";

	public String Fname="";
	public String Lname="";
	public String dob="";
	public String brief_sum="";
	public String vitalsigns="";
	public String priority="";
	public String doc_sum="";
	

	
	public String getBrief_Sum() {
		return brief_sum;
	}

	public void setBrief_Sum(String summary) {
		this.brief_sum = summary;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDoc_sum() {
		return doc_sum;
	}

	public void setDoc_sum(String doc_sum) {
		this.doc_sum = doc_sum;
	}

	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getVitalsigns() {
		return vitalsigns;
	}

	public void setVitalsigns(String vitalsigns) {
		this.vitalsigns = vitalsigns;
	}

}
