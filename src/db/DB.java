package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	private static Connection conn = null;
	
	// Criação da conexão do banco de dados
	/*  O método verifica se o banco ja foi conectado, caso ainda não inicia dentro de um try 
	 *  é carregado as propriedades dentro do obj props
	 *  em seguida é carregado a url através do props
	 *  por fim utilizamos o DriverManeger passando a url e as propierties para conectar
	 *  Ao passar pelo segundo if a conexão não é mais nulo e é reutilizada
	 */
	
	public static Connection getConnection() {
		if (conn == null) {
			try {	
				
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
				
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	// Realizar o fechamento da conexão
	
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	// Carregar os dados do arquivo e armazenar em objeto Properties
	
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			
			Properties props = new Properties();
			props.load(fs); // load faz a leitura apontado para fs e guarda no objeto props
			return props;
			
			
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
