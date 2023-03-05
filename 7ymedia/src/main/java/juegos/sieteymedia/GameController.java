/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegos.sieteymedia;
import java.util.Random;
import juegos.recursos.Baraja;
import juegos.recursos.Carta;

/**
 *
 * @author Hector
 */
public class GameController {
    private Baraja baraja;
    private Jugador jugador;
    static int valores[]={1,2,3,4,5,6,7,10,11,12};
    static String paloBaraja[]={"Espadas","Oros","Copas","Bastos"};
    
    
    public static void main(String[] args){
        
        String palo=paloAleatorio(paloBaraja[]);
        int valor=valorAleatorio(valores[]);
        Carta otraCarta=new Carta(palo,valor);
    }
    
    public void juegaMano(int valorCarta){
        }
    
    
    public static String paloAleatorio(String[] array){
        int tamañoArray=array.length;
        Random random=new Random();
        int indiceArray=random.nextInt(tamañoArray);
        return array[indiceArray];
    }
    
    public static int valorAleatorio(int[] array){
        int tamañoArray=array.length;
        Random random=new Random();
        int indiceArray=random.nextInt(tamañoArray);
        return array[indiceArray];
    }
    
       
}
