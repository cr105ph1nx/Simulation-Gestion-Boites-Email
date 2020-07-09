package com.messagerie;


import java.time.LocalDate;
import java.util.LinkedList;


public class BoiteMail {
    // Attributs
    LinkedList<Message> recus = new LinkedList<>(),
            envoyes = new LinkedList<>(),
            brouillons = new LinkedList<>(),
            archives = new LinkedList<>(),
            corbeille = new LinkedList<>(),
            spam = new LinkedList<>();
    final int capacite = 10 * 1048576; // 100 Mb

    // Constructeur
    public  BoiteMail(){}
    public BoiteMail(BoiteMail boite){
        this.recus = boite.recus;
        this.envoyes = boite.envoyes;
        this.brouillons = boite.brouillons;
        this.archives = boite.archives;
        this.corbeille = boite.corbeille;
        this.spam = boite.spam;
    }

    // Accesseurs
    public LinkedList<Message> getRecus(){return this.recus;}
    public LinkedList<Message> getEnvoyes(){return this.envoyes;}
    public LinkedList<Message> getBrouillons(){return this.brouillons;}
    public LinkedList<Message> getArchives(){return this.archives;}
    public LinkedList<Message> getCorbeille(){return this.corbeille;}
    public LinkedList<Message> getSpam(){return this.spam;}
    public int getCapacite(){return this.capacite;}

    // Mutateurs
    public void setRecus(LinkedList<Message> list){this.recus = list; }
    public void setEnvoyes(LinkedList<Message> list){this.envoyes = list;}
    public void setBrouillons(LinkedList<Message> list){this.brouillons = list;}
    public void setArchives(LinkedList<Message> list){this.archives = list;}
    public void setCorbeille(LinkedList<Message> list){this.corbeille = list;}
    public void setSpam(LinkedList<Message> list){this.spam = list;}

    // Methodes
    public LinkedList<AdrMail> EnvoyerMessage(LinkedList<AdrMail> adresses, int indexExpediteur, Message message) {
        // Ajouter message au dossier envoye dans la boite de l'expediteur

        adresses.get(indexExpediteur).boite.envoyes.add(message);
        adresses.get(indexExpediteur).boite.envoyes.getLast().setEtat(Message.Etat.envoye);

        return adresses;
    }
    public LinkedList<AdrMail> EnvoyerMessage(LinkedList<AdrMail> adresses, int indexExpediteur, MessageAttach message) {
        // Ajouter message au dossier envoye dans la boite de l'expediteur
        adresses.get(indexExpediteur).boite.envoyes.add(message);
        adresses.get(indexExpediteur).boite.envoyes.getLast().setEtat(Message.Etat.envoye);

        return adresses;
    }
    public LinkedList<AdrMail> RecevoirMessage(LinkedList<AdrMail> adresses, int indexDestinataire, Message message){
        // Ajouter message au dossier recus dans la boite du destinataire
        adresses.get(indexDestinataire).boite.recus.add(message);
        adresses.get(indexDestinataire).boite.recus.getLast().setEtat(Message.Etat.non_lu);

        return adresses;
    }
    public LinkedList<AdrMail> RecevoirMessage(LinkedList<AdrMail> adresses, int indexDestinataire, MessageAttach message){
        // Ajouter message au dossier recus dans la boite du destinataire
        adresses.get(indexDestinataire).boite.recus.add(message);
        adresses.get(indexDestinataire).boite.recus.getLast().setEtat(Message.Etat.non_lu);

        return adresses;
    }
    public LinkedList<AdrMail> OuvrirMessage(LinkedList<AdrMail> adresses, int indexAdrMail, int indexMessage){
        BoiteMail boite = adresses.get(indexAdrMail).boite;

        if(boite.getRecus().get(indexMessage) instanceof MessageAttach){
            MessageAttach message = (MessageAttach) boite.getRecus().get(indexMessage);
            message.setEtat(Message.Etat.lu);

        }else{
            Message message = boite.getRecus().get(indexMessage);
            message.setEtat(Message.Etat.lu);
        }

        System.out.println(boite.getRecus().get(indexMessage));
        return adresses;
    }
    public LinkedList<AdrMail> SupprimerMessage(LinkedList<AdrMail> adresses, int indexAdrMail, int indexMessage){
        if(adresses.get(indexAdrMail).boite.getRecus().get(indexMessage) instanceof MessageAttach){
            // Sauvegarder message
            MessageAttach message = (MessageAttach) adresses.get(indexAdrMail).boite.getRecus().get(indexMessage);
            // Supprimer de Recus
            adresses.get(indexAdrMail).boite.recus.remove(message);
            // Ajouter a Corbeille
            adresses.get(indexAdrMail).boite.corbeille.add(message);
            message.setEtat(Message.Etat.supprime);
        }else{
            // Sauvegarder message
            Message message = adresses.get(indexAdrMail).boite.getRecus().get(indexMessage);
            // Supprimer de Recus
            adresses.get(indexAdrMail).boite.recus.remove(message);
            // Ajouter a Corbeille
            adresses.get(indexAdrMail).boite.corbeille.add(message);
            message.setEtat(Message.Etat.supprime);
        }

        return adresses;
    }
    public void DetruireMessage(Message message){
        // Supprimer message de corbeille
        corbeille.remove(message);
    }
    public void DeplacerMessage(Message message){
        // Supprimer de spam
        spam.remove(message);
        // Ajouter dans recus
        message.setEtat(Message.Etat.non_lu);
        recus.add(message);
    }
    public LinkedList<AdrMail> ArchiverMessage(LinkedList<AdrMail> adresses, int indexAdrMail, LocalDate date){
        int k, c = 0;

        int sizeMsg = adresses.get(indexAdrMail).boite.recus.size();
        for (k = 0; k < sizeMsg; k++) {
            if (adresses.get(indexAdrMail).boite.recus.get(k).getDateCreation().compareTo(date) < 0) {
                // Archiver
                c++;
                if(adresses.get(indexAdrMail).boite.getRecus().get(k) instanceof MessageAttach){
                    // Sauvegarder message
                    MessageAttach message = (MessageAttach) adresses.get(indexAdrMail).boite.getRecus().get(k);
                    // Supprimer de Recus
                    adresses.get(indexAdrMail).boite.recus.remove(k);
                    sizeMsg--;
                    // Ajouter a Archives
                    adresses.get(indexAdrMail).boite.archives.add(message);
                    message.setEtat(Message.Etat.archive);
                }else{
                    // Sauvegarder message
                    Message message = adresses.get(indexAdrMail).boite.getRecus().get(k);
                    // Supprimer de Recus
                    adresses.get(indexAdrMail).boite.recus.remove(k);
                    sizeMsg--;
                    // Ajouter a Corbeille
                    adresses.get(indexAdrMail).boite.archives.add(message);
                    message.setEtat(Message.Etat.archive);
                }
            }
        }
        if(c == 0)
            System.out.println("Aucun message recu avant cette date...");

        return adresses;
    }
    public LinkedList<AdrMail> RestaurerMessage(LinkedList<AdrMail> adresses, int indexAdrMail, int indexMessage){

        if(adresses.get(indexAdrMail).boite.getRecus().get(indexMessage) instanceof MessageAttach){
            // Sauvegarder message
            MessageAttach message = (MessageAttach) adresses.get(indexAdrMail).boite.getCorbeille().get(indexMessage);
            // Supprimer de Corbeille
            adresses.get(indexAdrMail).boite.corbeille.remove(message);
            // Ajouter a Recu
            adresses.get(indexAdrMail).boite.recus.add(message);
            message.setEtat(Message.Etat.recu);
        }else{
            // Sauvegarder message
            Message message = adresses.get(indexAdrMail).boite.getCorbeille().get(indexMessage);
            // Supprimer de Corbeille
            adresses.get(indexAdrMail).boite.corbeille.remove(message);
            // Ajouter a Recu
            adresses.get(indexAdrMail).boite.recus.add(message);
            message.setEtat(Message.Etat.recu);
        }

        return adresses;
    }

    public void CreerMessage(){
        // Creer le message
        Message message = new Message();
        message.Creer();

        // Stocker le message dans le dossier brouillons
        message.setEtat(Message.Etat.brouillon);
        brouillons.add(message);

        // Calculer
        if(EspaceUtilise()*100/getCapacite() == 80)
            System.out.println("La taille des message a atteint 80% de la capacite de stockage de la boite.\n" +
                                "Vous devez supprimer quelques messages.");

    }
    public int EspaceUtilise(){
        int espaceUtilise = 0;
        int i;
        int sizeRecu = NombreRecus();
        int sizeEnvoyes = NombreEnvoyes();
        int sizeBrouillons = NombreBrouillon();
        int sizeArchives = NombreArchives();
        int sizeCorbeille = NombreCorbeille();
        int sizeSpam = NombreSpams();

        for(i = 0; i < sizeRecu; i++)
            espaceUtilise = espaceUtilise + getRecus().get(i).getTaille();

        for(i = 0; i < sizeEnvoyes; i++)
            espaceUtilise = espaceUtilise + getEnvoyes().get(i).getTaille();

        for(i = 0; i < sizeBrouillons; i++)
            espaceUtilise = espaceUtilise + getBrouillons().get(i).getTaille();

        for(i = 0; i < sizeArchives; i++)
            espaceUtilise = espaceUtilise + getArchives().get(i).getTaille();

        for(i = 0; i < sizeCorbeille; i++)
            espaceUtilise = espaceUtilise + getCorbeille().get(i).getTaille();

        for(i = 0; i < sizeSpam; i++)
            espaceUtilise = espaceUtilise + getSpam().get(i).getTaille();

        return espaceUtilise;
    }
    public int EspaceRestant(){
        return(getCapacite() - EspaceUtilise());
    }

    public int NombreRecus(){ return recus.size();}
    public int NombreEnvoyes(){ return envoyes.size();}
    public int NombreBrouillon(){ return brouillons.size();}
    public int NombreArchives(){ return archives.size();}
    public int NombreCorbeille(){ return corbeille.size();}
    public int NombreSpams(){ return spam.size();}

    // Exceptions
    public static class ExceptionDestinataireIncorrecte extends Exception {
        public ExceptionDestinataireIncorrecte(String message) {
            super(message);
        }
    }
    public static class ExceptionDebordementBoite extends  Exception{
        public ExceptionDebordementBoite(String message){super(message);}
    }
}
