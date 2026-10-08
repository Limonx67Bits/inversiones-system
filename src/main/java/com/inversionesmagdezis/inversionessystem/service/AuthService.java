package main.java.com.inversionesmagdezis.inversionessystem.service;

import java.util.UUID;
import main.java.com.inversionesmagdezis.inversionessystem.dto.request.UsuarioDTORequest;
import main.java.com.inversionesmagdezis.inversionessystem.dto.response.UsuarioDTOResponse;
import main.java.com.inversionesmagdezis.inversionessystem.model.Usuario;
import main.java.com.inversionesmagdezis.inversionessystem.repository.UsuarioRepository;
import main.java.com.pbcorporations.abarroteria.kinal.security.jbcrypt.BCrypt;

public class AuthService {

    private final UsuarioRepository repository;

    public AuthService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioDTOResponse login(UsuarioDTORequest request) {
        if (request == null || request.getUsername() == null || request.getPassword() == null
                || request.getPassword().isEmpty() || request.getPassword().isEmpty()) {
            System.out.println("Ciertos campos se encuentran vacíos");
        }
        UsuarioDTOResponse response = repository.findUserByUsername(request);

        if (response == null) {
            System.out.println("No se encontró al usuario");
        }

        if (response.getPasswordHash() == null) {
            System.out.println("No se logró concretar la operación");
        } else {
            if (BCrypt.checkpw(request.getPassword(), response.getPasswordHash())) {
                return response;
            }
        }
        return null;
    }

    public boolean registerUser(Usuario usuario, String password) throws Exception {
        if (usuario.getNombre() == null || usuario.getApellido() == null || usuario.getUsername() == null || usuario.getEmail() == null || usuario.getIdUser().isEmpty()
                || usuario.getNombre().isEmpty() || usuario.getApellido().isEmpty() || usuario.getUsername().isEmpty() || usuario.getEmail().isEmpty()) {
            throw new Exception("Ciertos campos se encuentran vacíos");
        }
        String idAsignado = UUID.randomUUID().toString();
        String pwHashed = BCrypt.hashpw(password, BCrypt.gensalt());
        Usuario nuevoUsuario = new Usuario(
                idAsignado,
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getUsername(),
                pwHashed,
                usuario.getEmail(),
                usuario.getIdRol()
        );
        return repository.save(nuevoUsuario);
    }
}
