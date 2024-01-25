package org.example;

public interface Monstre {
    public void attaque(Personnage personnage);
    public void subitAttaque(int degats);
    public boolean estVivant();
    public String toString();


}
