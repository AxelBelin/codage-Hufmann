import java.util.ArrayList;

/* Cette classe doit �tre compil�e pour tester le programme.
 * Il est possible de la modifier afin de pourvoir tester les fonctionnalit�s avec un autre texte.
 */
public class ListeArbreHuffman { // Pour faire des listes d�Arbres de Huffman
	ArbreHuffman tete ;
	ListeArbreHuffman reste ;
	boolean vide ; // Savoir si une liste est vide ou non
	
	// Default constructeur
	public ListeArbreHuffman()
	{
		vide = true ; // Liste vide
	}
	
	public ListeArbreHuffman(ArbreHuffman tete)
	{
		this(tete, null) ;
		vide = false ; // Liste non vide
	}
	
	// La liste contient une tete : un arbre de Huffman et un reste : une Liste d'arbres de Huffman
	public ListeArbreHuffman(ArbreHuffman tete, ListeArbreHuffman reste)
	{
		vide = false ; // Liste non vide 
		this.tete = tete ;
		this.reste = reste ;
	}
	
	// Accesseurs
	public boolean vide()
	{
		return vide ; // Lise vide 
	}
	
	public ListeArbreHuffman reste()
	{
		if(!vide)
		return reste ;
		else {
			ListeArbreHuffman L = new ListeArbreHuffman() ;
			return L ; // Retourne une Liste vide si elle est vide
		}
	}
	
	public ArbreHuffman tete()
	{
		if(!vide)
			return this.tete ;
		else {
			ArbreHuffman A = new ArbreHuffman() ;
			return A ; // retourne la t�te de la liste ou un nouvel Arbre de Hufman vide
		}
	}
	// Retourne une nouvelle Liste avec val (un arbre de Huffman) en tete et l'ancienne tete devient le reste
	public ListeArbreHuffman prefixer(ArbreHuffman val)
	{
		return new ListeArbreHuffman(val, this) ;
	}
	
	/* Retourne la liste resultant de l'insertion d'une info (un arbre de Huffman) dans une liste
	 * ordonn�e par ordre croissant (de fr�quence) pass�e en param�tres.
	 */
	public static ListeArbreHuffman insererOrd(ListeArbreHuffman uneListe, ArbreHuffman unABHuffmann)
	{
		if(uneListe.vide()) // Cas d'Arret
		{
			return uneListe.prefixer(unABHuffmann) ;
		} else if(uneListe.tete.frequence > unABHuffmann.frequence)
		{
			return uneListe.prefixer(unABHuffmann) ; // Traitement
		}
		return insererOrd(uneListe.reste(), unABHuffmann).prefixer(uneListe.tete()) ; // Appel recursif
	}
	
	/* Deuxi�me version :
	 * Ne prend qu'un seul param�tre : un arbre de Huffman
	 * Utilis�e dans la m�thode de l'algorithme d'Huffman afin de ranger des arbres dans une liste
	 * par ordre croissanr de fr�quence
	 */
	public ListeArbreHuffman insererOrd(ArbreHuffman unABHuffmann)
	{
		ListeArbreHuffman uneListe = this ; // Permet d'initialiser la liste avec l'�l�ment sur lequel elle est appell�e : permet d'�viter de mettre la m�thode en static
		if(uneListe.vide()) // Cas d'Arret
		{
			return uneListe.prefixer(unABHuffmann) ;
		} else if(uneListe.tete.frequence > unABHuffmann.frequence)
		{
			return uneListe.prefixer(unABHuffmann) ; // Traitement
		}
		return insererOrd(uneListe.reste(), unABHuffmann).prefixer(uneListe.tete()) ; // Appel recursif
	}
	
	@Override
	public String toString()
	{
		String str = "" + tete ;
		if(!reste.vide())
			str += "; " + reste ;
		return str ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Arraylist qui va contenir tous les arbres
		ArrayList<ArbreHuffman> A = new ArrayList<ArbreHuffman>() ;
		
		// Chaque arbre est un couple lettre / fr�quence : Il y a 29 caract�res diff�rents dans le texte donc on cr�e 29 arbres
		ArbreHuffman M = new ArbreHuffman('M', 1) ; A.add(M) ; // On ajoute chaque arbre � l'ArrayList A
		ArbreHuffman V = new ArbreHuffman('V', 1) ; A.add(V) ;
		ArbreHuffman j = new ArbreHuffman('j', 1) ; A.add(j) ;
		ArbreHuffman virgule = new ArbreHuffman(',', 2) ; A.add(virgule) ;
		ArbreHuffman T = new ArbreHuffman('T', 2) ; A.add(T) ;
		ArbreHuffman g = new ArbreHuffman('g', 2) ; A.add(g) ;
		ArbreHuffman � = new ArbreHuffman('�', 2) ; A.add(�) ;
		ArbreHuffman � = new ArbreHuffman('�', 2) ; A.add(�) ;
		ArbreHuffman E = new ArbreHuffman('E', 2) ; A.add(E) ;
		ArbreHuffman J = new ArbreHuffman('J', 2) ; A.add(J) ;
		ArbreHuffman c = new ArbreHuffman('c', 3) ; A.add(c) ;
		ArbreHuffman q = new ArbreHuffman('q', 4) ; A.add(q) ;
		ArbreHuffman b = new ArbreHuffman('b', 7) ; A.add(b) ;
		ArbreHuffman point = new ArbreHuffman('.', 7) ; A.add(point) ;
		ArbreHuffman d = new ArbreHuffman('d', 7) ; A.add(d) ;
		ArbreHuffman apostrophe = new ArbreHuffman('�', 8) ; A.add(apostrophe) ;
		ArbreHuffman m = new ArbreHuffman('m', 10) ; A.add(m) ;
		ArbreHuffman p = new ArbreHuffman('p', 11) ; A.add(p) ;
		ArbreHuffman l = new ArbreHuffman('l', 11) ; A.add(l) ;
		ArbreHuffman r = new ArbreHuffman('r', 16) ; A.add(r) ;
		ArbreHuffman t = new ArbreHuffman('t', 16) ; A.add(t) ;
		ArbreHuffman a = new ArbreHuffman('a', 18) ; A.add(a) ;
		ArbreHuffman i = new ArbreHuffman('i', 22) ; A.add(i) ;
		ArbreHuffman o = new ArbreHuffman('o', 23) ; A.add(o) ;
		ArbreHuffman s = new ArbreHuffman('s', 24) ; A.add(s) ;
		ArbreHuffman u = new ArbreHuffman('u', 25) ; A.add(u) ;
		ArbreHuffman n = new ArbreHuffman('n', 25) ; A.add(n) ;
		ArbreHuffman e = new ArbreHuffman('e', 33) ; A.add(e) ;
		ArbreHuffman espace = new ArbreHuffman(' ', 66) ; A.add(espace) ;
		
		// Cr�ation de la liste de tous les arbres
		ListeArbreHuffman ListeArbreHuffman = new ListeArbreHuffman() ;
		for(ArbreHuffman unArbre : A) // Boucle d'ajout des couples dans la liste
		{
			// Ajouter tous les arbres dans la liste tri�e sur la fr�quence : ordre croissant de fr�quence
			ListeArbreHuffman = insererOrd(ListeArbreHuffman, unArbre) ;
		}
		
		// Affichage de la liste d'arbres
		System.out.println("Liste d'arbres de Huffman tri�e par ordre croissant de fr�quence : \n" + ListeArbreHuffman) ;
		System.out.println() ;
		ListeArbreHuffman AHuff = new ListeArbreHuffman() ; // Cr�ation de l'Arbre de codage
		// Remplissage de cet arbre avec la liste de couples gr�ce � la m�thode de l'algo de Huffman : l'arbre est valide
		AHuff = ArbreHuffman.Huffman(ListeArbreHuffman) ;
		System.out.println("Arbre de codage de Huffman : \n") ;
		ArbreHuffman.afficheGraph(AHuff.tete()) ; // Affichage de la t�te de l'arbre de codage de Huffman
		// Affichage du reste de cet arbre (pas utile mais aide si l'arbre s'affiche mal)
		ArbreHuffman.afficheGraph(AHuff.reste().tete()) ;
		System.out.println() ;
		
		// Nouvelle instance de la classe Huffman pour faire appel � ses m�thodes
	    Huffman huff = new Huffman() ;
	    // On a mis le texte initial dans une variable
		String TexteAEncoder = "Tu n�es encore pour moi qu�un petit gar�on tout semblable � cent mille petits gar�ons. Et je n�ai pas besoin de toi. Et tu n�as pas besoin de moi non plus. Je ne suis pour toi qu�un renard semblable � cent mille renards. Mais, si tu m�apprivoises, nous aurons besoin l�un de l�autre. Tu seras pour moi unique au monde. Je serai pour toi unique au monde." ;
		System.out.println("Codage de chaque lettres du texte : \n") ;
	    huff.codageLettres(AHuff.tete(), "") ; // Permet d'appeler la proc�dure de codage des lettres et cr�ation de la table de codage
	    huff.afficherCodageLettres() ; // Affichage de la table de codage des caract�res 
	    System.out.println() ;
	    System.out.println("Tests d'encodage et de d�codage de valeurs avec et sans erreurs : \n") ;
	    System.out.println(huff.encoderTexte("Toto")) ; // Test avec une cha�ne valide : encodage
	    System.out.println(huff.decoderTexte("01001001001111011001")) ; // Test en sens inverse : d�codage
	    // System.out.println(huff.encoderTexte("Tataz,")) ;
	    
	    System.out.println() ;
	    System.out.println("Le texte � encoder : \n" + TexteAEncoder) ; // Affichage du texte � encoder
		System.out.println() ;
		System.out.println("Le texte encod� (encodage) : \n") ;
		// Encodage du texte initial avec la proc�dure d'encodage
		String texteEncode = huff.encoderTexte(TexteAEncoder) ;
		System.out.println(texteEncode) ; // Affichage du texte encod�
		System.out.println() ;
		System.out.println("Le texte d�cod� (d�codage) : \n") ;
		// D�codage du texte encod� avec la proc�dure de d�codage
		String texteDecode = huff.decoderTexte(texteEncode) ;
		System.out.println(texteDecode) ; // Affichage du texte d�cod�
	}
}
