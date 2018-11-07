package fr.laerce.cinema;

import java.util.Comparator;

public class FilmComparator implements Comparator<Film> {
    @Override
    public int compare(Film f1, Film f2) {
        return f1.titre.compareToIgnoreCase(f2.titre);
    }
}
