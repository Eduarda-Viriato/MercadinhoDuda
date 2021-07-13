package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Fornecedores;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class FornecedoresDao {

    private Connection connection;

    public FornecedoresDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastrarFornecedores(Fornecedores cli) {
        try {
            String sql
                    = "INSERT INTO tb_fornecedores(nome,rg,cpf,email,celular,cep,endereco,numero,"
                    + "bairro,cidade,estado)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?) ";

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getRg());
            stmt.setString(3, cli.getCpf());
            stmt.setString(4, cli.getEmail());
            stmt.setString(5, cli.getCelular());
            stmt.setString(6, cli.getCep());
            stmt.setString(7, cli.getEndereco());
            stmt.setInt(8, cli.getNumero());
            stmt.setString(9, cli.getBairro());
            stmt.setString(10, cli.getCidade());
            stmt.setString(11, cli.getUf());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo deu errado! " + ex);
        }

    }

    //Metodo Listar Todos Fornecedores
    public List<Fornecedores> listarFornecedores() {
        try {

            //1 passo criar a lista
            List<Fornecedores> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select * from tb_fornecedores";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedores cli = new Fornecedores();

                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setRg(rs.getString("rg"));
                cli.setCpf(rs.getString("cpf"));
                cli.setEmail(rs.getString("email"));
                cli.setCelular(rs.getString("celular"));
                cli.setCep(rs.getString("cep"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setNumero(rs.getInt("numero"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setUf(rs.getString("estado"));
                cli.toString();

                lista.add(cli);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }
    
    public List<Fornecedores> consultaPorNome(String nome){
        try {
            List<Fornecedores> lista = new ArrayList<>();            
            String sql = "SELECT * FROM tb_fornecedores WHERE nome like ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Fornecedores cli = new Fornecedores();

                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setRg(rs.getString("rg"));
                cli.setCpf(rs.getString("cpf"));
                cli.setEmail(rs.getString("email"));
                cli.setCelular(rs.getString("celular"));
                cli.setCep(rs.getString("cep"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setNumero(rs.getInt("numero"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setUf(rs.getString("estado"));
                cli.toString();

               lista.add(cli);
            }
            return lista;         
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ ex);
            return null;
        }
    }



    public void excluirFornecedores(Fornecedores cli){
          try {
                       
            String sql = "DELETE FROM tb_fornecedores WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,cli.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!!!");
                                 
            
        } catch (SQLException ex) {
 
  }
        
    }
    
    public void alterarFornecedores(Fornecedores cli){
         try {
                       
            String sql = "UPDATE tb_fornecedores SET nome=?, rg=?, cpf=?, email=?, "
                    + "celular=?, cep=?, endereco=?, numero=?, "
                    + "bairro=?, cidade=?, estado=?"
                    + " where id=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getRg());
            stmt.setString(3, cli.getCpf());
            stmt.setString(4, cli.getEmail());
            stmt.setString(5, cli.getCelular());
            stmt.setString(6, cli.getCep());
            stmt.setString(7, cli.getEndereco());
            stmt.setInt(8, cli.getNumero());
            stmt.setString(9, cli.getBairro());
            stmt.setString(10, cli.getCidade());
            stmt.setString(11, cli.getUf());
            
            stmt.setInt(12, cli.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!!!");
                                 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ ex);           
        }
    }
    
    public List<Fornecedores> Nome (Fornecedores cli){
          try {
                List<Fornecedores> lista = new ArrayList<>();           
            String sql = "SELECT nome FROM tb_fornecedores WHERE id =?;";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,cli.getId());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                              
                cli.setNome(rs.getString("nome"));
                lista.add(cli);
            
            
            
            stmt.execute();
            stmt.close();
            
            //JOptionPane.showMessageDialog(null, "Excluido com sucesso!!!");
                                 
        lista.add(cli);
            }
            return lista;         
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ ex);
            return null;
        }
    }

}
