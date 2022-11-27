package it.antoniogg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conto {
	
	String codice_conto;
	String cfc;
	String saldo;
	
	
	
	// METODO COSTRUTTORE
		public Conto(String codice_conto, String saldo, String cfc) {
			super();
			this.codice_conto=codice_conto;
			this.saldo=saldo;
			this.cfc=cfc;
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
		
		
		
		void inserisciconto(Conto cont) {

			Connection conn = connessione();
	//RICHIAMO METODO INSERT PASSANDO LA CONNESIONE E LA CLASSE CORRENTISTA
		
			insertc(conn, cont);
		}
	
		void insertc(Connection conn, Conto cont) {
			// QUERY PER INSERT DATI 
					String query_in = "INSERT INTO conto(saldo, codice_conto, cfc)VALUES(?,?,?)";

					PreparedStatement pstmt;
					// USIAMO TRY E CATCH PER
					try {
						pstmt = conn.prepareStatement(query_in);
			/*
			 * 
			 * 
			  */
			 
						pstmt.setString(1, cont.saldo);

						pstmt.setString(2, cont.codice_conto);

						pstmt.setString(3, cont.cfc);

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
