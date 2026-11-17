/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sie;

/**
 *
 * @author plazo
 */
public class test {

    public static void main(String[] args) {
        System.out.println("holi");
        metodoIncreible(1, 2, 3);
        metodoIncreible(1);
        metodoIncreible(1, 2, 3, 4, 5, 6);
    }

    public static void metodoIncreible(int... valor) {
        for(int v : valor){
            System.out.println("multiples valores ingresado : " + v);
        }
         System.out.println("===========");
    }
}
