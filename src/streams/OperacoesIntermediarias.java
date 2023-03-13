package streams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperacoesIntermediarias {

	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(1, 5, 8, 9, 1, 4, 7, 6, 6, 9, 9);
		List<Integer> lista2 = new ArrayList<>();
		
//		Operacoes Intermediarias - Filtros
		
		lista.stream()
		
//			.skip(2)   // skip - Ignora os dois primeiros elementos do stream "1, 5"
		
//			.limit(2)  // limit - Retorna/Filtra os dois primeiros elementos do stream
		
//			.distinct() // distinct - Impede o processamento de elementos repetidos (Equals/Hashcode)
		
//			.filter(e -> e % 2 == 0) // filter - Filtra usando expressao lambda
		
//			.map(e -> e * 2) // map - Transformacao, executa uma logica e manda pra frente sem modificar a lista original
//			.forEach(e -> lista2.add(e));
			
			
		
			.forEach(e -> System.out.println(e));
		
		System.out.println(lista);
		System.out.println(lista2);
		
	}
}
