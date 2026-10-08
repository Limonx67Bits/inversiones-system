package main.java.com.inversionesmagdezis.inversionessystem.dto.response;

public class UsuarioDTOResponse {
    private String nombreCompleto;
    private String passwordHash;
    private String nombreRol;

    public UsuarioDTOResponse(String nombreCompleto, String passwordHash, String nombreRol) {
        this.nombreCompleto = nombreCompleto;
        this.passwordHash = passwordHash;
        this.nombreRol = nombreRol;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
