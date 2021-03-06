package main;

import java.util.*;
import java.io.*;

public class Grid {

    final String startingGame = "Quelle colonne choisissez-vous ?";
	final String winGame = "Vous avez gagné la partie !";
	final String loseGame = "Vous avez perdu la partie !";
	final String drawGame = "Egalité pour tous les joueurs";

	String ChooseColumn() {

        System.out.println(startingGame);
        System.out.print(">> ");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try{
            String value = br.readLine();
            if(value.charAt(0) >= 'a' && value.charAt(0) <= 'h'){
                System.out.println(value);
            } else {
                throw new IOException("\nErreur ! Choississez une colonne valable\n");
            }
            if(value.chars().count() <= 1){
                System.out.println(value);
            } else {
                throw new IOException("\nVous ne pouvez choisir qu'une seul colonne a la fois, veuillez ressayez !\n");
            }
            return value;
        }
        catch(IOException e){
            System.err.println(e.getMessage());
            return ChooseColumn();
        }
	}

    static int vertical;
    static int horizontal;
    static char [][] grille;
    String choixJoueur;

    public Grid(int h, int v){

        vertical = v;
        horizontal = h;
        grille = new char[vertical][horizontal]; 

    }

    public void playTurn(int tour) {
        this.choixJoueur = ChooseColumn();
        int choixInt = choixJoueur.charAt(0) - 'a';
        boolean validColonne = false;
        
            for(int i = grille.length-1; i >= 0; i--){
                if(grille[i][choixInt] == '\0'){// verifie si la case n'est pas prise
                    grille[i][choixInt] = tour%2 == 1 ? 'X' : 'O'; // si tour est impair/pair alors c'est au tour de tel joueur ...( X / O)
                    validColonne = true;
                    break;
                }
            } 
            if(!validColonne){
                System.out.println("Colonne est deja prise");
                playTurn(tour);
            }  
            
    }

    public void victoryPlayerVertical(char joueurPion) {

        int choixInt = choixJoueur.charAt(0) - 'a';
        boolean victory = false;
        
        //vertical
         
        int alignTokens = 0;
        int i = 5;
        
        while ((alignTokens<4) && (i>=0)){
			if (grille[i][choixInt]==joueurPion){
				alignTokens ++;
				i --;
			}else{
				alignTokens = 0;
				i --;
			}
        }
        if(alignTokens == 4){
            System.out.println("\n");
            System.out.println("----------------------------------------------------");
            System.out.println("        Le joueur " + joueur + " a gagne !          ");
            System.out.println("----------------------------------------------------");
            System.exit(0);
        }

    }

    public void victoryPlayerHorizontal(char joueurPion) {

        int choixInt = choixJoueur.charAt(0) - 'a';
        boolean victory = false;

        int alignTokens = 0;
        
        //horizontal
        for(int i = 2; i < 5; i++){
            for(choixInt = 5; choixInt>= 1; choixInt--){
                if (grille[i][choixInt] == joueurPion){
                    alignTokens ++;
                }else{
                    alignTokens = 0;
				    choixInt --;
                }
            }
        }
        if(alignTokens == 4){
            System.out.println("\n");
            System.out.println("----------------------------------------------------");
            System.out.println("             Le joueur " + joueur + " a gagne !          ");
            System.out.println("----------------------------------------------------");
            System.exit(0);
        }

    }

    
    public void afficheGrid() {

        System.out.println();
       
        for(int i = 0; i < vertical; i++){
            System.out.print("|");
            for (int j = 0; j < horizontal; j++){
        
                System.out.print(grille[i][j] + "|");

            }
            System.out.println(" ");

        }
        System.out.print("-----------------");
        System.out.println();
        System.out.print(" a b c d e f g h ");
    }

    public void dispStartingGame() {

		System.out.println("Vous avez choisis la colonne : " + choixJoueur);
		System.out.println("---------------------");

	}
}
