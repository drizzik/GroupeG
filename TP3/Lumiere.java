package TP3;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

/**
 * Classe abstraite Lumiere
 * Va regrouper les valeurs AMBIENT, DIFFUSE et SPECULAR
 *
 * @author Axel
 * @version 0.01
 */
public abstract class Lumiere
{  
    private float[] ambient = {0.0f,0.0f,0.0f,0.0f};
    private float[] diffuse = {0.0f,0.0f,0.0f,0.0f};
    private float[] specular = {0.0f,0.0f,0.0f,0.0f};
    
    protected int currentLight = -1;
    
    private static int nextFreeLight = GL11.GL_LIGHT0;

    /**
     * Constructeur de la classe abstraite Lumiere
     * Va incrémenter l'ID à chaque instance 
     * (currentLight est static donc partagé entre toutes les instances de Lumiere)
     */
    public Lumiere()
    {
        currentLight = nextFreeLight;
        nextFreeLight++;
    }
    
    /**
     * Constructeur de la classe abstraite Lumiere avec valeurs données
     * pour les composantes ambiantes, diffuses et spéculaires de la lumiere
     * 
     * @param _amb      Vecteur3D pour la lumière ambiante
     * @param _diff     Vecteur3D pour la lumière diffuse
     * @param _spec     Vecteur3D pour la lumière spéculaire
     */
    public Lumiere(Vecteur3D _amb, Vecteur3D _diff, Vecteur3D _spec)
    {
        this();
        
        ambient[0] = _amb.getX();
        ambient[1] = _amb.getY();
        ambient[2] = _amb.getZ();
        ambient[3] = 1.0f;
       
        diffuse[0] = _diff.getX();
        diffuse[1] = _diff.getY();
        diffuse[2] = _diff.getZ();
        diffuse[3] = 1.0f;
        
        specular[0] = _spec.getX();
        specular[1] = _spec.getY();
        specular[2] = _spec.getZ();
        specular[3] = 1.0f;
    }
    
    /**
     * Initialisation de la lumière courante
     */
    public void initialise()
    {
        FloatBuffer buffAmbient = BufferUtils.createFloatBuffer(4).put(ambient);
        buffAmbient.position(0);
                
        FloatBuffer buffDiffuse = BufferUtils.createFloatBuffer(4).put(diffuse);
        buffDiffuse.position(0);
        
        FloatBuffer buffSpecular = BufferUtils.createFloatBuffer(4).put(specular);
        buffSpecular.position(0);
                
        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_AMBIENT, buffAmbient);
        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_DIFFUSE, buffDiffuse);
        GL11.glLight(GL11.GL_LIGHT1, GL11.GL_SPECULAR, buffSpecular);
    }
    
    /**
     * Active la lumiere courante
     * En supposant que GL_LIGHTNING est activé
     */
    public void allumer()
    {
        GL11.glEnable(currentLight);
    }
    
    /**
     * 
     */
    public void eteindre()
    {
        GL11.glDisable(currentLight);
    }
}
