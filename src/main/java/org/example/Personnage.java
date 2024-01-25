package org.example;

public interface Personnage {
    public void attaque(Monstre monstre);
    public void utiliserPouvoirSpecial();
    public void subitAttaque(int degats);
    public boolean estVivant();
    public String toString();

}
