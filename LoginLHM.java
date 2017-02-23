import java.util.*;
import java.lang.*;

public class LoginLHM{
  public static String leerDato(){
    String dato = "";
    Scanner kb  = new Scanner( System.in );
    System.out.print("> ");
    dato        = kb.nextLine();
    return dato;
  }

  public static void main(String[] args) {
    // Crear el LHP
    LinkedHashMap listaUsuarios   = new LinkedHashMap();
    int opc;
    String user, passwd;
    System.out.println("----- Ejemplo LinkedHashMap -----");
    do{
      System.out.println("0) Salir.\n1) Registrar tus usuarios y contraseñas.\n2) Iniciar sesión.");
      opc = Integer.parseInt( leerDato() );
      switch ( opc ) {
        case 0:
          System.out.println("Bye!");
          break;
        case 1: // Ingresar usuario y contraseña
          System.out.println("Ingresa usuario:\t");
          user  = leerDato();
          System.out.println("Ingresa contraseña:\t");
          passwd  = leerDato();
          listaUsuarios.put( user, passwd );
          break;
        case 2: // Iniciar sesión
          if ( listaUsuarios.isEmpty() == true ) {
            System.out.println("Primero debes insertar usuarios.");
          }
          else{
            System.out.println("Usuario:\t");
            user  = leerDato();
            System.out.println("Contraseña:\t");
            passwd  = leerDato();

            // En caso de que exista la llave
            if ( listaUsuarios.containsKey( user )) {
              if ( user.equals("admin") ) {

                Set set = listaUsuarios.entrySet();
                Iterator j = set.iterator();

                // Verificar contraseña correcta
                while( j.hasNext() ) {
                  Map.Entry usuario = ( Map.Entry )j.next();
                  if ( usuario.getValue().equals(passwd) ) {
                    System.out.println("Hola admin!");

                    //Iterar de nuevo
                    Iterator k = set.iterator();
                    System.out.println("Usuarios del sistema: ");
                    // Mostrar usuarios y contraseñas.
                    while( k.hasNext() ) {
                      Map.Entry userIn = ( Map.Entry )k.next();
                      System.out.print( "\t> [" + userIn.getKey() + "] : ");
                      System.out.println(userIn.getValue());
                    } //while

                    System.out.println();

                  } //if
                  else{
                    System.out.println("Contraseña incorrecta");
                  } //else
                } // while
              } // if
              else {
                System.out.println("Java Rifa!");
              } // else
            } // if: en caso de contener la llave 'admin'
            else{
              System.out.println("Este usuario no está registrado.");
            } // else: aun no registran un admin
          }
          break;
        default:
          System.out.println("Opción inexistente.");
      }
    } while( opc != 0); // Terminar loop del menú
  }
}
