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
     * Constructeur par d�faut de Ponctuelle
     */
    public Ponctuelle()
    {
        super();
    }
    
    /**
     * Constructeur de la classe Ponctuelle avec 3 vecteurs 3D en param�tres
     * 
     * @param _amb      Vecteur3D pour la lumi�re ambiante
     * @param _diff     Vecteur3D pour la lumi�re diffuse
     * @param _spec     Vecteur3D pour la lumi�re sp�culaire
     */
    public Ponctuelle(Vecteur3D _amb, Vecteur3D _diff, Vecteur3D _spec)
    {
        super(_amb, _diff, _spec);
    }
}
