/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vo.Figurino;

/**
 *
 * @author 3Info2023
 */
public class BdFigurino {
     public void inserir(Figurino figurino) {
        String sql = "insert into figurino (descricao, cor, tamanho, epoca, foto, custo, sala, armario) values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, figurino.getDescricao());
            ps.setString(2, figurino.getCor());
            ps.setString(3, figurino.getTamanho());
            ps.setString(4, figurino.getEpoca());
            ps.setBytes(5, figurino.getFoto());
            ps.setDouble(6, figurino.getCusto());
            ps.setString(7, figurino.getSala());
            ps.setString(8, figurino.getArmario());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
    }

    public void salvar(Figurino figurino) {
            String sql = "update figurino set descricao=?, cor=?, tamanho=?, epoca=?, foto=?, custo=?, sala=?, armario=? where id=?";
            try {
                PreparedStatement ps = Bd.getCon().prepareStatement(sql);
                ps.setString(1, figurino.getDescricao());
                ps.setString(2, figurino.getCor());
                ps.setString(3, figurino.getTamanho());
                ps.setString(4, figurino.getEpoca());
                ps.setBytes(5, figurino.getFoto());
                ps.setDouble(6, figurino.getCusto());
                ps.setString(7, figurino.getSala());
                ps.setString(8, figurino.getArmario());
                ps.execute();
            } catch (SQLException e) {
                System.out.println("Erro SQL: " + e.getMessage());
            }
        }

    public Figurino localizar(int id) {
        String sql = "select * from figurino where id=?";
        Figurino registro = null;
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                registro = new Figurino();
                registro.setId(rs.getInt("id"));
                registro.setDescricao(rs.getString("descricao"));
                registro.setCor(rs.getString("cor"));
                registro.setTamanho(rs.getString("tamanho"));
                registro.setEpoca(rs.getString("epoca"));
                registro.setFoto(rs.getBytes("foto"));
                registro.setCusto(rs.getDouble("custo"));
                registro.setSala(rs.getString("sala"));
                registro.setArmario(rs.getString("armario"));
                return registro;
            }
        } catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
        return null;
    }

    
    public List pesquisar() {
        String sql = "select * from Figurino order by id";
        List lista = new ArrayList();
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Figurino registro = new Figurino();
                registro.setId(rs.getInt("id"));
                registro.setDescricao(rs.getString("descricao"));
                registro.setCor(rs.getString("cor"));
                registro.setTamanho(rs.getString("tamanho"));
                registro.setEpoca(rs.getString("epoca"));
                registro.setFoto(rs.getBytes("foto"));
                registro.setCusto(rs.getDouble("custo"));
                registro.setSala(rs.getString("sala"));
                registro.setArmario(rs.getString("armario"));
                lista.add(registro);
            }
        } catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
        return lista;
    }

    public void excluir(String id) {
        String sql = "delete from figurino where id= ?";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
    }
    
    
}
