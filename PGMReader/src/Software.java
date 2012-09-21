/**
 * Classe principale du programme
 * 
 * @author Xenos
 *
 */
public class Software {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String filename = "lena512x512.pgm";
		PGMFile file = new PGMFile(filename);
		System.out.println(file.toString());
	}
}
