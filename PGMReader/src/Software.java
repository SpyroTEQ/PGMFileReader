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
		try {
			String filename = "lena512x512.pgm";
			PGMFile file = new PGMFile(filename);
			file.setfilename("outfile.pgm");
			file.save();
		}
		catch (Exception exep) {
			exep.printStackTrace();
		}
	}
}
