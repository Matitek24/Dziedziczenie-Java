package Ex1;

public class Main {
    public static void main(String[] args) {
        // Tworzymy obiekty Ex1.Gift
        Gift gift1 = new Gift("Zabawka", 1);
        Gift gift2 = new Gift("Klocki", 2);
        Gift gift3 = new Gift("Lalka", 3);

        // Tworzymy tablicę prezentów
        Gift[] gifts = {gift1, gift2, gift3};

        // Tworzymy tablicę z niegrzecznymi dziećmi
        String[] naughtyKids = {"Janek", "Marek", "Ania"};

        // Tworzymy tablicę historii miast
        String[] cityHistory = {"Warszawa", "Kraków"};

        // Tworzymy obiekt Ex1.Santa
        Santa santa = new Santa("Mikołaj", "Święty", 800, false, "Laponia", cityHistory, naughtyKids, gifts);

        // Testowanie metody startWork()
        santa.startWork();  // Powinna ustawić isWorking na true
        santa.startWork();  // Powinna wyświetlić "Mikołaj już pracuje"

        // Testowanie metody stopWork()
        santa.stopWork();   // Powinna zatrzymać pracę, ponieważ tablica 'gifts' nie jest pusta// Ustawiamy gifts na null
        santa.stopWork();   // Powinna zatrzymać pracę, ponieważ gifts jest puste

        // Tworzymy obiekt dziecka
        Child child = new Child("Janek", "Nowak", 10, 4, "Zabawka");

        // Testowanie metody giveGift()
        santa.giveGift(child);  // Powinna wyświetlić "Dziecko jest niegrzeczne", ponieważ Janek jest na liście niegrzecznych dzieci
        child.dreamGift = "Klocki";  // Zmieniamy wymarzony prezent
        santa.giveGift(child);  // Powinna wyświetlić "Gratulacje dziecko otrzymało prezent" i usunąć ostatni prezent

        // Testowanie metody visitCity()
        santa.visitCity("Gdańsk");  // Powinna dodać "Gdańsk" do historii
        santa.visitCity("Warszawa");  // Powinna wyświetlić "Historia już istnieje"

        // Testowanie metody findHeaviest()
        try {
            Gift heaviest = santa.findHeaviest();  // Powinna zwrócić najcięższy prezent
            System.out.println("Najcięższy prezent: " + heaviest.content + " o wadze " + heaviest.weight);
        } catch (noGiftsLeftException e) {
            System.out.println(e.getMessage());
        }

        // Testowanie metody addGift()
        santa.add(new Gift("Skarpety", 3));  // Powinna dodać nowy prezent do tablicy
        santa.add();
        santa.add(new Gift("Skarpety2", 35));
        System.out.println("Liczba prezentów po dodaniu: " + santa.gifts.length);

        // Testowanie metody joke()
        System.out.println("Żart Mikołaja: " + santa.joke());
    }
}
