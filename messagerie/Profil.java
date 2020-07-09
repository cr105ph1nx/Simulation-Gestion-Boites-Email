package com.messagerie;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Profil {
    // Attributs
    String nom, prenom;
    Genre genre;
    LocalDate date_nais;
    BigInteger tel;
    String pays;

    // Constructeurs
    public Profil(){}
    public Profil(String nom, String prenom, Genre genre, LocalDate date_naiss, BigInteger tel, String pays){
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.date_nais = date_naiss;
        this.tel = tel;
        this.pays = pays;
    }

    // Accesseurs
    public String getNom(){return this.nom;}
    public String getPrenom(){return this.prenom;}
    public Genre getGenre(){return this.genre;}
    public LocalDate getDateNaissance(){return this.date_nais;}
    public int getAge(){
        LocalDate currentDate = LocalDate.now();
        return Period.between(this.date_nais, currentDate).getYears();
    }
    public BigInteger getTel(){return this.tel;}
    public String getPays(){return this.pays;}

    // Mutateurs
    public String setNom(){
        Scanner in = new Scanner(System.in);
        String nom = "";

        do {
            System.out.print("- Nom: ");
            try {
                nom = in.nextLine();
            }catch (Exception e){
                System.out.println("Invalid Input...");
                setNom();
            }
        }while(nom.isEmpty());

        return nom;
    }
    public String setPrenom(){
        Scanner in = new Scanner(System.in);
        String prenom = "";

        do {
            System.out.print("- Prenom: ");
            try {
                prenom = in.nextLine();
            }catch (Exception e){
                System.out.println("Invalid Input...");
                setNom();
            }
        }while(prenom.isEmpty());

        return prenom;
    }
    public int setGenre(){
        Scanner in = new Scanner(System.in);
        int option = 0;

        do {
            System.out.print("- Genre (1) Feminin, (2) Masculin: ");
            try {
                option = in.nextInt();
            }catch (Exception e){
                System.out.println("Invalid Input...");
                setNom();
            }
        }while(option < 0 && option > 3);

        return option;
    }
    public LocalDate setDateNaissance(){
        LocalDate localDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        Scanner in = new Scanner(System.in);
        String date;

        try {
            do {
                System.out.print("- Date (dd/mm/yyyy): ");
                date = in.next();
            } while (date.isEmpty());

            //convert String to LocalDate
            localDate = LocalDate.parse(date, formatter);

        }catch (Exception ex){
            System.out.println("Invalid Input");
            setDateNaissance();
        }

        return localDate;
    }
    public BigInteger setTel(){
        Scanner in = new Scanner(System.in);
        BigInteger tel = new BigInteger("0");
        BigInteger zero = new BigInteger("0");

        do {
            System.out.print("- Numero de Telephone: ");
            try {
                tel = in.nextBigInteger();
            }catch (Exception ex){
                System.out.println("Invalid Input...");
                setTel();
            }
        }while(tel ==  zero);

        return tel;
    }
    public String setPays(){
        Scanner in = new Scanner(System.in);
        String pays = "";

        do {
            System.out.print("- Pays de Residence: ");
            try {
                pays = in.nextLine();
            }catch (Exception ex){
                System.out.println("Invalid Input...");
                setPays();
            }
        }while(pays.isEmpty());

        return pays;
    }

    // Methodes
    // Saisir le profil.
    public Profil Saisir(){
        this.nom = setNom();
        this.prenom = setPrenom();
        this.genre = Profil.Genre.values()[setGenre()-1];
        this.date_nais = setDateNaissance();
        this.tel = setTel();
        this.pays = setPays();

        return this;
    }
    // Verifier l'egalite entre deux profils.
    public boolean Equals(Profil profil){
        if(this == profil)
            return true;
        else
            return false;
    }
    // Afficher d'apres un format specifique.
    public String toString(){
        return(this.getPrenom() + ' ' + this.getNom());
    }

    // Inner Class
    public enum Genre{Feminin, Masculin}
}
