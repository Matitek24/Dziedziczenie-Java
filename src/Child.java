public class Child extends Osoba{
    int schoolClass;
    String dreamGift;
    public Child(String imie, String nazwisko, int wiek, int schoolClass, String dreamGift) {
        super(imie,nazwisko,wiek);
        this.schoolClass = schoolClass;
        this.dreamGift = dreamGift;
    }
}
