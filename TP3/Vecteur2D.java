package TP3;


/**
 * Cette classe représente un veteur à deux dimensions.
 * Elle est surtout utilisée pour définir les coordonnées (u,v) de texture
 *
 * @author Axel
 * @version 0.01
 */
public class Vecteur2D
{
    // instance variables - replace the example below with your own
    private float m_u=0.0f;
    private float m_v=0.0f;

    /**
     * Constructeur par défaut
     * Initialise les composantes du vecteur à zéro
     */
    public Vecteur2D()
    {
        // initialisation des composantes
        m_u=0.0f;
        m_v=0.0f;
    }
    
    /**
     * Constructeur dans lequel nous spécifions les valeurs de u et v
     * Initialise les composantes du vecteur en fonction des valeurs passées en paramètre
     * 
     * @param u_param valeur de la composante u
     * @param v_param valeur de la composante v
     */
    public Vecteur2D(float u_param,float v_param)
    {
        // initialisation des composantes
        m_u=u_param;
        m_v=v_param;
    }
    
    /**
     * Ajoute au vecteur courant le vecteur passé en paramètre
     * Les composantes du vecteur passé en paramètres sont ajoutées à celles du vecteur courant
     * 
     * @param vecteur à ajouter à l'instance courante
     */
    public void add(Vecteur2D vecteur_somme)
    {
        this.m_u += vecteur_somme.getU();
        this.m_v += vecteur_somme.getV();
    }

    /**
     * Retourne la norme du vecteur :
     * -> racine carrée de la somme de carrés des deux composantes du vecteur
     *
     * @return    norme du vecteur
     */
    public float getMagnitude()
    {
        // méthode sqrt du package de base Math (retourne normalement un double donc on transtype)
        return (float)Math.sqrt(m_u*m_u+m_v*m_v);
    }

    /**
     * Accesseur pour la composante u
     *
     * @return    la composante u
     */
    public float getU()
    {
        return m_u;
    }
    
    /**
     * Accesseur pour la composante v
     *
     * @return    la composante v
     */
    public float getV()
    {
        return m_v;
    }
    
    /**
     * Mutateur pour la composante u
     *
     * @param la nouvelle valeur de u
     */
    public void setU(float new_u)
    {
        this.m_u = new_u;
    }
    
    /**
     * Accesseur pour la composante v
     *
     * @param la nouvelle valeur de v
     */
    public void setV(float new_v)
    {
        this.m_v = new_v;
    }

}
