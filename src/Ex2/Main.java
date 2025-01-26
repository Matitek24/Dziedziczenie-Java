package Ex2;

public class Main {
    public static void main(String[] args) {
        // Tworzenie domu
        Home home = new Home("123 Elm Street", "McCallister");

        // Tworzenie Kevina
        Kevin kevin = Kevin.getInstance("Kevin", "McCallister", 10, 100, home, false);

        // Dodawanie pułapek
        kevin.setUpTrap("Paint Can", 20, "Head injury from flying paint can");
        kevin.setUpTrap("Hot Iron", 30, "Burn injury from falling iron");
        kevin.setUpTrap("Broken Glass", 10, "Cuts from broken glass");

        // Tworzenie rabusia
        Robber robber = new Robber("Harry", "Lyme", 40, 80, false, 50);

        try {
            // Rabuś próbuje okraść dom
            System.out.println("Robber is entering Kevin's house...");
            robber.rob(home);
        } catch (notKevinsHouseException e) {
            System.out.println(e.getMessage());
        }

        // Kevin spłoszony i opuszcza dom
        kevin.spook();
        kevin.run();
        kevin.putCoatOn();
        kevin.leaveHouse();

        // Próba zmiany domu Kevina
        Home newHome = new Home("742 Evergreen Terrace", "Simpsons");
        kevin.changeHouse(newHome);

        // Wyświetlanie końcowego statusu
        System.out.println("Robber lifePoints: " + robber.lifePoints);
        System.out.println("Robber injuries: " + String.join(", ", robber.injuries));
        System.out.println("Kevin's location: " + newHome.address);
    }
}
