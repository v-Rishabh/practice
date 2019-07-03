class Numbers{
	
	public void isNumberTest(String num){
		try{
			Double result = Double.parseDouble(num);
			System.out.println(num+" is a number");
		}
		catch(NumberFormatException e){
			System.err.println("Number Format Exception");
			e.printStackTrace();
		}
		
	}
}