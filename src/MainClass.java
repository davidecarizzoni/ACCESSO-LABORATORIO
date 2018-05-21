import java.io.IOException;
import java.time.DateTimeException;
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
		String[] vociMenu= {"1-->Registra accesso..richiesto salvataggio su file(serializzazione) a fine operazione", 
							"2-->Caricamento accessi per data(deserializzazione)",
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
		
		//PARAMETRI PER ACQUISIRE MATRICOLA
		
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
					System.out.println("Elenco delle giornate presenti:");
					for (int i = 0; i < workingDir.length; i++) 
					{
						System.out.println("->"+workingDir[i]);
					}
				}
				else
					System.out.println("Nessuna data con accessi presente");
				System.out.println("INSERIRE LA DATA IN CUI SI VOGLIONO REGISTRARE GLI ACCESSI");
				l1=new Laboratorio();
					boolean dataOK;
					do {
						dataOK=true;
						try {
							aa=0;
							mm=0;
							gg=0;
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
						if(aa<=0)
						{
							System.out.println("Errore nell'inserimento data, reinserirla!");
							dataOK=false;
							continue;
						}
							
						try {
							
							data= LocalDate.of(aa, mm, gg);	
						} catch (DateTimeException e) {
							System.out.println("Errore nell'inserimento data, reinserirla!");
							dataOK=false;
							continue;
						} 
						try
						{
							System.out.println("DATA INSERITA->"+data.toString());
							//break;
						}catch (NullPointerException e) {
							
						}
						
					} while (dataOK==false);
					
				String scelta1 = null;
				do
				{
					System.out.println("INSERIRE LA MATRICOLA DEL DIPENDENTE DI CUI SI VUOLE REGISTRARE L'ACCESSO");
					boolean matricolaOK1;
					do {
						matricolaOK1=true;
						System.out.print("Matricola: ");
						try {
							matricola=tastiera.readInt();
						} catch (NumberFormatException e) {
							System.out.println("Formato dato inserito errato, reinserire");
							matricolaOK1=false;
							continue;
						} catch (IOException e) {
							System.out.println("Impossibile leggere da tastiera");
						}
					} while (matricolaOK1==false);
					
					
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
				if(workingDir.length==0)
					System.out.println("Nessun data con accessi presente, impossibile effettuare l'operazione di caricamento.");
				else
				{
					System.out.println("Elenco delle giornate presenti:");
					for (int i = 0; i < workingDir.length; i++) 
					{
						System.out.println("->"+workingDir[i]);
					}
					System.out.println("INSERIRE LA DATA DI CUI SI VOGLIONO CARICARE GLI ACCESSI");
					boolean dataOK1;
					do {
						dataOK1=true;
						try {
							aa=0;
							mm=0;
							gg=0;
							System.out.print("Giorno: ");
							gg=tastiera.readInt();
							System.out.print("Mese: ");
							mm=tastiera.readInt();
							System.out.print("Anno: ");
							aa=tastiera.readInt();
						}catch (NumberFormatException e) {
							System.out.println("Formato dato inserito errato ");
						} catch (IOException e) {
							System.out.println("Impossibile leggere da tastiera");
						}
						if(aa<=0)
						{
							System.out.println("Errore nell'inserimento data, reinserirla!");
							dataOK1=false;
							continue;
						}
						try {
							data= LocalDate.of(aa, mm, gg);	
						} catch (DateTimeException e) {
							System.out.println("Errore nell'inserimento data, reinserirla!");
							dataOK1=false;
							continue;
						} 
						try
						{
							System.out.println("DATA INSERITA->"+data.toString());
							//break;
						}catch (NullPointerException e) {
							
						}
					} while (dataOK1==false);
					
					try {
						//l1.salvaLaboratorio(data);
						l1=l1.CaricaLaboratorio(data);
						System.out.println("Caricamento degli accessi in data "+data.toString()+" eseguito con successo");
						System.out.println(l1.toString());
					} catch (ClassNotFoundException e) {
						System.out.println("Impossibile caricare oggetti di tipo laboratorio");
					} catch (IOException e) {
						System.out.println("Nessun accesso presente in data "+data.toString()+". Impossibile completare il caricamento degli accessi.");
					}
				
				}
				break;
			
			case 3:
				workingDir=Laboratorio.elencaDate();
				if(workingDir.length==0)
					System.out.println("Nessun data con accessi presente, impossibile effettuare l'operazione di caricamento.");
				else
				{
					System.out.println("Elenco delle giornate presenti:");
					for (int i = 0; i < workingDir.length; i++) 
					{
						System.out.println("->"+workingDir[i]);
					}
					System.out.println("INSERIRE LA DATA IN CUI SI VUOLE VERIFICARE LA PRESENZA: ");
					boolean dataOK2;
					do {
						dataOK2=true;
						try {
							aa=0;
							mm=0;
							gg=0;
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
						if(aa<=0)
						{
							System.out.println("Errore nell'inserimento data, reinserirla!");
							dataOK2=false;
							continue;
						}
						try {
							data= LocalDate.of(aa, mm, gg);	
						} catch (DateTimeException e) {
							System.out.println("Errore nell'inserimento data, reinserirla!");
							dataOK2=false;
							continue;
						} 
						try
						{
							System.out.println("DATA INSERITA->"+data.toString());
						}catch (NullPointerException e) {
							
						}
					} while (dataOK2==false);
						try {
							//l1.salvaLaboratorio(data);
							l1=l1.CaricaLaboratorio(data);
							System.out.println("Caricamento degli accessi in data "+data.toString()+" eseguito con successo");
							System.out.println(l1.toString());
						} catch (ClassNotFoundException e) {
							System.out.println("Impossibile caricare oggetti di tipo laboratorio");
						} catch (IOException e) {
							System.out.println("Nessun accesso presente in data "+data.toString()+". Impossibile verificare la presenza.");
							break;
						}					
					System.out.println("INSERIRE LA MATRICOLA DEL DIPENDENTE DI CUI SI VOGLIONO VERIFICARE GLI ACCESSI");
					boolean matricolaOK;
					do {
						matricolaOK=true;
						try {
							System.out.print("Matricola: ");
							matricola=tastiera.readInt();
						} catch (NumberFormatException e1) {
							System.out.println("Formato dato inserito errato, reinserire");
							matricolaOK=false;
							continue;
						} catch (IOException e1) {
							System.out.println("Impossibile leggere da tastiera");
						}
					} while (matricolaOK==false);
						
						
						try {
						if(l1.verificaPresenza(matricola))
							System.out.println("Sono presenti accessi del dipendente con matricola " +matricola+ " in data "+data.toString()+". PRESENZA VERIFICATA!");
						} catch (LaboratorioException e1) {
							System.out.println(e1.toString());
						} catch (AccessoMatricolaNotFoundException e) {
							System.out.println(e.toString()+"in data "+data.toString()+".");
						}
				}
				
				break;
				
			
			case 4:
				Laboratorio l2=new Laboratorio();
				
				workingDir=Laboratorio.elencaDate();
				if(workingDir.length==0)
					System.out.println("Nessun data con accessi presente, impossibile effettuare l'operazione di caricamento.");
				else
				{
					System.out.println("Elenco delle giornate presenti:");
					for (int i = 0; i < workingDir.length; i++) 
					{
						System.out.println("->"+workingDir[i]);
					}
					System.out.println("INSERIRE LA DATA DI CUI SI VOGLIONO SALVARE GLI ACCESSI IN UN FILE DI TESTO");
					boolean dataOK3;
					do {
						dataOK3=true;
						try {
							aa=0;
							mm=0;
							gg=0;
							System.out.print("Giorno: ");
							gg=tastiera.readInt();
							System.out.print("Mese: ");
							mm=tastiera.readInt();
							System.out.print("Anno: ");
							aa=tastiera.readInt();
						}catch (NumberFormatException e) {
							System.out.println("Formato dato inserito errato ");
						} catch (IOException e) {
							System.out.println("Impossibile leggere da tastiera");
						}
						if(aa<=0)
						{
							System.out.println("Errore nell'inserimento data, reinserirla!");
							dataOK3=false;
							continue;
						}
						try {
							data= LocalDate.of(aa, mm, gg);	
						} catch (DateTimeException e) {
							System.out.println("Errore nell'inserimento data, reinserirla!");
							dataOK3=false;
							continue;
						} 
						try
						{
							System.out.println("DATA INSERITA->"+data.toString());
							//break;
						}catch (NullPointerException e) {
							
						}
					} while (dataOK3==false);
					
					try {
						l1=l1.CaricaLaboratorio(data);
						System.out.println("Caricamento degli accessi in data "+data.toString()+" eseguito con successo");
						//System.out.println(l1.toString());
					} catch (ClassNotFoundException e) {
						System.out.println("Impossibile caricare oggetti di tipo laboratorio");
					} catch (IOException e) {
						System.out.println("Nessun accesso presente in data "+data.toString()+". Impossibile completare il caricamento degli accessi per poi salvarli.");
						break;
					}
				
				try {
					System.out.println("SALVATAGGIO ACCESSI IN UN FILE DI TESTO IN ORDINE CRESCENTE");
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
				} catch (NullPointerException e) {
					System.out.println("Nessuna giornata presente. effettuare l'operazione di caricamento sulla data desiderata(operazione 2)");
				}
				}
				break;
			
			case 5:
				if(l1.getElementi()==0)
					System.out.println("Nessuna giornata caricata, eseguire prima il caricamento di una data (operazione 2)");
				else
				{

					System.out.println("VISUALIZZAZIONE ACCESSI IN ORDINE CRONOLOGICO CRESCENTE");
					try {
						l1=Ordinatore.selectionSortCrescenteNodi(l1);
						//System.out.println("visualizzazione accessi con orario crescente");
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
				
				}
				
				
				break;
				
			default:
				
				break;
			}
		}while(scelta!=0);
		System.out.println("SEI USCITO,BYE BYE");
		
	}

}
