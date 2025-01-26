package Ex2;

public class Home {
    String address;
    String ownersName;
    Kevin kidInside;
    Trap[] traps;

    public Home(String address, String ownersName) {
        this.address = address;
        this.ownersName = ownersName;
        traps = new Trap[0];
    }
    public void addKid(Kevin k){
        this.kidInside = k;
    }
    public void addTrap(Trap t){
        Trap[] trapstemp = traps;
        traps = new Trap[trapstemp.length + 1];
        for(int i = 0; i < traps.length; i++){
            if(i == trapstemp.length){
                traps[i] = t;
                break;
            }
            traps[i] = trapstemp[i];
        }
    }
}
