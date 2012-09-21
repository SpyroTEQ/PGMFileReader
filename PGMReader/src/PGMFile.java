import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
/**
 * Fichier Image PGM
 * @author Xenos
 *
 */
public class PGMFile extends ImageContent {
	
	/**
	 * @var filename Nom du fichier PGM
	 */
	public String filename;

	/**
	 * Réinitialise un PGM
	 */
	private void reset() {
		this.filename = "default.pgm";
		this.setsize(0, 0);
	}

	/**
	 * Crée un PGM vide
	 */
	public PGMFile() {
		super(0,0);
		this.reset();
	}
	/**
	 * Charge une image PGM 
	 * @param filename Nom du fichier à charger
	 */
	public PGMFile(String filename)
	{
		super(0,0);
		this.reset();
		this.filename = filename;
		this.load();
	}
	
	/**
	 * @alias loadfromfilename(String filename)
	 * @param filename Nom du fichier à charger
	 */
	public void read(String filename) {
		this.loadfromfilename(filename);
	}
	/**
	 * Charge le contenu du PGM depuis un fichier
	 * @param filename Nom du fichier source
	 */
	public void loadfromfilename(String filename) {
		this.setfilename(filename);
		this.load();
	}
	
	/**
	 * Définit le nom de fichier à utiliser
	 * @param	filename	Nom du fichier
	 */
	public void setfilename(String filename) {
		this.filename = filename;
	}
	
	/**
	 * Charge le fichier PGM
	 */
	public void load() {
		FileInputStream fileInputStream;
		try
		{
			fileInputStream = new FileInputStream(this.filename);
			Scanner scan = new Scanner(fileInputStream);

			String line;
			line = scan.nextLine();
			if (!line.equals((String)"P2"))
				throw new Exception("'"+line+"'");
			line = scan.nextLine();				/*	Commentaire	*/
			if (line.charAt(0) != '#')
				throw new Exception("'"+line+"'");

			int x = scan.nextInt(), y = scan.nextInt();
			this.setsize(x, y);
			
			for (int i=0;i<this.getpixelsnum();i++) {
					this.setpixel(i, scan.nextInt());
			}
			fileInputStream.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found:");
			e.printStackTrace();
		}
		catch (IOException e)
		{
			System.out.println("IOStream exception:");
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sauvegarde le fichier
	 */
	public void save() {
		PrintWriter outstream;
	    try
		{
		    outstream =  new PrintWriter(
		    				new BufferedWriter(
		    						new FileWriter(
		    								this.filename)));
		    outstream.println("P2");
		    outstream.println("#Saved file");
		    for (int i=0;i<this.getsize();i++)
		    	outstream.println(i);
			outstream.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Renvoie l'image sous forme texte, c'est nul, mais j'ai rien de mieux pour l'afficher
	 * @return L'image sous forme Texte
	 */
	public String toString() {
		String result = this.filename + "\n";
		try {
			for (int i=0;i<this.getsize();i++) {
				result += " " + this.getpixel(i);
			}
		}
		catch (Exception exep) {
			exep.getStackTrace();
		}
		return result;
	}
}
