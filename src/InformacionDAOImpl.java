import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InformacionDAOImpl implements InformacionDAO {

    @Override
    public void insertar(Informacion informacion) {
        String query = "INSERT INTO informacion (EmployeeID, FirstName, LastName, Gender, Email) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, informacion.getIdEmpleado());
            pstmt.setString(2, informacion.getPrimerNombre());
            pstmt.setString(3, informacion.getPrimerApellido());
            pstmt.setString(4, informacion.getSexo());
            pstmt.setString(5, informacion.getEmail());

            pstmt.executeUpdate();
            System.out.println("Registro insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    @Override
    public Informacion obtenerPorId(int idEmpleado) {
        Informacion informacion = null;
        String query = "SELECT * FROM informacion WHERE EmployeeID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, idEmpleado);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                informacion = new Informacion(
                        rs.getInt("EmployeeID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Gender"),
                        rs.getString("Email")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener por ID: " + e.getMessage());
        }
        return informacion;
    }

    @Override
    public List<Informacion> obtenerTodos() {
        List<Informacion> lista = new ArrayList<>();
        String query = "SELECT * FROM informacion";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Informacion informacion = new Informacion(
                        rs.getInt("EmployeeID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Gender"),
                        rs.getString("Email")
                );
                lista.add(informacion);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener todos: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void actualizar(Informacion informacion) {
        String query = "UPDATE informacion SET FirstName = ?, LastName = ?, Gender = ?, Email = ? WHERE EmployeeID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, informacion.getPrimerNombre());
            pstmt.setString(2, informacion.getPrimerApellido());
            pstmt.setString(3, informacion.getSexo());
            pstmt.setString(4, informacion.getEmail());
            pstmt.setInt(5, informacion.getIdEmpleado());

            pstmt.executeUpdate();
            System.out.println("Registro actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int idEmpleado) {
        String query = "DELETE FROM informacion WHERE EmployeeID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, idEmpleado);
            pstmt.executeUpdate();
            System.out.println("Registro eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}

