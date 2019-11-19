import java.util.ArrayList;
import java.util.Date;

public class Etudiant {
	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
	private String nom;
	private String prenom;
	private String ine;
	private String ville;
	private String desc_parcours;
	private Date ddn;
	
	public Etudiant(String n, String p, String i, Date d,String c,String desc) {
		nom = n;
		prenom = p;
		ine = i;
		ddn = d;
		ville = c;
		desc_parcours = desc;
	}
	
	public String toString() {
		return "nom: "+nom+" prenom: "+prenom+" ine: "+ine+" ville: "+ville+" desc: "+desc_parcours+" ddn: "+ddn.toString();
	}
	
	public static synchronized Etudiant generateEtudiant() {
		String prenom=Character.toString(CHAR_LOWER.charAt((int) (Math.random()*26)));
		String nom = Character.toString(CHAR_LOWER.charAt((int) (Math.random()*26)));
		String ine = Character.toString(CHAR_LOWER.charAt((int) (Math.random()*26)));
		Date ddn = new Date();
		String ville = Character.toString(CHAR_LOWER.charAt((int) (Math.random()*26)));
		String desc_parcours= Character.toString(CHAR_LOWER.charAt((int) (Math.random()*26)));
		return new Etudiant(prenom,nom,ine,ddn,ville,desc_parcours);
	}
	
	public static synchronized void addToList(ArrayList<Etudiant>arr) {
		arr.add(generateEtudiant());
	}
}
