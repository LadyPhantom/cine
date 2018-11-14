package fr.laerce.cinema;
public class Film{
    public Film(int id,String titre, String afficheNom, double note){
        this.id = id;
        this.titre = titre;
        this.afficheNom = afficheNom;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    int id;

    public double getNote() {
        return note;
    }

    public String getAfficheNom() {
        return afficheNom;
    }

    public String getTitre() {
        return titre;
    }

    String titre;
    String afficheNom;
    double note;


}