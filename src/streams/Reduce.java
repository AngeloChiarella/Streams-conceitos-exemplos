package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Reduce {

	public static void main(String[] args) {
		
//		REDUCE - Agrupar de alguma forma (Dependendo da funcao de acumulacao), os elementos do stream
		// accumulator - Funcao que vai ser chamada para fazer o reduce em cima da lista
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		
//		Transformando frase em lista de string
		String s = "Inscreva-se no canal e compartilhe esse vídeo!";
		String[] split = s.split(" ");
		List<String> listStr = Arrays.asList(split);
		
		Optional<Integer> reduce = list.stream()
//		Optional<String> reduce = list.stream()
				
				.parallel()
				
				/*Formas simples*/
				
//				.reduce((n1, n2) -> n1 + n2); // SOMA
				.reduce((n1, n2) -> n1 * n2); // MULTIPLICACAO
//				.reduce((s1, s2) -> s1.concat(s2)); //CONCATENACAO DE STRINGS
//  NAO FACA	.reduce((n1, n2) -> n1 - n2); // SUBTRACAO Nao e associativa, muda resultado quando e .parallel 
				
		 System.out.println("Reduce Simples: " + reduce.get());
		 
		 
		 	/* REDUCE COM VALOR DE IDENTIDADE (Parametro amais para juntar com stream) */
		 	/* NAO RETORNA Optional */
		 
//		 Integer reduce2 = list.stream()
		 String reduce2 = listStr.stream()
//		 				.reduce(1 , (n1 , n2) -> n1 + n2); // Identidade(1) + stream
//				 		.reduce(2 , (n1 , n2) -> n1 * n2); // Identidade(2) * stream
				 		.reduce("ANGELO ", (s1, s2) -> s1.concat(s2)); // Identidade(ANGELO) Concatenado com stream
				 
		 System.out.println("Reduce com identidade: " + reduce2);
		 
		 /* REDUCE menor valor */
		 Double reduce3 = DoubleStream.of(1.5, 2.9, 6.7)
		 	.reduce(Double.POSITIVE_INFINITY, (d1, d2) -> Math.min(d1, d2));
		 System.out.println("Menor Valor Double: " + reduce3);
		 
		 /* FUNCAO DE COMBINACAO  - map + combiner*/
		 String reduce4 = list.stream()
//				 .parallel() // Junta a ID em cada string
//				 .reduce(0, (n1, n2) -> n1 + n2, (n1, n2) -> n1 + n2 );
				 
//				 .map(n1 -> n1.toString()) // Transformar em string
//				 .reduce((n1, n2) -> n1.concat(n2)); // Concatenou todas as strings
		 
				 .reduce(
						 "ANGELO", 
						 (n1, n2) -> n1.toString().concat(n2.toString()), // MAP - Transformar em string
						 (n1, n2) -> n1.concat(n2) // Concatenou todas as strings
						);
		 
		 System.out.println("Combinacao: " + reduce4);
		 
		 
		 
	}

}
