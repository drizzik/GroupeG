package TP3;

/**
 * Cette classe repr�sente un veteur � trois dimensions.
 *
 * @author Axel
 * @version 0.01
 */
public class Vecteur3D
{
    // composantes x,y et z
    float m_x,m_y,m_z;

    /**
     * Constructeur par d�faut de la classe Vecteur3D
     */
    public Vecteur3D()
    {
        // initialisation des composantes � z�ro
        m_x = 0.0f;
        m_y = 0.0f;
        m_z = 0.0f;
    }

    /**
     * Constructeur d'un Vecteur3D avec valeurs pr�d�finies
     */
    public Vecteur3D(float _x, float _y, float _z)
    {
        // initialisation des composantes en fonction des valeurs pass�es en param�tres
        m_x = _x;
        m_y = _y;
        m_z = _z;
    }

    /**
     * Accesseur de la composante X
     */
    public float getX(){
        return m_x;
    }
    
    /**
     * Accesseur de la composante Y
     */
    public float getY(){
        return m_y;
    }

    /**
     * Accesseur de la composante Z
     */
    public float getZ(){
        return m_z;
    }

}