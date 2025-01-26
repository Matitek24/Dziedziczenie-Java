package Ex2;

public class Robber extends Ex2.Osoba{

    String[] injuries;
    boolean isArrested;
    int inteligance;

    public Robber(String imie, String nazwisko, int wiek, int punktyZycia, boolean isArrested, int inteligance) {
        super(imie,nazwisko,wiek,punktyZycia);
        this.injuries = new String[0];
        this.inteligance = inteligance;
        this.isArrested = isArrested;
    }
    public void rob(Home home) throws notKevinsHouseException {
        if(home.kidInside == null){
            throw new notKevinsHouseException("This isn't Kevin home");
        }
        int losowyprc = (int) (Math.random() * 100);
       for(Trap tr : home.traps){
           if(losowyprc < this.inteligance){
               System.out.println("Robber avoided trap");
           }
           else{
            tr.triggerTrap(this);
            if(lifePoints < 0){
                isArrested = true;
                System.out.println("Robber has found by polcie");
                return;
            }
           }
       }
        System.out.println("Kevin has ben caught by the wet bandit");
    }

    public void addInjuries(String injuries2){
        String[] temp = this.injuries;
        this.injuries = new String[this.injuries.length + 1];
        for(int i = 0; i < this.injuries.length; i++){
            if(i == this.injuries.length -1){
                this.injuries[i] = injuries2;
            }
            else{
                this.injuries[i] = temp[i];
            }
        }
    }
}
