import java.util.List;

public interface InformacionDAO {
    void insertar(Informacion informacion);
    Informacion obtenerPorId(int idEmpleado);
    List<Informacion> obtenerTodos();
    void actualizar(Informacion informacion);
    void eliminar(int idEmpleado);
}
