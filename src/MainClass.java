import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MainClass 
{

	public static void main(String[] args) 
	{
	/*	LocalDate data= LocalDate.of(2018, 5, 15);
		LocalTime ora=LocalTime.of(16,30,0);
		LocalDateTime dataOra=LocalDateTime.of(data,ora);
		
		//LocalDate data1= LocalDate.of(2018, 3, 1);
		LocalTime ora1=LocalTime.of(16,32,0);
		LocalDateTime dataOra1=LocalDateTime.of(data,ora1);

		//LocalDate data2= LocalDate.of(2018, 3, 1);
		LocalTime ora2=LocalTime.of(16,34,0);
		LocalDateTime dataOra2=LocalDateTime.of(data,ora2);
	*/	
		String[] vociMenu= {"1-->Registra accesso..richiesta serializzazione a fine operazione", 
							"2-->Deserializzazione per data",
							"3-->Verifica presenza dipendente in una determinata data",
							"4-->Salva accessi in un file di testo in ordine crescente di orario",
							"5-->Visualizza accessi di una data in ordine crescente di orario",
							"0-->ESCI"};

		ConsoleInput tastiera=new ConsoleInput();
		Menu menu=new Menu("MENU'", vociMenu);
		
		//PARAMETRI PER ACQUISIRE DATA
		int scelta;
		LocalDate data;
		int aa = 0,mm = 0,gg = 0;
		LocalTime ora;
		int h,m,s;
		
		//PARAMETRI PER ACQUISIRE DIPENDENTE
		String nominativo = null;
		int matricola = 0;
		
		//PARAMETRI PER ACQUISIRE ACCESSO
		LocalDateTime dataOra;
		
		//LABORATORIO
		Accesso accesso;
		Laboratorio l1=new Laboratorio();
		do
		{
			scelta=menu.scelta();
			switch (scelta)
			{
			case 1:
				System.out.println("INSERIRE LA DATA DI CUI SI VOGLIONO REGISTRARE GLI ACCESSI");
				System.out.print("Giorno: ");
					try {
						gg=tastiera.readInt();
					}catch (NumberFormatException e) {
						System.out.println("Formato dato inserito errato");
					} catch (IOException e) {
						System.out.println("Impossibile leggere da tastiera");
					}
				System.out.print("Mese: ");
					try {
						mm=tastiera.readInt();
					} catch (NumberFormatException e) {
						System.out.println("Formato dato inserito errato");
					} catch (IOException e) {
						System.out.println("Impossibile leggere da tastiera");
					}
				System.out.print("Anno: ");
					try {
						aa=tastiera.readInt();
					} catch (NumberFormatException e) {
						System.out.println("Formato dato inserito errato");
					} catch (IOException e) {
						System.out.println("Impossibile leggere da tastiera");
					}
					data= LocalDate.of(aa, mm, gg);	
					System.out.println("DATA INSERITA->"+data.toString());
				
				String scelta1 = null;
				do
				{
					System.out.println("INSERIRE LA MATRICOLA DEL DIPENDENTE DI CUI SI VUOLE REGISTRARE L'ACCESSO");
					System.out.print("Matricola: ");
					try {
						matricola=tastiera.readInt();
					} catch (NumberFormatException e) {
						System.out.println("Formato dato inserito errato");
					} catch (IOException e) {
						System.out.println("Impossibile leggere da tastiera");
					}
					
					ora=LocalTime.now();
					System.out.println("Orario: "+ora.toString());
					dataOra=LocalDateTime.of(data,ora);
					accesso=new Accesso(matricola,dataOra);
					l1.registraAccesso(accesso);
					
					System.out.println("Visualizzazione accessi: \n"+l1.toString());	
					
					System.out.println("Registrare un'altro accesso in  data " +data.toString()+"? ");
					try {
						scelta1=tastiera.readString();
					} catch (NumberFormatException e) {
						System.out.println("Formato dato inserito errato");
					} catch (IOException e) {
						System.out.println("Impossibile leggere da tastiera");
					}
					
				}while(scelta1.compareToIgnoreCase("si")==0);
				try {
					l1.salvaLaboratorio(data);
					System.out.println("Scrittura su file avvenuta con successo");
				} catch (IOException e) {
					System.out.println("Impossibile completare l'operazione di scrittura");
				}
				break;
			
			case 2:
				System.out.println("INSERIRE LA DATA DI CUI SI VOGLIONO REGISTRARE GLI ACCESSI");
				System.out.print("Giorno: ");
					try {
						gg=tastiera.readInt();
					}catch (NumberFormatException e) {
						System.out.println("Formato dato inserito errato");
					} catch (IOException e) {
						System.out.println("Impossibile leggere da tastiera");
					}
				System.out.print("Mese: ");
					try {
						mm=tastiera.readInt();
					} catch (NumberFormatException e) {
						System.out.println("Formato dato inserito errato");
					} catch (IOException e) {
						System.out.println("Impossibile leggere da tastiera");
					}
				System.out.print("Anno: ");
					try {
						aa=tastiera.readInt();
					} catch (NumberFormatException e) {
						System.out.println("Formato dato inserito errato");
					} catch (IOException e) {
						System.out.println("Impossibile leggere da tastiera");
					}
					data= LocalDate.of(aa, mm, gg);	
					System.out.println("DATA INSERITA->"+data.toString());
				try {
					l1.CaricaLaboratorio(data);
					System.out.println("Caricamento degli accessi in data "+data.toString()+" eseguito con successo");
					System.out.println(l1.toString());
				} catch (ClassNotFoundException e) {
					System.out.println("Impossibile caricare oggetti di tipo laboratorio");
				} catch (IOException e) {
					System.out.println("Impossibile completare il caricamento degli accessi");
				}
				break;
				
			default:
				break;
			}
		}while(scelta!=0);
	}

}
