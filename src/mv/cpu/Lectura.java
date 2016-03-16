package mv.cpu;

import java.util.Scanner;

public class Lectura {
	private static Scanner sc = new Scanner(System.in);

	// LEE UN ENTERO
	public static int LeerEntero() {
		
		int entero = sc.nextInt();
		return entero;
	}

	// LEE UNA CADENA
	public static String LeerCadena() {

		String cadena = sc.nextLine().trim();
		return cadena;
	}

	// LEE UN CHARACTER
	public static char LeerChar() {

		char caracter = sc.next().charAt(0);
		return caracter;
	}

	// LEE UN DOUBLE
	public static double LeerDouble() {

		double doble = sc.nextDouble();
		return doble;
	}

	// LEE UN BOOLEAN
	public static boolean LeerBoolean() {

		boolean bool = sc.nextBoolean();
		return bool;
	}

	// LEE UN BYTE
	public static byte LeerByte() {

		byte bit = sc.nextByte();
		return bit;
	}

	// LEE UN LONG
	public static long LeerLong() {

		Long largo = sc.nextLong();
		return largo;
	}

	// LEE UN SHORT
	public static short LeerShort() {

		Short corto = sc.nextShort();
		return corto;
	}

}
