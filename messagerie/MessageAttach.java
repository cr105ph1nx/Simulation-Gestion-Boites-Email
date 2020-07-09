package com.messagerie;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Scanner;

public class MessageAttach extends Message{
    // Attributs
    LinkedList<PieceJointe> piecesJointes = new LinkedList<PieceJointe>();
    final int limit = 1048576; //10 Mb

    // Constructeurs
    public MessageAttach(){}
    public MessageAttach(String objet, String contenu){
        super(objet, contenu);
    }
    public MessageAttach(String objet, String contenu, LocalDate date_crt, LocalTime heure_crt, Etat etat, int taille,
                  LinkedList<PieceJointe> pieceJointes){

        super(objet, contenu, date_crt, heure_crt, etat, taille);
        this.piecesJointes = pieceJointes;
    }

    // Accesseurs
    public LinkedList<PieceJointe> getPiecesJointes(){return this.piecesJointes;}
    public int getTaille(LinkedList<PieceJointe> pieceJointes){
        int taille = 0;
        int i, size = piecesJointes.size();

        for(i = 0; i<size; i++)
            taille = taille + pieceJointes.get(i).getTaille();

        return taille;
    }

    // Methodes
    // Saisir le message attache.
    public MessageAttach Saisir() throws ExcepetionPieceRepetition, ExceptionExceedsTailleLimite{
        MessageAttach message_att = new MessageAttach();
        Scanner in = new Scanner(System.in);
        short n = 0;
        int i;

        do{
            System.out.print("- Combien de pieces jointes voulez-vous attacher? ");
            try {
                n = in.nextShort();
            }catch (Exception e){
                System.out.println("Invalid Input...");
                Saisir();
            }
        }while(n <= 0);

        LinkedList<PieceJointe> pieces = new LinkedList<PieceJointe>();
        for(i = 0; i < n; i++){
            PieceJointe piece = new PieceJointe();
            piece = piece.Saisir();
            if (pieces.contains(piece)) {
                throw new ExcepetionPieceRepetition("Vous avez deja attache cette piece jointe!");
            } else if (getTaille(pieces) + piece.getTaille() >= limit) {
                throw new ExceptionExceedsTailleLimite("Vous avez atteint la limite autorisee!");
            }else
                pieces.add(piece);
        }

        message_att.piecesJointes = pieces;

        return message_att;
    }
    // Verifier l'egalite entre deux messages attaches.
    public boolean Equals(MessageAttach message){
        if(this == message)
            return true;
        else
            return false;
    }

    // Exceptions
    static class ExcepetionPieceRepetition extends Exception {
        public ExcepetionPieceRepetition(String message) {
            super(message);
        }
    }
    static class ExceptionExceedsTailleLimite extends Exception {
        public ExceptionExceedsTailleLimite(String message) {
            super(message);
        }
    }
}
