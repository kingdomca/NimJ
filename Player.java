import java.util.concurrent.ThreadLocalRandom;
public class Player {
    private String name = "";
    private static int currNum = ThreadLocalRandom.current().nextInt(20, 50 + 1);
    private boolean autoPlay = false;
    public Player(String name) {
        this.name = name;
    }
    public void testNum() {
        for (int i=1; i<=currNum; i++) {
            System.out.println(i);
        }
    }
    public String getName() {
        return name;
    }
    public static void showNum() {
        System.out.println(currNum);
    }
    public static int getNum() {
	    return currNum;
    }
    public void setAutoplay() {
	 this.autoPlay = true; 
    }
    public boolean getAutoplay() {
	   return this.autoPlay;
    }
    public String decrNum(int amt) {
        if (currNum == 1) {
            return "a";
        }
        if (amt > 0.5*currNum || amt < 1) {
            return "p";
        }
        currNum -= amt;
        if (testOver()) {
            return "a";
        } 
        else {
            return "b";
        }
    }
    public boolean testOver() {
        if (currNum <= 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
