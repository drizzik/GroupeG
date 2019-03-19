package TP4;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

/**
 * La classe LumiereSpot repr�sente une source de lumi�re ponctuelle
 * qui diffuse un faisceau de lumiere selon une direction et 
 * un angle de diffusion (GL_SPOT_CUTOFF).
 * Un troisi�me parametre (GL_SPOT_EXPONENT) d�termine l'att�nuation de
 * l'intensit� lumineuse
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LumiereSpot extends LumierePonctuelle
{
    
    // la direction principale de la lumi�re spot (tableau de r�els, dimension 3)
    float[] m_spotDirection = {0.0f, 0.0f, -1.0f};
    // l'angle de diffusion de la lumiere spot (r�el entre 0 (distrib uniforme) et 128 (focus max))
    float m_spotCutoff = 0;
    // l'attenuation par rapport � la direction principale (r�el entre 0 et 90, si 180 distrib uniforme)
    float m_spotExponent = 90;
    
    /**
     * Constructeur par d�faut de la classe LumiereDirectionnelle
     * La place en [0,0,0]
     */
    public LumiereSpot()
    {
        super();
    }
    
    /**
     * Constructeur de la classe LumiereSpot avec 7 arguments
     * 
     * @param _vecteurAmbiant : composante ambiante de la lumi�re
     * @param : _vecteurDiffus : composante diffuse de la lumi�re
     * @param _vecteurSpeculaire : composante sp�culaire de la lumi�re
     * @param _position : donne la position de la source
     * @param _direction : direction du faisceau
     * @param _cutoff : angle de diffusion
     * @param _exponent : attenuation 
     */
    public LumiereSpot(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus,
                        Vecteur3D _vecteurSpeculaire, Vecteur3D _position, 
                        Vecteur3D _direction, float _cutoff, float _exponent)
    {
        // On appelle le construction de la classe parente avec ses param�tres
        super(_vecteurAmbiant, _vecteurDiffus, _vecteurSpeculaire, _position);
        m_spotDirection[0] = _direction.getX();
        m_spotDirection[1] = _direction.getY();
        m_spotDirection[2] = _direction.getZ();
        m_spotCutoff = _cutoff;
        m_spotExponent = _exponent;
    }
    
    public void initialise()
    {
        super.initialise();
        
        FloatBuffer buffDirection = BufferUtils.createFloatBuffer(4).put(m_spotDirection);
        buffDirection.position(0);

        GL11.glLight(m_currentLight, GL11.GL_SPOT_DIRECTION, buffDirection);
        GL11.glLightf(m_currentLight, GL11.GL_SPOT_EXPONENT, m_spotExponent);
        GL11.glLightf(m_currentLight, GL11.GL_SPOT_CUTOFF, m_spotCutoff);
    }

}
