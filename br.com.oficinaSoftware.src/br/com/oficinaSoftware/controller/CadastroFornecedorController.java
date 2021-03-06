package br.com.oficinaSoftware.controller;

import br.com.oficinaSoftware.dao.UsuarioDAO;
import br.com.oficinaSoftware.entity.Fornecedor;
import br.com.oficinaSoftware.resource.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CadastroFornecedorController implements Initializable {
    @FXML
    private TextField idNomeFornecedor;
    @FXML
    private TextField idCnpjFornecedor;
    @FXML
    private TextField idEnderecoFornecedor;
    @FXML
    private TextField idTelefoneFornecedor;
    @FXML
    private TextField idEmailFornecedor;
    @FXML
    private Label idMessage;


    @FXML
    private void botaoSalvar(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        //if(verificaSeEstaVazio()){
           // idMessage.setText("Campos vazios.");
        //}//else{
                Fornecedor f = new Fornecedor();

                f.setNomeFornecedor(idNomeFornecedor.getText());
                f.setCnpjFornecedor(idCnpjFornecedor.getText());
                f.setEnderecoFornecedor(idEnderecoFornecedor.getText());
                f.setTelefoneFornecedor(idTelefoneFornecedor.getText());
                f.setEmailFornecedor(idEmailFornecedor.getText());
                //f.setSenha(idSenha.getText());

                UsuarioDAO dao = new UsuarioDAO();
                dao.salvarFornecedor(f);
                limpaCampos();
                //idMessage.setText("Senhas invalidas");
           // }

       // }
    }

    @FXML
    private void botaoVoltarM (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/oficinaSoftware/view/Menu.fxml"));
        Scene scene = new Scene(root);
        Main.myStage.setScene(scene);
    }

    private boolean verificaSeEstaVazio()
    {

        idNomeFornecedor.getText().isEmpty();
        idCnpjFornecedor.getText().isEmpty();
        idEnderecoFornecedor.getText().isEmpty();
        idTelefoneFornecedor.getText().isEmpty();
        idEmailFornecedor.getText().isEmpty();

        return false;
    }

    private void limpaCampos() {
        idNomeFornecedor.setText("");
        idCnpjFornecedor.setText("");
        idEnderecoFornecedor.setText("");
        idTelefoneFornecedor.setText("");
        idEmailFornecedor.setText("");
        idMessage.setText("");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
