package Ex1;

public class Gift {
    static int id;
    String content;
    int weight;

    public Gift(String content, int weight) {
        this.content = content;
        this.weight = weight;
        id++;
    }

}
