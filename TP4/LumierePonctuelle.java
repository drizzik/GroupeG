package TP4;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

/**
 * La classe LumierePonctuelle représente une source de lumière ponctuelle.
 * Elle est définie par un point dans l'espace à partir duquel vont irradier
 * les rayons émis par cette source lumineuse ponctuelle
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LumierePonctuelle extends Lumiere
{
    // tableau de floats représentant l'origine de la source lumineuse
    // la quatrième valeur vaut 1 : cela signifie que ce tableau de réels
    // sera interprété en tant que paramètre de lumière ponctuelle
    private float[] m_position = {0.0f,0.0f,0.0f,1.0f};

    /**
     * Constructeur par défaut de la classe LumiereDirectionnelle
     * La place en [0,0,0]
     */
    public LumierePonctuelle()
    {
        super();
        m_position[0] = 0.0f;
        m_position[1] = 0.0f;
        m_position[2] = 0.0f;
        m_position[3] = 1.0f; // cf https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/
    }
    
    /**
     * Constructeur de la classe LumierePonctuelle avec 4 arguments
     * 
     * @param _vecteurAmbiant : composante ambiante de la lumière
     * @param : _vecteurDiffus : composante diffuse de la lumière
     * @param _vecteurSpeculaire : composante spéculaire de la lumière
     * @param _position : donne la direction des rayons émis
     */
    public LumierePonctuelle(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, 
                             Vecteur3D _vecteurSpeculaire, Vecteur3D _position)
    {
        // On appelle le construction de la classe parente avec ses paramètres
        super(_vecteurAmbiant, _vecteurDiffus, _vecteurSpeculaire);
        
        // Avec le dernier paramètre, on initialise l'attribution m_position
        m_position[0] = _position.getX();
        m_position[0] = _position.getY();
        m_position[0] = _position.getZ();
        m_position[0] = 1.0f; // cf https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/
         
    }
    
    public void initialise()
    {
        super.initialise();
         
        FloatBuffer buffPosition = BufferUtils.createFloatBuffer(4).put(m_position);
        buffPosition.position(0);

        GL11.glLight(m_currentLight, GL11.GL_AMBIENT, buffPosition);
    }
}
