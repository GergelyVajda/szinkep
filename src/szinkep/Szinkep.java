/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szinkep;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
            FileReader buta= new FileReader("kep.txt");
            BufferedReader okos= new BufferedReader(buta);
            Integer[][] pixelek= new Integer[2500][3];
            String ideiglenes="";
            String [] harmas;
            for (int i = 0; i < 2500; i++) {
                ideiglenes=okos.readLine();
                harmas=ideiglenes.split(" ");
                pixelek[i][0]=Integer.parseInt(harmas[0]);
                pixelek[i][1]=Integer.parseInt(harmas[1]);
                pixelek[i][2]=Integer.parseInt(harmas[2]);
            }
            //2
            System.out.println("2. feladat");
            Integer R=0;
            Integer G=0;
            Integer B=0;
            Scanner sc= new Scanner(System.in);
            System.out.println("Kérem adjon meg egy RGB kódot! A három színt az Enter lenyomásával válassza el egymástól!");
            System.out.println("R:");
            R=sc.nextInt();
            System.out.println("G:");
            G=sc.nextInt();
            System.out.println("B:");
            B=sc.nextInt();
            
            Integer szamolo=0;
            for (int i = 0; i < 2500; i++) {
                if (R==pixelek[i][0] && 
                    G==pixelek[i][1] && 
                    B==pixelek[i][2]) {
                    szamolo++;
                    break;
                }
            }
            if (szamolo>0) {
                System.out.println("A bekért szín megtalálható a képen.");
            }else{
            System.out.println("A bekért szín nem található meg a képen.");
            }
            //3
            //37 sor 8 pixel = 1708
            Integer szin0=pixelek[1708][0];
            Integer szin1=pixelek[1708][1];
            Integer szin2=pixelek[1708][2];
            
            Integer oszlop=0;
            Integer sor=0;
            
            for (int i = 0; i < 100; i++) {
                if ((8+50*i)>2500) {
                    break;
                }
                if (pixelek[8+50*i][0]==szin0 &&
                    pixelek[8+50*i][1]==szin1 &&
                    pixelek[8+50*i][2]==szin2) {
                    oszlop++;
                }
            }
            for (int i = 0; i < 50; i++) {
                if (pixelek[1700+i][0]==szin0 &&
                    pixelek[1700+i][1]==szin1 &&
                    pixelek[1700+i][2]==szin2) {
                    sor++;
                }
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Nem található a file!");
        } catch (IOException ex) {
            System.out.println("Hiba az olvasásánál.");
        }
    }
    
}
