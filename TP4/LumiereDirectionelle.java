package TP4;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

/**
 * Une lumi�re directionnelle repr�sente une source de lumi�re
 * situ�e � l'infini : tous les rayons �mis par cette lumi�re *
 * sont parall�les et leur direction est donn�e par un vecteur de dimension trois
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LumiereDirectionelle extends Lumiere
{

    private float[] m_direction = {0.0f,0.0f,0.0f,0.0f};
    
    /**
     * Constructeur par d�faut de la classe LumiereDirectionnelle
     * Instancie une lumi�re plac� comme un soleil au z�nith
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
     * @param _vecteurAmbiant : composante ambiante de la lumi�re
     * @param : _vecteurDiffus : composante diffuse de la lumi�re
     * @param _vecteurSpeculaire : composante sp�culaire de la lumi�re
     * @param _direction : donne la direction des rayons �mis
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
     * de lumi�re directionelle apr�s avoir appel� la m�thode d'initialisation de la 
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
