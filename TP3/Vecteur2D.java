package TP3;


/**
 * Cette classe repr�sente un veteur � deux dimensions.
 * Elle est surtout utilis�e pour d�finir les coordonn�es (u,v) de texture
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
     * Constructeur par d�faut
     * Initialise les composantes du vecteur � z�ro
     */
    public Vecteur2D()
    {
        // initialisation des composantes
        m_u=0.0f;
        m_v=0.0f;
    }
    
    /**
     * Constructeur dans lequel nous sp�cifions les valeurs de u et v
     * Initialise les composantes du vecteur en fonction des valeurs pass�es en param�tre
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
     * Ajoute au vecteur courant le vecteur pass� en param�tre
     * Les composantes du vecteur pass� en param�tres sont ajout�es � celles du vecteur courant
     * 
     * @param vecteur � ajouter � l'instance courante
     */
    public void add(Vecteur2D vecteur_somme)
    {
        this.m_u += vecteur_somme.getU();
        this.m_v += vecteur_somme.getV();
    }

    /**
     * Retourne la norme du vecteur :
     * -> racine carr�e de la somme de carr�s des deux composantes du vecteur
     *
     * @return    norme du vecteur
     */
    public float getMagnitude()
    {
        // m�thode sqrt du package de base Math (retourne normalement un double donc on transtype)
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
