/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szinkep;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gvajd
 */
public class Szinkep {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            FileReader buta = new FileReader("kep.txt");
            BufferedReader okos = new BufferedReader(buta);
            Integer[][] pixelek = new Integer[2500][3];
            String ideiglenes = "";
            String[] harmas;
            for (int i = 0; i < 2500; i++) {
                ideiglenes = okos.readLine();
                harmas = ideiglenes.split(" ");
                pixelek[i][0] = Integer.parseInt(harmas[0]);
                pixelek[i][1] = Integer.parseInt(harmas[1]);
                pixelek[i][2] = Integer.parseInt(harmas[2]);
            }
            //2
            System.out.println("2. feladat");
            int R = 0;
            int G = 0;
            int B = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Kérem adjon meg egy RGB kódot! A három színt az Enter lenyomásával válassza el egymástól!");
            System.out.println("R:");
            R = sc.nextInt();
            System.out.println("G:");
            G = sc.nextInt();
            System.out.println("B:");
            B = sc.nextInt();

            int szamolo = 0;
            for (int i = 0; i < 2500; i++) {
                if (R == pixelek[i][0]
                        && G == pixelek[i][1]
                        && B == pixelek[i][2]) {
                    szamolo++;
                    break;
                }
            }
            if (szamolo > 0) {
                System.out.println("A bekért szín megtalálható a képen.");
            } else {
                System.out.println("A bekért szín nem található meg a képen.");
            }
            //3
            //37 sor 8 pixel = 1708
            int szin0 = pixelek[1708][0];
            int szin1 = pixelek[1708][1];
            int szin2 = pixelek[1708][2];

            int oszlop = 0;
            int sor = 0;

            for (int i = 0; i < 100; i++) {
                if ((8 + 50 * i) > 2500) {
                    break;
                }
                if (pixelek[8 + 50 * i][0] == szin0
                        && pixelek[8 + 50 * i][1] == szin1
                        && pixelek[8 + 50 * i][2] == szin2) {
                    oszlop++;
                }
            }
            for (int i = 0; i < 50; i++) {
                if (pixelek[1700 + i][0] == szin0
                        && pixelek[1700 + i][1] == szin1
                        && pixelek[1700 + i][2] == szin2) {
                    sor++;
                }
            }
            System.out.println("3. feladat");
            System.out.println("Sorban: " + sor + " Oszlopban: " + oszlop);

            //4
            System.out.println("4. feladat");
            R = 0;
            G = 0;
            B = 0;
            for (int i = 0; i < 2500; i++) {
                if (pixelek[i][0] == 255
                        && pixelek[i][1] == 0
                        && pixelek[i][2] == 0) {
                    R++;
                }
                if (pixelek[i][0] == 0
                        && pixelek[i][1] == 255
                        && pixelek[i][2] == 0) {
                    G++;
                }
                if (pixelek[i][0] == 0
                        && pixelek[i][1] == 0
                        && pixelek[i][2] == 255) {
                    B++;
                }

            }
            System.out.println(R + " " + G + " " + B);
            if (R >= G && R >= B) {
                System.out.println("Vörös");
            }
            if (G >= R && G >= B) {
                System.out.println("Zöld");
            }
            if (B >= G && B >= R) {
                System.out.println("Kék");
            }

            //5
            for (int i = 0; i < 2500; i++) {
                //bal küggőleges vonal rajzolása
                if ((i - 2) % 50 == 0) {

                    pixelek[i][0] = 0;
                    pixelek[i][1] = 0;
                    pixelek[i][2] = 0;
                }
                if ((i - 1) % 50 == 0) {

                    pixelek[i][0] = 0;
                    pixelek[i][1] = 0;
                    pixelek[i][2] = 0;
                }
                if ((i) % 50 == 0) {

                    pixelek[i][0] = 0;
                    pixelek[i][1] = 0;
                    pixelek[i][2] = 0;
                }
                //jobb függőleges
                if ((i - 49) % 50 == 0) {

                    pixelek[i][0] = 0;
                    pixelek[i][1] = 0;
                    pixelek[i][2] = 0;
                }
                if ((i - 48) % 50 == 0) {

                    pixelek[i][0] = 0;
                    pixelek[i][1] = 0;
                    pixelek[i][2] = 0;
                }
                if ((i - 47) % 50 == 0) {

                    pixelek[i][0] = 0;
                    pixelek[i][1] = 0;
                    pixelek[i][2] = 0;
                }

            }
            //teteje
            for (int i = 0; i < 150; i++) {
                pixelek[i][0] = 0;
                pixelek[i][1] = 0;
                pixelek[i][2] = 0;
            }
            //alja
            for (int i = 0; i < 2500; i++) {
                if (i > 2350) {
                    pixelek[i][0] = 0;
                    pixelek[i][1] = 0;
                    pixelek[i][2] = 0;
                }
            }
            //ellenőrző kiírató
            /*for (int i = 0; i < 2500; i++) {
                System.out.println(pixelek[i][0]);
                System.out.println(pixelek[i][1]);
                System.out.println(pixelek[i][2]);
            }*/

            //6
            FileWriter fw = new FileWriter("keretes.txt");
            PrintWriter pw = new PrintWriter(fw);

            for (int i = 0; i < 2500; i++) {
                pw.println(pixelek[i][0] + " " + pixelek[i][1] + " " + pixelek[i][2]);
            }
            pw.close();

            //7
            System.out.println("7. feladat");
            //pixel koordináták generálása
            Integer[][] sarga = new Integer[2500][3];
            int hor = 0;
            int ver = 1;
            for (int i = 0; i < 2500; i++) {
                hor++;
                sarga[i][0] = hor;
                sarga[i][1] = ver;
                sarga[i][2] = 0;
                if (hor == 50) {
                    hor = 0;
                    ver++;
                }
            }
            //ellenőrzés
            /*for (int i = 0; i < 2500; i++) {
                System.out.println(sarga[i][0]+" "+sarga[i][1]+" "+sarga[i][2]);
            }*/

            //sárga keresés és beírás a koordináták mellé = megvan a téglalap
            int osszSarga = 0;
            for (int i = 0; i < 2500; i++) {
                if (pixelek[i][0] == 255
                        && pixelek[i][1] == 255
                        && pixelek[i][2] == 0) {
                    sarga[i][2] = 1;
                    osszSarga++;
                }
            }
            //eredmény leolvasása
            int kezdH = 0;
            int kezdV = 0;
            int vegH = 0;
            int vegV = 0;
            for (int i = 0; i < 2500; i++) {
                if (sarga[i][2] == 1) {
                    kezdH = sarga[i][0];
                    kezdV = sarga[i][1];
                }
            }
            for (int i = 2499; i >= 0; i--) {
                 if (sarga[i][2] == 1) {
                    vegH = sarga[i][0];
                    vegV = sarga[i][1];
                }
            }
            System.out.println("Kezd: "+kezdH+", "+kezdV);
            System.out.println("Vége: "+vegH+", "+vegV);
            System.out.println("Képpontok száma: "+osszSarga+"db");

        } catch (FileNotFoundException ex) {
            System.out.println("Nem található a file!");
        } catch (IOException ex) {
            System.out.println("Hiba az olvasásánál.");
        }
    }

}
