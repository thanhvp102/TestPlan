package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;
import util.ConnectionUtil;
import util.SqlQuery;

public class UserDao {
	public void show() throws SQLException {
		Connection conn = DriverManager.getConnection(ConnectionUtil.dbUrl);
		Statement statement=conn.createStatement();
		ResultSet resultSet=statement.executeQuery(SqlQuery.SELECT);
		while(resultSet.next()) {
			System.out.print(resultSet.getString(1)+"\t");
			System.out.print(resultSet.getString(2)+"\t");
			System.out.print(resultSet.getString(3)+"\t");
			System.out.print(resultSet.getString(4));
			System.out.println("\n");
		}
	}
	public boolean insert(User user)throws SQLException {
		Connection conn=DriverManager.getConnection(ConnectionUtil.dbUrl);
		PreparedStatement preparedStatement=conn.prepareStatement(SqlQuery.INSERT);
		preparedStatement.setString(1, user.getAccount());
		preparedStatement.setString(2, user.getFirstName());
		preparedStatement.setString(3, user.getLastName());
		preparedStatement.setString(4, user.getEmail());
		preparedStatement.executeUpdate();
		return true;
	}
	public boolean delete(String account)throws SQLException{
		Connection conn=DriverManager.getConnection(ConnectionUtil.dbUrl);
		PreparedStatement preparedStatement=conn.prepareStatement(SqlQuery.DELETE_ACCOUNT);
		preparedStatement.setString(1,account);
		preparedStatement.execute();
		return true;
		
	}
	public boolean update(User user)throws SQLException{
		Connection conn=DriverManager.getConnection(ConnectionUtil.dbUrl);
		PreparedStatement preparedStatement=conn.prepareStatement(SqlQuery.UPDATE);
		preparedStatement.setString(1, user.getFirstName());
		preparedStatement.setString(2, user.getLastName());
		preparedStatement.setString(3,user.getEmail());
		preparedStatement.setString(4, user.getAccount());
		preparedStatement.executeUpdate();
		return true;
	}
	public ResultSet findByAccount(User user) throws SQLException {
		Connection conn=DriverManager.getConnection(ConnectionUtil.dbUrl);
		PreparedStatement preparedStatement=conn.prepareStatement(SqlQuery.FIND_BY_ACCOUNT);
		preparedStatement.setString(1, user.getAccount());
		ResultSet rs=preparedStatement.executeQuery();
		return rs;
	}
}
