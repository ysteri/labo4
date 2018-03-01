package occases;

public class Voiture {

    protected String numChassis = "";
    protected String marque = "";
    protected String modele = "";
    protected int km = 0;
    protected int annee = 0;
    protected double prix = 0;
    protected boolean vendue = false;
    protected Client acheteur = null;

    public Voiture() {
//constructeur par défaut
    }

    public Voiture(String numChassis) {  ///constructeur basé sur les informations d'identification
        this.numChassis = numChassis;
    }

    public Voiture(String numChassis, String marque, String modele, int km, int annee, double prix) { //constructeur complet
        this.numChassis = numChassis;
        this.marque = marque;
        this.modele = modele;
        this.km = km;
        this.annee = annee;
        this.prix = prix;
        this.acheteur = null;
    }

    public String getNumChassis() {
        return numChassis;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public int getKm() {
        return km;
    }

    public int getAnnee() {
        return annee;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double nouvPrix) {
        if (vendue) {
            System.out.println("voiture déjà vendue !");
            return;
        }
        prix = nouvPrix;
    }

    public String  vendre(Client acheteur) {
        if (vendue) {
            return("voiture déjà vendue à " + this.acheteur);
          }
        vendue = true;
        this.acheteur = acheteur;
        return "vente effectuée";
    }

    public Client getAcheteur() {
        return acheteur;
    }

    public boolean estVendue() {
        return vendue;
    }
    
     @Override
   public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Voiture other = (Voiture) obj;
        if ((this.numChassis == null) ? (other.numChassis != null) : !this.numChassis.equals(other.numChassis)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.numChassis != null ? this.numChassis.hashCode() : 0);
        return hash;
    }
    
    @Override
    public String toString() {
        return "numChassis=" + numChassis + ", marque=" + marque + ", modele=" + modele + ", km=" + km + ", annee=" + annee + ", prix=" + prix;
    }

}
