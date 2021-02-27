public class Liste {
	int tete ;
	Liste reste ;
	boolean vide ; // Savoir si une liste est vide ou non
	
	// Default constructeur
	public Liste()
	{
		vide = true ; // Liste vide
	}
	
	public Liste(int tete)
	{
		this(tete, null) ;
		vide = false ; // Liste non vide
	}
	
	// La liste contient une tete et un reste
	public Liste(int tete, Liste reste)
	{
		vide = false ; // Liste non vide 
		this.tete = tete ;
		this.reste = reste ;
	}
	
	// accesseurs
	public boolean vide()
	{
		return vide ; // Lise vide 
	}
	
	public int tete()
	{
			if(!vide)
			return tete ;
		return 0 ; // Retourne 0 si la liste n'est pas vide
	}
	
	public Liste reste()
	{
		if(!vide)
		return reste ;
		else {
			Liste L = new Liste() ;
			return L ; // Retourne une Liste vide si elle est vide
		}
	}
	
	// Retourne une nouvelle Liste avec val en tete et l'ancienne tete devient le reste
	public Liste prefixer(int val)
	{
		return new Liste(val, this) ;
	}
	
	@Override
	public String toString() // Methode toString
	{
		String str = "" + tete ;
		if(reste != null)
			str += " ; " + reste.toString() ;
		return str ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Tests pour verifier le bon fonctionnement de la classe Liste
		Liste ListeVide = new Liste() ;
		Liste ListeTete = new Liste(2) ;
		Liste ListeReste = new Liste(4, ListeTete) ;
		
		System.out.println("Tests de la classe Liste \n") ;
    	System.out.println("Liste Vide : ") ;
		System.out.println(ListeVide.vide()) ;
		System.out.println(ListeReste.vide()) ;
		System.out.println() ;
		System.out.println("Liste Tete : ") ;
		System.out.println(ListeReste.tete()) ;
		System.out.println(ListeVide.tete()) ;
		System.out.println() ;
		System.out.println("Liste Reste : ") ;
		System.out.println(ListeReste.reste()) ;
		System.out.println(ListeTete.reste()) ;
		System.out.println(ListeVide.reste()) ;
		System.out.println() ;
		System.out.println("Prefixer : ") ;
		ListeReste = ListeReste.prefixer(6) ;
		ListeTete = ListeTete.prefixer(42) ;
		ListeTete = ListeTete.prefixer(43) ;
		System.out.println(ListeTete) ;
		System.out.println(ListeReste) ;
		
		// Liste<ArbreBin<charFreq>> ;
	}
}