package TP4;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

/**
 * La classe LumierePonctuelle repr�sente une source de lumi�re ponctuelle.
 * Elle est d�finie par un point dans l'espace � partir duquel vont irradier
 * les rayons �mis par cette source lumineuse ponctuelle
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LumierePonctuelle extends Lumiere
{
    // tableau de floats repr�sentant l'origine de la source lumineuse
    // la quatri�me valeur vaut 1 : cela signifie que ce tableau de r�els
    // sera interpr�t� en tant que param�tre de lumi�re ponctuelle
    private float[] m_position = {0.0f,0.0f,0.0f,1.0f};

    /**
     * Constructeur par d�faut de la classe LumiereDirectionnelle
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
     * @param _vecteurAmbiant : composante ambiante de la lumi�re
     * @param : _vecteurDiffus : composante diffuse de la lumi�re
     * @param _vecteurSpeculaire : composante sp�culaire de la lumi�re
     * @param _position : donne la direction des rayons �mis
     */
    public LumierePonctuelle(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, 
                             Vecteur3D _vecteurSpeculaire, Vecteur3D _position)
    {
        // On appelle le construction de la classe parente avec ses param�tres
        super(_vecteurAmbiant, _vecteurDiffus, _vecteurSpeculaire);
        
        // Avec le dernier param�tre, on initialise l'attribution m_position
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
