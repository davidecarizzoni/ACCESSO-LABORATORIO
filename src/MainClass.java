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
		LocalDate data = null;
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
		String[] workingDir;
		
		do
		{
			scelta=menu.scelta();
			switch (scelta)
			{
			case 1:
				workingDir=Laboratorio.elencaDate();
				if(workingDir.length>0)
				{
					System.out.println("Elenco dei file binari presenti");
					for (int i = 0; i < workingDir.length; i++) 
					{
						System.out.println("->"+workingDir[i]);
					}
				}
				else
					System.out.println("Nessun file ancora presente");
				System.out.println("INSERIRE LA DATA DI CUI SI VOGLIONO REGISTRARE GLI ACCESSI");
				l1=new Laboratorio();
					try {
						System.out.print("Giorno: ");
						gg=tastiera.readInt();
						System.out.print("Mese: ");
						mm=tastiera.readInt();
						System.out.print("Anno: ");
						aa=tastiera.readInt();
					}catch (NumberFormatException e) {
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
					l1.registraAccesso(accesso);//Registra accesso sempre in testa
					
					System.out.println("Visualizzazione accessi: \n"+l1.toString());	
					
					System.out.print("Registrare un'altro accesso in  data " +data.toString()+"? (si o no)");
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
				workingDir=Laboratorio.elencaDate();
				System.out.println("Elenco dei file binari presenti");
				for (int i = 0; i < workingDir.length; i++) 
				{
					System.out.println("->"+workingDir[i]);
				}
				System.out.println("INSERIRE LA DATA DI CUI SI VOGLIONO CARICARE GLI ACCESSI");
					try {
						System.out.print("Giorno: ");
						gg=tastiera.readInt();
						System.out.print("Mese: ");
						mm=tastiera.readInt();
						System.out.print("Anno: ");
						aa=tastiera.readInt();
					}catch (NumberFormatException e) {
						System.out.println("Formato dato inserito errato");
					} catch (IOException e) {
						System.out.println("Impossibile leggere da tastiera");
					}
				
				data= LocalDate.of(aa, mm, gg);	
				//String nomeFile="C:\\Users\\Davide Carizzoni\\Desktop\\Davide\\SCUOLA QUARTA SUPERIORE\\INFORMATICA\\JAVA\\Workspace-carizzoni\\ACCESSO LABORATORIO\\fileBIN\\"+data.getDayOfMonth()+"_"+data.getMonthValue()+"_"+data.getYear()+".bin";
				System.out.println("DATA INSERITA->"+data.toString());
					try {
						//l1.salvaLaboratorio(data);
						l1=l1.CaricaLaboratorio(data);
						System.out.println("Caricamento degli accessi in data "+data.toString()+" eseguito con successo");
						System.out.println(l1.toString());
					} catch (ClassNotFoundException e) {
						System.out.println("Impossibile caricare oggetti di tipo laboratorio");
						
					
					} catch (IOException e) 
					{
						System.out.println("Impossibile completare il caricamento degli accessi");
					
					}
				break;
			
			case 3:
				workingDir=Laboratorio.elencaDate();
				System.out.println("Elenco dei file binari presenti");
				for (int i = 0; i < workingDir.length; i++) 
				{
					System.out.println("->"+workingDir[i]);
				}
				System.out.println("INSERIRE LA DATA DI CUI SI VUOLE VERIFICARE LA PRESENZA");
					try {
						System.out.print("Giorno: ");
						gg=tastiera.readInt();
						System.out.print("Mese: ");
						mm=tastiera.readInt();
						System.out.print("Anno: ");
						aa=tastiera.readInt();
					}catch (NumberFormatException e) {
						System.out.println("Formato dato inserito errato");
					} catch (IOException e) {
						System.out.println("Impossibile leggere da tastiera");
					}
				data= LocalDate.of(aa, mm, gg);	
				System.out.println("DATA INSERITA->"+data.toString());
					try {
						//l1.salvaLaboratorio(data);
						l1=l1.CaricaLaboratorio(data);
						System.out.println("Caricamento degli accessi in data "+data.toString()+" eseguito con successo");
						System.out.println(l1.toString());
					} catch (ClassNotFoundException e) {
						System.out.println("Impossibile caricare oggetti di tipo laboratorio");
					} catch (IOException e) {
						System.out.println("Impossibile completare il caricamento degli accessi");
					}					
				System.out.println("INSERIRE LA MATRICOLA DEL DIPENDENTE DI CUI SI VOGLIONO VERIFICARE LE PRESENZE");
					try {
						System.out.print("Matricola: ");
						matricola=tastiera.readInt();
						
					} catch (NumberFormatException e1) {
						System.out.println("Formato dato inserito errato");
					} catch (IOException e1) {
						System.out.println("Impossibile leggere da tastiera");
					}
					
				try {
					if(l1.verificaPresenza(matricola)==true)
						System.out.println("Sono presenti accessi del dipendente con matricola " +matricola+ ". PRESENZA VERIFICATA!");
					else
						System.out.println("Nessun accesso presente per il dipendente con matricola " +matricola+ ". ");
				break;
				} catch (LaboratorioException e1) {
					e1.toString();
				}
			
			case 4:
				Laboratorio l2=new Laboratorio();
				System.out.println("SALVA ACCESSI IN UN FILE DI TESTO IN ORDINE CRESCENTE");
				try {
					l2=Ordinatore.selectionSortCrescente(l1);
					System.out.println(l2.toString());
					l2.esportaLaboratorioCSV(data);
					System.out.println("Operazione completata con successo");
				} catch (FileException e) {
					System.out.println("Impossibile completare l'operazione, file aperto in scrittura");
				} catch (IOException e) {
					System.out.println("Impossibile completare il salvataggio degli oggetti");
				} catch (LaboratorioException e) {
					System.out.println(e.toString());
				//} catch (ClassNotFoundException e) {
				//	System.out.println("Impossibile caricare oggetti di tipo laboratorio");
				}
				
				break;
			
			case 5:
				
				System.out.println("VISUALIZZA ACCESSI IN BASE ALL'ORARIO");
				try {
					l1=Ordinatore.selectionSortCrescenteNodi(l1);
					System.out.println("visualizzazione accessi con orario crescente");
					System.out.println(l1.toString());
				} catch (LaboratorioException e) {
					System.out.println(e.toString());
				} catch (ClassNotFoundException e) {
					System.out.println("Impossibile caricare oggetti di tipo laboratorio");
				} catch (IOException e) {
					System.out.println("Impossibile completare il caricamento degli accessi");
				} catch (FileException e) {
					System.out.println("File non trovato");
				}
				break;
				
			default:
				break;
			}
		}while(scelta!=0);
		System.out.println("SEI USCITO,BYE BYE");
		
	}

}
