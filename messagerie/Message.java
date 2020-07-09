package com.messagerie;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Message {
    // Attributs
    String objet;
    String contenu;
    LocalDate date_crt;
    LocalTime heure_crt;
    Etat etat;
    int taille;
    AdrMail expediteur;

    // Constructeur
    public Message(){}
    public Message(String objet, String contenu){
        this.objet = objet;
        this.contenu = contenu;
    }
    public Message(Message message){
        this.objet = message.objet;
        this.contenu = message.contenu;
        this.date_crt = message.date_crt;
        this.heure_crt = message.heure_crt;
        this.etat = message.etat;
        this.taille = message.taille;
    }
    public Message(String objet, String contenu, LocalDate date_crt, LocalTime heure_crt, Etat etat, int taille){
        this.objet = objet;
        this.contenu = contenu;
        this.date_crt = date_crt;
        this.heure_crt = heure_crt;
        this.etat = etat;
        this.taille = taille;
    }

    // Accesseurs
    public String getObjet(){return this.objet;}
    public String getContenu(){return this.contenu;}
    public LocalDate getDateCreation(){return this.date_crt;}
    public LocalTime getHeureCreation(){return this.heure_crt;}
    public Etat getEtat(){return this.etat;}
    public int getTaille(){return this.taille;}
    public AdrMail getExpediteur() {
        return expediteur;
    }

    // Mutateurs
    public void setObjet() throws ExceptionMessageVide{
        Scanner in = new Scanner(System.in);
        String objet = "";

        System.out.print("- Objet: ");
        try {
            objet = in.nextLine();
        }catch (Exception e){
            System.out.println("Invalid Input...");
            setContenu();
        }

        if(objet.isEmpty())
            throw new ExceptionMessageVide("Objet ne peut pas etre vide...");

        this.objet = objet;
    }
    public void setContenu() throws ExceptionMessageVide {
        Scanner in = new Scanner(System.in);
        String contenu = "";

        System.out.print("- Contenu: ");
        try {
            contenu = in.nextLine();
        }catch (Exception e){
            System.out.println("Invalid Input...");
            setContenu();
        }

        if(contenu.isEmpty())
            throw new ExceptionMessageVide("Contenu ne peut pas etre vide...");

        this.contenu = contenu;
    }
    public void setTaille(Message message){
        byte[] a = message.objet.getBytes(StandardCharsets.UTF_8); // Construire un byte array a partir de String objet
        byte[] b = message.contenu.getBytes(StandardCharsets.UTF_8); // Construire un byte array a partir de String contenu
        int taille = a.length + b.length; // Faire la somme de la taille des bytes array respectifs

        if(message instanceof MessageAttach){
            // Est un message attache, ajouter la taille des pieces jointes
            MessageAttach instance = new MessageAttach();
            taille = taille + instance.getTaille(((MessageAttach) message).getPiecesJointes());
        }
        this.taille = taille;
    }
    public void setEtat(Etat etat){
        this.etat = etat;
    }
    public void setExpediteur(AdrMail adrMail){
        this.expediteur = adrMail;
    }
    // Methodes
    // Creer un message.
    public Message Creer(){
        Message message = new Message();
        // Saisir l'objet et le contenu du message
        try {
            message.setObjet();
        }catch (ExceptionMessageVide ex){
            System.out.println(ex.getMessage());
            Creer();
        }

        try {
            message.setContenu();
        }catch (ExceptionMessageVide ex){
            System.out.println(ex.getMessage());
            Creer();
        }

        // Recuperer la taille a partir des strings objet et contenu
        message.setTaille(message);
        // Creer le message
        message.setEtat(Etat.cree);
        message.date_crt = LocalDate.now();
        message.heure_crt = LocalTime.now();


        return message;
    }
    public MessageAttach CreerAvecAttach(Message message){
        // Creer l'ensemble de piece jointes
        MessageAttach tmp = new MessageAttach(message.objet, message.contenu);

        try{
            tmp = tmp.Saisir();
        }catch (MessageAttach.ExceptionExceedsTailleLimite | MessageAttach.ExcepetionPieceRepetition ex){
            System.out.println(ex.getMessage());
            tmp = CreerAvecAttach(message);
        }

        // Recuperer la taille a partir des string objet et contenu, et l'ensemble des pieces jointes
        message.taille = message.taille + tmp.getTaille();

        // Creer le message
        message.etat = Etat.cree;
        message.date_crt = LocalDate.now();
        message.heure_crt = LocalTime.now();

        // Creer le message attache
        return new MessageAttach(message.objet, message.contenu, message.date_crt, message.heure_crt, message.etat, message.taille,
        tmp.getPiecesJointes());
    }
    // Afficher contenu du message.
    public void Afficher(){
        System.out.println("Etat du message: " + getEtat().name() + "\t\t\t\t\tEnvoye le " + getDateCreation().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " a " + getHeureCreation().toString());
        System.out.println("Par: " + getExpediteur().getPrenom() + " " + getExpediteur().getNom());
        System.out.println("Objet: " + getObjet());
        System.out.println("Contenu: " + getContenu());
        System.out.println("Taille: " + getTaille() + " octets");
    }
    // Modifier contenu ou objet d'un message avant l'envoi.
    public Message Modifier(){
        // On ne peut modifier que le contenu ou l'objet des message qui ne sont pas encore envoye, ou les messages qui ne
        // sont pas recus, supprimes, archives
        if(getEtat() != Etat.envoye && getEtat() != Etat.recu && getEtat() != Etat.supprime && getEtat() != Etat.archive){
            // Message peut etre modifier
            // Demander si on veut modifier l'objet ou le contenu
            int option;
            Scanner in = new Scanner(System.in);
            do {
                System.out.println("Que voulez-vous modifier? (1) Objet, (2) Contenu");
                option = in.nextInt();
            }while(option<1 || option>2);

            if(option == 1){
                // Modifier l'objet
                try {
                    this.setObjet();
                }catch (ExceptionMessageVide ex){
                    System.out.println(ex.getMessage());
                    Modifier();
                }
            }else{
                // Modifier le contenu
                try {
                    this.setContenu();
                }catch (ExceptionMessageVide ex){
                    System.out.println(ex.getMessage());
                    Modifier();
                }
            }
        }else{
            // On ne peut pas modifier ce message
            System.out.format("Ce message est %s, il ne peut pas etre modifier.", getEtat().name());
        }
        return this;
    }
    // Verifier l'egalite entre deux messages.
    public boolean Equals(Message message){
        return this == message;
    }
    // Afficher d'apres un format specifique.
    public String toString(){
        return("Etat du message: " + getEtat().name() + "\t\t\t\t\tEnvoye le " + getDateCreation().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " a " + getHeureCreation().toString() +
        "\nPar: " + getExpediteur().getPrenom() + " " + getExpediteur().getNom() + "(" + getExpediteur().toString() + ")" +
        "\nObjet: " + getObjet() +
        "\nContenu: " + getContenu() +
        "\nTaille: " + getTaille() + " octets\n\n");
    }

    // Inner Class
    public enum Etat{non_lu, envoye, brouillon, archive, supprime, stocke, en_cours, retourne, lu, recu, cree}

    public static class ExceptionMessageVide extends Exception{
        public ExceptionMessageVide(String message){super(message);}
    }
}
