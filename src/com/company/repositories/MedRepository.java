package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Med;
import com.company.repositories.interfaces.IMedRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MedRepository implements IMedRepository {
    private final IDB db;

    public MedRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createMed(Med med) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO meddata(name,price,expiration,manufacturer,byrecept) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, med.getName());
            st.setInt(2, med.getPrice());
            st.setDate(3, med.getExpiration());
            st.setString(4, med.getManufacturer());
            st.setBoolean(5, med.getByRecept());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Med getMed(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,price,expiration,manufacturer,byrecept FROM meddata WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Med med = new Med(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getDate("expiration"),
                        rs.getString("manufacturer"),
                        rs.getBoolean("byrecept"));
                return med;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Med getMedByName(String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,price,expiration,manufacturer,byrecept FROM meddata WHERE name=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Med med = new Med(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getDate("expiration"),
                        rs.getString("manufacturer"),
                        rs.getBoolean("byrecept"));
                return med;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Med> getAllMeds() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,price,expiration,manufacturer,byrecept FROM meddata";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Med> meds = new LinkedList<>();
            while (rs.next()) {
                Med med = new Med(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getDate("expiration"),
                        rs.getString("manufacturer"),
                        rs.getBoolean("byrecept"));

                meds.add(med);
            }

            return meds;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void removeMedById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM meddata WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
           try {
               ResultSet rs = st.executeQuery();

           }catch (SQLException e){
               //return "was deleted";
           }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
       // return "Wasn't deleted";
    }
}