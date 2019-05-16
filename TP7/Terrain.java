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

        int dimension = 50;
        int matriceTerrain[][] = new int[dimension][dimension];
        SimplexNoise test = new SimplexNoise();
        // Remplissage de la matrice avec valeurs aléatoires
        for(int i=0; i<dimension;  i++){
            for(int j=0;j<dimension;j++){

                float res = test.noise((float)i/30.0f,(float)j/30.0f);
                //System.out.println(res);
                matriceTerrain[i][j] = (int)(res*10);
                //System.out.println(matriceTerrain[i][j]);
            }
        }

        // Affichage des cubes
        for(int i=0; i<dimension;  i++){
            for(int j=0;j<dimension;j++){
                float hauteur = (float)matriceTerrain[i][j];

                Vecteur3D vecteur1 = new Vecteur3D(dimension-2*i,hauteur,dimension-2*j); //
                Transformation translation1 = new Translation(translation0, vecteur1);
                CubeCouleur cube = new CubeCouleur(translation1, new Vecteur3D(0.964f, 0.803f, 0.505f));
                
                boolean cubeWithTree = treeGeneration();
                if (cubeWithTree)
                {
                    Vecteur3D vecteurTree = new Vecteur3D(1.0f,0.0f,-1.0f);
                    Transformation translationTree = new Translation(translation1, vecteurTree);
                    Arbre arbre1 = new Arbre(translationTree);
                    
                    // Vecteur3D vecteurTrees = new Vecteur3D(dimension-2*i,hauteur,dimension-2*j);
                    // Rotation rotationTrees = new Rotation(translation1, new Vecteur3D(0.0f,0.0f,1.0f), -90.0f);
                    // Transformation translationTrees = new Translation(rotationTrees, vecteurTrees);
                    // Arbre arbre1s = new Arbre(translationTrees);
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
    public boolean treeGeneration()
    {
        double alea = Math.random() * 100; // random entre 0 et 100
        boolean res;
        if (alea >=0 && alea <= 2)
            res = true;
        else
            res = false;
        return res;
    }
    
    // public int shittyNoise()
    // {
        // double alea = Math.random() * 120; // random entre 0 et 120
        // int niveau = 0;
        // if (alea >= 0 && alea <= 15)
            // niveau = 0;
        // else if (alea > 15  && alea <= 40)
            // niveau = 1;
        // else if (alea > 40 && alea <= 80)
            // niveau = 2;
        // else if (alea > 80 && alea <= 105)
            // niveau = 3;
        // else if (alea > 105 && alea <= 120)
            // niveau = 4;

        // return niveau;
    // }
}
