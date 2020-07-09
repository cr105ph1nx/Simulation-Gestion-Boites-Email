package com.application;

import com.messagerie.Message;

import java.util.Comparator;

public class MessageComparator implements Comparator {
    public int compare(Object obj1, Object obj2) {
        Message myObj1 = (Message) obj1;
        Message myObj2 = (Message) obj2;

        // Trier Date
        int dateResult = myObj1.getDateCreation().compareTo(myObj2.getDateCreation());
        if(dateResult == 0){
            // Les dates sont egaux, trier par objet
            return  myObj1.getObjet().compareTo(myObj2.getObjet());
        }else
            return dateResult;

    }

}
