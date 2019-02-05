class Program{
	
	// Constructor
	Program(){
		System.out.println("Program's Constructor was called");
	}
	// Instantiation Block
	{ System.out.println("Instantiation Block Activated");}
	{ ZIP = 201005;}
	
	private int ID;
	private int ZIP;
	private int PHONE;
	
	public void setID(int ID){
		this.ID = ID;
	}
	
	public int getID(){
		return ID;
	}
	
	public void setZIP(int ZIP){
		this.ZIP = ZIP;
	}
	
	public int getZIP(){
		return ZIP;
	}
	public void setPHONE(int PHONE){
		this.PHONE = PHONE;
	}
	
	public int getPHONE(){
		return PHONE;
	}
}