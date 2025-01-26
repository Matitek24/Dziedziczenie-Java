package Ex2;

public class Kevin extends Ex2.Osoba{
    private Home home;
    private boolean hasCoat;
    private boolean isScared;
    private boolean isOutside;
    private static Kevin instance;

    private Kevin(String name, String surname, int age, int lifePoints, Home home, boolean isScared) {
        super(name, surname, age, lifePoints);
        this.home = home;
        this.hasCoat = false;
        this.isScared = isScared;
        this.isOutside = false;
        home.addKid(this);
    }
    public static Kevin getInstance(String imie, String nazwisko, int wiek, int punktyZycia, Home home, boolean isScared) {
        if (instance == null) {
            instance = new Kevin(imie, nazwisko, wiek, punktyZycia, home, isScared);
        }
        return instance;
    }

    void setUpTrap(String name, int dmg, String desc){
        Trap tr = new Trap(name, dmg, desc);
        home.addTrap(tr);
        System.out.println("Trap is set: " + tr);
    }
    void run(){
        if(isScared == false){
            System.out.println("Kevin is on the move");
        }
        else{
            System.out.println("kevin is scared and cant move");
        }
    }
    void spook(){
        if(!isScared){
            isScared = true;
            System.out.println("Kevin is now scared");
        }
        else{
            System.out.println("Kevin is already scared");
        }
    }
    void relax(){
        if(isScared){
            isScared = false;
            System.out.println("Kevin is now relaxed");
        }
        else{
            System.out.println("Kevin is already realxed");
        }
    }
    void leaveHouse(){
        if(hasCoat){
            isOutside = true;
        }
        else{
            System.out.println("Kevin hasn't a coat");
        }
    }
    void putCoatOn(){
        if(!hasCoat){
            hasCoat = true;
        }
        else{
            System.out.println("Kevin has already coat");
        }
    }
    void changeHouse(Home newHome){
        this.home = newHome;
        System.out.println("Kevin changed home");
    }

}
