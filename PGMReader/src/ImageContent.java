/**
 * Contenu (pixels) d'une image
 * @author Xenos
 *
 */
public class ImageContent {

	/**
	 * @var pixels Contenu de l'image
	 */
	private int[] pixels;
	
	/**
	 * @var height Hauteur de l'image
	 */
	private int height;
	
	/**
	 * @var width Largeur de l'image
	 */
	private int width;
	
	/**
	 * Crée une image 
	 * @param h hauteur d'image
	 * @param w largeur d'image
	 */
	public ImageContent(int h, int w) {
		this.height = h;
		this.width = w;
	}
	
	/**
	 * Définit la taille de l'image
	 * @param width Largeur
	 * @param height Hauteur
	 */
	public void setsize(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[this.width*this.height];
	}
	
	/**
	 * Renvoie l'index du pixel demandé
	 * @param x Position X
	 * @param y Position y
	 * @return Index du pixel
	 */
	public int getindex(int x, int y) {
		return (this.width*y+x);
	}
	/**
	 * Définit un pixel
	 * @param i Position du pixel
	 * @param v Valeur de ce pixel
	 */
	public void setpixel(int i, int v) {
		this.pixels[i] = v;
	}
	/**
	 * Définit un pixel
	 * @param x position x
	 * @param y position y
	 * @param v Valeur de ce pixel
	 */
	public void setpixel(int x, int y, int v) {
		this.setpixel(this.getindex(x,y), v);
	}
	/**
	 * Récupère un pixel
	 * @param i pixelindex
	 * @return Ce pixel
	 */
	public int getpixel(int i) {
		return (this.pixels[i]);
	}
	/**
	 * Récupère un pixel
	 * @param x position x
	 * @param y position y
	 * @return Valeur de ce pixel
	 */
	public int getpixel(int x, int y) {
		return (this.getpixel(this.getindex(x, y)));
	}
	
	/**
	 * Renvoie le nombre total de pixels
	 * @return Nombre de pixels
	 */
	public int getpixelsnum() {
		return (this.height*this.width);
	}
	
	/**
	 * @alias getpixelsnum()
	 * @return Le nombre total de pixels
	 */
	public int getsize() {
		return (this.getpixelsnum());
	}
	
	/**
	 * Renvoie le tableau complet des pixels
	 * @return L'array de pixels
	 */
	public int[] getpixels() {
		return (this.pixels);
	}
}
