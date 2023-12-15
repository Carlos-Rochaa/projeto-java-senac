package application;

import services.Menu;

import java.util.Locale;

public class LojaPerifericos {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Locale.setDefault(Locale.US);

        menu.showMenu();
    }
}