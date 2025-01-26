package Ex2;

public class Trap {
    static int id;
    String name;
    int damageAmount;
    String damageDescription;
    boolean isActive;

    public Trap(String name, int damageAmount, String damageDescription) {
        id++;
        this.name = name;
        this.damageAmount = damageAmount;
        this.damageDescription = damageDescription;
        isActive = true;
    }

    public void triggerTrap(Osoba person){
    if(!isActive){
        System.out.println("Trap is disabled");
        return;
    }
    person.lifePoints -= damageAmount;
    if(person instanceof Robber){
    Robber rb = (Robber) person;
    rb.addInjuries(damageDescription);
    }
    isActive = false;
        System.out.println("Trap triggered" + name + " Damage: " + damageAmount);
    }
    public String toString() {
return "Trap: " + name + " Damage: " + damageAmount;
    }
}
