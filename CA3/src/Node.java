
public class Node extends ObjectMapper{
	private Patient patient;
	//private int priority;
	private Node next;
	private Node previous;
	public Node (Patient patient, Node previous, Node next){
		this.patient=patient;
		this.previous=previous;
		this.next=next;
		//this.priority=priority;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	

}
