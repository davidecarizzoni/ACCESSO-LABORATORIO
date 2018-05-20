import static org.junit.Assert.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Test;

public class LaboratorioTest {

	@Test
	public void testCostruttoreLaboratorio() 
	{
		Laboratorio laboratorio=new Laboratorio();
		assertTrue("Costruttore Laboratorio",laboratorio.getHead()==null && laboratorio.getElementi()==0);
	}
	
/*	//test commentato perchè metodo creaNodo è privato
	@Test
	public void testCreaNodo() 
	{
		Laboratorio laboratorio=new Laboratorio();
		Accesso accesso1=new Accesso();
		Accesso accesso2=new Accesso();
		Nodo nodo1=new Nodo(accesso1);
		Nodo nodo2=laboratorio.creaNodo(accesso2, nodo1);
		assertTrue("Crea Nodo",nodo2.getInfo().equals(accesso2) && nodo2.getLink()==nodo1);
	}
	*/
	
	@Test	public void testRegitraAccesso() 
	{
		Laboratorio laboratorio=new Laboratorio();
		Accesso accesso1=new Accesso();
		laboratorio.registraAccesso(accesso1);
		assertTrue("registraAccesso",laboratorio.getElementi()==1);
	}
	
	@Test 
	public void testToString() throws LaboratorioException 
	{
		Laboratorio laboratorio=new Laboratorio();
		LocalDateTime dataOra=LocalDateTime.now();
		Accesso accesso=new Accesso(1,dataOra);
		laboratorio.registraAccesso(accesso);
		assertTrue(laboratorio.toString().compareToIgnoreCase("-->"+accesso.toString()+"\n")==0);
		
	}
	
	@Test 
	public void testToStringVuoto() 
	{
		Laboratorio laboratorio=new Laboratorio();
		assertTrue("toString ",laboratorio.toString().compareToIgnoreCase("")==0);
		
	}
	
	@Test 
	public void testGetAccesso() throws LaboratorioException 
	{
		Laboratorio laboratorio=new Laboratorio();
		LocalDateTime dataOra=LocalDateTime.now();
		Accesso accesso=new Accesso(1,dataOra);
		laboratorio.registraAccesso(accesso);
		assertTrue("getAccesso",laboratorio.getAccesso(1).getIdAccesso()==accesso.getIdAccesso() && laboratorio.getAccesso(1).getMatricola()==accesso.getMatricola()   && laboratorio.getAccesso(1).getDataOra()==accesso.getDataOra() );
	}
	
	@Test (expected=LaboratorioException.class)
	public void testGetAccessoLaboratorioVuoto() throws LaboratorioException 
	{
		Laboratorio laboratorio=new Laboratorio();
		laboratorio.getAccesso(1);
	}
	
	@Test (expected=LaboratorioException.class)
	public void testGetAccessoPosizioneNonValida() throws LaboratorioException 
	{
		Laboratorio laboratorio=new Laboratorio();
		Accesso accesso=new Accesso();
		laboratorio.registraAccesso(accesso);
		laboratorio.getAccesso(2);
	}
	
	@Test 
	public void testEliminaInTesta() throws LaboratorioException 
	{
		Laboratorio laboratorio=new Laboratorio();
		Accesso accesso=new Accesso();
		laboratorio.registraAccesso(accesso);
		laboratorio.eliminaInTesta();
		assertTrue("EliminaInTesta", laboratorio.getHead()==null);
	}
	
	@Test (expected=LaboratorioException.class)
	public void testEliminaInTestaLaboratorioVuoto() throws LaboratorioException 
	{
		Laboratorio laboratorio=new Laboratorio();
		laboratorio.eliminaInTesta();
	}
	
	@Test 
	public void testEliminaInCoda() throws LaboratorioException 
	{
		Laboratorio laboratorio=new Laboratorio();
		Accesso accesso=new Accesso();
		laboratorio.registraAccesso(accesso);
		laboratorio.eliminaInCoda();
		assertTrue("EliminaInCoda", laboratorio.getHead()==null);
	}
	
	@Test (expected=LaboratorioException.class)
	public void testEliminaInCodaLaboratorioVuoto() throws LaboratorioException 
	{
		Laboratorio laboratorio=new Laboratorio();
		laboratorio.eliminaInCoda();
	}
	
	@Test
	public void testSalvaCaricaLaboratorio() throws IOException, ClassNotFoundException 
	{
		Laboratorio laboratorio=new Laboratorio();
		LocalDate data=LocalDate.now();
		LocalTime ora=LocalTime.now();
		LocalDateTime dataOra=LocalDateTime.of(data, ora);
		Accesso accesso=new Accesso(1,dataOra);
		laboratorio.registraAccesso(accesso);
		laboratorio.salvaLaboratorio(data);
		Laboratorio lcopia=laboratorio.CaricaLaboratorio(data);
		assertTrue("Salva e carica laboratorio",laboratorio.toString().compareTo(lcopia.toString())==0);
	}
/*	
	@Test (expected=IOException.class)
	public void testCaricaLaboratorioEccezione() throws IOException, ClassNotFoundException 
	{
		Laboratorio laboratorio=new Laboratorio();
		LocalDate data=LocalDate.of(28,2,2015);//Non deve essere già presente un file con questa data altrimenti non si verfifica la condizione del file non presente
		laboratorio.CaricaLaboratorio(data);
	}
*/	
	@Test
	public void testEsportaLaboratorioCSV() throws IOException, LaboratorioException, FileException
	{
		Laboratorio laboratorio=new Laboratorio();
		LocalDate data=LocalDate.now();
		LocalTime ora=LocalTime.now();
		LocalDateTime dataOra=LocalDateTime.of(data, ora);
		Accesso accesso=new Accesso(1,dataOra);
		laboratorio.registraAccesso(accesso);
		laboratorio.esportaLaboratorioCSV(data);
		String nomeFile="C:\\Users\\Davide Carizzoni\\Desktop\\Davide\\SCUOLA QUARTA SUPERIORE\\INFORMATICA\\JAVA\\Workspace-carizzoni\\ACCESSO LABORATORIO\\fileTXT\\"+data.getDayOfMonth()+"_"+data.getMonthValue()+"_"+data.getYear()+".txt";
		TextFile file=new TextFile(nomeFile,'R');
		String StringaLetta=file.fromFile();
		String accessoCSV=accesso.getMatricola()+";"+accesso.getDataOra()+";"+accesso.getIdAccesso()+";";
		assertTrue("EsportaLaboratorioCSV",StringaLetta.compareTo(accessoCSV)==0);
		
	}	
	
	@Test
	public void testVerificaPresenza() throws LaboratorioException, AccessoMatricolaNotFoundException
	{
		Laboratorio l=new Laboratorio();
		LocalDateTime dataOra=LocalDateTime.now();
		Accesso accesso=new Accesso(1,dataOra);
		l.registraAccesso(accesso);
		assertEquals("VerificaPresenza",l.getAccesso(1).getMatricola(),1);
	}	
	
	@Test(expected=AccessoMatricolaNotFoundException.class)
	public void testVerificaPresenzaEccezione() throws LaboratorioException, AccessoMatricolaNotFoundException
	{
		Laboratorio l=new Laboratorio();
		LocalDateTime dataOra=LocalDateTime.now();
		Accesso accesso=new Accesso(1,dataOra);
		l.registraAccesso(accesso);
		l.verificaPresenza(2);
	}	
	
	

	
	
	
	
	

}
