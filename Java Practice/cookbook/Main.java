import java.lang.Character;

class Main{
	public static void main(String[] args){
		System.out.println("In Test");
		Regex r = new Regex();
		r.checkFirst();
		
		MatchFile mf = new MatchFile();
		mf.matchExpFromFile();
	}
}