/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObj;

import ClassModel.Cliente_Class;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Leticia
 */
public class DAO_CadastroCliente {
     private Connection conn = null;
    private Statement stm = null;

    public DAO_CadastroCliente() {
//        try {
//            this.conn = new ConnectionFactory().getConnection();
//        } catch (SQLException ex) {
//            Logger.getLogger(DAO_CadastroLogin.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(DAO_CadastroLogin.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void add(Cliente_Class cliente) {

//        try {
//            stm = conn.createStatement();
//            String sql = String.format("insert into login(usuario, senha, email, nome) values('%s', '%s', '%s', '%s')", login.getUsuario(), login.getSenha(), login.getEmail(), login.getNome());
//            stm.executeUpdate(sql);
//            stm.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(DAO_CadastroLogin.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
}
