package org.ITstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ITstep.dao.ConnectionToDB;
import org.ITstep.model.Account;

public class AccountDAO {

	public Account save(Account account) {
		Connection connection = null;
		PreparedStatement statement = null;

		String sql = "INSERT INTO accounts (login, birthday)  VALUES(?,?)";


		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, account.getLogin());
			statement.setLong(2, account.getBirthday());
			
			
			statement.executeUpdate();
			return account;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseAll(statement,connection);
		}

		return null;
	}

	public Account update(Account newAccount) {
		
		String sql = "UPDATE accounts SET birtday=? WHERE login=?";
		return null;
	}

	public Account get(String login) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "SELECT * FROM accounts WHERE login=?";

		try {
			connection = ConnectionToDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Account account = new Account();
				account.setLogin(resultSet.getString("login"));
				account.setBirthday(resultSet.getLong("birthday"));
				return account;
			}
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseAll(resultSet,statement,connection);
		}
		return null;
	}

	public Account delete(String login) {
		return null;
	}
	
	private void CloseAll(PreparedStatement statement, Connection connection) {
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
