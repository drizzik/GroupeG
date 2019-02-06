package TP3;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

/**
 * Write a description of class Ponctuelle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ponctuelle extends Lumiere
{

    private float[] direction = {0.0f,0.0f,0.0f,0.0f};
    
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
    public Ponctuelle(Vecteur3D _amb, Vecteur3D _diff, Vecteur3D _spec, Vecteur3D _direction)
    {
        super(_amb, _diff, _spec);
        direction[0] = _direction.getX();
        direction[1] = _direction.getY();
        direction[2] = _direction.getZ();
        direction[3] = 1.0f;
       
    }
    
    /**
     * Initialisation de la lumière ponctuelle courante
     */
    public void initialise()
    {
        
        super.initialise();
        FloatBuffer buffDirection = BufferUtils.createFloatBuffer(4).put(direction);
        buffDirection.position(0);
                
        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_AMBIENT, buffDirection);
    }
}
