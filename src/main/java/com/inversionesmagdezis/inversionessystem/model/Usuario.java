package main.java.com.inversionesmagdezis.inversionessystem.model;

public class Usuario {
    private String idUser;
    private String nombre;
    private String apellido;
    private String username;
    private String passwordHash;
    private String email;
    private int idRol;

    public Usuario(String idUser, String nombre, String apellido, String username, String passwordHash, String email, int idRol) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.idRol = idRol;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
}
