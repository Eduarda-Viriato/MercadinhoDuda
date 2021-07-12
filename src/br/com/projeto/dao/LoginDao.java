
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Login;
import br.com.projeto.view.JFrmFornecedores;
import br.com.projeto.view.JFrmProdutos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginDao {

    private Connection connection;

    public LoginDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public boolean checkLogin(Login cli) {
        boolean check = false;

        try {
            
            

            String sql = "SELECT * FROM tb_login WHERE usuario =? and senha= ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cli.getLogin());
            stmt.setString(2, cli.getSenha());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                
                check = true;
            }

           
        } catch (SQLException ex) {
            
        } 
        return check;

     
    }
    
    public void cadastrarUser(Login cli) {
       
        try {
            String sql = "INSERT INTO tb_login( usuario,senha) values(?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, cli.getLogin());
            stmt.setString(2, cli.getSenha());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo deu errado! " + ex);

        }
        
    }
}