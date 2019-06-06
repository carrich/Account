package com.t1708m.model;

import com.t1708m.entity.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentModel {
    public Student findByUsernameAndStatus(String usename, Student.Status status) {

        try {
            String sqlCommand = "select * from Student where username = ? and status = ?";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setString(1,usename);
            preparedStatement.setInt(2,status.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Student student = new Student();
                student.setAddress(resultSet.getString("address"));
                student.setEmail(resultSet.getString("email"));
                student.setFullName(resultSet.getString("fullName"));
                student.setPassword(resultSet.getString("password"));
                student.setUsername(resultSet.getString("username"));
                student.setPhone(resultSet.getString("phone"));
                student.setRole(resultSet.getInt("role"));
                return student;
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public boolean save(Student student) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/student-manager?user=root&password=");
            Statement statement = connection.createStatement();
            String sqlCommand = "insert into students (username, password, email, fullName, address, phone) " +
                    "values ('" + student.getUsername() + "', '" + student.getPassword() + "'" +
                    ", '" + student.getEmail() + "', '" + student.getFullName() + "', '" + student.getAddress() + "', '" + student.getPhone() + "')";
            statement.execute(sqlCommand);
            System.out.println("Okie.");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean saveV2(Student student) {
        try {
            String sqlCommand = "insert into student (username, password, email, fullName, address, phone,status,role) values (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setString(1, student.getUsername());
            preparedStatement.setString(2, student.getPassword());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getFullName());
            preparedStatement.setString(5, student.getAddress());
            preparedStatement.setString(6, student.getPhone());
            preparedStatement.setInt(7, student.getStatu());
            preparedStatement.setInt(8, student.getRole());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<Student> getList() {
        ArrayList<Student> results = new ArrayList<>();
        try {
            String sqlCommand = "select * from student";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                Student student = new Student();
                student.setUsername(username);
                student.setPassword(password);
                student.setFullName(fullName);
                student.setEmail(email);
                student.setAddress(address);
                student.setPhone(phone);
                results.add(student);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }
    public ArrayList<Student> getListByUser() {
        ArrayList<Student> results = new ArrayList<>();
        try {
            String sqlCommand = "select * from student where role = ?";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setInt(1,1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                int role = resultSet.getInt("role");
                Student student = new Student();
                student.setUsername(username);
                student.setPassword(password);
                student.setFullName(fullName);
                student.setEmail(email);
                student.setAddress(address);
                student.setPhone(phone);
                student.setRole(role);
                results.add(student);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public ArrayList<Student> getListByAdmin() {
        ArrayList<Student> results = new ArrayList<>();
        try {
            String sqlCommand = "select * from student where role = ?";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setInt(1,2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                Student student = new Student();
                student.setUsername(username);
                student.setPassword(password);
                student.setFullName(fullName);
                student.setEmail(email);
                student.setAddress(address);
                student.setPhone(phone);
                results.add(student);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public static void main(String[] args) {
        String inputPassword = "1";
        StudentModel studentModel = new StudentModel();
        Student student = studentModel.findByUsernameAndStatus("ahaha", Student.Status.DEACTIVE);
        if (student==null) {
            System.out.println("khong tim thay");
        } else {
            if (student.getPassword().equals(inputPassword)) {
                System.out.println("login thanh cong");
            }else {
                System.out.println("login khong thanh cong");
            }
            System.out.println(student.getFullName());
        }
    }

}
