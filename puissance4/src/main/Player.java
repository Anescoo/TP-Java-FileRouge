package main;

public class Player {

    final String startingGame = "Quelle colonne choisissez-vous \n";
    final String winGame = "Vous avez gagne la partie !\n";
    final String loseGame = "Vous avez perdu la partie !\n";
    final String drawGame = "Egalite pour tous les joueurs\n";

    public void display() {

        System.out.println(startingGame);
        System.out.println(winGame);
        System.out.println(loseGame);
        System.out.println(drawGame);
    }
}

