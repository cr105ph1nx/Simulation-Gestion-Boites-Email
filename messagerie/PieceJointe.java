package com.messagerie;

import java.util.Scanner;

public class PieceJointe {
    // Attributs
    String nom;
    int taille;

    // Constructeurs
    public PieceJointe(){}
    public PieceJointe(String nom, int taille){
        this.nom = nom;
        this.taille = taille;
    }

    // Accesseurs
    public String getNom(){return this.nom;}
    public int getTaille(){return this.taille;}

    // Mutateurs
    public String setNom(){
        Scanner in = new Scanner(System.in);
        String nom = "";

        try {
            do {
                System.out.print("- Nom: ");
                nom = in.nextLine();
            } while (nom.isEmpty());
        }catch (Exception ex){
            System.out.println("Invaid Input...");
            setNom();
        }

        return nom;
    }
    public int setTaille(){
        Scanner in = new Scanner(System.in);
        int taille = 0;

        while(taille <= 0){
            System.out.println("- Taille: ");
            try{
                taille = in.nextInt();
            }catch (Exception ex){
                System.out.println("Invaid Input...");
                setTaille();
            }

            if(taille <= 0)
                System.out.println("Veuillez attacher une piece jointe!");
        }

        return taille;
    }

    // Methodes
    // Saisir la piece jointe.
    public PieceJointe Saisir(){
        this.nom = setNom();
        this.taille = setTaille();

        return this;
    }

    // Verifier l'egalite entre deux pieces jointes.
    public boolean Equals(PieceJointe piece){
        return (this.nom == piece.nom && this.taille == piece.taille);
    }

    // Afficher d'apres un format specifique.
    public String toString(){
        return("Nom: " + this.nom +
                "\nTaille: " + this.taille + " octets");
    }

}
