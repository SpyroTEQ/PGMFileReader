//import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Fichier Image PGM
 * @author Xenos
 *
 */
public class PGMFile {
	
	/**
	 * @var filename Nom du fichier PGM
	 */
	public String filename;
	/**
	 * @var width Largeur, en pixels, de l'image
	 */
	public int width;
	/**
	 * @var height Hauteur, en pixels, de l'image
	 */
	public int height;

	/**
	 * @var	pixels Contenu de l'image
	 */
	public int[][] pixels;
	/**
	 * Charge une image PGM 
	 * @param filename Nom du fichier à charger
	 */
	public PGMFile(String filename)
	{
		this.filename = filename;
		this.width = this.height= 0;
		
		FileInputStream fileInputStream;
		try
		{
			fileInputStream = new FileInputStream(this.filename);
			Scanner scan = new Scanner(fileInputStream);

			scan.nextLine();				/* 	P2			*/
			scan.nextLine();				/*	Commentaire	*/

			this.width = scan.nextInt();	/* Width et Height	*/
			this.height = scan.nextInt();
			this.pixels = new int[this.height][this.width];
			
			for (int i=0;i<this.height;i++) {
				for (int j=0;j<this.width;j++) {
					this.pixels[i][j] = scan.nextInt();
				}
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
	}
	
	/**
	 * Renvoie l'image sous forme texte, c'est nul, mais j'ai rien de mieux pour l'afficher
	 * @return L'image sous forme Texte
	 */
	public String toString() {
		String result = this.filename + "\n";
		try {
			for (int i=0;i<this.height;i++) {
				System.out.println(i);
				result += this.pixels[i][0];
				for (int j=1;j<this.width;j++) {
					result += " " + this.pixels[i][j];
				}
				result += "\n";
			}
		}
		catch (Exception exep) {
			exep.getStackTrace();
		}
		return result;
	}
}
