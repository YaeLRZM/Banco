
package Funciones;

public class ClaseMain {
    public static void main(String[] args){
     clsBD_Conexion objConectar=new clsBD_Conexion();
     try{
         objConectar.conectarBD();
         if(objConectar.getEstado()){
             System.out.println("Desconectado");   
         }
         else{
             System.out.println("Conectado");
         }
     }catch(Exception e){
         System.out.println("Error");
     }
    }
}
