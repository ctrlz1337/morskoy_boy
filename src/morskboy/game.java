package morskboy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class game {
    public final static String kletka= "░░";
    public final static String kletka1="██";
    public final static int[] korab = {4,3,3,2,2,2,1,1,1,1};
    public static Map<String,Integer> koord = new HashMap<String, Integer>();
    public static int kolvo_popad = 0;
    public static void main(String[] args) throws InterruptedException {
        NPC npc = new NPC();
        npc.generate();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = in.next();
        System.out.println("Привет " + name + ".");
        Gamer vz = new Gamer();
        vz.generate(2);
        vz.watch();
        System.out.println("Это твое поле для боя.\nЧтобы расставить корабли тебе надо ввести координат и направление корабля в формате 'Б2' и 'вправо/вниз' соответсвенно." +
                "\nЗапомни что нельзя расставлять корабли так, чтобы они касались друг друга. ");
        System.out.println("Если хочешь автоматическую расстановку кораблей введи 1. Ввод другого символа включит ручную расстановку кораблей.");
        String nam = in.next();
        if (nam.equals("1")) {
            vz.generate(1);
            vz.watch();
            System.out.println("Корабли успешно расставлены. Начинаем бой!");
            Thread.sleep(1000);
            System.out.println("---------------------------------ИГРА НАЧИНАЕТСЯ!----------------------------------");
            for (int i = 1; i < 10; i++) {
                Thread.sleep(500);
                System.out.println("\n");
            }
            while (kolvo_popad != 20 & NPC.kolvo_popad1 != 20) {
                System.out.println("Выберите место для удара");
                vz.watch1();
                String kord = in.next();
                vz.koord = kord;
                int f = vz.attack();
                if (f == 0) {
                    int l=1;
                    do {
                        l = npc.attack();
                    }while (l!=0);
                } else if (f == 1) {
                    continue;
                }
            }
            if (NPC.kolvo_popad1 == 20) {
                System.out.println("Вы проиграли, игра окончена");
            } else if (kolvo_popad == 20) {
                System.out.println("Вы выйграли, игра окончена");
            }
        } else {
            for (int i = 0; i < korab.length; ) {
                System.out.println("Введи начальную координату для " + korab[i] + " палубного корабля:");
                String kord = in.next();
                if (korab[i] != 1) {
                    System.out.println("Введи направление для " + korab[i] + " палубного корабля:");
                    String naprav = in.next();
                    vz.naprav = naprav;
                }
                vz.koord = kord;
                int q = vz.rastanovka(korab[i]);
                if (q == 1) {
                    continue;
                }
                vz.watch();
                i++;
            }

            vz.watch();
            System.out.println("Корабли успешно расставлены. Начинаем бой!");
            Thread.sleep(1000);
            System.out.println("---------------------------------ИГРА НАЧИНАЕТСЯ!----------------------------------");
            for (int i = 1; i < 10; i++) {
                Thread.sleep(500);
                System.out.println("\n");
            }
            while (kolvo_popad != 20 & NPC.kolvo_popad1 != 20) {
                System.out.println("Выберите место для удара");
                vz.watch1();
                String kord = in.next();
                vz.koord = kord;
                int f = vz.attack();
                if (f == 0) {
                    int l=1;
                    do {
                        l = npc.attack();
                    }while (l!=0);
                } else if (f == 1) {
                    continue;
                }
            }
            if (NPC.kolvo_popad1 == 20) {
                System.out.println("Вы проиграли, игра окончена");
                vz.watch();
            } else if (kolvo_popad == 20) {
                System.out.println("Вы выйграли, игра окончена");
                vz.watch1();
            }
        }
    }
}

class Gamer {
    static String[][] pole = new String[11][11];
    static String[][] pole12 = new String[11][11];
    static int[][] pole1 = new int[10][10];
    String koord;
    String koord1;
    int koord2;
    String naprav;
    int c = 0;
    int i;
    int j;
    int z = 0;
    int z1 = 0;
    int r = 0;
    int r1 = 0;

    void generate(int a) {
        RandPlace vz = new RandPlace();
        pole[0][0] = " ▚";
        pole[0][1] = " а";
        pole[0][2] = " б";
        pole[0][3] = " в";
        pole[0][4] = " г";
        pole[0][5] = " д";
        pole[0][6] = " е";
        pole[0][7] = " ж";
        pole[0][8] = " з";
        pole[0][9] = " и";
        pole[0][10] = " к";
        pole[1][0] = " 1 ";
        pole[2][0] = " 2 ";
        pole[3][0] = " 3 ";
        pole[4][0] = " 4 ";
        pole[5][0] = " 5 ";
        pole[6][0] = " 6 ";
        pole[7][0] = " 7 ";
        pole[8][0] = " 8 ";
        pole[9][0] = " 9 ";
        pole[10][0] = "10 ";
        for (int i = 1; i < pole.length; i++) {
            for (int j = 1; j < pole[i].length; j++) {
                pole[i][j] = game.kletka;
            }
        }
        for (int i = 0; i < pole1.length; i++) {
            for (int j = 0; j < pole1[i].length; j++) {
                pole1[i][j] = 1;
            }
        }
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole[i].length; j++) {

                pole12[i][j] = pole[i][j];
            }
        }
        game.koord.put("А", 1);
        game.koord.put("Б", 2);
        game.koord.put("В", 3);
        game.koord.put("Г", 4);
        game.koord.put("Д", 5);
        game.koord.put("Е", 6);
        game.koord.put("Ж", 7);
        game.koord.put("З", 8);
        game.koord.put("И", 9);
        game.koord.put("К", 10);
        if (a == 1) {
            random(1, 4);
            random(2, 3);
            random(3, 2);
            random(4, 1);
        }
    }

    int rastanovka(int b) {
        read();
        try {
            int a = b;
            if ((naprav.equals("вправо")) == true) {
                int i = koord2;
                int j = game.koord.get(koord1);
                System.out.println(i + " " + j);
                while (a != 0) {
                    pole[i][j] = game.kletka1;
                    j++;
                    a--;
                }
            } else if ((naprav.equals("вниз")) == true) {
                int i = koord2;
                int j = game.koord.get(koord1);
                while (a != 0) {
                    pole[i][j] = game.kletka1;
                    i++;
                    a--;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Введены неправильные координаты! Повторите ввод!");
            return 1;
        }
        System.out.println("Введены неправильные координаты! Повторите ввод!");
        return 1;
    }


    void read(){
        try {
            char[] kord = koord.toCharArray();
            koord1 = String.valueOf(kord[0]);
            koord2 = Character.getNumericValue(kord[1]);
            try {
                if (Character.getNumericValue(kord[2]) == 0) {
                    koord2 = 10;
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
        }catch (ArrayIndexOutOfBoundsException e1){

        }
    }
    void watch(){
        for (int i = 0; i < pole.length; i++){
            for(int j=0; j < pole[i].length; j++){

                System.out.print(pole[i][j]);
            }
            System.out.println();
        }
    }
    void watch1(){
        for (int i = 0; i < pole12.length; i++){
            for(int j=0; j < pole12[i].length; j++){

                System.out.print(pole12[i][j]);
            }
            System.out.println();
        }
    }
    int attack() throws InterruptedException {
        int ret=0;
        boolean t=true;
        try {
            do {
                read();
                int i = koord2;
                int j = game.koord.get(koord1);
                if (RandPlace.pole1[i][j] == game.kletka1) {
                    System.out.println("Есть пробитие!");
                    pole12[i][j] = "❌";
                    game.kolvo_popad++;
                    Thread.sleep(1000);
                    ret=1;
                    t=false;
                } else {
                    System.out.println("Промах, ход противника");
                    pole12[i][j] = "  ";
                    Thread.sleep(1000);
                    ret=0;
                    t=false;
                }
            }while (t);
            return ret;
        } catch (NullPointerException e){
            System.out.println("Введены неправильные координаты! Повторите ввод!");
            return ret=3;
        }
    }
    void random(int kolvo_korabl,int vid_korabl){
        int v = kolvo_korabl;
        int b = vid_korabl;
        Napravlenie();
        while (v != 0) {
            c = 0;
            do {
                Koord(b);
            }while(Proverka(i,j,r,b,r1)!=true);
            while (c != b) {
                pole[i+1][j+1] = game.kletka1;
                pole1[i][j] = 2;
                i = i + z;
                j = j + z1;

                c++;
            }
            v--;
        }
    }
    boolean Proverka(int i,int j,int r,int b,int r1) {
        int fromX=0;
        int fromY=0;
        int toX = 0;
        int toY=0;
        if (i==0){
            fromX=0;
        }else{
            fromX=i-1;
        }
        if(i+r*b==10&r==1){
            toX=i+r*b;
        }else if(i+r*b<10&r==1){
            toX=(i+(r*b))+1;
        }else if(i==9&r==0){
            toX=i+1;
        }else if (i<9&r==0){
            toX=i+2;
        }
        if (j==0){
            fromY=0;
        }else{
            fromY=j-1;
        }
        if(j+r1*b==10&r1==1){
            toY=j+r1*b;
        }else if(j+r1*b<10&r1==1){
            toY=(j+(r1*b))+1;
        }else if(j==9&r1==0){
            toY=j+1;
        }else if (j<9&r1==0){
            toY=j+2;
        }
        for (int a = fromX; a < toX; a++) {
            for (int c = fromY; c < toY; c++) {
                if (pole1[a][c] == 2) {
                    return false;
                }
            }
        }
        return true;
    }
    void Napravlenie() {
        r = Rand(1);
        if (r == 0) {
            r1 = 1;
        } else {
            r1 = 0;
        }
    }
    void Koord(int b){
        if (r == 0) {
            i = Rand(9);
            j = Rand(10 - b);
            z1 = 1;
            z = 0;
        } else {
            i = Rand(10 - b);
            j = Rand(9);
            z = 1;
            z1 = 0;
        }
    }
    int Rand(int n){
        return (int) (Math.random() * (n+1));
    }
}
class NPC {
    static int kolvo_popad1=0;
    void generate(){
        RandPlace vz = new RandPlace();
        vz.randPlace();
        vz.Zapolnenie(1,4,RandPlace.pole1);
        vz.Zapolnenie(2,3,RandPlace.pole1);
        vz.Zapolnenie(3,2,RandPlace.pole1);
        vz.Zapolnenie(4,1,RandPlace.pole1);
    }
    int attack() throws InterruptedException {
        Boolean ret=true;
        int p = 0;
        do {
            Gamer gamer = new Gamer();
            int i = (int) (Math.random() * (10)) + 1;
            int j = (int) (Math.random() * (10)) + 1;
            if (Gamer.pole[i][j] == game.kletka1) {
                Gamer.pole[i][j] = "❌";
                System.out.println("Противник успешно попал по вашему кораблю");
                gamer.watch();
                Thread.sleep(2000);
                kolvo_popad1++;
                ret = false;
                p=1;
            } else {
                System.out.println("Противник промахнулся");
                Thread.sleep(1000);
                ret = false;
                p=0;
            }
        }while (ret!=false);
        return p;
    }
}
