package com.application;
import com.messagerie.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import static java.lang.System.exit;


public class AppMessagerie {
    LinkedList<AdrMail> adresses = new LinkedList<>();
    LinkedList<AdrMail> adrPublics = new LinkedList<>();
    LinkedList<AdrMail> adrPros = new LinkedList<>();
    LinkedList<Message> messages = new LinkedList<>();

    // Methodes du Menu
    void CreationAdrMail() {
        BoiteMail boite = null;

        if (adresses.size() == 0) {
            Profil profil = new Profil("Lea", "Merabet", Profil.Genre.Feminin, LocalDate.of(1999, 1, 8), new BigInteger("05557840230"), "Algeria");
            adresses.add(new AdrMail("leamea12", "hotmail.fr", "Kokobop_1299", profil, boite));

            profil = new Profil("Jacob", "Smith", Profil.Genre.Masculin, LocalDate.of(2001, 4, 5), new BigInteger("07232597527"), "United States");
            adresses.add(new AdrMail("jacob78", "yahoo.fr", "UCpbH8FZJ9BfNkC6", profil, boite));

            profil = new Profil("Moussa", "Fateh", Profil.Genre.Masculin, LocalDate.of(1998, 3, 2), new BigInteger("0667549620"), "Algeria");
            adresses.add(new AdrMail("moussa.fateh", "gmail.com", "9PtLAPRQHbhd2NGX", profil, boite));

            profil = new Profil("Schahrazed", "Mehamli", Profil.Genre.Feminin, LocalDate.of(1989, 7, 22), new BigInteger("0775632145"), "Algeria");
            adresses.add(new AdrMail("schahrazed.meha", "outlook.com", "MV8HmEm3", profil, boite));

            profil = new Profil("Sameh", "Hebish", Profil.Genre.Masculin, LocalDate.of(1980, 6, 25), new BigInteger("08494787643"), "Egypt");
            adresses.add(new AdrMailProf("s.hebish", "powering.com", "2wENyCVS", profil, boite, "Powering", AdrMailProf.Domaine.production));

            profil = new Profil("Alaa", "Meghenni", Profil.Genre.Feminin, LocalDate.of(1993, 12, 15), new BigInteger("04544322980"), "Switzerland");
            adresses.add(new AdrMail("alaa.meha", "gmail.com", "crowl0v3rSh_", profil, boite));

            profil = new Profil("Lilia", "Mehamli", Profil.Genre.Feminin, LocalDate.of(2001, 02, 19), new BigInteger("0556321420"), "Algeria");
            adresses.add(new AdrMail("lilia.mehamli", "protonmail.com", "A99l3Pi30", profil, boite));

            profil = new Profil("Amir", "Sakouti", Profil.Genre.Masculin, LocalDate.of(1998, 8, 21), new BigInteger("05500210030"), "Algeria");
            adresses.add(new AdrMail("amir_sakou", "live.com", "Tby86_kx69s", profil, boite));

            profil = new Profil("George", "Crowder", Profil.Genre.Masculin, LocalDate.of(1997, 1, 5), new BigInteger("07095656418"), "England");
            adresses.add(new AdrMailProf("g.crowder", "openmindsclub.net", "ZjegfTUG", profil, boite, "OpenMindsClub", AdrMailProf.Domaine.education));

            profil = new Profil("Nawel", "Imad-eddine", Profil.Genre.Feminin, LocalDate.of(1969, 2, 13), new BigInteger("07095656418"), "England");
            adresses.add(new AdrMailProf("n.imad_eddine", "sonatrach.dz", "RIaridThOyBo", profil, boite, "Sonatrach", AdrMailProf.Domaine.production));

            profil = new Profil("Zahraa", "Kareem", Profil.Genre.Feminin, LocalDate.of(1963, 3, 14), new BigInteger("05500555060"), "Algeria");
            adresses.add(new AdrMailProf("zahraa.kareem", "usthb.etu.dz", "POiliNtaNGLO", profil, boite, "University of Sciences and Technology Houari Boumediene", AdrMailProf.Domaine.recherche));

            profil = new Profil("Fox", "Levine", Profil.Genre.Feminin, LocalDate.of(1996, 11, 25), new BigInteger("07237491238"), "United States");
            adresses.add(new AdrMailProf("fox.levine", "mit.etu.us", "oISEworKONAp", profil, boite, "Massachusetts Institute of Technology", AdrMailProf.Domaine.enseignement_superieur));

            profil = new Profil("Ashton", "Ford", Profil.Genre.Masculin, LocalDate.of(1973, 12, 1), new BigInteger("07274257502"), "United States");
            adresses.add(new AdrMailProf("a.ford", "spire.us", "STeRUeretIal", profil, boite, "Spire Healthcare", AdrMailProf.Domaine.sante));

            profil = new Profil("Mariah", "Hull", Profil.Genre.Feminin, LocalDate.of(1964, 8, 2), new BigInteger("07093306005"), "England");
            adresses.add(new AdrMailProf("m.hull", "geneva.en", "xAnTrUncOCHe", profil, boite, "Geneva Hospitals", AdrMailProf.Domaine.sante));

            profil = new Profil("Vlad", "Robles", Profil.Genre.Masculin, LocalDate.of(1996, 4, 16), new BigInteger("03294762363"), "Germany");
            adresses.add(new AdrMailProf("vlad.robles", "junction.com", "SyClOCiFiShe", profil, boite, "Junction", AdrMailProf.Domaine.education));

            System.out.println("Repertoire des adresses mail crees!");
        }else{
            System.out.println("Repertoire des adresses mail a deja ete crees...");
        }
    }
    void AjouterAdrMail(){
        Scanner in = new Scanner(System.in);
        System.out.println("Voulez-vous ajouter une adresse:\n" +
                "1. Professionelle\n" +
                "2. Non-Professionelle");
        System.out.print(">>> ");
        int option = 0;
        try {
            do {
                option = in.nextInt();
            } while (option > 2 || option < 1);

        }catch (Exception e){
            System.out.println("Invalid Input...");
            AjouterAdrMail();
        }
            switch (option) {
                case 1: // Professionelle
                    AdrMailProf adrMailProf = new AdrMailProf();
                    adrMailProf = adrMailProf.Saisir();
                    adrMailProf.setBoiteMail(null);
                    if (!adresses.contains(adrMailProf))
                        adresses.add(adrMailProf);
                    else
                        System.out.print("Cette adresse mail existe deja dans le repertoire des adresses...");
                    break;
                case 2: // Non-Professionelle
                    AdrMail adrMail = new AdrMail();
                    adrMail = adrMail.Saisir();
                    adrMail.setBoiteMail(null);
                    if (!adresses.contains(adrMail))
                        adresses.add(adrMail);
                    else
                        System.out.print("Cette adresse mail existe deja dans le repertoire des adresses...");
                    break;
            }
    }
    void ModifierAdrMail(){
        int indexAdrMail = 0;
        try{
            indexAdrMail = CheckAdrMail();
        } catch (BoiteMail.ExceptionDestinataireIncorrecte ex){
            System.out.println(ex.getMessage());
            SupprAdrMail();
        }

        if(adresses.get(indexAdrMail) instanceof AdrMailProf){
            // AdrMail Professionelle
            AdrMailProf newAdrMailProf = new AdrMailProf();
            System.out.println("Saisir les nouvelles informations de l'adresse: ");
            newAdrMailProf = newAdrMailProf.Saisir();
            adresses.set(indexAdrMail, newAdrMailProf);
        }else{
            // AdrMail non Professionelle
            AdrMail newAdrMail = new AdrMail();
            System.out.println("Saisir les nouvelles informations de l'adresse: ");
            newAdrMail = newAdrMail.Saisir();
            adresses.set(indexAdrMail, newAdrMail);
        }
    }
    void SupprAdrMail() {
        int indexAdrMail = 0;
        try{
            indexAdrMail = CheckAdrMail();
        } catch (BoiteMail.ExceptionDestinataireIncorrecte ex){
            System.out.println(ex.getMessage());
            SupprAdrMail();
        }

        // Adresse correct
        adresses.remove(indexAdrMail-1);
    }
    void AffichageAdrMail(){
        int i, j, size = adresses.size();

        AdrMail adrMail;
        AdrMailProf adrMailProf = new AdrMailProf();
        AdrMailProf.Domaine[] values = AdrMailProf.Domaine.values();
        LinkedList<AdrMail> tmpAdr = adresses;

        System.out.println("Les adresses non-professionelles: ");
        for(i = 0; i < size; i++){
            adrMail = new AdrMail(tmpAdr.get(i));
            if(!(tmpAdr.get(i) instanceof AdrMailProf)) {
                System.out.println("\t" + adrMail.toString());
                tmpAdr.remove(adrMail);
            }
        }

        System.out.println("Les adresses professionelles: ");
        for(j = 0; j < 5; j++){
            System.out.println("\tDomaine de " + values[j].name() + " :");
            for(i = 0; i < size; i++){
                adrMail = new AdrMail(tmpAdr.get(i));
                if(tmpAdr.get(i) instanceof AdrMailProf){
                    if(adrMailProf.getDomaine((AdrMailProf) tmpAdr.get(i)) == values[j]){
                        System.out.println("\t\t" + adrMail.toString());
                        tmpAdr.remove(adrMail);
                    }
                }
            }
        }
    }
    void CreationBoitesMail() {
        int sizeAdr = adresses.size();
        int i;

        LinkedList<Message> tmpList;
        BoiteMail boite = new BoiteMail();

        Profil profil = new Profil("Messagerie", "Employe", Profil.Genre.Masculin, LocalDate.of(1998, 1, 8), new BigInteger("02126984520"), "Algeria");
        AdrMail expediteur = new AdrMail("welcome", "contact.com", "Fndsf841_sds", profil, boite);
        Message message = new Message(
                "Bienvenu!",
                "\nBonjour," +
                        "\n     Nous sommes très heureux de vous accueillir en tant que nouvel utilisateur de notre messagerie.\n" +
                        "Nous espérons que vous apprécierez l'utilisation et que nous vous aiderons à atteindre ce que vous visez!",
                LocalDate.now(),
                LocalTime.now(),
                Message.Etat.non_lu,
                0);
        message.setTaille(message);
        message.setExpediteur(expediteur);

        for (i = 0; i < sizeAdr; i++) {
            // Boite par Boite
            boite = new BoiteMail();
            tmpList = new LinkedList<>();
            tmpList.add(message);
            boite.setRecus(tmpList);

            // Associer la boitemail a l'adresse email
            if (adresses.get(i) instanceof AdrMailProf) {
                AdrMailProf adrMailProf = new AdrMailProf((AdrMailProf) adresses.get(i));
                adrMailProf.setBoiteMail(boite);
                adresses.set(i, adrMailProf);
            } else {
                AdrMail adresse = new AdrMail(adresses.get(i));
                adresse.setBoiteMail(boite);
                adresses.set(i, adresse);
            }
        }
    }
    void AjouterBoiteMail(){
        // Demander saisie d'une adresse email
        AdrMailProf adrMailProf;
        AdrMail adrMail;

        // Recupere l'adresse associee
        System.out.println("Saisir l'adresse a laquelle vous voulez ajouter une boite ");
        int indexAdrMail = 0;
        try{
            indexAdrMail = CheckAdrMail();
        } catch (BoiteMail.ExceptionDestinataireIncorrecte ex){
            System.out.println(ex.getMessage());
            SupprAdrMail();
        }

        // Verifier si l'adresse email a une boite mail associe
        if(adresses.get(indexAdrMail).getBoite() == null){
            LinkedList<Message> tmpList;
            BoiteMail boite = new BoiteMail();

            Profil profil = new Profil("Messagerie", "Employe", Profil.Genre.Masculin, LocalDate.of(1998, 1, 8), new BigInteger("02126984520"), "Algeria");
            AdrMail expediteur = new AdrMail("welcome", "contact.com", "Fndsf841_sds", profil, boite);
            Message message = new Message(
                    "Bienvenu!",
                    "\nBonjour," +
                            "\n     Nous sommes très heureux de vous accueillir en tant que nouvel utilisateur de notre messagerie.\n" +
                            "Nous espérons que vous apprécierez l'utilisation et que nous vous aiderons à atteindre ce que vous visez!",
                    LocalDate.now(),
                    LocalTime.now(),
                    Message.Etat.non_lu,
                    0);
            message.setTaille(message);
            message.setExpediteur(expediteur);

                // Boite par Boite
            boite = new BoiteMail();
            tmpList = new LinkedList<>();
            tmpList.add(message);
            boite.setRecus(tmpList);

                // Associer la boitemail a l'adresse email
            if (adresses.get(indexAdrMail) instanceof AdrMailProf) {
                adrMailProf = new AdrMailProf((AdrMailProf) adresses.get(indexAdrMail));
                adrMailProf.setBoiteMail(boite);
                adresses.set(indexAdrMail, adrMailProf);
            } else {
                AdrMail adresse = new AdrMail(adresses.get(indexAdrMail));
                adresse.setBoiteMail(boite);
                adresses.set(indexAdrMail, adresse);
            }

            // Associer la boitemail a l'adresse email
            if(adresses.get(indexAdrMail) instanceof AdrMailProf){
                adrMailProf = new AdrMailProf((AdrMailProf) adresses.get(indexAdrMail));
                adrMailProf.setBoiteMail(boite);
                adresses.set(indexAdrMail, adrMailProf);
            }else{
                adrMail = new AdrMail(adresses.get(indexAdrMail));
                adrMail.setBoiteMail(boite);
                adresses.set(indexAdrMail, adrMail);
            }

            System.out.println("Boite mail ajoutee!");
        }else{
            // Elle a deja une boite mail associee.
            System.out.println("Cette adresse mail possede deja une boite!");
        }
    }
    void AffichageBoitesMail(){
        int sizeAdr = adresses.size();
        int i, j, k, size;

        BoiteMail boite;
        int totalEtat = 6;

        for(i = 0; i < sizeAdr; i++){
            // Boite par Boite
            System.out.print(adresses.get(i).getProfil());
            System.out.println(" (" + adresses.get(i)+") ");

            try{
                boite = new BoiteMail(adresses.get(i).getBoite());

                for(j = 0; j < totalEtat; j++){
                    // Dossier par Dossier
                    if(j == 0){
                        size = boite.getRecus().size();
                        System.out.println("********************************************************************************");
                        System.out.println("\t\t\t\t\t\t\t\tDossier Recus: ");
                        System.out.println("********************************************************************************");
                        for(k = 0; k < size; k++) {
                            Message message = boite.getRecus().get(k);
                            System.out.println(message);
                        }
                        if(size == 0) System.out.println("\t\t\t\t\t\t\t</ Dossier vide />\n\n");
                    }else if(j == 1){
                        size = boite.getEnvoyes().size();
                        System.out.println("********************************************************************************");
                        System.out.println("\t\t\t\t\t\t\t\tDossier Envoyes: ");
                        System.out.println("********************************************************************************");
                        for(k = 0; k < size; k++) {
                            Message message = boite.getEnvoyes().get(k);
                            System.out.println(message);
                        }
                        if(size == 0) System.out.println("\t\t\t\t\t\t\t</ Dossier vide />\n\n");
                    }else if(j == 2) {
                        size = boite.getBrouillons().size();
                        System.out.println("********************************************************************************");
                        System.out.println("\t\t\t\t\t\t\t\tDossier Brouillons: ");
                        System.out.println("********************************************************************************");
                        for(k = 0; k < size; k++) {
                            Message message = boite.getBrouillons().get(k);
                            System.out.println(message);
                        }
                        if(size == 0) System.out.println("\t\t\t\t\t\t\t</ Dossier vide />\n\n");
                    }else if(j == 3) {
                        size = boite.getArchives().size();
                        System.out.println("********************************************************************************");
                        System.out.println("\t\t\t\t\t\t\t\tDossier Archives: ");
                        System.out.println("********************************************************************************");
                        for(k = 0; k < size; k++) {
                            Message message = boite.getArchives().get(k);
                            System.out.println(message);
                        }
                        if(size == 0) System.out.println("\t\t\t\t\t\t\t</ Dossier vide />\n\n");
                    }else if(j == 4) {
                        size = boite.getCorbeille().size();
                        System.out.println("********************************************************************************");
                        System.out.println("\t\t\t\t\t\t\t\tDossier Corbeille: ");
                        System.out.println("********************************************************************************");
                        for(k = 0; k < size; k++) {
                            Message message = boite.getCorbeille().get(k);
                            System.out.println(message);
                        }
                        if(size == 0) System.out.println("\t\t\t\t\t\t\t</ Dossier vide />\n\n");
                    }else{
                        size = boite.getSpam().size();
                        System.out.println("********************************************************************************");
                        System.out.println("\t\t\t\t\t\t\t\tDossier Spam: ");
                        System.out.println("********************************************************************************");
                        for(k = 0; k < size; k++) {
                            Message message = boite.getSpam().get(k);
                            System.out.println(message);
                        }
                        if(size == 0) System.out.println("\t\t\t\t\t\t\t</ Dossier vide />\n\n");
                    }
                }
            }catch (Exception ex){
                if(adresses.get(i).getBoite() == null) {
                    System.out.println("Cette adresse n'a pas de boite pour le moment...\n");
                }
            }

            pressAnyKeyToContinue();
        }
        if(sizeAdr == 0){
            System.out.println("Aucune adresse n'a ete cree...");
        }
    }

    // Methodes du Sous-Menu
    void CreationMessages() {
        Message message;
        MessageAttach messageAttach;
        PieceJointe piece;
        LinkedList<PieceJointe> pieceJointes;

        if (messages.size() == 0) {
            message = new Message(
                    "Devoir noté - remarque",
                    "\nBonjour," +
                            "\n     Ceux qui m'ont envoyé leur devoir sous la forme de lignes de code dans un mail, ou d'un fichier PDF " +
                            "\ncontenant une capture d'écran d'un script, ou d'une capture d'écran dans un mail, sont priés de me " +
                            "\nrenvoyer rapidement leur devoir sous la forme d'un script Python avec extension .py" +
                            "\nMerci d'avance." +
                            "\nN.Z",
                    LocalDate.of(2020, 07, 21),
                    LocalTime.of(7, 52, 06, 0),
                    Message.Etat.cree,
                    0);
            message.setTaille(message);
            messages.add(message);

            message = new Message(
                    "RE: Réunion de rencontre en ligne avec la nouvelle direction (10/06/2020 à 10H00)",
                    "\nBonjour, suite à un imprévu, nous vous informons que la réunion prévue pour 10H est reportée à 13H.\n" +
                            "\nMerci pour votre compréhension," +
                            "\nCordialement",
                    LocalDate.of(2020, 07, 9),
                    LocalTime.of(9, 10, 06, 0),
                    Message.Etat.cree,
                    0);
            message.setTaille(message);
            messages.add(message);

            message = new Message(
                    "Rappel : Conférences Live sur le Développement Personnel",
                    "\nBonjour," +
                            "\nNous vous rappelons que la suite de la Conférence Live organisée par l’ANPT sur le Développement " +
                            "\nPersonnel, Entrepreneuriat, Management et Leadership, est prévue pour demain mercredi 22 avril à partir de 9h30." +
                            "\nVous trouverez le détail et le lien de la conférence dans l’évènement Facebook ci-dessous :\n" +
                            "\nhttps://www.facebook.com/events/946467892437269/" +
                            "\n\nVous pourrez interagir avec le formateur et poser vos question, ne ratez donc pas cette opportunité.",
                    LocalDate.of(2020, 04, 21),
                    LocalTime.of(9, 25, 06, 0),
                    Message.Etat.cree,
                    0);
            message.setTaille(message);
            messages.add(message);

            message = new Message(
                    "Fwd: Invitation to Web seminar: React js",
                    "\nAbdelkrim Embarek invites you to attend a Webex event." +
                            "\nThis event requires registration. After you register, you'll receive a confirmation email " +
                            "\nmessage with instructions on how to join the event.\n" +
                            "\n\nReact js OnSunday, May 3, 2020 4:00 pm, West Africa Time (Windhoek, GMT+01:00)" +
                            "\n\nHost: Abdelkrim Embarek (maxnew486@gmail.com)",
                    LocalDate.of(2020, 07, 28),
                    LocalTime.of(11, 30, 06, 0),
                    Message.Etat.cree,
                    0);
            message.setTaille(message);
            messages.add(message);

            message = new Message(
                    "Formation Réussir son projet entrepreneurial",
                    "\nBonjour," +
                            "\nJ’espère que vous allez bien ainsi que vos proches." +
                            "\nNous organisons, la semaine prochaine 20 et 21 avril 2020, une formation intitulée ‘Réussir " +
                            "\nson projet entrepreneurial, qui sera assurée par notre coach formateur M. Mazouz Ghalib." +
                            "\nLa formation se déroulera par Visio-conférence, avec un nombre limité de participant, " +
                            "\n5 projets/équipes par journée. La formation commencera à 9h pour la partie commune, puis " +
                            "\n40 minutes seront consacrées pour chaque projets/équipes. Merci aux équipes qui sont sûr de " +
                            "\npouvoir se libérer le jour de la formation et d’en profiter un maximum de nous confirmer leur " +
                            "\nparticipation, et de nous indiquer la journée choisie (20 ou 21/04). La liste sera finalisée " +
                            "\nle 19/04 à midi, dernier délai pour la réception de vos confirmations ; les plus réactifs seront priorisés." +
                            "\n\nCordialement.",
                    LocalDate.of(2020, 07, 16),
                    LocalTime.of(10, 53, 06, 0),
                    Message.Etat.cree,
                    0);
            message.setTaille(message);
            messages.add(message);

            //ATTACHEMENT
            pieceJointes = new LinkedList<>();
            piece = new PieceJointe("Suite formation Data Mining", 25 * 2048);
            pieceJointes.add(piece);
            piece = new PieceJointe("Suite formation Big Data", 10 * 2048);
            pieceJointes.add(piece);

            messageAttach = new MessageAttach(
                    "Courses",
                    "\nHeyy l'équipe ..!!!!" +
                            "\nPlus que on a fait dans ORS CAMP" +
                            "\nVoici la suite des formations" +
                            "\nEnjoy .",
                    LocalDate.of(2020, 03, 28),
                    LocalTime.of(4, 56, 06, 0),
                    Message.Etat.cree,
                    0,
                    pieceJointes);
            messageAttach.setTaille(message);
            messages.add(messageAttach);

            //ATTACHEMENT
            pieceJointes = new LinkedList<>();
            piece = new PieceJointe("Dynamisez vos sites web avec javascript", 1 * 2048 * 2048);
            pieceJointes.add(piece);
            piece = new PieceJointe("No Starch Python", 1 * 2048 * 2048);
            pieceJointes.add(piece);

            messageAttach = new MessageAttach(
                    "Js and python courses",
                    "\nHere are the Js and python courses you told me to send you. You're welcome!",
                    LocalDate.of(2019, 11, 21),
                    LocalTime.of(6, 43, 06, 0),
                    Message.Etat.cree,
                    0,
                    pieceJointes);
            messageAttach.setTaille(message);
            messages.add(messageAttach);


            message = new Message(
                    "dossier à fournir ",
                    "\nBonjour" +
                            "\nNous avons le plaisir de vous informer, que suite à la présentation de votre projet, votre " +
                            "\ncandidature a été retenue pour bénéficier d’un accompagnement au sein de notre Agence." +
                            "\n\nA cet effet, nous vous prions de bien vouloir apporter le dossier administratif ci-dessous pour " +
                            "\nchaque membre de l’équipe , et ce avant le jeudi 06.02.2020.",
                    LocalDate.of(2020, 02, 15),
                    LocalTime.of(12, 59, 06, 0),
                    Message.Etat.cree,
                    0);
            message.setTaille(message);
            messages.add(message);

            //ATTACHEMENT
            pieceJointes = new LinkedList<>();
            piece = new PieceJointe("Participants Git Worshop", 3 * 2048);
            pieceJointes.add(piece);

            messageAttach = new MessageAttach(
                    "git workshop",
                    "\nVoici la liste des participants au workshop git ce samedi.",
                    LocalDate.of(2020, 02, 8),
                    LocalTime.of(7, 8, 06, 0),
                    Message.Etat.cree,
                    0,
                    pieceJointes);
            messageAttach.setTaille(message);
            messages.add(messageAttach);

            message = new Message(
                    "Section 1 MI",
                    "\nBonsoir madame,\n" +
                            "   Je suis Lilia MEHAMLI, déléguée du groupe 1 de la section 1. Une camarade du nom de Rania " +
                            "\nZELLAGUI immatriculée #171731088574 m'a demandé de vous envoyer un email pour vous informer " +
                            "\nqu'elle était une des personnes qui n'ont pas pu passer l'interrogation d'OPM mais elle n'est " +
                            "\npas sûre si son nom figurait sur la liste car elle nous a informer trop tard.\n" +
                            "\n" +
                            "Merci pour votre compréhension. En attente d'une reponse.\n",
                    LocalDate.of(2019, 9, 21),
                    LocalTime.of(8, 40, 06, 0),
                    Message.Etat.cree,
                    0);
            message.setTaille(message);
            messages.add(message);

            //ATTACHEMENT
            pieceJointes = new LinkedList<>();
            piece = new PieceJointe("Of Space and Graves - Chap 1/2/3/4/5", 38 * 2048);
            pieceJointes.add(piece);

            messageAttach = new MessageAttach(
                    "Editing Request: liliamehamli",
                    "\nHello Corry," +
                            "\nHere are the chapters I've written so far. \n" +
                            "\nYou will find attached the synopsis of the novel. If you notice anything amiss, please feel free " +
                            "\nto make me know. As I told you, this is my first time working with an editor." +
                            "\nThanks, ",
                    LocalDate.of(2019, 8, 29),
                    LocalTime.of(7, 6, 06, 0),
                    Message.Etat.cree,
                    0,
                    pieceJointes);
            messageAttach.setTaille(message);
            messages.add(messageAttach);

            message = new Message(
                    "Hi,",
                    "\nI haven't recieved your last report about the seminars. Is the work going fine? Make sure to " +
                            "\nfinish it by Tuesday.\n",
                    LocalDate.of(2018, 2, 12),
                    LocalTime.of(11, 10, 06, 0),
                    Message.Etat.cree,
                    0);message.setTaille(message);
            messages.add(message);
        }
    }
    void AjoutMessages(int indexAdrMail) throws BoiteMail.ExceptionDebordementBoite {
        CreationMessages();
        LinkedList<Message> tmpMessages;
        LinkedList<AdrMail> tmpAdresses;
        LinkedList<Message> tmpList;

        int limit = 4;
        int j, k, l, sizeMsg, sizeAdrTmp, rand;
        Random random;

        BoiteMail boite;
        Message message;

        // Creer un tableau d'etat
        Message.Etat[] values = Message.Etat.values();
        int totalEtat = 6;

        // Creer boite
        boite = adresses.get(indexAdrMail).getBoite();

        for (j = 0; j < totalEtat; j++) {
            // Dossier par Dossier
            tmpMessages = (LinkedList<Message>) messages.clone();
            sizeMsg = messages.size();
            //Initializer
            sizeAdrTmp = adresses.size();
            tmpAdresses = (LinkedList<AdrMail>) adresses.clone();
            tmpList = new LinkedList<Message>();

            // Ajouter des messages au dossier actuel
            for (k = 0; k < limit; k++) {
                // Choisir un index au hasard.
                random = new Random();
                rand = random.nextInt(sizeMsg);

                // Copier message ensuite le supprimer de la LL temporaire.
                message = new Message(tmpMessages.get(rand));
                tmpMessages.remove(rand);
                sizeMsg--;

                // Changer Etat du message.
                message.setEtat(values[j]);
                // Ajouter Expediteur
                for(l = 0; l < sizeAdrTmp; l++){
                    // Choisir un index au hasard.
                    random = new Random();
                    do {
                        rand = random.nextInt(sizeAdrTmp);
                    }while (rand == indexAdrMail);

                    // Ajouter l'adresse du dstinataire ensuite la supprimer de la LL temporaire.
                    message.setExpediteur(adresses.get(rand));
                    tmpAdresses.remove(rand);

                    sizeAdrTmp--;
                }
                // Ajouter le message au dossier actuel.
                tmpList.add(message);

                switch(j){
                    case 0: boite.setRecus(tmpList);
                    case 1: boite.setEnvoyes(tmpList);
                    case 2: boite.setBrouillons(tmpList);
                }
            }
        }


        // Associer la boitemail a l'adresse email
        if (adresses.get(indexAdrMail) instanceof AdrMailProf) {
            AdrMailProf adrMailProf = new AdrMailProf((AdrMailProf) adresses.get(indexAdrMail));
            adrMailProf.setBoiteMail(boite);
            adresses.set(indexAdrMail, adrMailProf);
        } else {
            AdrMail adresse = new AdrMail(adresses.get(indexAdrMail));
            adresse.setBoiteMail(boite);
            adresses.set(indexAdrMail, adresse);
        }
        if(boite.EspaceUtilise()*100/boite.getCapacite() == 80)
            throw new BoiteMail.ExceptionDebordementBoite(
                    "La taille des message a atteint 80% de la capacite de stockage de la boite.\n" +
                            "Vous devez supprimer quelques messages..."
            );
    }
    void AfficherBoite(int indexAdrMail){
        int j, k, size;

        BoiteMail boite;
        int totalEtat = 6;

        boite = new BoiteMail(adresses.get(indexAdrMail).getBoite());

        System.out.println("* Espace utilise: " + boite.EspaceUtilise() + " octets");
        System.out.println("* Espace restant: " + boite.EspaceRestant() + " octets\n");

        for(j = 0; j < totalEtat; j++){
            // Dossier par Dossier
            if(j == 0){
                size = boite.getRecus().size();
                System.out.println("********************************************************************************");
                System.out.println("\t\t\t\t\t\t\t\tDossier Recus: ");
                System.out.println("********************************************************************************");
                for(k = 0; k < size; k++) {
                    Message message = boite.getRecus().get(k);
                    System.out.println(message);
                }
                if(size == 0) System.out.println("\t\t\t\t\t\t\t\t</ Dossier vide />");
            }else if(j == 1){
                size = boite.getEnvoyes().size();
                System.out.println("********************************************************************************");
                System.out.println("\t\t\t\t\t\t\t\tDossier Envoyes: ");
                System.out.println("********************************************************************************");
                for(k = 0; k < size; k++) {
                    Message message = boite.getEnvoyes().get(k);
                    System.out.println(message);
                }
                if(size == 0) System.out.println("\t\t\t\t\t\t\t\t</ Dossier vide />");
            }else if(j == 2) {
                size = boite.getBrouillons().size();
                System.out.println("********************************************************************************");
                System.out.println("\t\t\t\t\t\t\t\tDossier Brouillons: ");
                System.out.println("********************************************************************************");
                for(k = 0; k < size; k++) {
                    Message message = boite.getBrouillons().get(k);
                    System.out.println(message);
                }
                if(size == 0) System.out.println("\t\t\t\t\t\t\t\t</ Dossier vide />");
            }else if(j == 3) {
                size = boite.getArchives().size();
                System.out.println("********************************************************************************");
                System.out.println("\t\t\t\t\t\t\t\tDossier Archives: ");
                System.out.println("********************************************************************************");
                for(k = 0; k < size; k++) {
                    Message message = boite.getArchives().get(k);
                    System.out.println(message);
                }
                if(size == 0) System.out.println("\t\t\t\t\t\t\t\t</ Dossier vide />");
            }else if(j == 4) {
                size = boite.getCorbeille().size();
                System.out.println("********************************************************************************");
                System.out.println("\t\t\t\t\t\t\t\tDossier Corbeille: ");
                System.out.println("********************************************************************************");
                for(k = 0; k < size; k++) {
                    Message message = boite.getCorbeille().get(k);
                    System.out.println(message);
                }
                if(size == 0) System.out.println("\t\t\t\t\t\t\t\t</ Dossier vide />");
            }else{
                size = boite.getSpam().size();
                System.out.println("********************************************************************************");
                System.out.println("\t\t\t\t\t\t\t\tDossier Spam: ");
                System.out.println("********************************************************************************");
                for(k = 0; k < size; k++) {
                    Message message = boite.getSpam().get(k);
                    System.out.println(message);
                }
                if(size == 0) System.out.println("\t\t\t\t\t\t\t\t</ Dossier vide />");
            }
        }
    }
    void AfficherMessage(int indexAdrMail){
        int k, size = adresses.get(indexAdrMail).getBoite().getRecus().size();
        BoiteMail boite = adresses.get(indexAdrMail).getBoite();

        // Demander Message
        System.out.println("Quel message voulez-vous ouvrir? ");
        for(k = 0; k < size; k++) {
            Message message = new Message(boite.getRecus().get(k));
            System.out.format("\t%d. %s\n", k+1, message.getObjet());
        }
        System.out.print(">>> ");
        do {
            Scanner in = new Scanner(System.in);
            k = in.nextInt();
        }while(k < 1 || k > size);

        // Ouvrir Message
        adresses = boite.OuvrirMessage(adresses, indexAdrMail, k-1);
    }
    void ViderDossier(int indexAdrMail){
        // Spam ou Envoyes?
        int option = 0;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Vider dossier (1) Spam, (2) Envoyes ? ");
            try {
                option = in.nextInt();
            }catch (Exception ex){
                System.out.println("Invalid Input...");
                ViderDossier(indexAdrMail);
            }
        }while(option<1 || option>2);

        if(option == 1){
            // Spam
            adresses.get(indexAdrMail).getBoite().getSpam().clear();
        }else{
            // Envoyes
            adresses.get(indexAdrMail).getBoite().getEnvoyes().clear();
        }
    }
    void EnvoyerMessage(int indexExpediteur) throws BoiteMail.ExceptionDebordementBoite {
        BoiteMail instance = new BoiteMail();
        int indexDestinataire = 0;
        BoiteMail boite = adresses.get(indexExpediteur).getBoite();

        // Demander Destinataire.
        System.out.println("Veuillez entrer l'adresse du destinataire.");
        try{
            indexDestinataire = CheckAdrMail();
        } catch (BoiteMail.ExceptionDestinataireIncorrecte ex){
            System.out.println(ex.getMessage());
            EnvoyerMessage(indexExpediteur);
        }
        
        // Creer Message
        Message message = new Message();
        message = message.Creer();

        // Demander a l'utilisateur s'il veut ajouter un attachement ou non.
        int option = 0;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Ajouter un attachement (1) Oui, (2) Non ? ");
            try {
                option = in.nextInt();
            }catch (Exception ex){
                System.out.println("Invalid Input...");
            }
        }while(option<1 || option>2);

        // Tester input
        if(option == 1){
            // Avec Attachement
            MessageAttach messageAttach = new MessageAttach();
            messageAttach = messageAttach.CreerAvecAttach(message);
            // Envoyer Message
            adresses = instance.EnvoyerMessage(adresses, indexExpediteur, messageAttach);
            // Recevoir Message
            adresses = instance.RecevoirMessage(adresses, indexDestinataire, messageAttach);
        }
        else {
            // Envoyer Message
            adresses = instance.EnvoyerMessage(adresses, indexExpediteur, message);
            // Recevoir Message
            adresses = instance.RecevoirMessage(adresses, indexDestinataire, message);
        }

        if(boite.EspaceUtilise()*100/boite.getCapacite() == 80)
            throw new BoiteMail.ExceptionDebordementBoite(
                    "La taille des message a atteint 80% de la capacite de stockage de la boite.\n" +
                            "Vous devez supprimer quelques messages..."
            );
    }
    void SupprimerMessage(int indexAdrMail){
        int k, size = adresses.get(indexAdrMail).getBoite().getRecus().size();
        BoiteMail boite = adresses.get(indexAdrMail).getBoite();

        // Demander Message
        System.out.println("Quel message voulez-vous supprimer? ");
        for(k = 0; k < size; k++) {
            Message message = new Message(boite.getRecus().get(k));
            System.out.format("\t%d. %s\n", k+1, message.getObjet());
        }
        System.out.print(">>> ");
        do {
            Scanner in = new Scanner(System.in);
            try {
                k = in.nextInt();
            }catch (Exception ex){
                System.out.println("Invalid Input...");
                SupprimerMessage(indexAdrMail);
            }
        }while(k < 1 || k > size);

        // Supprimer Message
        adresses = boite.SupprimerMessage(adresses, indexAdrMail, k-1);
    }
    void RestaurerMessage(int indexAdrMail){
        int k, size = adresses.get(indexAdrMail).getBoite().getCorbeille().size();
        BoiteMail boite = adresses.get(indexAdrMail).getBoite();

        // Demander Message
        System.out.println("Quel message voulez-vous restaurer? ");
        for(k = 0; k < size; k++) {
            Message message = new Message(boite.getCorbeille().get(k));
            System.out.format("\t%d. %s\n", k+1, message.getObjet());
        }
        System.out.print(">>> ");
        do {
            Scanner in = new Scanner(System.in);
            try {
                k = in.nextInt();
            }catch (Exception ex){
                System.out.println("Invalid Input...");
                SupprimerMessage(indexAdrMail);
            }
        }while(k < 1 || k > size);

        // Restaurer Message
        adresses = boite.RestaurerMessage(adresses, indexAdrMail, k-1);
    }
    void ArchiverMessage(int indexAdrMail){
        LocalDate date;
        Profil instance = new Profil();
        BoiteMail boite = adresses.get(indexAdrMail).getBoite();

        // Demander date
        date = instance.setDateNaissance();

        // Archiver Message
        adresses = boite.ArchiverMessage(adresses, indexAdrMail, date);
    }
    void RepondreMessage(int indexExpediteur) throws BoiteMail.ExceptionDebordementBoite{
        int k, size = adresses.get(indexExpediteur).getBoite().getRecus().size();
        BoiteMail boite = adresses.get(indexExpediteur).getBoite();

        // Demander Message auquel repondre
        System.out.println("A quel message voulez-vous repondre? ");
        for(k = 0; k < size; k++) {
            Message message = new Message(boite.getRecus().get(k));
            System.out.format("\t%d. %s\n", k+1, message.getObjet());
        }
        System.out.print(">>> ");
        do {
            Scanner in = new Scanner(System.in);
            try {
                k = in.nextInt();
            }catch (Exception ex){
                System.out.println("Invalid Input...");
                RepondreMessage(indexExpediteur);
            }
        }while(k < 1 || k > size);

        // Recuperer index du destinataire
        int indexDestinataire = adresses.indexOf(boite.getRecus().get(k-1).getExpediteur());

        // Creer Message
        Message message = new Message();
        message = message.Creer();

        // Demander a l'utilisateur s'il veut ajouter un attachement ou non.
        int option;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Ajouter un attachement? (1) Oui, (2) Non");
            option = in.nextInt();
        }while(option<1 || option>2);

        // Tester input
        if(option == 1){
            // Avec Attachement
            MessageAttach messageAttach = new MessageAttach();
            messageAttach = messageAttach.CreerAvecAttach(message);
            // Repondre Message
            adresses = boite.EnvoyerMessage(adresses, indexExpediteur, messageAttach);
            // Recevoir Message
            adresses = boite.RecevoirMessage(adresses, indexDestinataire, messageAttach);
        }
        else {
            // Repondre Message
            adresses = boite.EnvoyerMessage(adresses, indexExpediteur, message);
            // Recevoir Message
            adresses = boite.RecevoirMessage(adresses, indexDestinataire, message);
        }

        if(boite.EspaceUtilise()*100/boite.getCapacite() == 80)
            throw new BoiteMail.ExceptionDebordementBoite(
                    "La taille des message a atteint 80% de la capacite de stockage de la boite.\n" +
                            "Vous devez supprimer quelques messages..."
            );
    }
    void TrierMessages(int indexAdrMail){
        int j, totalEtat = 6;

        for(j = 0; j<totalEtat; j++){
            // Dossier par Dossier
            switch (j){
                case 0:  Collections.sort(adresses.get(indexAdrMail).getBoite().getRecus(), new MessageComparator());
                case 1:  Collections.sort(adresses.get(indexAdrMail).getBoite().getEnvoyes(), new MessageComparator());
                case 2:  Collections.sort(adresses.get(indexAdrMail).getBoite().getBrouillons(), new MessageComparator());
                case 3:  Collections.sort(adresses.get(indexAdrMail).getBoite().getArchives(), new MessageComparator());
                case 4:  Collections.sort(adresses.get(indexAdrMail).getBoite().getCorbeille(), new MessageComparator());
                case 5:  Collections.sort(adresses.get(indexAdrMail).getBoite().getSpam(), new MessageComparator());
            }
        }
    }

    // Methodes du Autre-Menu
    void AffichAdrDeMessage(){
        int i, j, c = 0;
        int sizeAdr = adresses.size(), sizeMessage;
        LinkedList<Message> tmpList;
        Boolean exist;
        String objet = "";
        Scanner in = new Scanner(System.in);

        // Demander Message
        do {
            System.out.print("L'Objet du message: ");
            try {
                objet = in.nextLine();
            }catch (Exception ex){
                System.out.println("Invalid Input...");
                AffichAdrDeMessage();
            }
        }while(objet.isEmpty());

        // Recherche de boitesmail.
        for(i = 0; i < sizeAdr; i++){
            try{
                // Boite par Boite
                tmpList = (LinkedList) adresses.get(i).getBoite().getRecus().clone();
                sizeMessage = tmpList.size();
                exist = false;
                j = 0;

                while(j < sizeMessage && exist == false){
                    if(adresses.get(i).getBoite().getRecus().get(j).getObjet().equals(objet))
                        exist = true;
                    j++;
                }
                if(exist) {
                    System.out.println(adresses.get(i));
                    c++;
                }
            }catch (Exception ex){
                System.out.println("Cette adresse mail n'a pas de boite pour le moment...");
            }
        }
        if(c == 0){
            System.out.println("Aucune adresse ne contient un message avec cet objet...");
        }
    }
    void AffichAdrRemplies(){
        int i, c = 0;
        int sizeAdr = adresses.size();
        BoiteMail boite;

        for(i = 0; i < sizeAdr; i++){
            // Boite par Boite
            try {
                boite = adresses.get(i).getBoite();
                if ((boite.EspaceUtilise() / boite.getCapacite()) > 0.5) {
                    System.out.println(adresses.get(i));
                    c++;
                }
            }catch (Exception ex){
                System.out.println("Cette adresse mail n'a pas de boite pour le moment...");
            }
        }

        if(c == 0){
            System.out.println("Pas de boites remplies a 50% de leur capacite...");
        }
    }
    void EclaterCollectionBoites(){
        int i;
        int sizeAdr = adresses.size();

        for(i = 0; i < sizeAdr; i++){
            // Boite par Boite
            if(adresses.get(i) instanceof AdrMailProf)
                adrPros.add(adresses.get(i));
            else
                adrPublics.add(adresses.get(i));
        }
    }
    void CalculUsage(){
        int maxAge = 35, minAge = 18, age;
        String site = "";
        Scanner in = new Scanner(System.in);
        int i, sizeAdr = adresses.size();
        float totalUsage = 0;

        // Demander Site
        do {
            System.out.print("Le site a calculer son pourcentage d'usage: ");
            try {
                site = in.nextLine();
            }catch (Exception ex){
                System.out.println("Invalid Input...");
                CalculUsage();
            }
        }while(site.isEmpty());

        // Calculer
        for(i = 0; i < sizeAdr; i++){
            if(adresses.get(i).getSite().equals(site)) {
                age = adresses.get(i).getProfil().getAge();
                if (age >= minAge && age <= maxAge) {
                    totalUsage++;
                }
            }
        }

        System.out.format("pourcentage d’utilisation par la catégorie " +
                "d’âge comprise entre 18 et 35 ans est: %.1f", (totalUsage / sizeAdr) * 100);
        System.out.println("%");
    }
    void AffichMessPieceJointes() {
        int i, k, c = 0, size;
        int indexAdrMail = 0;

        // Demander Boite
        try{
            indexAdrMail = CheckAdrMail();
        } catch (BoiteMail.ExceptionDestinataireIncorrecte ex){
            System.out.println(ex.getMessage());
            AutreMenu();
        }

        try {
            BoiteMail boite = adresses.get(indexAdrMail).getBoite();

            int totalEtat = 6;
            for (i = 0; i < totalEtat; i++) {
                // Dossier par dossier
                if (i == 0) {
                    size = boite.getRecus().size();
                    for (k = 0; k < size; k++) {
                        if (boite.getRecus().get(k) instanceof MessageAttach) ;
                        System.out.println(boite.getRecus().get(k));
                        c++;
                    }
                } else if (i == 1) {
                    size = boite.getEnvoyes().size();
                    for (k = 0; k < size; k++) {
                        if (boite.getEnvoyes().get(k) instanceof MessageAttach) ;
                        System.out.println(boite.getEnvoyes().get(k));
                        c++;
                    }
                } else if (i == 2) {
                    size = boite.getBrouillons().size();
                    for (k = 0; k < size; k++) {
                        if (boite.getBrouillons().get(k) instanceof MessageAttach) ;
                        System.out.println(boite.getBrouillons().get(k));
                        c++;
                    }
                } else if (i == 3) {
                    size = boite.getArchives().size();
                    for (k = 0; k < size; k++) {
                        if (boite.getArchives().get(k) instanceof MessageAttach) ;
                        System.out.println(boite.getArchives().get(k));
                        c++;
                    }
                } else if (i == 4) {
                    size = boite.getCorbeille().size();
                    for (k = 0; k < size; k++) {
                        if (boite.getCorbeille().get(k) instanceof MessageAttach) ;
                        System.out.println(boite.getCorbeille().get(k));
                        c++;
                    }
                } else {
                    size = boite.getSpam().size();
                    for (k = 0; k < size; k++) {
                        if (boite.getSpam().get(k) instanceof MessageAttach) ;
                        System.out.println(boite.getSpam().get(k));
                        c++;
                    }
                }
            }

            if(c == 0)
                System.out.println("Aucune piece jointe dans cette boite mail...");

        }catch (Exception e){
            System.out.println("Cette adresse mail n'a pas de boite pour le moment...");
            AutreMenu();
        }

    }
    void AffichNomAvecDeuxBoites(){
        int i,j, c = 0, sizeAdr = adresses.size();
        Profil profil;
        Boolean exist;

        for(i = 0; i<sizeAdr; i++){
            // Profil par Profil
            profil = adresses.get(i).getProfil();
            exist = false;
            j = 0;
            while(!exist && j < sizeAdr){
                if(j != i && profil == adresses.get(j).getProfil()){
                    exist = true;
                    System.out.println(profil);
                    c++;
                }
                j++;
            }
        }

        if(c == 0){
            System.out.println("Aucun profil avec deux boites...");
        }
    }
    void ViderBoites(){
        int i;
        int sizeAdr = adresses.size();
        String site = "";
        Scanner in = new Scanner(System.in);

        // Demander Site
        do {
            System.out.print("Le site que vous voulez pirater: ");
            try{
                site = in.next();
            }catch (Exception ex){
                System.out.println("Invalid Input...");
                ViderBoites();
            }
        }while(site.isEmpty());

        // Pirater Site
        for(i = 0; i < sizeAdr; i++){
            if(adresses.get(i).getSite().equals(site)){
                adresses.remove(i);
                sizeAdr--;
            }
        }
    }
    void RechercheMessages(){
        // Rechercher les messages par destinataire, par expéditeur, par mot clé.
        int indexDestinataire = 0 , indexExpediteur = 0, indexExpTmp;
        String motCle = "";
        int  j, k, c = 0, size;
        BoiteMail boite;
        int totalEtat = 6;
        Scanner in = new Scanner(System.in);

        // Demander Destinataire.
        System.out.println("Saisir adresse du destinataire ");
        try{
            indexDestinataire = CheckAdrMail();
        } catch (BoiteMail.ExceptionDestinataireIncorrecte ex){
            System.out.println(ex.getMessage());
            RechercheMessages();
        }

        if(adresses.get(indexDestinataire).getBoite() == null){
            System.out.println("Le destinataire que vous avez entre n'a pas de boite...");
            AutreMenu();
        }

        // Demander Expediteur.
        System.out.println("Saisir adresse de l'expediteur: ");
        try{
            indexExpediteur = CheckAdrMail();
        } catch (BoiteMail.ExceptionDestinataireIncorrecte ex){
            System.out.println(ex.getMessage());
            RechercheMessages();
        }

        // Demander Mot Cle
        do{
            System.out.print("Mot Cle: ");
            try{
                motCle = in.next();
            }catch (Exception ex){
                System.out.println("Invalid Input...");
                RechercheMessages();
            }
        }while(motCle.isEmpty());

        // Recherche
        boite = new BoiteMail(adresses.get(indexDestinataire).getBoite());
        for(j = 0; j < totalEtat; j++){
            // Dossier par Dossier
            if(j == 0){
                size = boite.getRecus().size();
                for(k = 0; k < size; k++) {
                    Message message = boite.getRecus().get(k);
                    indexExpTmp = adresses.indexOf(message.getExpediteur());

                    if(indexExpTmp == indexExpediteur && message.getContenu().contains(motCle)) {
                        System.out.println(message);
                        c++;
                    }
                }
            }else if(j == 1){
                size = boite.getEnvoyes().size();
                for(k = 0; k < size; k++) {
                    Message message = boite.getEnvoyes().get(k);
                    indexExpTmp = adresses.indexOf(message.getExpediteur());

                    if(indexExpTmp == indexExpediteur && message.getContenu().contains(motCle)) {
                        System.out.println(message);
                        c++;
                    }
                }
            }else if(j == 2) {
                size = boite.getBrouillons().size();
                for(k = 0; k < size; k++) {
                    Message message = boite.getBrouillons().get(k);
                    indexExpTmp = adresses.indexOf(message.getExpediteur());

                    if(indexExpTmp == indexExpediteur && message.getContenu().contains(motCle)) {
                        System.out.println(message);
                        c++;
                    }
                }
            }else if(j == 3) {
                size = boite.getArchives().size();
                for(k = 0; k < size; k++) {
                    Message message = boite.getArchives().get(k);
                    indexExpTmp = adresses.indexOf(message.getExpediteur());

                    if(indexExpTmp == indexExpediteur && message.getContenu().contains(motCle)) {
                        System.out.println(message);
                        c++;
                    }
                }
            }else if(j == 4) {
                size = boite.getCorbeille().size();
                for(k = 0; k < size; k++) {
                    Message message = boite.getCorbeille().get(k);
                    indexExpTmp = adresses.indexOf(message.getExpediteur());

                    if(indexExpTmp == indexExpediteur && message.getContenu().contains(motCle)) {
                        System.out.println(message);
                        c++;
                    }
                }
            }else{
                size = boite.getSpam().size();
                for(k = 0; k < size; k++) {
                    Message message = boite.getSpam().get(k);
                    indexExpTmp = adresses.indexOf(message.getExpediteur());

                    if(indexExpTmp == indexExpediteur && message.getContenu().contains(motCle)) {
                        System.out.println(message);
                        c++;
                    }
                }
            }
        }

        if(c == 0)
            System.out.println("Aucun message ne correspond aux donnees que vous avez entre...");
    }

    // Autres Methodes
    int CheckAdrMail() throws BoiteMail.ExceptionDestinataireIncorrecte {
        Scanner in = new Scanner(System.in);
        int j=0;
        int size = adresses.size();
        boolean exist = false;

        String StrAdresse, nom = "", site = "";

        try{
            System.out.print("Saisir l'adresse: ");
            StrAdresse = in.next();
            // Get le nom
            nom = StrAdresse.substring( 0, StrAdresse.indexOf("@"));
            nom.trim();
            // Get le site
            site = StrAdresse.substring(StrAdresse.lastIndexOf("@")+1);
            site.trim();
        }catch (Exception e){
            System.out.println("Invalid Input...");
            CheckAdrMail();
        }

        while(!exist && j < size){
            if(adresses.get(j).getPseudonyme().equals(nom)  && adresses.get(j).getSite().equals(site))
                exist = true;
            j++;
        }
        if(!exist){
            throw new BoiteMail.ExceptionDestinataireIncorrecte("Adresse incorrecte!");
        }
        
        return j-1;
    }
    private void pressAnyKeyToContinue() {
        System.out.print("Clicker sur Entrer pour continuer...");
        try {
            System.in.read();
        }
        catch(Exception e){}
    }

    // Menus
    public void AutreMenu() {
        int option = 0;

        while(true) {
            System.out.println("\n**************************************************************************************************************************\n" +
                               "* 1. Afficher toutes les boites (adresses mail) ayant reçu un message donné (on donnera l’objet du message)              *\n" +
                               "* 2. Afficher les boites qui sont remplies à plus de 50% de leur capacité                                                *\n" +
                               "* 3. Eclater la collection des boites en deux collections :                                                              *\n" +
                               "*          - la première contenant les boites publiques                                                                  *\n" +
                               "*          - l’autre contenant les boites professionnelles                                                               *\n" +
                               "* 4. Pour un site donné, calculer le pourcentage d’utilisation par la catégorie d’âge comprise entre 18 et 35 ans        *\n" +
                               "* 5. Afficher les messages ayant des pièces jointes (pour une boite donnée)                                              *\n" +
                               "* 6. Rechercher les messages par destinataire, par expéditeur, par mot clé                                               *\n" +
                               "* 7. Afficher les noms, prénoms des profils ayant au moins deux boites de messagerie                                     *\n" +
                               "* 8. Vider toutes les boites d’un site donné (piratage du site)                                                          *\n" +
                               "* 9. Retour                                                                                                              *\n" +
                               "* 10. Quitter                                                                                                            *\n" +
                               "**************************************************************************************************************************\n");
            System.out.print(">>> ");
            Scanner in = new Scanner(System.in);
            try {
                option = in.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Input...");
                AutreMenu();
            }
            switch (option) {
                case 1: AffichAdrDeMessage(); break;
                case 2: AffichAdrRemplies(); break;
                case 3: EclaterCollectionBoites(); System.out.println("Collection eclates!"); break;
                case 4: CalculUsage(); break;
                case 5: AffichMessPieceJointes(); break;
                case 6: RechercheMessages(); break;
                case 7: AffichNomAvecDeuxBoites(); break;
                case 8: ViderBoites(); System.out.println("Site pirate!"); break;
                case 9: Menu(); break;
                case 10: exit(0);
                default: AutreMenu();
            }
        }
    }
    public void SousMenu(int indexAdrMail){
        if(adresses.get(indexAdrMail).getBoite() == null){
            System.out.println("Cette adresse mail n'a pas de boite pour le moment...");
            Menu();
        }

        int option = 0;
        System.out.println("\n**************************************************************************************************************************");
        System.out.print("\t\t\t\t\t\t\tGestion de la boite de: " + adresses.get(indexAdrMail).getProfil() + " (" + adresses.get(indexAdrMail)+") ");
        while (true) {
            System.out.println("\n**************************************************************************************************************************\n" +
                               "* 1. Ajout automatique de messages (reçus, envoyés, brouillons)                                                          *\n" +
                               "* 2. Afficher le contenu d’une boite (en séparant les dossiers, en donnant des infos espace utilisé et espace restant)   *\n" +
                               "* 3. Envoyer message                                                                                                     *\n" +
                               "* 4. Afficher le contenu d’un message (avec l’en-tête)                                                                   *\n" +
                               "* 5. Supprimer un message                                                                                                *\n" +
                               "* 6. Archiver un message / ou les messages reçus avant une date d donnée                                                 *\n" +
                               "* 7. Restaurer un message donné (restituer de la corbeille)                                                              *\n" +
                               "* 8. Répondre à un message                                                                                               *\n" +
                               "* 9. Vider un dossier (« spam » ou « envoyés »)                                                                          *\n" +
                               "* 10. Trier les messages par date (le plus récent d’abord), par objet (ordre alphabétique)                               *\n" +
                               "* 11. Retour                                                                                                             *\n" +
                               "* 12. Quitter                                                                                                            *\n" +
                               "**************************************************************************************************************************\n");
            System.out.print(">>> ");
            Scanner in = new Scanner(System.in);
            try {
                option = in.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Input...");
                SousMenu(indexAdrMail);
            }

            switch (option) {
                case 1:
                    try{
                        AjoutMessages(indexAdrMail);
                    }catch (BoiteMail.ExceptionDebordementBoite ex) {
                        System.out.println(ex.getMessage());
                        SousMenu(indexAdrMail);
                    }
                    System.out.println("Messages ajoutes!");
                    break;
                case 2: AfficherBoite(indexAdrMail); break;
                case 3:
                    try{
                        EnvoyerMessage(indexAdrMail);
                    }catch (BoiteMail.ExceptionDebordementBoite ex) {
                        System.out.println(ex.getMessage());
                        SousMenu(indexAdrMail);
                    }
                    System.out.println("Message envoye!");
                    break;
                case 4: AfficherMessage(indexAdrMail); break;
                case 5: SupprimerMessage(indexAdrMail); System.out.println("Messages supprime!");break;
                case 6: ArchiverMessage(indexAdrMail); System.out.println("Messages archive!"); break;
                case 7: RestaurerMessage(indexAdrMail); System.out.println("Messages restaure!");break;
                case 8:
                    try{
                        RepondreMessage(indexAdrMail);
                    }catch (BoiteMail.ExceptionDebordementBoite ex) {
                        System.out.println(ex.getMessage());
                        SousMenu(indexAdrMail);
                    }
                    System.out.println("Messages envoye!");
                    break;
                case 9: ViderDossier(indexAdrMail); System.out.println("Dossier vide!"); break;
                case 10: TrierMessages(indexAdrMail); System.out.println("Messages tries!"); break;
                case 11:
                    System.out.println("Voulez-vous vraiment vous deconnecter?\n" +
                            "1. Oui\n" +
                            "2. Non\n" );
                    System.out.print(">>> ");
                    int option2 = 0;
                    // Try for input.
                    try {
                        do {
                            option2 = in.nextInt();
                        } while (option2 > 2 || option2 < 1);
                    } catch (Exception e) {
                        System.out.println("Invalid Input...");
                        SousMenu(indexAdrMail);
                    }
                    // Handle Input.
                    switch (option2) {
                        case 1:
                            System.out.println("Deconnexion....");
                            Menu();
                        case 2:
                            SousMenu(indexAdrMail);
                    }
                case 12: exit(0);
                default: SousMenu(indexAdrMail);
            }
        }
    }
    public void Menu() {
        while (true) {
            System.out.println(
                    "\n**************************************************************\n" +
                    "* 1. Création des adresses e-mail (avec les profils)         *\n" +
                    "* 2. Ajouter/suppr/modifier une adresse                      *\n" +
                    "* 3. Affichage des adresses créées (par catégorie)           *\n" +
                    "* 4. Création des boites e-mail correspondantes              *\n" +
                    "* 5. Ajouter une boite                                       *\n" +
                    "* 6. Affichage des boites e-mails (avec leur contenu)        *\n" +
                    "* 7. Gestion des boites e-mails                              *\n" +
                    "* 8. Autres options de gestion                               *\n" +
                    "* 9. Quitter                                                 *\n" +
                    "**************************************************************\n");
            System.out.print(">>> ");
            int option = 0;
            Scanner in = new Scanner(System.in);
            try {
                option = in.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Input...");
                Menu();
            }
            switch (option) {
                case 1:
                    // Creer les adresses emails.
                    CreationAdrMail();
                    break;
                case 2:
                    // Ajouter/suppr/modifier une adresse
                    System.out.println("Voulez-vous:\n" +
                            "1. Ajouter une adresse e-mail\n" +
                            "2. Supprimer une adresse e-mail\n" +
                            "3. Modifier une adresse e-mail");
                    System.out.print(">>> ");
                    int option2 = 0;
                    // Try for input.
                    try {
                        do {
                            option2 = in.nextInt();
                        } while (option2 > 3 || option2 < 1);
                    } catch (Exception e) {
                        System.out.println("Invalid Input...");
                        Menu();
                    }
                    // Handle Input.
                    switch (option2) {
                        case 1: AjouterAdrMail();System.out.println("Adresse mail ajoutee!"); break;
                        case 2: SupprAdrMail(); System.out.println("Adresse mail supprimee!"); break;
                        case 3: ModifierAdrMail(); System.out.println("Adresse mail modifiee!"); break;
                    }
                    break;
                case 3:
                    // Afficher tous les adresses crees par categorie
                    AffichageAdrMail();
                    break;
                case 4:
                    // Creer les boites mail
                    CreationBoitesMail();
                    System.out.println("Boites mail crees!");
                    break;
                case 5:
                    // Ajouter une boite mail
                    AjouterBoiteMail();
                    break;
                case 6:
                    // Afficher tous les boites mail
                    AffichageBoitesMail();
                    break;
                case 7:
                    int indexAdrMail;
                    // Demander Boite Correspondante.
                    try {
                        indexAdrMail = CheckAdrMail();
                        SousMenu(indexAdrMail);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        Menu();
                    }
                case 8: AutreMenu(); break;
                case 9: exit(0);
                default: Menu();
            }
        }
    }

    // Main
    public static void main(String[] args) {
        AppMessagerie instance = new AppMessagerie();
        // Afficher Header.
        System.out.println("\n" +
                "                   Coded by: Lilia Mehamli\n" +
                "                      Section: ACAD A\n" +
                "                         Group: 1\n" +
                "                     ID: 181831083114");
        // Afficher Menu.
        instance.Menu();
    }
}
