package dao;

import model.Pessoa;

import javax.swing.*;
import java.sql.*;
import java.util.ConcurrentModificationException;

public class PessoaDAO {
    public static void inserir(Pessoa pessoa) throws SQLException {
        //RECEBENDO DADOS
        String adicionar = "insert into Pessoa (id, nome, cpf, sexo, email, nascimento) values (?, ?, ?, ?, ?, ?)";
        Connection connect = DriverManager.getConnection();
        PreparedStatement insere = connect.prepareStatement(adicionar);

        //ENTRADA DE DADOS
        String nome = JOptionPane.showInputDialog("Digite o Nome: ");
        String cpf = JOptionPane.showInputDialog("Digite o CPF: ");
        String sexo = JOptionPane.showInputDialog("Digite o Sexo: ");
        String email = JOptionPane.showInputDialog("Digite o Email: ");
        String nascimento = JOptionPane.showInputDialog("Digite o Nascimento: ");

        //INSERIR DADOS
        insere.setString(1, pessoa.getNome());
        insere.setString(2, pessoa.getCpf());
        insere.setString(3, pessoa.getSexo());
        insere.setString(4, pessoa.getEmail());
        insere.setString(5, pessoa.getNascimento());

        insere.execute();

        String inserire = "insert into Pessoa (id, nome, cpf, sexo, email, nascimento) values (?, ?, ?, ?, ?, ?)";
    }

    public static void visualizar() throws SQLException {
        //RECEBENDO DADOS
        String pesquisa = "select * from Pessoa";
        Connection connect = DriverManager.getConnection();
        PreparedStatement stmt = connect.prepareStatement(pesquisa);
        ResultSet pessoa = stmt.executeQuery();
        while (pessoa.next()) {
            System.out.println(pessoa.getString("nome") + " - " + pessoa.getString("id"));
            System.out.println(pessoa.getString("cpf") + " - " + pessoa.getString("id"));
            System.out.println(pessoa.getString("sexo") + " - " + pessoa.getString("id"));
            System.out.println(pessoa.getString("email") + " - " + pessoa.getString("id"));
            System.out.println(pessoa.getString("nascimento") + " - " + pessoa.getString("id"));
        }
    }

    public static void atualizar(Pessoa pessoa) throws SQLException {
        String updatepessoa = "update Pessoa set nome=?, cpf=?, sexo=?, email=?, nascimento=? where id=?";
        Connection connect = DriverManager.getConnection();
        PreparedStatement prepareUpdate = connect.prepareStatement(updatepessoa);
        prepareUpdate.setString(1, pessoa.getNome());
        prepareUpdate.setString(2, pessoa.getCpf());
        prepareUpdate.setString(3, pessoa.getSexo());
        prepareUpdate.setString(4, pessoa.getEmail());
        prepareUpdate.setString(5, pessoa.getNascimento());
        prepareUpdate.execute();
    }

    public static void remover(Pessoa pessoa) throws SQLException {
        String removerautores = "delete from Pessoa where id=?";
        Connection connect = DriverManager.getConnection();
        PreparedStatement removecategorias = connect.prepareStatement(removerautores);
        removecategorias.setInt(1, pessoa.getId());
        removecategorias.execute();
    }
}



