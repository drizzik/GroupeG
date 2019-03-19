package TP4;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

/**
 * Une lumière directionnelle représente une source de lumière
 * située à l'infini : tous les rayons émis par cette lumière *
 * sont parallèles et leur direction est donnée par un vecteur de dimension trois
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LumiereDirectionelle extends Lumiere
{

    private float[] m_direction = {0.0f,0.0f,0.0f,0.0f};
    
    /**
     * Constructeur par défaut de la classe LumiereDirectionnelle
     * Instancie une lumière placé comme un soleil au zénith
     */
    public LumiereDirectionelle()
    {
        super();
        m_direction[0] = 0.0f;
        m_direction[1] = -1.0f;
        m_direction[2] = 0.0f;
        m_direction[3] = 0.0f; // cf https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/
    }
    
    /**
     * Constructeur de la classe LumierePonctuelle avec 4 arguments
     * 
     * @param _vecteurAmbiant : composante ambiante de la lumière
     * @param : _vecteurDiffus : composante diffuse de la lumière
     * @param _vecteurSpeculaire : composante spéculaire de la lumière
     * @param _direction : donne la direction des rayons émis
     */
    public LumiereDirectionelle(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, 
                             Vecteur3D _vecteurSpeculaire, Vecteur3D _direction)
    {
        super(_vecteurAmbiant, _vecteurDiffus, _vecteurSpeculaire);
        m_direction[0] = _direction.getX();
        m_direction[0] = _direction.getY();
        m_direction[0] = _direction.getZ();
        m_direction[0] = 0.0f; // cf https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/      
    }
    
    /**
     * On initialise la valeur du vecteur de direction pour cette instance de classe 
     * de lumière directionelle après avoir appelé la méthode d'initialisation de la 
     * classe parente
     */
    public void initialise()
    {
        super.initialise();
        
        FloatBuffer buffDirection = BufferUtils.createFloatBuffer(4).put(m_direction);
        buffDirection.position(0);

        GL11.glLight(m_currentLight, GL11.GL_AMBIENT, buffDirection);
        
    }

}
