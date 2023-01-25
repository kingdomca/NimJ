import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

import java.util.concurrent.ThreadLocalRandom;
public class Runner {
    public Player p1;
    public Player p2;
    public Runner() {
        p1 = new Player("joe");
        p2 = new Player("hayden");
    }
    public static void main(String[] args) {
        Runner runner = new Runner();
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(runner.p1);
        players.add(runner.p2);
       
        //p1.testNum();
        //p2.testNum();
        Scanner sc = new Scanner(System.in);
        int i = 0;
        if (Math.random() > 0.5) {
            i = 0;
        }
        else {
            i = 1;
        }
        System.out.println(i);
        int amt = 0;
        String res = "";
        Player.showNum();
        System.out.println("Set Autoplay Option");
        String autoPlay = sc.nextLine();
        if (autoPlay.equals("1")) {
            runner.p2.setAutoplay();
        }
        else if (autoPlay.equals("2")) {
            runner.p1.setAutoplay();
            runner.p2.setAutoplay();
        }
        while (true) {
            Player currPlayer = players.get(i%players.size());
            System.out.println(currPlayer.getName() + " turn");
            if (Player.getNum() == 1) {
                amt = 1;
            }
            else {
                if (currPlayer.getAutoplay() == true) {
                    amt = ThreadLocalRandom.current().nextInt(1, Player.getNum()/2+1); } 
                else { 
                    amt = sc.nextInt();
                }
            }
            res = currPlayer.decrNum(amt);
            if (res.equals("p")) {
                System.out.println("not in correct range");
                while (res.equals("p")) {
                    amt = sc.nextInt();
                    res = currPlayer.decrNum(amt);
                }
                if (res.equals("a")) {
                    System.out.println(currPlayer.getName() + " Lost");
                    break;
                }

            }
            if (res.equals("a")) {
                System.out.println(currPlayer.getName() + " Lost");
                break;
            }
            i ++;
            Player.showNum();

        }
         
        for (Player p: players) {
            if (p.getName().equals(players.get(i%players.size()).getName())) {
                System.out.println("Loser:" + p.getName());
            }
            else {
                System.out.println("Winner:" + p.getName());
            }
        }
            
        


        }
}

