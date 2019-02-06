package TP3;


/**
 * Write a description of class Ponctuelle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ponctuelle extends Lumiere
{

    /**
     * Constructeur par défaut de Ponctuelle
     */
    public Ponctuelle()
    {
        super();
    }
    
    /**
     * Constructeur de la classe Ponctuelle avec 3 vecteurs 3D en paramètres
     * 
     * @param _amb      Vecteur3D pour la lumière ambiante
     * @param _diff     Vecteur3D pour la lumière diffuse
     * @param _spec     Vecteur3D pour la lumière spéculaire
     */
    public Ponctuelle(Vecteur3D _amb, Vecteur3D _diff, Vecteur3D _spec)
    {
        super(_amb, _diff, _spec);
    }
}
