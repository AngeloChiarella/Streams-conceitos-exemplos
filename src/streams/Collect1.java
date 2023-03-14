package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collect1 {

	/* Collect - Muito parecido com reduce, foi feito para objetos mutáveis */
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		
		/* fornecedor - funcao lambda que vai fornecer a instancia do obj pra acumula o resultado */
		
		// .collect(fornecedor - acumulacao - combinacao)
		List<Integer> collect = list.stream()
			.collect(
				() -> new ArrayList<>(), 	// Instancia do que for usado para armazenar os resultados
				(l, e) -> l.add(e),         // Modo de armazenar o resultado no que foi instanciado
				(l1, l2) -> l1.addAll(l2)	// Como combinar varias treds que estao tratando ao mesmo tempo esse stream
			);
		
		System.out.println("Lista original: " + list);
		System.out.println("Collect antigo: " + collect);
	
	
	/* toList - Armazena o resultado em uma lista, de forma mais simples.
		Tambem funciona parecido com o toSet 
	*/
		List<Integer> toList = list.stream()
			.filter((n) -> n % 2 == 0)
//				.collect(Collectors.toList()); // Armazena na lista 
			.collect(Collectors.toCollection(
					() -> new ArrayList<>())); 
		
		System.out.println("toList (PARES): " + toList);
		
		/* joining - Serve para unir strings, entao sempre deve-se transformar o objeto em string*/
		String join = list.stream()
			.map(n -> n.toString()) // Transformando de integer para string
			.collect(Collectors.joining(", ")); // Pode-se usar um delimitador " ; "
	
		System.out.println("Join: " + join);
	
		/* averaging - Serve para contas matematicas em geral */
		Double media = list.stream()
			.collect(Collectors.averagingInt(n -> n.intValue())); // Retorna a MEDIA dos valores da lista
		System.out.println("(averagingInt) MEDIA de inteiros: " + media);
	
		/* summing - Parecido com averaging */
		Integer soma = list.stream()
			.collect(Collectors.summingInt(n -> n.intValue())); // Retorna a SOMA dos valores da lista
		System.out.println("(summing) SOMA de inteiros: " + soma);
		
		/* summarizing - Faz uma sumarizacao dos valores */
		IntSummaryStatistics stats = list.stream()
			.collect(Collectors.summarizingInt(n -> n.intValue())); // Retorna a SOMARIZACAO dos valores da lista
		System.out.println("");
		System.out.println(" - IntSummaryStatistics  ");
		System.out.println("MEDIA: " + stats.getAverage());
		System.out.println("QUANTIDADE: " + stats.getCount());
		System.out.println("MAIOR: " + stats.getMax());
		System.out.println("MENOR: " + stats.getMin());
		System.out.println("SOMA: " + stats.getSum());
		System.out.println("");
	
		/* counting - Ver quantos elementos tem no stream */ 
		Long counting = list.stream()
				.filter((n) -> n % 2 == 0) // numeros pares
				.collect(Collectors.counting()); // quantidade de numeros pares
		System.out.println("Couting: " + counting);
		
		/* Max/Min */ 
		list.stream()
				.filter((n) -> n % 2 == 0) 
				.collect(Collectors.minBy(
									Comparator.naturalOrder()))// Passando um comparador pelo parametro
				.ifPresent(System.out::println); 
		
		/* groupingBy - Pega a expressao lambda e agrupa os elementos */ 
		Map<Integer, List<Integer>> groupingBy = list.stream()
			.collect(Collectors.groupingBy((n) -> n % 3)); // Agrupar pelo resto da divisao = 3
		
		System.out.println("GroupingBy: " + groupingBy);
		
		/* partitioningBy - Tambem agrupa e retorna mapa, porem boleano */ 
		Map<Boolean, List<Integer>> partitioningBy = list.stream()
			.collect(Collectors.partitioningBy((n) -> n % 3 == 0));
		System.out.println("PartitioningBy: " + partitioningBy);
	
		/*  toMap - Map sempre chave e valor, duas experssoes (lambda)*/
		Map<Integer, Double> toMap = list.stream()
			.collect(Collectors.toMap(
						n -> n,
						n -> Math.pow(n.doubleValue(), 5) // Math.pow - Pegando a potencia, n elevado a 5
					));
		System.out.println("ToMap: " + toMap);
	}

}
