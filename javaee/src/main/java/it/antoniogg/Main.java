package it.antoniogg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//buffer reader
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		/*
		
		System.out.println("ins codice fiscale da ricercare");	
		String cod_fis_ric=br.readLine();
		Correntista cod=new Correntista(null,null,cod_fis_ric);
		cod.inserisciselect(cod);
		*/
		// caricamento degli utenti e del conto
		// CARICARE LA SCELTA
		
		Scanner input=new Scanner(System.in);
		
		int scelta;
		System.out.print("RUBRICA \n 1 Caricamento utenti e conto  \n 2 Ricerca per nome \n 3 Stampa \n 4 mod");
		scelta=input.nextInt();


		while(scelta!=1)
		{
		System.out.print("RUBRICA \n 1 Caricamento utenti e conto \n 2 Ricerca per nome \n 3 Stampa \n 4 mod");
		scelta=input.nextInt();


		}
		while(scelta!=5)
		{
		switch(scelta)
		{
			case 1:

				System.out.println("ins nome");	
				String nome=br.readLine();
				
				System.out.println("ins cognome");	
				String cognome=br.readLine();
				
				System.out.println("ins codice fiscale");	
				String cf=br.readLine();
				
				System.out.println("ripetere il codice fiscale uguale");	
				String cfc=br.readLine();	
				
				System.out.println("ins saldo");	
				String saldo=br.readLine();
				
				System.out.println("ins codcie_conto");	
				String codice_conto=br.readLine();
				
				Correntista c=new Correntista(nome,cognome,cf);
				c.inserisci(c);

				Conto cont= new Conto(saldo,codice_conto,cfc);
				cont.inserisciconto(cont);
				break;
				
			 case 2:
				 	
				    break;
				    
				      case 3:
				    	   
				    	 			 
				        break;
				        
				        case 4:
				      
				           break;
		}		 
			
		System.out.print("RUBRICA \n 1 Caricamento utenti e conto \n 2 Ricerca per nome \n 3 Stampa \n 4 mod");
		scelta=input.nextInt();

			}

		}

			
		
		
		
		
		
		
		
	}


