package Ex1;

public class Santa extends Osoba{
    private boolean isWorking;
    private String cityLocation;
    private String[] cityHistory;
    static String[] naughtyKids;
    Gift[] gifts;

    public Santa(String imie, String nazwisko, int wiek, boolean isWorking, String cityLocation, String[] cityHistory, String[] naughtyKids, Gift[] gifts) {
        super(imie, nazwisko, wiek);
        this.isWorking = isWorking;
        this.cityLocation = cityLocation;
        this.cityHistory = cityHistory;
        this.naughtyKids = naughtyKids;
        this.gifts = gifts;
    }
    void startWork(){
        if(!isWorking){
            isWorking = !isWorking;
        }
        else{
            System.out.println("mikolaj juz pracuje");
        }
    }
    void stopWork(){
        if(gifts != null){
            System.out.println("w tablicy sa jeszcze obiekty");
        }
        else if(isWorking){
            isWorking = !isWorking;
        }
    }
    void giveGift(Child child){
        if (gifts == null || gifts.length == 0) {
            System.out.println("Brak prezentów do rozdania.");
            return;
        }

        for (String dziecko : naughtyKids) {
            if (dziecko.equals(child.imie)) {
                System.out.println("Dziecko jest niegrzeczne");
                return;
            }
        }
        if (gifts[gifts.length - 1].content.equals(child.dreamGift)) {
            System.out.println("Dziecko otrzymało wymarzony prezent");
            gifts[gifts.length - 1] = null;  // Usuwamy prezent z tablicy
        } else {
            gifts[gifts.length - 1] = null;  // Usuwamy prezent z tablicy
            System.out.println("Gratulacje dziecko otrzymało prezent");
        }

    }
    void visitCity(String city){
        cityLocation = city;
        String[] cityHistoryTemp = cityHistory;
        cityHistory = new String[cityHistory.length + 1];
        for(int i = 0; i < cityHistoryTemp.length; i++){
           if( cityHistoryTemp[i].equals("Nowa Historia")){
               System.out.println("Historia juz istnieje");
               return;
           }
            if(cityHistoryTemp.length-1 == i){
                cityHistory[i] = "Nowa Historia";
            }
            else{
                cityHistory[i] = cityHistoryTemp[i];
            }
        }
    }
    Gift findHeaviest() throws noGiftsLeftException {
        if (gifts == null || gifts.length == 0) {
            throw new noGiftsLeftException("Tablica jest pusta");
        }
        Gift heaviest = gifts[0];
        for (Gift gift : gifts) {
            if (gift.weight > heaviest.weight) {
                heaviest = gift;
            }
        }
        return heaviest;
    }
    void coppytab(Gift gift2) {
        if (gifts == null) {
            gifts = new Gift[0]; // Inicjalizujemy jako pustą tablicę, jeśli gifts jest null
        }
        Gift[] gifttemp = new Gift[gifts.length + 1];
        for (int i = 0; i < gifts.length; i++) {
            gifttemp[i] = gifts[i];
        }
        gifttemp[gifts.length] = gift2;
        gifts = gifttemp;
    }

    void add(Gift gift){
        coppytab(gift);
    }
    void add(){
        coppytab(new Gift("Uścisk dłoni prezesa",0));
    }

    String joke(){
        String[] jokes = {"pierwszy zart", "drugi zart", "trzeci zart"};
        return jokes[2];
    }
}
