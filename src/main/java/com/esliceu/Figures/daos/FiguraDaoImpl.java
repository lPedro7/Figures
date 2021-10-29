package com.esliceu.Figures.daos;

import com.esliceu.Figures.models.Figura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FiguraDaoImpl implements FiguraDao{
    Database db = new Database();
    Figura figura;
    @Override
    public Figura getFigura(String nom_Figura, String username_owner) {

        Connection con = db.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Figura WHERE name=? AND username_owner=?");
            ps.setString(1,nom_Figura);
            ps.setString(2,username_owner);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                figura = new Figura();

                figura.setNom(rs.getString(1));
                figura.setTipus(rs.getString(2));
                figura.setCoordX(rs.getInt(3));
                figura.setCoordY(rs.getInt(4));
                figura.setColor(rs.getString(5));
                figura.setGrandaria(rs.getInt(6));
                figura.setUsername_owner(rs.getString(7));
                figura.setNomFigura2(rs.getString(8));
                figura.setComposed(rs.getBoolean(9));

                ps.close();
                rs.close();
                con.close();
                return figura;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Figura> getFigures() {
        Connection con = db.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Figura");
            ResultSet rs = ps.executeQuery();

            List<Figura> figuras = new ArrayList<>();

            while (rs.next()){
                figura = new Figura();
                figura.setNom(rs.getString(1));
                figura.setTipus(rs.getString(2));
                figura.setCoordX(rs.getInt(3));
                figura.setCoordY(rs.getInt(4));
                figura.setColor(rs.getString(5));
                figura.setGrandaria(rs.getInt(6));
                figura.setUsername_owner(rs.getString(7));
                figura.setNomFigura2(rs.getString(8));
                figura.setComposed(rs.getBoolean(9));

                figuras.add(figura);
            }

            ps.close();
            con.close();

            return figuras;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Figura> getFiguresByUser(String username) {
        Connection con = db.getConnection();

        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Figura WHERE username_owner=?");
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            List<Figura> figuras = new ArrayList<>();

            while (rs.next()){
                figura = new Figura();
                figura.setNom(rs.getString(1));
                figura.setTipus(rs.getString(2));
                figura.setCoordX(rs.getInt(3));
                figura.setCoordY(rs.getInt(4));
                figura.setColor(rs.getString(5));
                figura.setGrandaria(rs.getInt(6));
                figura.setUsername_owner(rs.getString(7));
                figura.setNomFigura2(rs.getString(8));
                figura.setComposed(rs.getBoolean(9));

                figuras.add(figura);
            }
            return figuras;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void createFigura(Figura figura) {
        Connection con = db.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Figura VALUES(?,?,?,?,?,?,?,?,?)");
            ps.setString(1,figura.getNom());
            ps.setString(2,figura.getTipus());
            ps.setInt(3,figura.getCoordX());
            ps.setInt(4,figura.getCoordY());
            ps.setString(5,figura.getColor());
            ps.setInt(6,figura.getGrandaria());
            ps.setString(7,figura.getUsername_owner());
            ps.setString(8,figura.getNomFigura2());
            ps.setBoolean(9,figura.isComposed());
            ps.execute();

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFigura(Figura figura) {
        Connection con = db.getConnection();

        try {
            PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM Figura WHERE name=? AND username_owner=?");
            preparedStatement.setString(1,figura.getNom());
            preparedStatement.setString(2,figura.getUsername_owner());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
