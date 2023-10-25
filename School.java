package designPattern;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class School {

    private static School instance;
    private School(){}

    public static School getInstance() {
        if (instance == null) {
            instance = new School();
        }
        return instance;
    }

    public void display() {
        SchoolData schoolData = SchoolData.getInstance();
        Admin admin = new Admin(1, "Admin", "Admin", "01/01/1990", "Adresse de l'Admin  ");
        admin.ajouterÉlève(schoolData.getÉlèves(), new Élève(1, "Dupont", "Jean", "01/01/1990", "Adresse de Jean", 0.0f));
        try {
            FileInputStream fileIn = new FileInputStream("school_data.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            SchoolData savedData = (SchoolData) in.readObject();
            in.close();
            fileIn.close();
            schoolData = savedData;
        } catch (IOException | ClassNotFoundException e) {
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez vous connecter en tant qu'administrateur. \n indice le mot de passe est admin");
        System.out.print("Mot de passe : ");
        String motDePasse = scanner.nextLine();

        if (!motDePasse.equals("admin")) {
            System.out.println("Mot de passe incorrect. L'application se ferme.");
            return;
        }

        boolean continuer = true;
        while (continuer) {
            System.out.println("\nOptions :");
            System.out.println("1 - Ajouter un élève");
            System.out.println("2 - Ajouter un professeur");
            System.out.println("3 - Afficher les élèves");
            System.out.println("4 - Afficher les professeurs");
            System.out.println("5 - Ajouter un cours à un élève");
            System.out.println("6 - Ajouter note à un élève");
            System.out.println("7 - Afficher les cours d'un élève");
            System.out.println("8 - Quitter et sauvegarder les données");
            System.out.print("Choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); 
            

            switch (choix) {
                case 1:
                    System.out.print("Nom de l'élève : ");
                    String nomÉlève = scanner.nextLine();
                    System.out.print("Prénom de l'élève : ");
                    String prénomÉlève = scanner.nextLine();
                    System.out.print("Date de naissance de l'élève : ");
                    String dateNaissanceÉlève = scanner.nextLine();
                    System.out.print("Adresse de l'élève : ");
                    String adresseÉlève = scanner.nextLine();
                    
                    

                    Élève nouvelÉlève = new Élève(schoolData.getÉlèves().size() + 1, nomÉlève, prénomÉlève, dateNaissanceÉlève, adresseÉlève, 0.0f);
                    admin.ajouterÉlève(schoolData.getÉlèves(), nouvelÉlève);
                    System.out.println("Élève ajouté avec succès.");
                    break;
                case 2:
                    System.out.print("Nom du professeur : ");
                    String nomProfesseur = scanner.nextLine();
                    System.out.print("Prénom du professeur : ");
                    String prénomProfesseur = scanner.nextLine();
                    System.out.print("Date de naissance du professeur : ");
                    String dateNaissanceProfesseur = scanner.nextLine();
                    System.out.print("Adresse du professeur : ");
                    String adresseProfesseur = scanner.nextLine();

                    Professeur nouveauProfesseur = new Professeur(schoolData.getProfesseurs().size() + 1, nomProfesseur, prénomProfesseur, dateNaissanceProfesseur, adresseProfesseur);
                    System.out.print("Matières enseignées (séparées par des virgules) : ");
                    String matières = scanner.nextLine();
                    String[] matièresArray = matières.split(",");
                    for (String matière : matièresArray) {
                        nouveauProfesseur.ajouterMatière(matière.trim());
                    }

                    admin.ajouterProfesseur(schoolData.getProfesseurs(), nouveauProfesseur);
                    System.out.println("Professeur ajouté avec succès.");
                    break;
                case 3:
                    List<Élève> élèves = schoolData.getÉlèves();
                    System.out.println("Liste des élèves :");
                    for (Élève élève : élèves) {
                        // note
                        System.out.println("Nom : " + élève.getNom() + ", Prénom : " + élève.getPrénom() + ", Note : " + élève.getNotes());
                    }
                    break;
                case 4:
                    List<Professeur> professeurs = schoolData.getProfesseurs();
                    System.out.println("Liste des professeurs :");
                    for (Professeur prof : professeurs) {
                        System.out.println("Nom : " + prof.getNom() + ", Prénom : " + prof.getPrénom());
                    }
                    break;
                    case 5:
                    System.out.print("ID de l'élève : ");
                    int idÉlève1 = scanner.nextInt();
                    scanner.nextLine();
                    Élève élève = schoolData.getÉlèveById(idÉlève1);
                    if (élève != null) {
                        System.out.print("Nom du cours : ");
                        String nomCours = scanner.nextLine();
                        System.out.print("Horaire du cours : ");
                        String horaireCours = scanner.nextLine();
                        Cours nouveauCours = new Cours(schoolData.getCours().size() + 1, nomCours, horaireCours);
                        élève.inscrireAuCours(nouveauCours);
                        schoolData.getCours().add(nouveauCours);
                        System.out.println("Cours ajouté à l'élève " + élève.getNom() + " " + élève.getPrénom());
                    } else {
                        System.out.println("Élève non trouvé.");
                    }
                    break;
                    case 6:
                    System.out.print("ID de l'élève : ");
                    int idÉlève = scanner.nextInt();
                    élève = schoolData.getÉlèveById(idÉlève);
                    scanner.nextLine();
                    if (élève != null) {
                        System.out.print("Valeur de la note : ");
                        double valeurNote = scanner.nextDouble();
                        scanner.nextLine();
                
                        Note note = new Note(Note.getUniqueNoteId(), valeurNote);
                
                        élève.ajouterNote(note);
                
                        // Mettez à jour la note de l'élève
                        élève.setNote((float) valeurNote);
                
                        System.out.println("Note ajoutée à l'élève " + élève.getNom() + " " + élève.getPrénom());
                    } else {
                        System.out.println("Élève non trouvé.");
                    }
                    break;
                

                case 7:
                    System.out.print("ID de l'élève : ");
                    int idÉlève2 = scanner.nextInt();
                    scanner.nextLine();
                    Élève élève2 = schoolData.getÉlèveById(idÉlève2);
                    if (élève2 != null) {
                        System.out.println("Cours de l'élève " + élève2.getNom() + " " + élève2.getPrénom() + ":");
                        for (Cours cours : élève2.getCoursInscrits()) {
                            System.out.println(cours.getNomCours());
                        }
                    } else {
                        System.out.println("Élève non trouvé.");
                    }
                    break;
                
                    case 8:
    // (sérialisation)
    try {
        FileOutputStream fileOut = new FileOutputStream("school_data.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(schoolData);
        out.close();
        fileOut.close();
        System.out.println("Données sauvegardées avec succès.");
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Erreur lors de la sauvegarde des données.");
    }
    continuer = false;
    break;
                
                default:
                    System.out.println("Choix non valide. Réessayez.");
                    scanner.close();
                    break;
            }
        }
    }
}
