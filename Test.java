import java.util.Scanner;

public class Test { // Scanner du texte et tester puis le d�coder et l'afficher
	static Scanner inputTexte = new Scanner(System.in) ; // Scanner pour saisir le texte a encoder
	String str ;
	public Test()
	{
		
	}
	
	public void saisirTexte()
	{
		Test test = new Test() ;
		System.out.println("Veuillez saisir le texte a encoder : \n") ;
		System.out.println("$> ") ;
		String str = inputTexte.nextLine() ;
		if(str != null)
			test.str = str ;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test = new Test() ;
		test.saisirTexte() ;
		System.out.println(test.str) ;
		inputTexte.close() ; // On ferme le scaneur de saisie du texte a encoder
		// game.humain.getSc().close() ;
	}
}
