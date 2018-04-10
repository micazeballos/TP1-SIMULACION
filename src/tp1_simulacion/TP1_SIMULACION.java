/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_simulacion;
import java.util.InputMismatchException;
import java.util.Scanner; 

public class TP1_SIMULACION {
    
     private static double[] generador(int a,double x0,int c,double m, int p){
        double x1 = (a * x0 + c) % m;
        double[] v;
        double r;
        v = new double [p]; // CUANDO ES EL GENERADOR PASAR 20 Y SINO LO QUE TE DIGA EL USUARIO
        r = x1 /(m);//se saca el menos uno para que no incluya el 1 
        System.out.println("Los 20 valores aleatorios son: ");
        System.out.println(String.format("%.4f", r));
        v[0]= r; 
        for (int i = 1 ; i <p ; i++) {
            x1 = (a * x1 + c) % m;
            r = x1 /(m); // se saca el menos uno para que no incluya el 1
        System.out.println(String.format("%.4f", r));
        v[i]= r;
        
        }
    return v;}
    
    
    public static double chiCuadr(double[] v, int k)
    {
        //tamaño del intervalo
        double t;
        t = 1/(double)k;
        //distribucion de frecuencias
        double[] distribucion;
        distribucion = new double[k];
        //frecuencia esperada
        double fe = v.length/k;
        
        
        for (int i = 0; i < v.length; i++) {
            int vuelta = 0;
            for (double j = t; Math.round(j*100) <= 100; j+=t) {
                vuelta+=1;
                if (v[i]<j){
                    distribucion[vuelta-1]+=1;
                    break;
                }
                
            }
        }
        int vuelta=0;
        System.out.println("La distribucion de frecuencias es:");
        for (double i = t; Math.round(i*100) <= 100; i+=t) {
            vuelta+=1;
            System.out.println("Intervalo [0."+(Math.round((i-t)*100))+", 0."+(Math.round(i*100))+"]: "+distribucion[vuelta-1]);
        }
        boolean agrupado=false;
        double[] v1;
        v1= new double[k/2];
        while (fe<5 && k%2==0){
            int j = 0;
            for (int i = 0; i < (k); i+=2) {
                
                v1[j]=(distribucion[i]+distribucion[i+1]);
                j++;
            }
            fe*=2;
            t*=2;
            k/=2;
            agrupado=true;
            
            vuelta=0;
            System.out.println("La distribucion de frecuencias es:");
            for (double i = t; Math.round(i*100) <= 100; i+=t) {
            vuelta+=1;
            System.out.println("Intervalo ["+(i-t)+", "+i+"]: "+v1[vuelta-1]);
            
        }
            
        }
        double chi=0;
        System.out.println("Frecuencia esperada: " + fe);
        if (agrupado){
            for (int i = 0; i < k; i++) {
                
                chi+= (Math.pow(v1[i]-fe, 2)) / fe;
            }    
        }
        else
            
        {for (int i = 0; i < k; i++) {
                chi+= (Math.pow((distribucion[i]-fe),2)) / fe;}}
        return chi;}
        
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
 
 
 boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
            System.out.println("MENU");    
            System.out.println("1. Metodo congruencial multiplicativo mixto");
            System.out.println("2. Metodo congruencial multiplicativo");
            System.out.println("3. Prueba de frecuencia (Test de Chi Cuadrado)");
            System.out.println("4. Prueba de frecuencia (Test de Chi Cuadrado)con cong mixto");
            System.out.println("5. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sc.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        System.out.println("1. Metodo congruencial multiplicativo mixto");
                        
            //INGRESO DE DATOS 
            System.out.println("Empezaremos con el ingreso de datos...");

            //Semilla
            System.out.println("Ingrese un valor inicial o semilla : ");
            double x0= sc.nextInt();
            //Cte multiplicativa
            int a;
            System.out.println("Ingrese la constante multiplicativa");
            a=sc.nextInt();
            //Cte aditiva
            System.out.println("Ingrese la constante aditiva");
            int c=sc.nextInt();
            //Modulo 
            System.out.println("Ingrese el modulo");
            int m=sc.nextInt();
           
        System.out.println("Finalizamos el ingreso de datos");
       
        //METODO CONGRUENCIAL MULTIPLICATIVO MIXTO
        double v[];
        v=generador( a, x0, c, m, 20);             
        
        //PARA VER LA CONTINUACION DE LA SERIE UNO A UNO 
        System.out.println("Quiere ver la continuacion de los numeros de la serie de a un valor por vez?");
        System.out.println("Ingrese s (si) o n (no)");
        String res; 
        res = sc.next();
            
       double e = v[19];
      
        while ("s".equals(res))
        {   double xa= m * e; 
            v = generador( a, xa, c, m, 1);
            e= v[0];
            // System.out.println(String.format("%.4f", r));
            System.out.println("Quiere ver el siguiente numero?");
         res = sc.next();
        }
            break;
                        case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        System.out.println("2. Metodo congruencial multiplicativo");
                        
            //INGRESO DE DATOS 
            System.out.println("Empezaremos con el ingreso de datos...");

            //Semilla
            System.out.println("Ingrese un valor inicial o semilla : ");
            double x0m= sc.nextInt();
            //Cte multiplicativa
            int am;
            System.out.println("Ingrese la constante multiplicativa");
            am=sc.nextInt();
            //Modulo 
            System.out.println("Ingrese el modulo");
            int mm=sc.nextInt();
           
            System.out.println("Finalizamos el ingreso de datos");
                        
            //  Metodo congruencial Multiplicativo
            double vm[];
            vm = generador(am,x0m,0,mm, 20);
        
            //PARA VER LA CONTINUACION DE LA SERIE UNO A UNO 
        System.out.println("Quiere ver la continuacion de los numeros de la serie de a un valor por vez?");
        System.out.println("Ingrese s (si) o n (no)");
        String resm; 
        resm = sc.next();
            
       double em = vm[19];
      
        while ("s".equals(resm))
        {   double xam= mm * em; 
            vm = generador( am, xam, 0, mm, 1);
            em= vm[0];
            // System.out.println(String.format("%.4f", r));
            System.out.println("Quiere ver el siguiente numero?");
         resm = sc.next();
        }
                        break;
                        
                    case 3:
            System.out.println("Has seleccionado la opcion 3");
            System.out.println("3. Prueba de frecuencia (Test de Chi Cuadrado)");
            
            //Cantidad de numeros de la serie
            System.out.println("______________");
            System.out.println("Ingrese la cantidad de numeros a generar.");
            int n=sc.nextInt();
            
            double[] v2;
            v2 = new double [n];
            
            for (int i = 0; i < n; i++) {
                v2[i]=Math.random();
                System.out.println(v2[i]);
            }
            
            System.out.println("______________");
            System.out.println("Ingrese el número de intervalos que desea en la distribución de frecuencias:");
            int k = sc.nextInt();
            double chi = chiCuadr(v2, k);
            
            System.out.println("Variable Chi cuadrado calculada es: "+ chi);
            break;
            
                    case 4:
            System.out.println("Has seleccionado la opcion 4");
            System.out.println("4. Prueba de frecuencia (Test de Chi Cuadrado)con cong mixto");
            //INGRESO DE DATOS 
                      System.out.println("Empezaremos con el ingreso de datos...");
            //Semilla
            System.out.println("Ingrese un valor inicial o semilla : ");
            double x0n= sc.nextInt();
            //Cte multiplicativa
            System.out.println("Ingrese la constante multiplicativa");
            int an=sc.nextInt();
            //Cte aditiva
            System.out.println("Ingrese la constante aditiva");
            int cn=sc.nextInt();
            //Modulo 
            System.out.println("Ingrese el modulo");
            int mn=sc.nextInt();
            //Cantidad de numeros de la serie
            System.out.println("______________");
            System.out.println("Ingrese la cantidad de numeros a generar.");
            n = sc.nextInt();
            
            System.out.println("Finalizamos el ingreso de datos");
            
            double[] v3;
            v3 =new double [n];
            
            //generador(int a,double x0,int c,double m, int p); (PONER GENERADOR MIXTO, yo lo probe con el multiplicativo que ya lo tenia echo)
            v3=generador(an,x0n,cn,mn, n);
            
            System.out.println("______________");
            System.out.println("Ingrese el número de intervalos que desea en la distribución de frecuencias:");
            k = sc.nextInt();
            chi = chiCuadr(v3, k);
            
            System.out.println("Variable Chi cuadrado calculada es: "+ chi);
            
            break;
                    case 5:
                        salir = true;
                        System.out.println("SALIR.");
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sc.next();
            }
    
}}
    

}
