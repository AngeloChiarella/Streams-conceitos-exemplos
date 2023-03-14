package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OperacoesFinais {

	public static void main(String[] args) {

//		Operacoes Finais - Todas Retornam algo, e sempre bom guardar em variaveis
		
		List<Integer> lista = Arrays.asList(1, 5, 8, 9, 1, 4, 7, 6, 6, 9, 9);

		var var = lista.stream()
//			.filter(e -> e % 2 == 0)
//			.map(e -> e * 3)
				
//			.forEach(e -> System.out.println(e));  ForEach - Não retorna nada, apenas um for pratico
//			.forEach(System.out::println);
//			.count(); // count - Retorna a quantidade de itens
			
//			.min(Comparator.naturalOrder()); // min - Pega o MENOR valor, tem que passar um comparados nele
			
//			.max(Comparator.naturalOrder()); // min - Pega o MAIOR valor, tem que passar um comparados nele
											// Comparator.naturalOrder - Implementada pela integer e tem metodo compareTo
			
//			.collect(Collectors.toList()); // Collect - Pega todos os dados e armazena em uma lista
//			.collect(Collectors.groupingBy(e -> e % 2 == 0)); // groupingBy - Agrupar os numeros em certos criterios
														//Saida : {false=[3, 15, 27, 3, 21, 27, 27], true=[24, 12, 18, 18]}
		
//			.collect(Collectors.groupingBy(e -> e % 3)); // Parametro Integer ( MUITO UTIL PARA TRABALHAR COM ENTIDADES)
//														Ex: Separar os clientes por qualquer atributo												
//														Saida: {0=[9, 6, 6, 9, 9], 1=[1, 1, 4, 7], 2=[5, 8]}
		
			.map(e -> String.valueOf(e)) // Transformando em um stream de strings
			.collect(Collectors.joining(";")); // joining - Serve para agrupar Streams retornando string
//												Saida: 1;5;8;9;1;4;7;6;6;9;9
			
			
		System.out.println(var);
	
	}

}
