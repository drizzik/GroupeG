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
 * Write a description of class Arc here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Arc extends Objet
{

    
    private Noeud m_translationOrigine;
    /**
     * Constructor for objects of class Arc
     */
    public Arc(Noeud _parent)
    {
        super(_parent);
        
        Vecteur3D vecteur0 = new Vecteur3D(0.0f,0.0f,0.0f);
        Transformation translation0 = new Translation(this, vecteur0);
        m_translationOrigine=translation0;
        
        String textureCube = "/TP7/res/gris2.jpg";
            
        
        int t21[][] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 0}, 
                       {0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 1, 1, 1, 1, 2},
                       {0, 0, 0, 0, 0, 2, 2, 1, 1, 1, 2, 2, 2, 2, 0},
                       {0, 0, 0, 0, 2, 3, 1, 2, 2, 2, 0, 0, 4, 0, 0},
                       {0, 0, 0, 2, 3, 4, 3, 0, 0, 0, 0, 4, 0, 0, 0},
                       {0, 0, 2, 3, 4, 3, 0, 0, 0, 0, 4, 0, 0, 0, 0},
                       {0, 0, 2, 1, 3, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0},
                       {0, 2, 1, 2, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0},
                       {0, 2, 1, 2, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0},
                       {0, 2, 1, 2, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0},
                       {2, 1, 2, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {2, 1, 2, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {2, 1, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {2, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
                       
        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (t21[i][j]!=0){
                    
                         switch(t21[i][j]){
                             case 1: textureCube = "/TP7/res/marron.jpg";
                                break;
                             case 2: textureCube = "/TP7/res/marron2.jpg";
                                break;
                             case 3: textureCube = "/TP7/res/gris.jpg";
                                break;
                             case 4: textureCube = "/TP7/res/gris2.jpg";
                                break;
                             case 5: textureCube = "/TP7/res/noir.jpg";
                                break;
                            }
                     Vecteur3D vecteur1 = new Vecteur3D(15-2*i,15-2*j,0.0f);
                     Transformation translation1 = new Translation(translation0, vecteur1);
                     CubeTexture cube = new CubeTexture(translation1,textureCube);

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
