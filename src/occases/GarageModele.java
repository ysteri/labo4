package occases;

import java.util.*;

public class GarageModele {
  protected  List<Client> mesClients = new ArrayList<>();
  protected  List<Voiture> mesVoitures = new ArrayList<>();
 
          
  public GarageModele(){
    
  }
  
  public String ajouterVoiture(Voiture v){
     if(v==null)return "Voiture nulle";
     int p=mesVoitures.indexOf(v);
     if(p>=0)return "voiture deja enregistree";
     mesVoitures.add(v);
     return "ajout voiture effectue";
  }
  
   public String ajouterClient(Client c){
     if(c==null)return "client nul";
     int p=mesClients.indexOf(c);
     if(p>=0)return "client deja enregistre";
     mesClients.add(c);
     return "ajout client effectue";
  }
   
    public Voiture getVoiture(String numrech ) {
     Voiture vRech= new Voiture(numrech);
     int p = mesVoitures.indexOf(vRech);
     if(p<0) return null;
     else return mesVoitures.get(p);
    }
   
     public Client getClient(String nomRech,String prenomRech,String telRech) {
     Client  cRech= new Client(nomRech,prenomRech,telRech);
     int p = mesClients.indexOf(cRech);
     if(p<0) return null;
     else return mesClients.get(p);
    }
    
    public List<Client> TousClients() {
      
      return mesClients;
   }
 
  
  public List<Voiture> getVoituresClient(Client c){
      if(c==null)return null;
      if(mesVoitures.isEmpty())return null;
      ArrayList<Voiture> listev =new ArrayList<>();
      for(Voiture v :mesVoitures){
            if(!v.estVendue())continue;
            Client ca=v.getAcheteur();
            if(ca.equals(c))listev.add(v);
      }
      if(listev.isEmpty())return null;
      return listev;
  }
   
}