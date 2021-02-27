import java.io.* ;
public class Arbre {
    
	//Attributs
    boolean arbreVide ;
    int info ;
    Arbre fg ; // Fils gauche
    Arbre fd ; // Fils droit

    //Constructeurs

    Arbre ()
    {
    	arbreVide = true ;
    }

	    Arbre (int info)
	    {
		arbreVide = false ;
		this.info = info ;
		fg = new Arbre() ;
		fd = new Arbre() ;
	    }

    Arbre (int info, Arbre filsGauche, Arbre filsDroit)
    {
    	arbreVide = false ;
    	this.info = info ;
    	this.fg = filsGauche ;
    	this.fd = filsDroit ;
    }

    // M�thodes
 
    public boolean vide ()
    {
    	return arbreVide ;
    }

    public int info ()
    {
		if (!(arbreVide))
		    return info ;
		else return 0 ;  
    }

    public Arbre fg ()
    {
	    return fg ;
    } 

    public Arbre fd ()
    { 
	    return fd ;
    }
    
    // Proc�dures pour g�rer l'affichage d'un arbre
    public static void afficheInfixe (Arbre unArbre)
    {
		afficheInf(unArbre) ;
		System.out.println("");
    }
    
    public static void afficheInf(Arbre unArbre)
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

    public static void afficheGraph(Arbre unArbre) // affiche un arbre couch�
    {
    	System.out.println("=================================");
    	if (!(unArbre.vide()))
    	    afficheGr(unArbre, 0) ;
    	System.out.println("=================================") ;
    }

    public static void afficheGr(Arbre unArbre, int d)
    {
    	if (!(unArbre.vide()))
    	{
    	    afficheGr(unArbre.fd(),d+1) ;
    	    for (int i=0;i<d;i++)
    	    	System.out.print("      ");
    	    System.out.println(unArbre.info()) ;
    	    afficheGr(unArbre.fg(),d+1) ;
    	}
    }
    
    public static void main(String[] args) {
    	Arbre a1 = new Arbre(1) ;
    	Arbre a2 = new Arbre(2) ;
    	Arbre a3 = new Arbre(3,a1,a2) ;
    	Arbre a4 = new Arbre(4,a2,a1) ;
    	Arbre a5 = new Arbre(5,a3,a4) ;
    	Arbre a6 = new Arbre(8,a5,a4) ;
    	
    	System.out.println("Tests de la classe Arbre \n") ;
    	System.out.println("Arbre 3 : ") ;
    	afficheGraph(a3);
    	System.out.println("Arbre 5 : ") ;
    	afficheGraph(a5);
    	System.out.println("Arbre 6 : ") ;
    	afficheGraph(a6) ;
    	
    	// Liste<ArbreBin<charFreq>> ;
    }
}