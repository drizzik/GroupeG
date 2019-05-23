package TP7;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import org.lwjgl.util.glu.GLU;

import org.lwjgl.input.Keyboard;

import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

import TP4.*;
import TP6.*;

import java.io.*;
import java.util.Vector;

/**
 * Write a description of class Arbre here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Arbre extends Objet
{

    
    private Noeud m_translationOrigine;
    /**
     * Constructor for objects of class Arbre
     */
    public Arbre(Noeud _parent)
    {
        super(_parent);
        
        Vecteur3D vecteur0 = new Vecteur3D(0.0f,0.0f,0.0f);
        Transformation translation0 = new Translation(this, vecteur0);
        m_translationOrigine=translation0;
        
        Vecteur3D textureCube = new Vecteur3D(1.0f,1.0f,1.0f);
        
        int dimensionsX = 5;
        int dimensionsY = 7;
        
        int t21[][] = {{0, 2, 2, 2, 0},
                       {0, 2, 1, 2, 0},
                       {2, 2, 1, 2, 2},
                       {2, 2, 1, 2, 2},
                       {0, 0, 1, 0, 0},
                       {0, 0, 1, 0, 0},
                       {0, 0, 1, 0, 0}};
                       
        for(int i=dimensionsX-1; i>-1;  i--){
            for(int j=dimensionsY-1;j>-1;j--){
                if (t21[j][i]!=0){
                    
                         switch(t21[j][i]){
                             case 1: textureCube = new Vecteur3D(0.33f,0.22f,0.0f);
                                break;
                             case 2: textureCube = new Vecteur3D(0.28f,0.54f,0.0f);
                                break;
                            }
                     Vecteur3D vecteur1 = new Vecteur3D(dimensionsX-2-2*i,2*dimensionsY-2*j,-1.0f);
                     Transformation translation1 = new Translation(translation0, vecteur1);
                     CubeCouleur cube = new CubeCouleur(translation1, textureCube);
                     CubeFilDeFer contour = new CubeFilDeFer(translation1);   
                    } 
                }
            }
                    int t23[][] = {{0, 0, 0, 0, 0},
                                   {0, 0, 0, 0, 0},
                                   {2, 2, 2, 2, 2},
                                   {2, 2, 2, 2, 2},
                                   {0, 0, 0, 0, 0},
                                   {0, 0, 0, 0, 0},
                                   {0, 0, 0, 0, 0}};
                       
        for(int i=dimensionsX-1; i>-1;  i--){
            for(int j=dimensionsY-1;j>-1;j--){
                if (t23[j][i]!=0){
                    
                         switch(t23[j][i]){
                             case 1: textureCube = new Vecteur3D(0.33f,0.22f,0.0f);
                                break;
                             case 2: textureCube = new Vecteur3D(0.28f,0.54f,0.0f);
                                break;
                            }
                     Vecteur3D vecteur1 = new Vecteur3D(dimensionsX-2-2*i,2*dimensionsY-2*j,1.0f);
                     Vecteur3D vecteur4 = new Vecteur3D(dimensionsX-2-2*i,2*dimensionsY-2*j,-3.0f);
                     Transformation translation1 = new Translation(translation0, vecteur1);
                     Transformation translation4 = new Translation(translation0, vecteur4);
                     CubeCouleur cube = new CubeCouleur(translation1, textureCube);
                     CubeCouleur cube2 = new CubeCouleur(translation4, textureCube);
                     CubeFilDeFer contour = new CubeFilDeFer(translation1);
                     CubeFilDeFer contour2 = new CubeFilDeFer(translation4);
                    } 
                }
            }
            int t22[][] = {{0, 0, 2, 0, 0},
                           {0, 2, 2, 2, 0},
                           {2, 2, 2, 2, 2},
                           {2, 2, 2, 2, 2},
                           {0, 0, 0, 0, 0},
                           {0, 0, 0, 0, 0},
                           {0, 0, 0, 0, 0}};
                       
        for(int i=dimensionsX-1; i>-1;  i--){
            for(int j=dimensionsY-1;j>-1;j--){
                if (t22[j][i]!=0){
                    
                         switch(t22[j][i]){
                             case 1: textureCube = new Vecteur3D(0.33f,0.22f,0.0f);
                                break;
                             case 2: textureCube = new Vecteur3D(0.28f,0.54f,0.0f);
                                break;
                            }
                     Vecteur3D vecteur1 = new Vecteur3D(dimensionsX-2-2*i,2*dimensionsY-2*j,0.0f);
                     
                     Vecteur3D vecteur3 = new Vecteur3D(dimensionsX-2-2*i,2*dimensionsY-2*j,-2.0f);
                     
                     Transformation translation1 = new Translation(translation0, vecteur1);
                     
                     Transformation translation3 = new Translation(translation0, vecteur3);
                     
                     CubeCouleur cube = new CubeCouleur(translation1, textureCube);
                     
                     CubeCouleur cube3 = new CubeCouleur(translation3, textureCube);
                     
                     CubeFilDeFer contour = new CubeFilDeFer(translation1);
                     CubeFilDeFer contour2 = new CubeFilDeFer(translation3);

                    } 
                }
            }
            
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void dessine()
    {
        m_translationOrigine.affiche();
    }
}
