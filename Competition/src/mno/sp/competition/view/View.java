/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mno.sp.competition.view;

/**
 *
 * @author Mariusz Nowak
 * @version 0.0
 */
public class View {
    
    
    /**
     * The initiating constructor.
     */
    public View() {
    }

    /**
     * Method id sending welcome message to user.
     */
    public void helloUser() {
        System.out.println("Witaj w programie, który pomoże Ci obliczyć ile bedziesz potrzebować papieru aby opakować swoje paczki.");
    }
    /**
     * Method id sending incentive message to user.
     */
    public void incentiveWord() {
        System.out.println("Podaj mi pełną ścieżkę do pliku wejściowego zawierającego dane: ");
    }

    /**
     * Method id sending warning message if word is too long.
     * @param sum to show for user
     */
    public void finalSum(long sum) {
        System.out.println("Obliczyłem, że będziesz potrzebował "+ Long.toString(sum)+" dm2 papieru");
    }
  /**
     * Method is sending question to user to operate with word.
     */
    public void operateQuestion() {

        System.out.print("Czy przetwarzać zadanie? T/N :");
    }
    /**
     * Method is sending question to user to continue work.
     */
    public void continueQuestion() {

        System.out.println("Obliczymy coś jeszcze?: ");
    }
    
    public void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
}  

    /**
     * Method is sending goodbye message.
     */
    public void goodbye() {
        System.out.print("Do zobaczenia");

    }

    
}
