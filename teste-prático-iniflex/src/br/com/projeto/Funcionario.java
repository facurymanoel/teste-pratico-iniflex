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

	// Construtor padrão
	public Funcionario() {

	}

	// Construtor paramêtros
	public Funcionario(String nome, String dataNascimento, double salario, String funcao) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.funcao = funcao;
	}

	// 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
	public String mostarLista(List<Funcionario> funcs) {
		String m = "";
		for (Funcionario f : funcs) {
			m += f;
		}
		return m;
	}

	// 3.2 – Remover o funcionário “João” da lista.
	public void retirarNomeLista(List<Funcionario> funcs) {

		for (Funcionario fun : funcs) {
			if (fun.getNome().equalsIgnoreCase("João")) {
				funcs.remove(fun);
				break;
			} else {

				System.out.println(fun);
			}

		}

	}

	// • informação de valor numérico deve ser exibida no formatado com separador de
	// milhar como ponto e decimal como vírgula.
	public void formatarValores(List<Funcionario> funcs) {

		for (int i = 0; i < funcs.size(); i++) {
			Funcionario func = new Funcionario();
			func = funcs.get(i);
		}

		NumberFormat salario = DecimalFormat.getNumberInstance(new Locale("pt", "BR"));

		System.out.println(salario);
	}

	// 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista
	// de funcionários com novo valor.
	public String atualizarSalario(List<Funcionario> funcs) {
		String valor = "";
		Funcionario func = new Funcionario();

		for (Funcionario f : funcs) {

			double salario = f.getSalario() + (f.getSalario() * 10 / 100);
			valor += "\nFuncionário: " + f.getNome() + " - Novo Salário: " + salario;

		}
		return valor;

	}

	// 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função e o valor a “lista de funcionários”.”
	// 3.6 – Imprimir os funcionários, agrupados por função.
	public void agruparPorFuncao(Map<String, List<Funcionario>> funcs) {

		List<Funcionario> funcionarios = new ArrayList<>();
		Map<String, List<Funcionario>> pegaFuncao = new HashMap<>();

		pegaFuncao = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

		System.out.println(pegaFuncao);

	}

	// 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
	public void pegarMesAniversario(List<Funcionario> funcs) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		for (int i = 0; i < funcs.size(); i++) {
			LocalDate date = LocalDate.parse(funcs.get(i).getDataNascimento(), formatter);
			if (date.getMonthValue() == 10 || date.getMonthValue() == 12) {
				System.out.println("Nome: " + funcs.get(i).getNome() + ", " + date.getMonthValue());
			}
		}
	}

	// 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
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
				pegaNome = "Funcionário com a maior idade: " + funcs.get(i).getNome();
			}
		}

		horaSistema -= maior;
		System.out.println(pegaNome + ", com " + horaSistema + " anos");

	}

	// 3.10 – Imprimir a lista de funcionários por ordem alfabética.
	@Override
	public int compare(Funcionario f1, Funcionario f2) {

		String funcionario1 = f1.getNome();
		String funcionario2 = f2.getNome();
		return funcionario1.compareTo(funcionario2);

	}

	// 3.11 – Imprimir o total dos salários dos funcionários.
	public double totalSalarioFuncionarios(List<Funcionario> funcs) {

		double totSalarios = 0;

		for (int i = 0; i < funcs.size(); i++) {
			totSalarios += funcs.get(i).getSalario();
		}

		return totSalarios;

	}

	// 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando
	// que o salário mínimo é R$1212.00.
	public String imprimirSalarios(List<Funcionario> func) {

		String mostrar = "";

		for (Funcionario f : func) {
			double salarioMinimo = 1212.00;

			salarioMinimo /= f.getSalario();

			mostrar += "\n Nome do Funcionário(a): " + f.getNome() + salarioMinimo;

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
