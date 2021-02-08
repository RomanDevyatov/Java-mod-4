package com.april;


public class Game {

    private int[][] mas;

    public Game() {
        mas = new int[30][30];
    }

    public int getMasByXY(int x, int y) {
        return mas[y][x];
    }

    private void makeNew() {
        while(true) {
            int x = (int) (Math.random() * 30);
            int y = (int) (Math.random() * 30);
            System.out.println(x + " " + y);

            if (mas[y][x] == 0) {
                mas[y][x] = -1;
                break;
            }
        }
    }

    public void start() {
        for (int i = 0; i < 30; i++) {
            for (int k = 0; k < 30; k++) {
                mas[i][k] = 0;
            }
        }

        mas[15][15] = 1;

        makeNew();
    }






}
