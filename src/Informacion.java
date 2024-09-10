public class Informacion {
    private int idEmpleado;
    private String primerNombre;
    private String primerApellido;
    private String sexo;
    private String email;

    // Constructores
    public Informacion() {}

    public Informacion(int idEmpleado, String primerNombre, String primerApellido, String sexo, String email) {
        this.idEmpleado = idEmpleado;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.sexo = sexo;
        this.email = email;
    }

    // Getters y Setters
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Informacion{" +
                "idEmpleado=" + idEmpleado +
                ", primerNombre='" + primerNombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", sexo='" + sexo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
