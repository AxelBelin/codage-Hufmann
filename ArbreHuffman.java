public class ArbreHuffman { // Pour cr�er des arbres de Huffmann
    boolean arbreVide ;
    char info ;
    ArbreHuffman fg ; // Fils Gauche
    ArbreHuffman fd ; // Fils Droit
    int frequence ; // On rajoute la fr�quence comme attribut
    boolean CharVide = true ; // Permet de savoir si la racine de l'arbre est vide : vrai par d�faut

    //Constructeurs
    ArbreHuffman ()
    {
    	arbreVide = true ;
    }

    ArbreHuffman (char info, int frequence)
	{
		arbreVide = false ;
		this.info = info ;
		this.frequence = frequence ;
		fg = new ArbreHuffman() ;
		fd = new ArbreHuffman() ;
		CharVide = false ; // La racine ne peut pas �tre nulle dans ce cas
	}

    // Un arbre de Huffman peut disposer de deux fils sans racine
    ArbreHuffman (ArbreHuffman filsGauche, ArbreHuffman filsDroit)
    {
    	arbreVide = false ;
    	this.fg = filsGauche ;
    	this.fd = filsDroit ;
    	/* fr�quence totale = fr�quence fils droit + fr�quence fils gauche
    	 * Permet de construire l'arbre de codage de Huffman pour les sommets qui contienent la somme 
    	 * de deux fr�quences
    	 */
    	this.frequence = filsDroit.frequence() + filsGauche.frequence() ;
    }

    // M�thodes
 
    public boolean vide()
    {
    	return arbreVide ;
    }
    
    public boolean CharVide()
    {
    	return CharVide ;
    }

    public char info()
    {
    	return this.info ;
    }

    public ArbreHuffman fg ()
    {
	    return this.fg ;
    } 

    public ArbreHuffman fd ()
    { 
	    return this.fd ;
    }
    
    // Methode fr�quence
    public int frequence()
    {
    	return this.frequence ;
    }
    
    // Proc�dures pour g�rer l'affichage d'un arbre
    public static void afficheInfixe (ArbreHuffman unArbre) // Affichage Infixe
    {
		afficheInf(unArbre) ;
		System.out.println("");
    }
    
    // Affichage : gauche, racine, droite = Infixe
    public static void afficheInf(ArbreHuffman unArbre)
    { 
    	if (!(unArbre.vide()))
    	{
	    		System.out.print("(") ;
	    		afficheInf(unArbre.fg()) ;
	    		System.out.print(unArbre.info()) ;
	    		afficheInf(unArbre.fd()) ;
	    		System.out.print(")") ;
    	}
    }

    public static void afficheGraph(ArbreHuffman unArbre)
    {
    	System.out.println("=================================");
    	if (!(unArbre.vide()))
    	    afficheGr(unArbre, 0) ;
    	System.out.println("=================================") ;
    }
    
    /* Affichage "graphique" d'un arbre 
     * d est un d�limiteur servant � r�partir les sommets dans l'espace en focntion de sa valeur
     */
    public static void afficheGr(ArbreHuffman unArbre, int d) 
    {
    	if (!(unArbre.vide())) // Cas d'Arret
    	{
    	    afficheGr(unArbre.fd(),d+1) ; // Appel Recursif avac le fils droit
    	    // Affichage d'espaces pour s�parer les diff�rents sommets les un des autres
    	    for (int i=0; i<d; i++)
    	    	System.out.print("      ") ;
    	    if(unArbre.CharVide()) // Cas d'arret : Si la racine ne contient pas de caract�re
    	    	System.out.println("_(" + unArbre.frequence() + ")_") ; // Alors on affiche juste la fr�quence
    	    else 
    	    System.out.println("(" + unArbre.info() + ":" + unArbre.frequence() + ")") ; // Sinon la racine et sa fr�quence
    	    
    	    afficheGr(unArbre.fg(),d+1) ; // Appel r�cursif avec le fils gauche
    	}
    }
    
     /* Methode qui impl�mente l'algorithme d'Huffman
      * Prends une liste d'arbes de Huffman en param�tres */
    public static ListeArbreHuffman Huffman(ListeArbreHuffman L)
    {
    	if(!L.vide() && !L.reste().vide()) // Cas d'arret : si ni la liste ni son reste sont vide
    	{
    		// Cr�ation d'un nouvel arbre qui contient la t�te de la liste (fg) et le premier �l�ment du reste (fd)
    		ArbreHuffman z = new ArbreHuffman(L.tete(), L.reste().tete()) ;
    		// Appel recursif avec le reste de la liste dans lequel on ajoute le nouvel arbre tri� par fr�quence
    		return Huffman(L.reste().reste().insererOrd(z)) ;
    	} else {
    		return L ; // Sinon retourner la liste initiale
    	}		
    }
    
    @Override
	public String toString() // Methode toString
	{
		String str = "" + info + ":" + frequence ;
		// if(fg != null && fd != null)
			// str += " -> " + fg.toString() + fd.toString() ;
		return str ;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ArbreHuffman ArbreHuffman = new ArbreHuffman() ; // Arbre de codage
	}
}
