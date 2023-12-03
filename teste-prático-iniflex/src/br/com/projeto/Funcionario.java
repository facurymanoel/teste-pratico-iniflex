package br.com.projeto;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Funcionario extends Pessoa implements Comparator<Funcionario> {

	double salario;
	String funcao;

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	// Construtor padr�o
	public Funcionario() {

	}

	// Construtor param�tros
	public Funcionario(String nome, String dataNascimento, double salario, String funcao) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.funcao = funcao;
	}

	// 3.1 � Inserir todos os funcion�rios, na mesma ordem e informa��es da tabela acima.
	public String mostarLista(List<Funcionario> funcs) {
		String m = "";
		for (Funcionario f : funcs) {
			m += f;
		}
		return m;
	}

	// 3.2 � Remover o funcion�rio �Jo�o� da lista.
	public void retirarNomeLista(List<Funcionario> funcs) {

		for (Funcionario fun : funcs) {
			if (fun.getNome().equalsIgnoreCase("Jo�o")) {
				funcs.remove(fun);
				break;
			} else {

				System.out.println(fun);
			}

		}

	}

	// � informa��o de valor num�rico deve ser exibida no formatado com separador de
	// milhar como ponto e decimal como v�rgula.
	public void formatarValores(List<Funcionario> funcs) {

		for (int i = 0; i < funcs.size(); i++) {
			Funcionario func = new Funcionario();
			func = funcs.get(i);
		}

		NumberFormat salario = DecimalFormat.getNumberInstance(new Locale("pt", "BR"));

		System.out.println(salario);
	}

	// 3.4 � Os funcion�rios receberam 10% de aumento de sal�rio, atualizar a lista
	// de funcion�rios com novo valor.
	public String atualizarSalario(List<Funcionario> funcs) {
		String valor = "";
		Funcionario func = new Funcionario();

		for (Funcionario f : funcs) {

			double salario = f.getSalario() + (f.getSalario() * 10 / 100);
			valor += "\nFuncion�rio: " + f.getNome() + " - Novo Sal�rio: " + salario;

		}
		return valor;

	}

	// 3.5 � Agrupar os funcion�rios por fun��o em um MAP, sendo a chave a �fun��o e o valor a �lista de funcion�rios�.�
	// 3.6 � Imprimir os funcion�rios, agrupados por fun��o.
	public void agruparPorFuncao(Map<String, List<Funcionario>> funcs) {

		List<Funcionario> funcionarios = new ArrayList<>();
		Map<String, List<Funcionario>> pegaFuncao = new HashMap<>();

		pegaFuncao = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

		System.out.println(pegaFuncao);

	}

	// 3.8 � Imprimir os funcion�rios que fazem anivers�rio no m�s 10 e 12.
	public void pegarMesAniversario(List<Funcionario> funcs) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		for (int i = 0; i < funcs.size(); i++) {
			LocalDate date = LocalDate.parse(funcs.get(i).getDataNascimento(), formatter);
			if (date.getMonthValue() == 10 || date.getMonthValue() == 12) {
				System.out.println("Nome: " + funcs.get(i).getNome() + ", " + date.getMonthValue());
			}
		}
	}

	// 3.9 � Imprimir o funcion�rio com a maior idade, exibir os atributos: nome e idade.
	 public void funcionarioMaiorIdade(List<Funcionario> funcs) {

		int maior = 0;
		String pegaNome = "";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataAtual = LocalDate.now();
		int horaSistema = dataAtual.getYear();

		for (int i = 0; i < funcs.size(); i++) {
			LocalDate date = LocalDate.parse(funcs.get(i).getDataNascimento(), formatter);
			if (date.getYear() >= maior) {
				maior = date.getYear();
				pegaNome = "Funcion�rio com a maior idade: " + funcs.get(i).getNome();
			}
		}

		horaSistema -= maior;
		System.out.println(pegaNome + ", com " + horaSistema + " anos");

	}

	// 3.10 � Imprimir a lista de funcion�rios por ordem alfab�tica.
	@Override
	public int compare(Funcionario f1, Funcionario f2) {

		String funcionario1 = f1.getNome();
		String funcionario2 = f2.getNome();
		return funcionario1.compareTo(funcionario2);

	}

	// 3.11 � Imprimir o total dos sal�rios dos funcion�rios.
	public double totalSalarioFuncionarios(List<Funcionario> funcs) {

		double totSalarios = 0;

		for (int i = 0; i < funcs.size(); i++) {
			totSalarios += funcs.get(i).getSalario();
		}

		return totSalarios;

	}

	// 3.12 � Imprimir quantos sal�rios m�nimos ganha cada funcion�rio, considerando
	// que o sal�rio m�nimo � R$1212.00.
	public String imprimirSalarios(List<Funcionario> func) {

		String mostrar = "";

		for (Funcionario f : func) {
			double salarioMinimo = 1212.00;

			salarioMinimo /= f.getSalario();

			mostrar += "\n Nome do Funcion�rio(a): " + f.getNome() + salarioMinimo;

			salarioMinimo = 0;
		}
		return mostrar;

	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + " data de nascimento=" + dataNascimento + " salario=" + salario
				+ ", funcao=" + funcao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcao == null) ? 0 : funcao.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (funcao == null) {
			if (other.funcao != null)
				return false;
		} else if (!funcao.equals(other.funcao))
			return false;
		if (Double.doubleToLongBits(salario) != Double.doubleToLongBits(other.salario))
			return false;
		return true;
	}

}
