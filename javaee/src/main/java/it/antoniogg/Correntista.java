package it.antoniogg;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//DICHIARO CORRENTISTA
public class Correntista {

	String nome;
	String cognome;
	String cf;

	// METODO COSTRUTTORE
	public Correntista(String nome, String cognome, String cf) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
	}

	void inserisci(Correntista c) {

		Connection conn = connessione();
//RICHIAMO METODO INSERT PASSANDO LA CONNESIONE E LA CLASSE CORRENTISTA
	
		insert(conn, c);
	}
	void inserisciselect(Correntista cod) {
		
		Connection conn = connessione();
//RICHIAMO METODO SELECT PASSANDO LA CONNESIONE E LA CLASSE CORRENTISTA
		select(conn,cod);
		
	}
	Connection connessione() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/banca";
			String name = "anto";
			String password = "gio";
			try {
				conn = DriverManager.getConnection(url, name, password);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
//METODO INSERT GLI PASSIAMO LA CONNESSIONE E LA CLASE CORRENTISTA
	
	void insert(Connection conn, Correntista c) {
// QUERY PER INSERT DATI 
		String query_in = "INSERT INTO correntista(nome, cognome, cf)VALUES(?,?,?)";

		PreparedStatement pstmt;
		// USIAMO TRY E CATCH PER
		try {
			pstmt = conn.prepareStatement(query_in);
/*
 * 
 * 
  */
 
			pstmt.setString(1, c.nome);

			pstmt.setString(2, c.cognome);

			pstmt.setString(3, c.cf);

							try {
				
								pstmt.execute();
				
							} catch (Exception e) {
				
								System.out.println(e);
				
							}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally 
		       {
					try {
					conn.close();
							}
						catch (SQLException e) 
						{
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
		}

	}

	
	void select(Connection conn,Correntista cod) {
		
		String query_sel="SELECT * FROM `correntista`"; 
		
		PreparedStatement pstmt;
		// USIAMO TRY E CATCH PER
		try {
			pstmt = conn.prepareStatement(query_sel);
			
			ResultSet result=pstmt.executeQuery();
			
			
			while(result.next())
			{
				System.out.println("ho fatto");
				System.out.println(result.getString(1)+""+result.getString(2)+""+result.getString(3));
			}

							try {
				
								pstmt.execute();
				
							} catch (Exception e) {
				
								System.out.println(e);
				
							}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally 
		       {
					try {
					conn.close();
							}
						catch (SQLException e) 
						{
									// TODO Auto-generated catch block
									e.printStackTrace();
		
						}
					}
	}
}



