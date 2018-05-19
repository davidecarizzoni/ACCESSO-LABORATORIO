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
		System.out.println(laboratorio.getAccesso(1).toString());
		System.out.println(accesso.toString());
		assertTrue(laboratorio.getAccesso(1).toString().compareToIgnoreCase("-->"+accesso.toString()+"\n")==0);
		
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
		assertEquals("getAccesso", accesso, laboratorio.getAccesso(1));
		//assertTrue("getAccesso",laboratorio.getAccesso(1)==accesso);
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
		Laboratorio l=new Laboratorio();
		LocalDate data=LocalDate.now();
		LocalTime ora=LocalTime.now();
		LocalDateTime dataOra=LocalDateTime.of(data, ora);
		Accesso accesso=new Accesso(1,dataOra);
		l.registraAccesso(accesso);
		l.salvaLaboratorio(data);
		Laboratorio lcopia=l.CaricaLaboratorio(data);
		assertTrue("Serializzazione e Deserializzzazione",l.toString().compareTo(lcopia.toString())==0);
	}
	
	//DA FINIRE
	@Test
	public void testEsportaLaboratorioCSV()
	{
		Laboratorio l=new Laboratorio();
		LocalDate data=LocalDate.now();
		LocalTime ora=LocalTime.now();
		LocalDateTime dataOra=LocalDateTime.of(data, ora);
		Accesso accesso=new Accesso(1,dataOra);
	}	
	
	@Test
	public void testVerificaPresenza() throws LaboratorioException, AccessoMatricolaNotFoundException
	{
		Laboratorio l=new Laboratorio();
		LocalDateTime dataOra=LocalDateTime.now();
		Accesso accesso=new Accesso(1,dataOra);
		assertEquals("VerificaPresenza",l.getAccesso(1).getMatricola(),1);
	}	
	
	@Test(expected=AccessoMatricolaNotFoundException.class)
	public void testVerificaPresenzaEccezione() throws LaboratorioException, AccessoMatricolaNotFoundException
	{
		Laboratorio l=new Laboratorio();
		LocalDateTime dataOra=LocalDateTime.now();
		Accesso accesso=new Accesso(1,dataOra);
		l.verificaPresenza(1);
	}	
	
	

	
	
	
	
	

}
