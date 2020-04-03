package morskboy;

public class RandPlace {
    static int[][] pole = new int[10][10];
    static String[][] pole1 = new String[11][11];
    int c =0;
    int i;
    int j;
    int z=0;
    int z1=0;
    int r =0;
    int r1=0;
    void randPlace(){
        pole1[0][0] = " ▚";
        pole1[0][1] = " а";
        pole1[0][2] = " б";
        pole1[0][3] = " в";
        pole1[0][4] = " г";
        pole1[0][5] = " д";
        pole1[0][6] = " е";
        pole1[0][7] = " ж";
        pole1[0][8] = " з";
        pole1[0][9] = " и";
        pole1[0][10] = " к";
        pole1[1][0] = " 1 ";
        pole1[2][0] = " 2 ";
        pole1[3][0] = " 3 ";
        pole1[4][0] = " 4 ";
        pole1[5][0] = " 5 ";
        pole1[6][0] = " 6 ";
        pole1[7][0] = " 7 ";
        pole1[8][0] = " 8 ";
        pole1[9][0] = " 9 ";
        pole1[10][0] = "10 ";
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole[i].length; j++) {
                pole[i][j] = 1;
            }
        }
        for (int i = 1; i < pole1.length; i++) {
            for (int j = 1; j < pole1[i].length; j++) {
                pole1[i][j] = game.kletka;
            }
        }

    }


    void Zapolnenie(int kolvo_korabl, int vid_korabl,String[][]pole1232) {
        String[][]pole1=pole1232;
        int v = kolvo_korabl;
        int b = vid_korabl;
        Napravlenie();
        while (v != 0) {
            c = 0;
            do {
                Koord(b);
            }while(Proverka(i,j,r,b,r1)!=true);
                while (c != b) {
                    pole1[i+1][j+1] = game.kletka1;
                    pole[i][j] = 2;
                    //Zapolnenie2(b);
                    i = i + z;
                    j = j + z1;

                    c++;
                }
                v--;
        }
    }
    void Zapolnenie2(int b) {
        if (b == 1) {
            pole[i][j]=2;
//            try {
//                pole[i][j - 1] = 2;
//                pole[i - 1][j] = 2;
//                pole[i + 1][j] = 2;
//                pole[i][j + 1] = 2;
//                pole[i - 1][j - 1] = 2; // корабль где в середине карты
//                pole[i + 1][j - 1] = 2;
//                pole[i - 1][j + 1] = 2;
//                pole[i + 1][j + 1] = 2;
//            } catch (ArrayIndexOutOfBoundsException e) {
//
//            }
//            try {
//                pole[i - 1][j] = 2;
//                pole[i + 1][j] = 2; //корабль у левой стены
//                pole[i][j + 1] = 2;
//                pole[i - 1][j + 1] = 2;
//                pole[i + 1][j + 1] = 2;
//            } catch (ArrayIndexOutOfBoundsException e1) {
//
//            }
//            try {
//                pole[i + 1][j] = 2; //корабль в левом верхнем углу
//                pole[i][j + 1] = 2;
//                pole[i + 1][j + 1] = 2;
//            } catch (ArrayIndexOutOfBoundsException e2) {
//
//            }
//            try {
//                pole[i - 1][j] = 2; //корабль в нижнем левом углу
//                pole[i][j + 1] = 2;
//                pole[i - 1][j + 1] = 2;
//            } catch (ArrayIndexOutOfBoundsException e3) {
//
//            }
//            try {
//                pole[i][j - 1] = 2;
//                pole[i + 1][j] = 2; //корабль у верхней стенки
//                pole[i][j + 1] = 2;
//                pole[i + 1][j - 1] = 2;
//                pole[i + 1][j + 1] = 2;
//            } catch (ArrayIndexOutOfBoundsException e4) {
//
//            }
//            try {
//                pole[i][j - 1] = 2; //корабль у нижней стенки
//                pole[i - 1][j] = 2;
//                pole[i][j + 1] = 2;
//                pole[i - 1][j - 1] = 2;
//                pole[i - 1][j + 1] = 2;
//            } catch (ArrayIndexOutOfBoundsException e5) {
//
//            }
//            try {
//                pole[i][j - 1] = 2; //корабль в нижнем правом углу
//                pole[i - 1][j] = 2;
//                pole[i - 1][j - 1] = 2;
//            } catch (ArrayIndexOutOfBoundsException e6) {
//
//            }
//            try {
//                pole[i][j - 1] = 2;
//                pole[i - 1][j] = 2; //корабль у правой стенки
//                pole[i + 1][j] = 2;
//                pole[i - 1][j - 1] = 2;
//                pole[i + 1][j - 1] = 2;
//            } catch (ArrayIndexOutOfBoundsException e7) {
//
//            }
//            try {
//                pole[i][j - 1] = 2;
//                pole[i + 1][j] = 2; //корабль в верхнем правом углу
//                pole[i + 1][j - 1] = 2;
//            } catch (ArrayIndexOutOfBoundsException e8) {
//
//            }
        }
        if (c == 0) {
            try {
                if (r == 0) {
                    pole[i][j - 1] = 2;
                    pole[i - 1][j] = 2;
                    pole[i + 1][j] = 2;
                    pole[i - 1][j - 1] = 2;
                    pole[i + 1][j - 1] = 2;

                } else {

                    pole[i - 1][j] = 2;
                    pole[i][j - 1] = 2;
                    pole[i][j + 1] = 2;
                    pole[i - 1][j - 1] = 2;
                    pole[i - 1][j + 1] = 2;

                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
            try {
                pole[i + 1][j] = 2;
                pole[i - 1][j] = 2;
            } catch (ArrayIndexOutOfBoundsException e1) {

            }
            try {
                pole[i][j + 1] = 2;
                pole[i][j - 1] = 2;
            } catch (ArrayIndexOutOfBoundsException e2) {

            }
            try {
                pole[i + 1][j] = 2;
            } catch (ArrayIndexOutOfBoundsException e3) {

            }
            try {
                pole[i][j - 1] = 2;
            } catch (ArrayIndexOutOfBoundsException e4) {

            }
            try {
                pole[i - 1][j] = 2;
            } catch (ArrayIndexOutOfBoundsException e5) {

            }
            try {
                pole[i][j + 1] = 2;
            } catch (ArrayIndexOutOfBoundsException e6) {

            }
            try {
                pole[i - 1][j + 1] = 2;
                pole[i - 1][j] = 2;
                pole[i][j + 1] = 2;
            } catch (ArrayIndexOutOfBoundsException e){

            }
            try {
                pole[i - 1][j - 1] = 2;
                pole[i - 1][j] = 2;
                pole[i][j - 1] = 2;
            } catch (ArrayIndexOutOfBoundsException e){

            }

        } else if (c == (b - 1)) {
            try {
                if (r == 0) {

                    pole[i][j + 1] = 2;
                    pole[i - 1][j] = 2;
                    pole[i + 1][j + 1] = 2;
                    pole[i - 1][j + 1] = 2;
                    pole[i + 1][j] = 2;


                } else {

                    pole[i + 1][j] = 2;
                    pole[i + 1][j - 1] = 2;
                    pole[i + 1][j + 1] = 2;
                    pole[i][j + 1] = 2;
                    pole[i][j - 1] = 2;

                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
            try {
                pole[i][j + 1] = 2;
                pole[i][j - 1] = 2;
            } catch (ArrayIndexOutOfBoundsException e2) {

            }
            try {
                pole[i + 1][j] = 2;
            } catch (ArrayIndexOutOfBoundsException e3) {

            }
            try {
                pole[i][j - 1] = 2;
            } catch (ArrayIndexOutOfBoundsException e4) {

            }
            try {
                pole[i - 1][j] = 2;
            } catch (ArrayIndexOutOfBoundsException e5) {

            }
            try {
                pole[i][j + 1] = 2;
            } catch (ArrayIndexOutOfBoundsException e6) {

            }
            try {
                pole[i + 1][j + 1] = 2;
                pole[i + 1][j] = 2;
                pole[i][j + 1] = 2;
            } catch (ArrayIndexOutOfBoundsException e){

            }
            try {
                pole[i + 1][j - 1] = 2;
                pole[i + 1][j] = 2;
                pole[i][j - 1] = 2;
            } catch (ArrayIndexOutOfBoundsException e){

            }
        } else {
            try {
                if (r == 0) {
                    pole[i - 1][j] = 2;
                    pole[i + 1][j] = 2;
                } else {
                    pole[i][j - 1] = 2;
                    pole[i][j + 1] = 2;
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
            try {
                pole[i + 1][j] = 2;
            } catch (ArrayIndexOutOfBoundsException e3) {

            }
            try {
                pole[i][j - 1] = 2;
            } catch (ArrayIndexOutOfBoundsException e4) {

            }
            try {
                pole[i - 1][j] = 2;
            } catch (ArrayIndexOutOfBoundsException e5) {

            }
            try {
                pole[i][j + 1] = 2;
            } catch (ArrayIndexOutOfBoundsException e6) {

            }
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
                if (pole[a][c] == 2) {
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

