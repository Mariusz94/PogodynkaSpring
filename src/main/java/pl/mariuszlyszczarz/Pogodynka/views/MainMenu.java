package pl.mariuszlyszczarz.Pogodynka.views;

import javax.swing.*;
import java.util.Scanner;

public class MainMenu {
    private Scanner scanner;

    public MainMenu() {
        scanner = new Scanner(System.in);
    }

    public void printMenu() {
        System.out.println("=------------------------=");
        System.out.println("=---Witaj w Pogodynce---=");
    }

    public String getCityFromUser(){
        System.out.print("=--- Podaj miasto: ");
        return scanner.nextLine();
    }

    public void cleanConsole(int lines){
        for (int i = 0; i < lines; i++) {
            System.out.println();
        }
    }

    public void sendMessageToConsole(String message){
        JOptionPane.showMessageDialog(null, message);
    }
}
