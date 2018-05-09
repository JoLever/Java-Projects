import java.awt.Point;
import java.io.*;
import java.util.*;
/**
 * This class contains all of the methods for the levle class
 * @author Jordan
 *
 */
public class Level {
	/**
	 * The character array for level
	 */
	private char[][] level;
	/**
	 * This methods sets the array to a 4x4
	 */
	public Level() {
		level = new char[4][4];
	}
	/**
	 * This method reads in from the file
	 * @param numLevel the number to read in from
	 * @throws FileNotFoundException
	 */
	public void generateLevel(int numLevel)  {
		int y;
		
		try {
			Scanner read = new Scanner(new File("Level" + numLevel + ".txt"));
			y =0;
			do{
				String line = read.nextLine();
				String [] chars = line.split(" ");
				for(int i =0; i < chars.length;i++){
					level[y][i]= chars[i].charAt(0);
				}
				y++;
			}while(read.hasNextLine());

		} catch (FileNotFoundException e) {
			System.out.println("FNF");
		}
	}
	/**
	 * This method returns the character at a certain point p
	 * @param p the location of the room
	 * @return the char at that room
	 */
	public char getRoom(Point p) {
		int x = (int) p.getX();
		int y = (int) p.getY();
		if ((p.getX() >= 0 && p.getX() < 4)
				&& ((p.getY() >= 0 && p.getY() < 4))) {
			return level[x][y];
		} else {
			return 'z';
		}
	}
	/**
	 * This method prints out the updated map
	 * @param p the point to move to
	 */
	public void displayMap(Point p){
		int z = (int) p.getX();
		int v = (int) p.getY();
		  for(int i = 0; i<4; i++){
		   for(int j = 0; j<4;j++){
		    if(z == i && v == j){
		     System.out.print("!");
		    }
		    else{
		     System.out.print(level[i][j]);
		    }
		   }
		  System.out.println("");
		  }
		 }
	/**
	 * This method finds the start location
	 * @return the point of the start location
	 */
	public Point findStartLocation() {
		Point p = null;
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				if (level[x][y] == 's') {
					p = new Point(x, y);

				}

			}
		}
		return p;
	}
}