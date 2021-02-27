import java.util.ArrayList;

public class Huffman { // Pour impl�menter les m�thodes de codage, encodage et d�codage
	// Contient les codages des caract�res sous forme de chaine de 1 et 0
	ArrayList<String> tabCodage = new ArrayList<String>() ;
	// Contient tous les caract�res qui sont pr�sent dans le texte
	ArrayList<Character> lettres = new ArrayList<Character>() ;
	
    public Huffman()
    {
    	
    }
    
    /* Regarder dans l'arbre et pour chaque caract�res 
     * convertir en binaire en fonction de sa position dans l'arbre */
	public void codageLettres(ArbreHuffman A, String str)
	{
		if(!A.CharVide()) // Cas d'arret : si l'Arbre n'a pas de caract�re en racine
		{
			/* Tant que la racine de l'arbre contient un caract�re :
			 * On ajoute ce caract�re dans l'ArrayList des caract�res
			 * Il faut faire un cast de A.info() en caract�re (classe Charact�re) afin de pouvoir l'inserer dans l'Array
			 * Il faut aussi inserer le codage de ce caract�re dans la bonne ArrayList */
			lettres.add((Character)A.info()) ;
			tabCodage.add(str) ;
			return ; // On exit la procedure
		}
			// fg = 0 | fd = 1
			codageLettres(A.fg(), str + "0") ; // Appel recursif : O si dans le fils gauche 
			codageLettres(A.fd(), str + "1") ; // Appel recursif : 1 si dans le fils droit
	}
	
	public void afficherCodageLettres() // Pour chaque caract�re dans l'Arraylist, affichage de son codage
	{
		for(String s : tabCodage) // Parcourir l'ArrayList
			System.out.println(lettres.get(tabCodage.indexOf(s)) + " -> " + s) ;
			// R�cup�rer la letrre + sa fr�quence � l'aide des m�thodes d'Arraylist et les afficher
	}
	
	public String encoderTexte(String TexteAEncoder) // M�thode d'encodage du texte
	{
		boolean existe ;
		String str = new String() ; // D�claration d'un String pour contenir le codage du texte
		// Convertion du texte � encoder en suite de caract�res afin de pouvoir les parcourir un par un
		for(char c : TexteAEncoder.toCharArray())
		{
			existe = false ;
			for(char l : lettres) // parcours de l'ArrayList de caract�res
			{
				if(c == l) // Si la caract�re du texte et de l'ArrayList matchent
				{
					existe = true ; // Alors, on peut coder le texte
					// On ajoute � la chaine encod�e le code du caract�re de la chaine � coder
					str += tabCodage.get(lettres.indexOf(c)) ;
				}
			}
			/* if(!existe)
				return "erreur, le caract�re n'est pas cod� " ; */
		}
		return str ; // On retourne la chaine encod�e
	}
	
	public String decoderTexte(String TexteADecoder) // M�thode de d�codage du texte
	{
		boolean existe ;
		String str = new String() ; // D�claration d'un String pour contenir la chaine de caract�re d�cod�e
		// Tant qu'il retse des caract�res � d�coder dans la chaine encod�e
		while(TexteADecoder.length() > 0)
		{
			existe = false ;
			for(String l : tabCodage) // Parcours de l'ArrayList des codages des caract�res
			{
				if(TexteADecoder.startsWith(l)) // Si la chaine commence par un string contenu dan tabCodage
				{
					existe = true ; // Alors on peut d�coder
					// On ajoute � la chaine d�cod�e les caract�res conresspondants � ceux de la chaine encod�e
					str += lettres.get(tabCodage.indexOf(l)) ;
					// On supprime les code d�ja d�cod�s de la chaine pour continuer sur le reste de cette chai encod�e
					TexteADecoder = TexteADecoder.substring(l.length()) ; 
				}
			}
			/* if(!existe)
				return "erreur, d'encodage" ; */
		}
		return str ; // On retorune le texte d�cod�
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
