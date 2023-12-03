package br.com.projeto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import javafx.collections.transformation.SortedList;

 

public class Main {

	public static void main(String[] args) {
		
		List<Funcionario> funcionarios = new ArrayList<>();
		
		Funcionario funcionario = new Funcionario();
		 
		Funcionario f1 =  new Funcionario("Maria","18/10/2000", 2009.44, "Operador");
		Funcionario f2 =  new Funcionario("João", "12/05/1990", 2284.38, "Operador");
		Funcionario f3 =  new Funcionario("Caio", "02/12/1961", 9836.14, "Coodenador");
		Funcionario f4 =  new Funcionario("Miguel", "14/10/1988", 19119.88, "Diretor");
		Funcionario f5 =  new Funcionario("Alice", "05/01/1995", 2234.68, "Recepcionista");
		Funcionario f6 =  new Funcionario("Heitor", "19/11/1999", 1582.72, "Operador");
		Funcionario f7 =  new Funcionario("Arthur", "31/03/1993", 4071.84, "Contador");
		Funcionario f8 =  new Funcionario("Laura", "08/07/1994", 3017.45 , "Gerente");
		Funcionario f9 =  new Funcionario("Heloísa", "24/05/2003", 1606.85, "Eletricista");
		Funcionario f10 = new Funcionario("Helena", "02/09/1996", 2799.93, "Gerente");
		
		funcionarios = Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10);
		 
		  //3.10 – Imprimir a lista de funcionários por ordem alfabética.    
		  funcionarios.sort(new Funcionario());
		      
		     for (Funcionario fun : funcionarios) {
				System.out.println(fun.toString());
			 }
		     
		    
		     //"==================CHAMADA DOS MÉTODOS============================"
		    
		      funcionario.mostarLista(funcionarios);
		     
		     funcionario.retirarNomeLista(funcionarios);
		     
		     funcionario.formatarValores(funcionarios);
		     
		     funcionario.atualizarSalario(funcionarios);
		     
		     //funcionario.agruparPorFuncao(Map<String, List<Funcionario>> funcionarios);
		     
		     funcionario.pegarMesAniversario(funcionarios);
		     
		     funcionario.funcionarioMaiorIdade(funcionarios);
		     
		     funcionario.totalSalarioFuncionarios(funcionarios);
		     
		     funcionario.imprimirSalarios(funcionarios);
		     
				 
	}			
	     
				 
}

	 

 
