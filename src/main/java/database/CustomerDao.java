package database;

import model.Customer;
import utils.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDao extends AbsDao<Customer> {
    @Override
    public int insert(Customer data) {
        try {
            Connection con = JDBC.getConnection();

            String sql = "insert into Customers (username, password, name, email, numberPhone)  values (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setNString(1, data.getUsername());
            pst.setNString(2, data.getPassword());
            pst.setNString(3, data.getName());
            pst.setNString(4, data.getEmail());
            pst.setNString(5, data.getNumberPhone());
            int i = pst.executeUpdate();
            if (i > 0) {
                super.insert(data);
                return i;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Customer data) {
        try {
            Connection con = JDBC.getConnection();
            String sql = "delete from customers where username = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setNString(1, data.getUsername());
            int i = pst.executeUpdate();
            if (i > 0) {
                super.delete(data);
                return i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Customer login(String username, String password) {
        try {
            Connection con = JDBC.getConnection();
            String sql = "Select * from Customers where username = ? and password = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setNString(1, username);
            pst.setNString(2, password);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Customer cus = new Customer(rs.getNString("username"), rs.getNString("password"), rs.getNString("name"), rs.getNString("email"),rs.getNString("numberPhone"));
                super.username  = cus.getUsername();
                super.login(cus);
                return cus;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean checkUsername(String username){
        try {
            Connection con = JDBC.getConnection();
            String sql = "Select * from Customers where username = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setNString(1, username);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
              return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<Customer> selectAll() {
        ArrayList<Customer> result = new ArrayList<Customer>();
        try {
            Connection con = JDBC.getConnection();
            String sql = "Select * from Customers";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Customer cus = new Customer(rs.getNString("username"), rs.getNString("password"), rs.getNString("name"), rs.getNString("email"),rs.getNString("numberPhone"));
                result.add(cus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result = (result.isEmpty()) ? null : result;
    }
    public ArrayList<Customer> selectByUsername(String username) {
        ArrayList<Customer> result = new ArrayList<Customer>();
        try {
            Connection con = JDBC.getConnection();
            String sql = "Select * from Customers where username = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setNString(1, username);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Customer cus = new Customer(rs.getNString("username"), rs.getNString("password"), rs.getNString("name"), rs.getNString("email"),rs.getNString("numberPhone"));
                result.add(cus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result = (result.isEmpty()) ? null : result;
    }

    public static void main(String[] args) {
        CustomerDao cus = new CustomerDao();
        for(Customer c : cus.selectByUsername("hoangtube123")){
            System.out.println(c);
        }
        
    }
}
