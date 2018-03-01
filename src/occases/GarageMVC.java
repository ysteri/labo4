package occases;


public class GarageMVC {
    private GarageControleur gc;
    private GarageVue gv;
    private GarageModele gm;
    
    public GarageMVC(){
        
        gv=new GarageVue();
        gm=new GarageModele();
        gc=new GarageControleur(gm,gv);
        gc.gestion();
    }
   
    public static void main(String[] args) {
        GarageMVC gmvc=new GarageMVC();
    }
    
}
