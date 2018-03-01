package occases;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;


public class GarageVue {
   
    
    
     private Scanner sc = new Scanner(System.in);
     
     
     
   public int menu(){
       List<String> listeItems = new ArrayList<>(Arrays.asList(
            "ajouter voiture", 
            "ajouter client", 
            "vendre véhicule", 
            "changement d'adresse", 
            "fin"));
       affListe(listeItems);
       
            int ch;
        do {
            String chs = getMsg("votre choix");
            ch = Integer.parseInt(chs);
            if (ch > 0 && ch <= listeItems.size()) {
                break;
            }
            affMsg("choix incorrect");
        } while (true);
        return ch;
   }


   public String formRechVoiture(){
        String numChassis;
        numChassis = getMsg("numero de chassis du vehicule:");
        return numChassis;
   }
   
   
   public void formRechClient(StringBuilder nom,StringBuilder prenom,StringBuilder tel){
       nom.setLength(0);
       prenom.setLength(0);
       tel.setLength(0);
       nom.append(getMsg("nom :"));
       prenom.append(getMsg("prenom :"));
       tel.append(getMsg("tel :"));
    }
   
    public Voiture encodeVoiture() {
        String numChassis = getMsg("entrer le  numéro de chassis de la voiture ");
        String marque =getMsg("entrer la marque de la voiture ");
        String modele = getMsg("entrer le modele ");
        String annees = getMsg("entrer l annee ");
        int annee = Integer.parseInt(annees);
        String kms = getMsg("entrer le kilometrage ");
        int km = Integer.parseInt(kms);
        String prixs = getMsg("entrer le prix ");
        float prix = Float.parseFloat(prixs);
        Voiture v = new Voiture(numChassis, marque, modele, annee, km, prix);
        return v;
    }

    public Client encodeClient() {

        String nom = getMsg("nom du client : ");
        String prenom = getMsg("prenom du client ");
        String adresse = getMsg("adresse du client :");
        String tel = getMsg("tel du client :");
        Client cl = new Client(nom, prenom, tel, adresse);
        return cl;
    }

   

    public void affVoiture(Voiture v) {
        affMsg("numéro de châssis  :" + v.getNumChassis());
        affMsg("marque :" + v.getMarque());
        affMsg("modèle:" + v.getModele());
        affMsg("km :"+v.getKm());
        affMsg("année :" + v.getAnnee());
        affMsg("prix :" + v.getPrix());
        if(v.estVendue()) {
            affMsg("Vendue à :");
            affClient(v.getAcheteur());
        }
      }

    public void affClient(Client cl) {
        affMsg("nom :" + cl.getNom());
        affMsg("prénom :" + cl.getPrenom());
        affMsg("adresse  :" + cl.getAdresse());
        affMsg("tel :" + cl.getTel());
    }

    
    public String getMsg() {
        String msg = sc.nextLine();
        return msg;
    }

    public void affMsg(Object msg) {
        System.out.println(msg);
    }

    public String getMsg(String msg) {//surcharge de la méthode getMsg
        affMsg(msg);
        return getMsg();
    }

        
    public void affListe(Collection liste){
      int i=1;
        for(Object o : liste){
          affMsg((i++)+"." + o);
      }  
    }
    
 }
