

import java.util.Date;

public class Etudiant {
	private String ine;
	private String nom;
	private String prenom;
	private Date date_de_naissance;
	
	
	
	public Etudiant() {
		super();
	}



	public Etudiant(String ine, String nom, String prenom,
		Date date_de_naissance) {
		super();
		this.ine = ine;
		this.nom = nom;
		this.prenom = prenom;
		this.date_de_naissance = date_de_naissance;
	}



	public String getIne() {
		return ine;
	}



	public void setIne(String ine) {
		this.ine = ine;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public Date getDate_de_naissance() {
		return date_de_naissance;
	}



	public void setDate_de_naissance(Date date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
	}

	
	
	public void getAge(){
		int age = 2019-this.date_de_naissance.getYear();
	}

	@Override
	public String toString() {
		return "Etudiant [ine=" + ine + ", nom=" + nom + ", prenom=" + prenom
				+ ", date_de_naissance=" + date_de_naissance + "]";
	}
	
	public void afficher(){
		System.out.println(this.toString());
	}
}