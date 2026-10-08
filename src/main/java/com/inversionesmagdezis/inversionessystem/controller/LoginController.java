package main.java.com.inversionesmagdezis.inversionessystem.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import main.java.com.inversionesmagdezis.inversionessystem.service.AuthService;
import main.java.com.inversionesmagdezis.inversionessystem.util.SceneManager;

public class LoginController implements Initializable {
    private final AuthService service;
    private final SceneManager manager;
    
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public LoginController(AuthService service, SceneManager manager) {
        this.service = service;
        this.manager = manager;
    }
    
}
