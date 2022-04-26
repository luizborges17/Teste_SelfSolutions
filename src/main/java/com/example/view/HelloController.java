package com.example.view;

import java.sql.SQLException;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class HelloController {

	private UsuarioDAO usuariodao = new UsuarioDAO();

	@FXML
	private AnchorPane geral;

	@FXML
	private TableColumn<String, String> columnStatus = new TableColumn<String, String>();

	@FXML
	private TableColumn<UsuarioDTO, String> columnTarefas = new TableColumn<UsuarioDTO, String>();

	@FXML
	private TableColumn<UsuarioDTO, String> columnUsuario = new TableColumn<UsuarioDTO, String>();

	@FXML
	private TableView<UsuarioDTO> tabela = new TableView<UsuarioDTO>();

	@FXML
	private TextField txtTarefas;

	@FXML
	private TextField txtUsuario;

	// Botão cadastrar e inserir na tabela
	@FXML
	void btnCadastrar(ActionEvent event) throws SQLException {
		// Cadastro de Usuario e Tarefas
		String nomeTarefas = this.txtTarefas.getText();
		String nomeUsuario = this.txtUsuario.getText();

		UsuarioDTO objususarioDTO = new UsuarioDTO(nomeUsuario, nomeTarefas, null);

		objususarioDTO.setNomeUsuario(nomeUsuario);
		objususarioDTO.setNomeTarefas(nomeTarefas);
		
		usuariodao.cadastrarUsuario(objususarioDTO);
		usuariodao.cadastrarTabela(objususarioDTO);

		// Inserindo na tabela
		ObservableList<UsuarioDTO> list = FXCollections.observableArrayList(new UsuarioDTO(nomeUsuario, nomeTarefas, objususarioDTO.getStatus()));
		// String statusValidado = "Completed";
		columnTarefas.setCellValueFactory(new PropertyValueFactory<UsuarioDTO, String>("nomeTarefas"));
		columnUsuario.setCellValueFactory(new PropertyValueFactory<UsuarioDTO, String>("nomeUsuario"));
		columnStatus.setCellValueFactory(new PropertyValueFactory<String,String>("status"));
		tabela.setItems(list);
	}

}
