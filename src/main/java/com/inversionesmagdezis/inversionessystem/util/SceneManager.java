package main.java.com.inversionesmagdezis.inversionessystem.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.com.inversionesmagdezis.inversionessystem.controller.LoginController;
import main.java.com.inversionesmagdezis.inversionessystem.repository.UsuarioRepository;
import main.java.com.inversionesmagdezis.inversionessystem.service.AuthService;

public class SceneManager {
    private final String FXML_PATH = "/main/resources/view/";
    private final Stage stage;
    
    public SceneManager (Stage stage) {
        this.stage = stage;
    }
    
        public void showLoginView() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_PATH + "login-view.fxml"));
        
        loader.setControllerFactory(
        clazz -> {
            if(clazz == LoginController.class){
                UsuarioRepository repository = new UsuarioRepository();
                AuthService service = new AuthService(repository);
                return new LoginController(service, this);
            }
            
            try{
                return clazz.getDeclaredConstructor().newInstance();
            }catch (Exception e){
                throw new RuntimeException("Error al crear constructor... " + e.getMessage());
            }
        }
        );
        
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 600);
        stage.setMinWidth(420);
        stage.setMinHeight(360);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

}
