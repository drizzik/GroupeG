package TP7;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import org.lwjgl.util.glu.GLU;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

import TP4.*;
import TP6.*;

import java.io.*;


/**
* La classe Monde est le noeud primordial à l'origine du graphe
* de scène. Elle prend en charge les interactions ainsi que l'initialisation
* du contexte OpenGL
*
* @author Alexis Heloir
* @version 2019/03/21
*/
public class Monde extends Noeud
{
static final int MS_ENTRE_DEUX_AFFICHAGES = 40; // 25 affichages par secondes

private boolean m_done = false; // Est ce que l'application doit se terminer?
private boolean m_fullscreen = false; // Est-ce que l'application doit être plein écran?
private final String m_windowTitle = "OpenGL et Graphe de scène"; // Titre de l'application
private boolean m_f1 = false; // A t-on appuyé sur la touche F1?
private DisplayMode m_displayMode; // propriétés de la fenêtre d'affichage

private boolean m_filter = false; // Est-ce  que l'on applique le mipmapping de texture 

private int dx,dy;
private float yaw,pitch,xoff,yoff;
private double lookx,looky,lookz;   
    /**
     * Le constructuer de la classe Monde ne prend pas de parmètre : la classe Monde 
     * n'a pas de parent car son instance (souvent unique) est à l'origine du graphe de scène.
     */
    public Monde()
    {
        super(null);
        Mouse.setGrabbed(true);
        dx = 0;
        dy = 0;
    }
    
    /**
     * La méthode affiche vides les buffers du contexte OpenGL puis appelle de manière 
     * récursive la méthode affiche pour l'ensemble des noeuds enfants. Le graphe de scene est ainsi parcouru.
     */
    public void affiche(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);          // Clear The Screen And The Depth Buffer

        for (int i=0; i<m_enfants.size(); i++ )
        {
            m_enfants.get(i).affiche();
        }        

    }

    /**
     * Méthode responsable de la gestion des interactions avec l'utilisateur --
     * elle gère principalement les interruptions clavier
     */
    private void interactionManagement() {
        if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {       // Exit if Escape is pressed
            m_done = true;
        }
        if(Display.isCloseRequested()) {                     // Exit if window is closed
            m_done = true;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_F1) && !m_f1) {    // Is F1 Being Pressed?
            m_f1 = true;                                      // Tell Program F1 Is Being Held
            switchMode();                                   // Toggle Fullscreen / Windowed Mode
        }
        if(!Keyboard.isKeyDown(Keyboard.KEY_F1)) {          // Is F1 Being Pressed?
            m_f1 = false;
        }
        if(!Keyboard.isKeyDown(Keyboard.KEY_F)) {          // Is F Being Pressed?
            m_filter = true;
        }        
        
        lookAtMousePosition();
    }
    
    private void lookAtMousePosition()
    {
        dx = Mouse.getDX();
        dy = Mouse.getDY();

        float sensitivity = 0.5f;
        xoff = dx * sensitivity;
        yoff = dy * sensitivity;
    
        yaw += xoff;                // yaw is x
        pitch += yoff;              // pitch is y
    
        // Limit up and down camera movement to 90 degrees
        if (pitch > 89.0f)
            pitch = 89.0f;
        if (pitch < -89.0f)
            pitch = -89.0f;
    
        // Update camera position and viewing angle
        lookx = Math.cos(yaw*2*Math.PI/360) * Math.cos(pitch*2*Math.PI/360);
        looky = Math.sin(pitch*2*Math.PI/360);
        lookz = Math.sin(yaw*2*Math.PI/360) * Math.cos(pitch*2*Math.PI/360);
        
        GLU.gluLookAt(0.0f,  0.0f,  0.0f,  
                      (float)lookx,(float)looky,(float)lookz,  
                      0.0f,  1.0f,  0.0f);
    }
    
    /**
     *  Appelé par la méthode interactionManagement() en charge de capturer les
     *  évènments clavier. Cette méthode gère l'attribut sanctionnant le mode plein
     *  écran
     */
    private void switchMode() {
        m_fullscreen = !m_fullscreen;
        try {
            Display.setFullscreen(m_fullscreen);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void start(boolean fullscreen) {
        this.m_fullscreen = fullscreen;
        try {
            initGL();
            prepareScene();
            while (!m_done) {
                Thread.sleep(MS_ENTRE_DEUX_AFFICHAGES);
                interactionManagement();
                affiche();
                Display.update();
            }
            cleanup();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
        
    private void initGL() throws Exception {
        
        createWindow();
      
        if (m_filter){
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MAG_FILTER,GL11.GL_LINEAR); // contre l'aliasage proche
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MIN_FILTER,GL11.GL_LINEAR); // contre l'aliasage lointain
        }else{
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MAG_FILTER,GL11.GL_NEAREST); // contre l'aliasage proche
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MIN_FILTER,GL11.GL_NEAREST); // contre l'aliasage lointain
        }
        
        GL11.glEnable(GL11.GL_TEXTURE_2D); // Enable Texture Mapping
        GL11.glShadeModel(GL11.GL_SMOOTH); // Enable Smooth Shading
        GL11.glClearColor(0.5f, 0.8f, 1.0f, 0.0f); // Black Background
        GL11.glClearDepth(1.0); // Depth Buffer Setup
        GL11.glEnable(GL11.GL_DEPTH_TEST); // Enables Depth Testing
        GL11.glDepthFunc(GL11.GL_LEQUAL); // The Type Of Depth Testing To Do

        GL11.glEnable(GL11.GL_CULL_FACE); // Back face culling 
        
        GL11.glMatrixMode(GL11.GL_PROJECTION); // Select The Projection Matrix
        GL11.glLoadIdentity(); // Reset The Projection Matrix

        // Calculate The Aspect Ratio Of The Window
        GLU.gluPerspective(
          45.0f,
          (float) m_displayMode.getWidth() / (float) m_displayMode.getHeight(),
          0.1f,
          1000.0f);

        GL11.glMatrixMode(GL11.GL_MODELVIEW); // Select The Modelview Matrix
        
        GL11.glEnable(GL11.GL_LIGHTING);
        
        LumiereDirectionelle maLumiere = new LumiereDirectionelle();
        maLumiere.allumer();
        
        // GL11.glDisable(GL11.GL_LIGHTING);
        
    }

    private void prepareScene(){
        // TERRAIN
        // Vecteur3D vecteur1 = new Vecteur3D(-0.0f,-20.0f,-60.0f);
        // Transformation translation1 = new Translation(this, vecteur1);
        // Rotation rotationCamera = new Rotation(translation0, new Vecteur3D(1.0f,0.0f,0.0f), -20.0f);
        
        Vecteur3D vecteur0 = new Vecteur3D(-0.0f,-20.0f,-60.0f);
        Transformation translation0 = new Translation(this, vecteur0);
        
        
        // DEPLACEMENT TERRAIN
        DeplacementTerrain depTerrain = new DeplacementTerrain(translation0, new Vecteur3D(1.0f,1.0f,1.0f));
        //RotationAnimee rota = new RotationAnimee(translation0, new Vecteur3D(0.0f,1.0f,0.0f), 90.0f, 5000);
        
        Terrain terter = new Terrain(depTerrain);
    }
    
    private void createWindow() throws Exception {
        Display.setFullscreen(m_fullscreen);
        DisplayMode d[] = Display.getAvailableDisplayModes();
        for (int i = 0; i < d.length; i++) {
            if (d[i].getWidth() == 1920
                && d[i].getHeight() == 1080
                && d[i].getBitsPerPixel() == 32) {
                m_displayMode = d[i];
                break;
            }
        }
        Display.setDisplayMode(m_displayMode);
        Display.setTitle(m_windowTitle);
        Display.create();
    }

    
    private static void cleanup() {
        Display.destroy();
    }    

    /**
     * Méthode statique permettant de lancer l'application depuis la ligne de commande
     */
    public static void main(String[] argv) {
        String OS = System.getProperty("os.name").toLowerCase();
        String path = "";
        try{
            if(OS.indexOf("win") >= 0){
                path = Monde.class.getResource("../native/windows").getPath();
                path = java.net.URLDecoder.decode(path, "UTF-8");
            }
            if(OS.indexOf("linux") >= 0){
                path = Monde.class.getResource("../native/linux").getPath();
                path = java.net.URLDecoder.decode(path, "UTF-8");                
            }
            if(OS.indexOf("mac") >= 0){
                path = Monde.class.getResource("../native/macosx").getPath();
                path = java.net.URLDecoder.decode(path, "UTF-8");
            }
            System.setProperty("org.lwjgl.librarypath", path);
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // il est possible de passer l'argument "fullscreen" lors de l'invocation de la fonction 
        //<b>main()</b> pour que la fenètre soit affichée en mode plein écran
        boolean fullscreen = false;
        if(argv.length>0) {
            if(argv[0].equalsIgnoreCase("fullscreen")) {
                fullscreen = true;
            }
        }
        
        Monde monMonde = new Monde();
        monMonde.start(fullscreen);
    }
    
}


