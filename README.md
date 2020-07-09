# Simulation-Gestion-Boites-Email
Ce projet porte sur la mise en place d’une simulation d’une gestion de boite de messagerie (boite e-mail) (écrite dans un langage orienté objet : Java)

Une boite e-mail est identifiée par une adresse électronique (exemple Section2aAacad@gmail.com), une boite e-mail comporte un ensemble de messages organisés dans différents dossiers (messages reçus, messages envoyés, brouillons, corbeille, archives, spam).

Je présente, dans un premier temps, les objectifs du TP, puis la description des différentes classes implémentées, ensuite les scénarios d’exécutions du code et je terminerai avec une conclusion générale du mini projet de TP.

# Objectifs du TP
* Manipulations des collections.
* Les collections triées et non triées.
* L’interface java.lang.Comparable et l’interface java.util.Comparator
* Implémentation de classes en java, instanciation d’objets et saisie de données.
* Manipulation des types énumérés.
* Redéfinition de méthodes (toString, equals, …)
* Création de classes par héritage.
* Rédaction d’un rapport.

# Description des Classes
Dans ce qui suit, on ne mentionne pas les constructeurs, accesseurs et mutateurs nécessaires à la manipulation des attributs de la classe :

## Package : messagerie 

### public class Profil
// Attributs

String nom, prenom;
Genre genre;
LocalDate date_nais;
BigInteger tel;
String pays;

// Méthodes
* Public Profil Saisir() : Construire un objet Profil personnalisé en effectuant des saisies au clavier.
* Public boolean Equals(Profil profil): Redéfinie afin de vérifier l’égalité ou
l’inégalité de deux profils.
* Public String toString() : Redéfinie afin de donner une description satisfaisante des objets de la classe Profil.
Ex : Lilia Mehamli
* Public enum Genre{Feminin, Masculin}: Créer le type Genre qui ne peut prendre que les valeurs: Féminin, Masculin.

### public class AdrMail
// Attributs

String pseudo;
String site;
String mp;
Profil profil ;
BoiteMail boite ;

// Méthodes
* Public boolean pseudoValide() : Vérifier la validité du pseudonyme (non vide, doit commencer par une lettre, il peut comporter des chiffres et que les caractères tiret et point).
* Public boolean siteValide() : Vérifier la validité du site (non vide, doit commencer par une lettre, il doit comporter un point et ne peut pas comporter des chiffres).
* Public boolean motDePasseValide(): Vérifier la validité du mot de passe (non vide, doit être composé de huit (08) caractères en minimum, il doit comporter des lettres, au moins un chiffre et au moins un caractère spécial).
* Public AdrMail Saisir(): Construire un objet AdrMail personnalisé en effectuant des saisies au clavier.
* Public void Afficher(): Afficher les propriétés d’un objet de classe AdrMail.
* Public void ModifierMotDePasse(): Modifier le mot de passe, en saisissant l’ancien mot de passe d’abord. Toute modification est confirmée en saisissant une deuxième fois le mot de passe.
* Public boolean Equals(AdrMail adrMail): Redéfinie afin de vérifier l’égalité ou l’inégalité de deux adresses mail.
* Public String toString(): Redéfinie afin de donner une description satisfaisante des objets de la classe AdrMail.
Ex : lilia.mehamli@protonmail.com

### public class AdrMailProf extends AdrMail
// Attributs

String entreprise;
Domaine domaine;

// Méthodes
* Public AdrMailProf Saisir(): Construire un objet AdrMailProf personnalisé en effectuant des saisies au clavier.
* Public boolean Equals(AdrMailProf adrMailProf) : Redéfinie afin de vérifierl’égalité ou l’inégalité de deux adresses mail professionelles.
* Public String toString() : Redéfinie afin de donner une description satisfaisante des objets de la classe AdrMailProf.
Ex : g.crowder@openmindsclub.net
* Public enum Domaine {recherche, production, education, sante, enseignement_superieur} : Créer le type Domaine qui ne peut prendre que les valeurs : Recherche, production, education, sante, enseignement_superieur.

### public class PieceJointe
// Attributs

String nom;
int taille;

// Méthodes
* Public PieceJointe Saisir() : Construire un objet PieceJointe personnalisé en effectuant des saisies au clavier.
* Public Boolean Equals(PieceJointe pieceJointe) : Redéfinie afin de vérifier l’égalité ou l’inégalité de deux pièces jointes.
* Public String toString() : Redéfinie afin de donner une description satisfaisante des objets de la classe PieceJointe.
Ex : Python, 253 octets

### public class Message
// Attributs

String objet;
String contenu;
LocalDate date_crt;
LocalTime heure_crt;
Etat etat;
int taille;
AdrMail expediteur;

// Méthodes
* Public Message Creer() throws ExceptionMessageVide: Construire un objet Message personnalisé en effectuant des saisies au clavier. Une exception est levée si l’objet ou le contenu attachés sont vides. L’exception ExceptionMessageVide est levee dans les methodes de mutations public String setObjet() et public String setContenu().
* Public MessageAttach CreerAvecAttach() throws ExceptionMessageVide: Construire un objet MessageAttach personnalisé en effectuant des saisies au clavier. Une exception est levée si l’objet ou le contenu attachés sont vides. L’exception ExceptionMessageVide est levee dans les methodes de mutations public String setObjet() et public String setContenu().
* Public void Afficher() : Afficher les propriétés d’un objet de classe Message.
* Public Message Modifier() : Modifier l’objet et/ou le contenu du message avant de l’envoyer. L’exception ExceptionMessageVide est levee dans les methodes de mutations public String setObjet() et public String setContenu().
* Public Boolean Equals(Message message) : Redéfinie afin de vérifier l’égalité ou l’inégalité de deux messages.
* Public String toString() : Redéfinie afin de donner une description satisfaisante des objets de la classe Message.
Ex :
Etat du message : non_lu Envoyé le 26/06/2020 à 03:13:02 h
Par : Amina Malek <a.malek@anpt.dz>
Objet : TR: Model des états financiers
Contenu : Bonjour,
Veuillez trouver ci-joint en format PDF Le model officiel des états financiers diffusé par le conseil national de la comptabilité du ministère des finances algérien. Ce model contient des tableaux financiers qui vous aideront à établir le plan financier de vos projets. Bonne réception,
Cordialement.
Taille : 183 octets
* Public enum Etat{non_lu, envoye, brouillon, archive, supprime, stocke, en_cours, retourne, lu, recu, cree} : Créer le type Etat qui ne peut prendre que les valeurs : non_lu, envoye, brouillon, archive, supprime, stocke, en_cours, retourne, lu, recu, cree.
* Public static class ExceptionMessageVide extends Exception : Créer une exception personnalisée, levée dans le cas où le message est vide. 

### public class MessageAttach extends Message
// Attributs

LinkedList<PieceJointe> piecesJointes = new LinkedList<PieceJointe>();
final int limit = 1048576; //10 Mb
  
// Méthodes
* Public MessageAttach Saisir() throws ExcepetionPieceRepetition, ExceptionExceedsTailleLimite: Construire un objet MessageAttach personnalisé en effectuant des saisies au clavier. Une exception est levée dans le cas ou on attache la même pièce jointe, si les pièces jointes dépassent 10 Mo.
* Public Boolean Equals(MessageAttach messageAttach) : Redéfinie afin de vérifier l’égalité ou l’inégalité de deux messages attaches.
* Static class ExcepetionPieceRepetition extends Exception: Créer une exception
personnalisée, levée dans le cas où on essaie d’attacher deux fois la même pièce.
* Static class ExceptionExceedsTailleLimite extends Exception: Créer une exception personnalisée, levée dans le cas où l’attachement dépasse 10Mo.
  
### public class BoiteMail
// Attributs

LinkedList<Message> recus = new LinkedList<>(),
 envoyes = new LinkedList<>(),
 brouillons = new LinkedList<>(),
 archives = new LinkedList<>(),
 corbeille = new LinkedList<>(),
 spam = new LinkedList<>();
final int capacite = 10 * 1048576; // 100 Mb
  
// Méthodes
* Public LinkedList<AdrMail> EnvoyerMessage(LinkedList<AdrMail> adresses, int indexExpediteur, Message message) : Envoyer un message à un destinataire (ou plusieurs), spécifier l’adresse (ou les adresses) du (des) destinataire(s)). Et ajouter le message dans le dossier « envoyés ». L’exception est générée à partir de la méthode appelant EnvoyerMessage().
* Public LinkedList<AdrMail> EnvoyerMessage(LinkedList<AdrMail> adresses, int indexExpediteur, MessageAttach message) : Envoyer un message à un destinataire (ou plusieurs), spécifier l’adresse (ou les adresses) du (des) destinataire(s)). Et ajouter le message dans le dossier « envoyés ». L’exception est générée à partir de la méthode appelant EnvoyerMessage().
* Public LinkedList<AdrMail> RecevoirMessage(LinkedList<AdrMail> adresses, int indexDestinataire, Message message) : Recevoir un message, l’ajouter dans le dossier « reçus », et le marquer comme « non lu » jusqu’à son ouverture (afficher son contenu).
* Public LinkedList<AdrMail> RecevoirMessage(LinkedList<AdrMail> adresses, int indexDestinataire, MessageAttach message) : Recevoir un message, l’ajouter dans le dossier « reçus », et le marquer comme « non lu » jusqu’à son ouverture (afficher son contenu).
* Public LinkedList<AdrMail> OuvrirMessage(LinkedList<AdrMail> adresses, int indexAdrMail, int indexMessage) : Ouvrir un message (l’afficher) ensuite le marquer comme lu.
* Public LinkedList<AdrMail> SupprimerMessage(LinkedList<AdrMail> adresses, int indexAdrMail, int indexMessage) : Supprimer un message (du dossier « envoyés » et/ou « reçus »), le marquer comme supprimé pour ensuite le mettre dans le dossier « corbeille ».
* Public void DetruireMessage((LinkedList<AdrMail> adresses, int indexAdrMail, int indexMessage): Définitivement supprimer un message en le supprimant de la corbeille.
* Public void DeplacerMessage((LinkedList<AdrMail> adresses, int indexAdrMail, int indexMessage) : Déplacer un message du dossier « spam » vers le dossier « reçus » et le marquer comme non lu.
* Public LinkedList<AdrMail> ArchiverMessage(LinkedList<AdrMail> adresses, int indexAdrMail, LocalDate date) : Archiver un message envoyé avant une date donnée en le déplaçant vers le dossier « archives » et le marquer comme archivé.
* Public LinkedList<AdrMail> RestaurerMessage(LinkedList<AdrMail> adresses, int indexAdrMail, int indexMessage) : Restaurer un message de la corbeille.
* Public void CréerMessage(): Créer un message et le stocker dans le dossier «brouillons » avant de l’envoyer.
* Public int EspaceUtilise() : Retourner l’espace de stockage utilisé.
* Public int EspaceRestant() : Retourner l’espace de stockage restant dans la boite.
* Public int NombreRecus() : Retourner le nombre de messages reçus (lus et non lus).
* Public int NombreEnvoyes() : Retourner le nombre de messages envoyés.
* Public int NombreBrouillon() : Retourner le nombre de messages brouillons.
* Public int NombreArchives() : Retourner le nombre de messages archivés.
* Public int NombreCorbeille() : Retourner le nombre de messages dans le dossier corbeille.
* Public int NombreSpam(): Retourner le nombre de messages dans le dossier spam.
* Public static class ExceptionDestinataireIncorrecte extends Exception : Créer une exception personnalisée, levée dans le cas où une adresse de destinataire est incorrecte ou le message est vide.
* Public static class ExceptionDebordementBoite extends Exception : Créer une exception personnalisée, levée dans le cas où la taille des messages dans une boite e-mail (tous dossiers confondus et pièces jointes comprises) atteint 80% de la capacité de stockage de la boite. L’alerte doit prévenir qu’il faut supprimer certains messages.

## Package : application 

### public class MessageComparator implements Comparator

// Méthodes
Public int compare(Object obj1, Object obj2): Comparer les Messages MyObj1 et MyObj2. Cette méthode renvoie zéro si les messages ont la même date et le même objet. Elle renvoie une valeur positive si la date ou l’objet du message MyObj1 viennent avant le message MyObj2. Sinon, une valeur négative est renvoyée.

### public class AppMessagerie
// Attributs

LinkedList<AdrMail> adresses = new LinkedList<>();
LinkedList<AdrMail> adrPublics = new LinkedList<>();
LinkedList<AdrMail> adrPros = new LinkedList<>();
LinkedList<Message> messages = new LinkedList<>();
  
// Méthodes
* Void CreationAdrMail(): Création des adresses e-mail (avec les profils).
* Void CreationMessages(): Création des messages et messages attachées.
* Void AjouterAdrMail(): Ajouter une adresse mail, afficher un message d’erreur si l’adresse mail saisie existe déjà dans le répertoire des adresses.
* Void ModifierAdrMail(): Modifier une adresse mail. Si l’adresse n’existe pas dans le répertoire de adresses, une exception est levée dans la méthode CheckAdrMail().
* Void SupprAdrMail(): Supprimer une adresse mail. Si l’adresse n’existe pas dans le répertoire de adresses, une exception est levée dans la méthode CheckAdrMail().
* Void AffichageAdrMail(): Affichage de tous les adresses créées (par catégorie).
* Void CreationBoitesMail() throws BoiteMail.ExceptionDebordementBoite: Création des boites e-mail correspondantes. Cette méthode permet l’ajout automatique des expéditeurs aux messages avant de les ajouter aux différents dossiers. Une exception est levée si la taille des messages dans une boite e-mail (tous dossiers confondus et pièces jointes comprises) atteint 80% de la capacité de stockage de la boite. L’alerte doit prévenir qu’il faut supprimer certains messages.
* Void AjouterBoiteMail() throws BoiteMail.ExceptionDebordementBoite: Ajouter une boite à une adresse mail donnée. Si l’adresse n’existe pas dans le répertoire de adresses, une exception est levée dans la méthode CheckAdrMail(). Et une erreur est affiche si l’adresse donnée possède déjà une boite mail. Cette méthode permet l’ajout automatique des expéditeurs aux messages avant de les ajouter aux différents dossiers. Une exception est levée si la taille des messages dans une boite e-mail (tous dossiers confondus et pièces jointes comprises) atteint 80% de la capacité de stockage de la boite. L’alerte doit prévenir qu’il faut supprimer certains messages.
* Void AffichageBoitesMail(): Affichage des boites e-mails (avec leur contenu).
* Void AjoutMessages(int indexAdrMail) throws BoiteMail.ExceptionDebordementBoite: Ajout automatique de messages (reçus, envoyés, brouillons). Cette méthode permet l’ajout automatique des expéditeurs aux messages avant de les ajouter aux différents dossiers (reçus, envoyés, brouillons). Une exception est levée si la taille des messages dans une boite email (tous dossiers confondus et pièces jointes comprises) atteint 80% de la capacité de stockage de la boite. L’alerte doit prévenir qu’il faut supprimer certains messages.
* AfficherBoite(int indexAdrMail): Afficher le contenu d’une boite (en séparant les dossiers, en donnant des infos espace utilisé et espace restant).
* Void EnvoyerMessage(int indexAdrMail) throws BoiteMail.ExceptionDebordementBoite: Envoyer message (une exception doit être générée si une adresse de destinataire n’existe pas dans le répertoire des adresses). Une exception est levée si la taille des messages dans une boite e-mail (tous dossiers confondus et pièces jointes comprises) atteint 80% de la capacité de stockage de la boite. L’alerte doit prévenir qu’il faut supprimer certains messages.
* Void AfficherMessages(int indexAdrMail): Afficher le contenu d’un message (avec l’en-tête).
* Void SupprimerMessage(int indexAdrMail): Supprimer un message.
* Void ArchiverMessage(int indexAdrMail): Archiver un message / ou les messages reçus avant une date d donnée. Afficher un message s’il n’existe aucun message avant la date saisie.
* Void RestaurerMessage(int indexAdrMail): Restaurer un message donné (restituer de la corbeille).
* Void RepodreMessage(int indexExpediteur) throws BoiteMail.ExceptionDebordementBoite: Répondre à un message. Une exception est levée si la taille des messages dans une boite e-mail (tous dossiers confondus et pièces jointes comprises) atteint 80% de la capacité de stockage de la boite. L’alerte doit prévenir qu’il faut supprimer certains messages. 
* Void ViderDossier(int indexAdrMail): Vider le/les dossier Spam/Envoyés.
* Void TrierMessages(int indexAdrMail): Trier les messages par date (le plus récent d’abord), par objet (ordre alphabétique).
* Void AffichAdrDeMessage(): Afficher toutes les boites (adresses mail) ayant reçu un message donné (on donnera l’objet du message). Afficher un message s’il n’existe aucune adresse qui a reçu ce message.
* Void AffichAdrRemplies(): Afficher les boites qui sont remplies à plus de 50% de leur capacité. Afficher un message s’il n’existe aucune adresse remplies a plus de 50% de sa capacité.
* Void EclaterCollectionBoites(): Eclater la collection des boites en deux collections : la première contenant les boites publiques et l’autre contenant les boites professionnelles.
* Void CalculUsage(): Pour un site donné, calculer le pourcentage d’utilisation
par la catégorie d’âge comprise entre 18 et 35 ans.
* Void AffichMessPieceJointes(): Afficher les messages ayant des pièces jointes (pour une boite donnée). Afficher un message s’il n’existe aucun message attaché.
* Void AffichNomAvecDeuxBoites(): Afficher les noms, prénoms des profils ayant au moins deux boites de messagerie. Afficher un message s’il n’existe aucun profil avec aux moins deux boites de messagerie.
* Void RechercheMessages(): Rechercher les messages par destinataire, par expéditeur, par mot clé. Afficher un message s’il n’existe aucun message avec les caractéristiques saisies par l’utilisateur.
* Void ViderBoites(): Vider toutes les boites d’un site donné (piratage du site).
* Int CheckAdrMail() throws BoiteMail.ExceptionDestinataireIncorrecte: Retourner l’index d’une adresse mail saisie au clavier, lever une exception si l’adresse est incorrect or si l’adresse n’existe pas dans le répertoire des adresses.
* Private void pressAnyKeyToContinue(): Demander à l’utilisateur de cliquer n’importe quelle touche pour continuer.
* Public void AutreMenu(): Afficher le menu des requêtes supplémentaires en boucle.
* Public void SousMenu(int indexAdrMail): Afficher le menu gestion d’une boite e-mail en boucle.
* Public void Menu(): Afficher le menu principal en boucle.
* Public static void main(String[] args): Démarrer une Machine Virtuelle Java, désigner la classe principale, et de spécifier la valeur d'un certain nombre de paramètres du programme .
  
# Conclusion 
  L’objectif de créer une simulation d’une gestion de boites de messageries (dans le langage orienté objet JAVA) en interaction avec l’utilisateur est bien atteint. Je regrette cependant qu’au début du projet, mes connaissances en Programmation Orientée Objet et surtout mes compétences dans ce domaine, étaient un peu vagues. Je me suis aperçu qu’il reste quelques façons pour permettre des optimisations supplémentaires ainsi que beaucoup de choses qu’il pourrait être intéressant d’essayer, comme par exemple, développer une interface graphique pour faciliter l’utilisation de ce programme, utilisant une bibliothèque GUI pour ce grès.
  
   Si le projet était à refaire, je ne le referai pas de la même manière. Ceci étant, le projet m’a pleinement profité et je pense beaucoup mieux comprendre maintenant ce que l’on attendait de moi et ce qu’un langage orienté objet peut apporter.
  
  Ceci dit, cette expérience m’a permis de répondre à tous les questionnements que j’avais au sujet de la programmation orientée objet, et de fortifier ma compréhension des théories acquises en cours et en TD.
