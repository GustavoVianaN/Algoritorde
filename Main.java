import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Random random = new Random();

		int escolha;

		int[] lista = {random.nextInt(50), random.nextInt(50),
					random.nextInt(50), random.nextInt(50), 
						random.nextInt(50), random.nextInt(50)};

		while (true)
		{
			System.out.println("Quick Sort :      1");
			System.out.println("Bubble Sort :     2");
			System.out.println("Insertion Sort: : 3");
			Scanner input = new Scanner(System.in);
			escolha = input.nextInt();

			if (escolha == 1)
			{
				System.out.println("Quick Sort: ");
				System.out.println(Arrays.toString(quick(Arrays.copyOf(lista, lista.length))));
				System.out.println("Lista: ");
				System.out.println(Arrays.toString(lista));	

			}
			if (escolha == 2)
			{
				System.out.println("Bubble Sort: ");
				System.out.println(Arrays.toString(bubble(Arrays.copyOf(lista, lista.length))));
				System.out.println("Lista: ");
				System.out.println(Arrays.toString(lista));	

			}
			if (escolha == 3)
			{
				System.out.println("Insertion Sort: ");
				System.out.println(Arrays.toString(insertion(Arrays.copyOf(lista, lista.length))));	
				System.out.println("Lista: ");
				System.out.println(Arrays.toString(lista));	

			}

		}

	}


    public static int[] quick(int[] lista) {
		return quick(lista, 0, lista.length-1);
	}
	
	public static int[] quick(int[] lista , int menor, int maior) {
		if (menor < maior) {
			int elemento = particao(lista, menor, maior);
			lista = quick(lista, menor, elemento-1);
			lista = quick(lista, elemento+1, maior);
		}
		return lista;
	}



	public static int[] bubble(int[] lista) {
		for (int i = 1; i < lista.length; i++) {

			boolean random = true;
			
			for (int j = 0; j < lista.length - i; j++) {
				if (lista[j] > lista[j+1]) {
					swap(lista, j, j+1);
					random = false;
				}
			}
			if (random)
				return lista;
		}
		return lista;
	}

	public static int[] insertion(int[] lista) {
		for (int i = 1; i < lista.length; i++) {
			int elemento = lista[i];
			int j;
			for (j = i-1; j >= 0 && lista[j] > elemento; j--)
			lista[j+1] = lista[j];
			lista[j+1] = elemento;
		}
		return lista;
	}

	public static int particao(int[] lista, int menor, int maior) {
		int elementoelemento = lista[menor];
		int elementoPosition = menor;
		
		for (int i = menor+1; i <= maior; i++) {
			if (lista[i] < elementoelemento) {
				elementoPosition++;
				swap(lista, i, elementoPosition);
			}
		}
		swap(lista, menor, elementoPosition);
		return elementoPosition;
	}
	
	
	public static void swap(int[] lista, int abssissa, int ordenada) {
		int temp = lista[abssissa];
		lista[abssissa] = lista[ordenada];
		lista[ordenada] = temp;
	}

}