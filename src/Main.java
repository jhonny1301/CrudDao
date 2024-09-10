/*import java.util.List;
import java.util.ArrayList; // Si también estás usando ArrayList

public class Main {
    public static void main(String[] args) {
        InformacionDAO dao = new InformacionDAOImpl();

        // Insertar nuevo registro
        Informacion nuevaInformacion = new Informacion(1, "carlos", "perez", "M", "carlos.perez123@example.com");
        dao.insertar(nuevaInformacion);

        
        //Obtener registro por ID
        Informacion info = dao.obtenerPorId(1);
        System.out.println(info);

        //Actualizar registro
        info.setEmail("carlos.perez123@example.com");
        dao.actualizar(info);

        // Obtener todos los registros
        List<Informacion> lista = dao.obtenerTodos();
        lista.forEach(System.out::println);

        // Eliminar registro
        dao.eliminar(1);
    }
}*/

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InformacionDAO dao = new InformacionDAOImpl();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("=== MENÚ CRUD ===");
            System.out.println("1. Insertar nuevo registro");
            System.out.println("2. Actualizar registro");
            System.out.println("3. Eliminar registro");
            System.out.println("4. Obtener todos los registros");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    // Insertar nuevo registro
                    System.out.println("=== Insertar nuevo registro ===");
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    System.out.print("Primer Nombre: ");
                    String primerNombre = scanner.nextLine();

                    System.out.print("Primer Apellido: ");
                    String primerApellido = scanner.nextLine();

                    System.out.print("Sexo (M/F): ");
                    String sexo = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Informacion nuevaInformacion = new Informacion(id, primerNombre, primerApellido, sexo, email);
                    dao.insertar(nuevaInformacion);
                    break;

                case 2:
                    // Actualizar registro
                    System.out.println("=== Actualizar registro ===");
                    System.out.print("ID del registro a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    Informacion infoActualizar = dao.obtenerPorId(idActualizar);
                    if (infoActualizar != null) {
                        System.out.print("Nuevo email: ");
                        String nuevoEmail = scanner.nextLine();
                        infoActualizar.setEmail(nuevoEmail);
                        dao.actualizar(infoActualizar);
                    } else {
                        System.out.println("Registro no encontrado.");
                    }
                    break;

                case 3:
                    // Eliminar registro
                    System.out.println("=== Eliminar registro ===");
                    System.out.print("ID del registro a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    dao.eliminar(idEliminar);
                    break;

                case 4:
                    // Obtener todos los registros
                    System.out.println("=== Obtener todos los registros ===");
                    List<Informacion> lista = dao.obtenerTodos();
                    lista.forEach(System.out::println);
                    break;

                case 5:
                    // Salir
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}




