package com.april;


public class Game {

    private int[][] mas;
    
    private int napr;
    // 0 - left, 1 - up, 2 - right, 3 - down
    private int gX, gY;
    private int kol;
    
    public int newNapr;
    
    private int dlina;
    
    private boolean endg;
    
    public Game() {
        mas = new int[30][30];
    }
    
    public boolean getEndg() {
    	return this.endg;
    }

    public int getMasByXY(int x, int y) {
        return mas[y][x];
    }

    public int getKol() {    	
    	return kol;
    }
    
    public int getNapr() {    	
    	return napr;
    }
    
    public void setNapr(int anotherNapr) {    	
    	this.napr = anotherNapr;
    }
    
    public int getNewNapr() {    	
    	return newNapr;
    }
    
    public void setNewNapr(int anotherNewNapr) {    	
    	this.newNapr = anotherNewNapr;
    }
    
    private void povorot() {
    	if (Math.abs(newNapr - napr) != 2) {
    		napr = newNapr;
    	}
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
        
        napr = 0;        
        kol = 0;        
        
        mas[14][14] = 1;
        mas[14][15] = 2;
        mas[14][16] = 3;
        dlina = 3;
        gX = gY = 14;
        endg = false;
        
        makeNew();        
    }
    
    public int peremGolova() {    	
    	if (napr == 0) {
    		if ((gX - 1) >= 0) {
    			gX--;
    		} else {
    			gX = 29;
    		}
    	} else if (napr == 1) {
    		if ((gY - 1) >= 0) {
    			gY--;
    		} else {
    			gY = 29;
    		}    		
    	} else if (napr == 2) {
    		if ((gX + 1) <= 29) {
    			gX++;
    		} else {
    			gX = 0;
    		}    		
    	} else if (napr == 3) {
    		if ((gY + 1) <= 29) {
    			gY++;
    		} else {
    			gY = 0;
    		}    		
    	}
    	   	
    	int rez = 0;
    	if (mas[gY][gX] == -1) {
    		rez = 1; // попали туда, где еда
    	} else if (mas[gY][gX] == 0) {
    		rez = 2;// попали в пустое поле
    	} else if (mas[gY][gX] > 0) {
    		rez = 3;// попали в туловище змейки
    	}
    	
    	mas[gY][gX] = -2;
    	
    	return rez;
    }
    
    public void perem() {
    	int flag = peremGolova();
    	
    	if (flag == 3) {
    		endg = true;
    	} else {    	
    		for (int i = 0; i < 30; i++) {
    			for (int k = 0; k < 30; k++) {
    				if (mas[i][k] > 0) {
    					mas[i][k]++; //увеличили каждое поле змейки на 1
    				} else if (mas[i][k] == -2) { // -2 -новая координата головы змейки
    					mas[i][k] = 1; // помещаем голову
    				}
    			
    				if (flag != 1) {
    					if (mas[i][k] == (dlina + 1)) {
    						mas[i][k] = 0;
    					}
    				}
    			}
    		}
    	
    		if (flag == 1) {
    			dlina++;
    			makeNew();
    			kol += 10;
    		}
    		
    		povorot();
    	}
    }


}
