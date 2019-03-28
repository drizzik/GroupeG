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

import java.util.Random;

/**
 * Write a description of class Terrain here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Terrain extends Objet
{

    private Noeud m_translationOrigine;
    /**
     * Constructor for objects of class Terrain
     */
    public Terrain(Noeud _parent)
    {
        super(_parent);

        Vecteur3D vecteur0 = new Vecteur3D(0.0f,0.0f,0.0f);
        Transformation translation0 = new Translation(this, vecteur0);
        m_translationOrigine=translation0;

        String textureCube = "/TP7/res/gris2.jpg";
        
        int dimension = 15;
        int matriceTerrain[][] = new int[dimension][dimension];

        // Remplissage de la matrice avec valeurs aléatoires
        for(int i=0; i<dimension;  i++){
            for(int j=0;j<dimension;j++){
                int noise = shittyNoise();
                int valeurPrec = 0;
                if (j==0 && i>0)
                    valeurPrec = matriceTerrain[i-1][14];
                else if (j==0 && i==0)
                    valeurPrec=0;
                else
                    valeurPrec = matriceTerrain[i][j-1];
                    
                switch (noise){
                    case 0 : matriceTerrain[i][j] = valeurPrec-2;
                        break;
                    case 1 : matriceTerrain[i][j] = valeurPrec-1;
                        break;
                    case 2 : matriceTerrain[i][j] = valeurPrec;
                        break;
                    case 3 : matriceTerrain[i][j] = valeurPrec+1;
                        break;
                    case 4 : matriceTerrain[i][j] = valeurPrec+2;
                        break;
                }               
            }
        }
        
        // Affichage des cubes
        for(int i=0; i<dimension;  i++){
            for(int j=0;j<dimension;j++){
                float _hauteur = (float)matriceTerrain[i][j];
                for (float h = 0.0f; h<=_hauteur*2; h = h+2.0f)
                {
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*i,h,15-2*j);
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
    
    /**
     * 
     */
    public int shittyNoise()
    {
        double alea = Math.random() * 125; // random entre 0 et 100
        int niveau = 0;
        if (alea >= 0 && alea <= 25)
            niveau = 0;
        else if (alea > 25  && alea <= 50)
            niveau = 1;
        else if (alea > 50 && alea <= 75)
            niveau = 2;
        else if (alea > 75 && alea <= 100)
            niveau = 3;
        else if (alea > 100 && alea <= 125)
            niveau = 4;
        
        return niveau;
    }
}
