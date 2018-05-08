package mjack.local;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.imageio.ImageIO;

import mjack.net.PlayerMat;

public class NameGen {
	
	public static void main(String[] args) {
		Properties nameProperties = new Properties();
		Properties artProperties = new Properties();
		
		try {
			ClassLoader loader = PlayerMat.class.getClassLoader();          
			InputStream stream = loader.getResourceAsStream("properties/mat_name.properties");
			nameProperties.load(stream);

			stream = loader.getResourceAsStream("properties/art_info.properties");
			artProperties.load(stream);
			
	
			for (String matName : nameProperties.stringPropertyNames()) {
				System.out.println("Writing " + matName + "...");
				BufferedImage bg = ImageIO.read(new FileInputStream("C:\\Users\\j_mar\\eclipse-workspace\\Scythe960\\src\\main\\webapp\\WEB-INF\\images\\bonus\\Encounter_2_TP.png"));
			    Graphics graphics = bg.getGraphics();

			    Font font = new Font("TimesRoman", Font.BOLD, 11);
				graphics.setFont(font);
				graphics.setColor(Color.black);
				graphics.drawString(matName, 900, 200);
				ImageIO.write(bg,"PNG",new File("C:\\Users\\j_mar\\Desktop\\Scythe\\Images\\Names\\name_"+matName+".png"));
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
