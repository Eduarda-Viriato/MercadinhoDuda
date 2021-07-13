package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Fornecedores;
import br.com.projeto.model.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutosDao {

    private Connection connection;

    public ProdutosDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastrarProduto(Produtos pro) {
        try {
            String sql
                    = "INSERT INTO tb_produtos(nome,descricao,preco,qtd_estoque, for_id)"
                    + " values(?,?,?,?,?) ";

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, pro.getNome());
            stmt.setString(2, pro.getDescricao());
            stmt.setDouble(3, pro.getPreco());
            stmt.setString(4, pro.getQtd_estoque());
            stmt.setInt(5, pro.getFornecedorId());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algo deu errado! " + ex);
        }

    }

    public void alterarProduto(Produtos pro) {
        try {

            String sql = "UPDATE tb_produtos SET nome = ?,descricao=?,preco=?,qtd_estoque=?, for_id=? where id=?";

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, pro.getNome());
            stmt.setString(2, pro.getDescricao());
            stmt.setDouble(3, pro.getPreco());
            stmt.setString(4, pro.getQtd_estoque());
            stmt.setInt(5, pro.getFornecedorId());

            stmt.setInt(6, pro.getCódigo());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!!!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
    }

    public void excluirCliente(Produtos pro) {
        try {

            String sql = "DELETE FROM tb_produtos WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, pro.getCódigo());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!!!");

        } catch (SQLException ex) {

        }
    }

    public List<Produtos> listarProdutos() {
        
        try {

            //1 passo criar a lista
            List<Produtos> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select * from tb_produtos";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            

            while (rs.next()) {
                Produtos pro = new Produtos();
                Fornecedores cli = new Fornecedores();

                pro.setCódigo(rs.getInt("id"));
                pro.setNome(rs.getString("nome"));
                pro.setDescricao(rs.getString("descricao"));
                pro.setPreco(rs.getDouble("preco"));
                pro.setQtd_estoque(rs.getString("qtd_estoque"));
                pro.setFornecedorId(rs.getInt("for_id"));
                
                
                lista.add(pro);
                
                

            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }
}
