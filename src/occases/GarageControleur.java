package occases;

public class GarageControleur {

    
    private GarageModele gm = null;
    private GarageVue gv = null;

    public GarageControleur() {

    }

    public GarageControleur(GarageModele gm, GarageVue gv) {
        this.gm = gm;
        this.gv = gv;
    }


    public void gestion() {
        
        //TODO rendre cohérent la liste des switch cases et la liste des éléments du menu
        int ch;
        do {
            ch = gv.menu();

            switch (ch) {
                case 1:
                    ajoutVoiture();
                    break;
                case 2:
                    ajoutClient();
                    break;
                case 3:
                    vendreVehicule();
                    break;
                
                case 4:
                    changementAdresse();
                    break;
                case 5:
                    gv.affMsg("bye");
                    break;
                default:
                    gv.affMsg("choix invalide");
            }
        } while (ch != 5);

    }

    public void ajoutVoiture() {
        Voiture v = gv.encodeVoiture();
        String msg = gm.ajouterVoiture(v);
        gv.affMsg(msg);

    }

    public void ajoutClient() {
        Client cl=gv.encodeClient();
        String msg = gm.ajouterClient(cl);
        gv.affMsg(msg);
    }

    public void vendreVehicule() {
        Voiture oRech = rechVoiture();

        if (oRech != null) {
            gv.affMsg("la voiture trouvée est " + oRech);
        } else {
            gv.affMsg("voiture introuvable");
            return;
        }

        Client cliRech = rechClient();
        if (cliRech == null) {
            gv.affMsg("client introuvable");
            return;
        }
        gv.affMsg("le client trouvé est " + cliRech);
        String msg = oRech.vendre(cliRech);
        gv.affMsg(msg);
    }

   

    public void changementAdresse() {

        Client cliRech = rechClient();
        if (cliRech == null) {
            gv.affMsg("client introuvable");
            return;
        }
        String nvadr = gv.getMsg("nouvelle adresse :");
        cliRech.setAdresse(nvadr);
        gv.affMsg("changement effectué");
    }

    public Client rechClient() {
        StringBuilder nom=new StringBuilder(),prenom=new StringBuilder(),tel=new StringBuilder();
        gv.formRechClient(nom, prenom,tel);
        return gm.getClient(nom.toString(), prenom.toString(), tel.toString());
    }

    public Voiture rechVoiture() {
       String numChassis=gv.formRechVoiture();
       return gm.getVoiture(numChassis);
    }

   
}
