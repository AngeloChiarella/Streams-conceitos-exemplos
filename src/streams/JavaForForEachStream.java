package streams;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class JavaForForEachStream {

	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(1, 5, 8, 9, 1, 4, 7, 6, 6, 9, 0);
		
//		Stream = Fluxo de dados
//		Java 8 Streams
//		lista.stream().forEach(e -> System.out.println(e));
		lista.stream().forEach(System.out::println);

//		Java 5
		for (Integer integer : lista) {
			System.out.println(integer);
		}

//		Java 4
		for (Iterator<Integer> iterator = lista.iterator(); iterator.hasNext();) {
			Integer integer = iterator.next();
			System.out.println(integer);
		}

	}

}
