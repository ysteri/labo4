/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occases;

/**
 *
 * @author Ivernation
 */
public class DemoVue2 {
    public static void main(String[] args) {
        GarageVue gv=new GarageVue();
        
        gv.affMsg("numéro de châssis  :");
        String numChassis=gv.getMsg();
        gv.affMsg("marque :");
        String marque=gv.getMsg();
        gv.affMsg("modèle:");
        String modele=gv.getMsg();  
        gv.affMsg("km :");
        String kms=gv.getMsg();
        gv.affMsg("année :");
        String annees=gv.getMsg();
        gv.affMsg("prix :");
        String prixs=gv.getMsg();
        try{
        int km = Integer.parseInt(kms);
        int annee = Integer.parseInt(annees);
        float prix = Float.parseFloat(prixs);
        
        Voiture v = new Voiture(numChassis, marque, modele, annee, km, prix);
        gv.affMsg(v);
        }
        catch(NumberFormatException e){
            gv.affMsg("une erreur de transformation numérique est survenue");
        }
      }
}
