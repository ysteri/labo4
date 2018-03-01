package occases;

import java.util.*;

public class Garage {
  ArrayList<Voiture> mesVoitures = new ArrayList<>();
  ArrayList<Client>  mesClients = new ArrayList<>();
  Scanner sc= new Scanner(System.in);
    public Garage() {

    }

    public void gestion() {
        
        int ch;
     
      do {
          System.out.println("1.nouvelle voiture ");
          System.out.println("2.nouveau client");
          System.out.println("3.vente véhicule ");
          System.out.println("4.changement d'adresse ");
          System.out.println("5.fin");
          System.out.println("votre choix :");
          ch=sc.nextInt();
         sc.skip("\n");
          switch(ch){
              case 1:nouvVoiture();
                     break;
                    
              case 2 :nouvClient();
                    break;
              case 3:vendreVehicule();
                    break;
              case 4:changementAdresse();
                    break;
              case 5:System.out.println("bye");
                   break;
              default :System.out.println("choix invalide");         
          }
      }while (ch!=5);
     
    }
        
     public void nouvVoiture(){
        System.out.print("entrer le  numéro de chassis de la voiture ");
        String numChassis = sc.nextLine();
        System.out.print("entrer la marque de la voiture ");
        String marque = sc.nextLine();
        System.out.print("entrer le modele ");
        String modele = sc.nextLine();
        System.out.print("entrer l annee ");
        int annee = sc.nextInt();
        System.out.print("entrer le kilometrage ");
        int km = sc.nextInt();
        System.out.print("entrer le prix ");
        double prix = sc.nextDouble();
        sc.skip("\n");
        Voiture nv = new Voiture(numChassis, marque, modele, annee, km, prix);
        if(mesVoitures.contains(nv))System.out.println("Voiture déjà encodée");
            else {
                mesVoitures.add(nv);
                System.out.println("Voiture encodée");
            }
      }
     
       public void nouvClient(){
           System.out.println("nom du client = ");
            String nom = sc.nextLine();
            System.out.println("prenom du client = ");
            String prenom = sc.nextLine();
            System.out.println("adresse du client = ");
            String adresse = sc.nextLine();
            System.out.println("tel du client = ");
            String tel = sc.nextLine();
            Client nc= new Client(nom, prenom,tel, adresse);
            if(mesClients.contains(nc))System.out.println("Client déjà encodé");
            else {
                mesClients.add(nc);
                System.out.println("Client encodé");
            }
       }
     
     
      public  void vendreVehicule(){
          
           Voiture oRech=rechercheVoiture();
           if(oRech==null){
               System.out.println("voiture introuvable");
               return;
           }
           System.out.println("la voiture trouvée est "+oRech);
        
           Client cliRech=rechercheClient() ;
            if(cliRech==null) {
                System.out.println("client introuvable");
                return;
             }
           System.out.println("le client trouvé est "+cliRech);       
           oRech.vendre(cliRech);  
           System.out.println("vente terminée");
      }
     
  /*     public void afficherClientVente(){
          
           Voiture oRech=rechercheVoiture();
           if(oRech==null){
               System.out.println("voiture introuvable");
               return;
           }
           if(oRech.estVendue()){
               Client cliRech=oRech.getAcheteur();
               System.out.println("le client est "+cliRech);
           }
           else System.out.println("voiture encore en vente");
       }
      
       public void afficherVehiculeClient(){
            Client  cliRech=rechercheClient();
            if(cliRech==null) {
                System.out.println("client introuvable");
                return;
             }
            for(Voiture oRech :mesVoitures){
                 Client cliVoiture=oRech.getAcheteur();
                 if(cliRech.equals(cliVoiture)){
                    System.out.println("voiture vendue : "+oRech);
                }
            }
            
       }
       */   
      
       public void changementAdresse(){
            Client cliRech=rechercheClient() ;
            if(cliRech==null){
                System.out.println("client introuvable");
                return;
            }
            System.out.print("nouvelle adresse :");
            String nvadr=sc.nextLine();
            cliRech.setAdresse(nvadr);
            System.out.println("changement effectué");
       }
       
       public Voiture rechercheVoiture(){
           Scanner lecteur=new Scanner(System.in);
           System.out.print("numero de chassis du vehicule :");
           String numrech =lecteur.nextLine();
           Voiture vrech= new Voiture(numrech);
           
           int p = mesVoitures.indexOf(vrech);
           if(p<0) return null;
           return mesVoitures.get(p);
          
         }
           
       
       public Client rechercheClient(){
            System.out.println("nom du client = ");
            String nom = sc.nextLine();
            System.out.println("prenom du client = ");
            String prenom = sc.nextLine();
            System.out.println("tel du client = ");
            String tel = sc.nextLine();
            Client crech=new Client(nom,prenom,tel);
            int p= mesClients.indexOf(crech);
            if(p<0) return null;
            return mesClients.get(p);
            
       }
      public static void main(String[] args) {
        Garage monGarage = new Garage();
        monGarage.gestion();
    }
}
