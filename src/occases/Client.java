package occases;

import java.util.Objects;

public class Client {

    protected String nom = "";
    protected String prenom = "";
    protected String tel = "";
    protected String adresse = "";

    public Client() {
//constructeur par défaut
    }

    public Client(String nom, String prenom, String tel) {  //constructeur basé sur les informations d'identification
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    public Client(String nom, String prenom, String tel, String adresse) { //constructeur complet
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", adresse=" + adresse;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.nom);
        hash = 23 * hash + Objects.hashCode(this.prenom);
        hash = 23 * hash + Objects.hashCode(this.tel);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        return true;
    }

}
