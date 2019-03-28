package TP7;


/**
 * Classe singleton qui représente une Horlge dont l'instance unique 
 * garantie que la base de temps sera partagée par toutes les instances
 * uitlisatrices du Singleton
 *
 * @author Alexis Heloir
 * @version 2019/03/26
 */
public class Horloge
{
    // instance variables - replace the example below with your own
    private static Horloge m_instanceUnique = null;
    
    private long m_startTime = 0;
    private long m_lastTick = 0;

/**
 * Constructeur de la classe horloge
 */
    public Horloge()
    {
        m_startTime = System.currentTimeMillis();
        m_lastTick = m_startTime;
    }
    


    /**
     * Conbien de temps se sont écoulés depuis le dernier tick()?
     * @return le temps écoulé depuis le dernier tick (em millisecondes)
     */
    public long getTempsPasseDepuisDernierTick(){
        long tempsPasse = System.currentTimeMillis()-m_lastTick;
        m_lastTick += tempsPasse;
        return tempsPasse;
    }

    
    
}
