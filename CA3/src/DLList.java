
public class DLList {
	private Node head;
	private int size;
	
	public DLList(){
		this.head=null;
		this.size=0;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public int getPosition(Node n){
		for(int i=1; i<=this.size; i++){
			Node currentNode = getNode(i);
			if(n.equals(currentNode)){
				return i;
			}
		}
		System.out.println("Invalid Position");
		return 0;
	}
	
	public Node getNode(int pos){
		Node n = null;
		for(int i=1; i<=pos; i++){
			if(i==1){
				n=this.head;
			}
			else{
				n=n.getNext();
			}
		}
		return n;
	}
	
	public void add(Patient patient){
		if(head==null){
			this.head = new Node(patient, null, null);
		}else{
			Node tail= getNode(this.size);
			Node new_Node = new Node(patient,tail, null);
			tail.setNext(new_Node);
			
		}
		this.size+=1;
	}
	
	public void remove(int pos){
		if(pos==1){
			Node n = getNode(1);
			if(size==1){
				this.head.setPatient(null);;
			}else{
				this.head=n.getNext();
			}
		}
		else if(pos==size && size>1){
			Node n = getNode(pos-1);
			n.setNext(null);
		}
		else{
			Node current = getNode(pos);
			Node previous = getNode(pos-1);
			previous.setNext(current.getNext());
		}
		this.size-=1;
	}
	
	public Node getHighestPriority(){
		Node n = null;
		int highestPriority = 0;
		int pos = 0;
		for(int i =1; i<=size; i++){
			n=getNode(i);
			if(n.getPatient().priority.equals("")){
				//do nothing
			}else{
			int pri = Integer.parseInt(n.getPatient().getPriority());
			if( pri > highestPriority){
				highestPriority=pri;
				pos=i;
			}
			}
		}
		//System.out.println(pos);
		n=getNode(pos);
		return n;
	}
	
	public String toString(){
		String output="";
		
		if(head!=null){
			Node n = head;
			while(n!=null){
				output+="***" + n.getPatient().toString() + "***";
				n = n.getNext();
			}
		}
		return output;
	}
	

}
