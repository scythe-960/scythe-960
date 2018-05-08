package mjack.net;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

public class PlayerMatImageServlet extends HttpServlet {
	private ServletContext context;
	Properties nameProperties;
	Properties artProperties;

	HashMap<String, BufferedImage> imageCache;
	
	
	
    public void init(ServletConfig config) {
    	context = config.getServletContext();    	
    	nameProperties = new Properties();
    	artProperties = new Properties();
		try {
			ClassLoader loader = PlayerMat.class.getClassLoader();          
			InputStream stream = loader.getResourceAsStream("properties/mat_name.properties");
			nameProperties.load(stream);
			stream = loader.getResourceAsStream("properties/art_info.properties");
			artProperties.load(stream);
			
			
			imageCache = new HashMap<String, BufferedImage>();
			populateCache("bonus", "Bonus_1_TP.png");
			populateCache("bonus", "Bonus_2_TP.png");
			populateCache("bonus", "Bonus_3_TP.png");
			populateCache("bonus", "Bonus_4_TP.png");
			populateCache("bonus", "Bonus_5_TP.png");
			populateCache("bonus", "Bonus_6_TP.png");
			populateCache("bonus", "Bonus_7_TP.png");
			populateCache("bonus", "Coin_1_TP.png");
			populateCache("bonus", "Coin_2_TP.png");
			populateCache("bonus", "Coin_3_TP.png");
			populateCache("bonus", "Coin_4_TP.png");
			populateCache("bonus", "Coin_5_TP.png");
			populateCache("bonus", "Coin_6_TP.png");
			populateCache("bonus", "Coin_7_TP.png");
			populateCache("bonus", "Coin_8_TP.png");
			populateCache("bonus", "Coin_9_TP.png");
			populateCache("bonus", "Heart_1_TP.png");
			populateCache("bonus", "Heart_2_TP.png");
			populateCache("bonus", "Heart_3_TP.png");
			populateCache("bonus", "Heart_4_TP.png");
			populateCache("bonus", "Heart_5_TP.png");
			populateCache("bonus", "Heart_6_TP.png");
			populateCache("bonus", "Heart_7_TP.png");

			/*
			populateCache("bra", "Build_22_TP.png");
			populateCache("bra", "Build_31_TP.png");
			populateCache("bra", "Build_32_TP.png");
			populateCache("bra", "Build_33_TP.png");
			populateCache("bra", "Build_41_TP.png");
			populateCache("bra", "Build_42_TP.png");
			populateCache("bra", "Build_43_TP.png");
			populateCache("bra", "Build_44_TP.png");
			populateCache("bra", "Build_C0_TP.png");
			populateCache("bra", "Build_C1_TP.png");
			populateCache("bra", "Build_C2_TP.png");
			populateCache("bra", "Build_C3_TP.png");
		
			
			populateCache("bra", "Deploy_22_TP.png");
			populateCache("bra", "Deploy_31_TP.png");
			populateCache("bra", "Deploy_32_TP.png");
			populateCache("bra", "Deploy_33_TP.png");
			populateCache("bra", "Deploy_41_TP.png");
			populateCache("bra", "Deploy_42_TP.png");
			populateCache("bra", "Deploy_43_TP.png");
			populateCache("bra", "Deploy_44_TP.png");
			populateCache("bra", "Deploy_C0_TP.png");
			populateCache("bra", "Deploy_C1_TP.png");
			populateCache("bra", "Deploy_C2_TP.png");
			populateCache("bra", "Deploy_C3_TP.png");
			
			populateCache("bra", "Enlist_22_TP.png");
			populateCache("bra", "Enlist_31_TP.png");
			populateCache("bra", "Enlist_32_TP.png");
			populateCache("bra", "Enlist_33_TP.png");
			populateCache("bra", "Enlist_41_TP.png");
			populateCache("bra", "Enlist_42_TP.png");
			populateCache("bra", "Enlist_43_TP.png");
			populateCache("bra", "Enlist_44_TP.png");
			populateCache("bra", "Enlist_C0_TP.png");
			populateCache("bra", "Enlist_C1_TP.png");
			populateCache("bra", "Enlist_C2_TP.png");
			populateCache("bra", "Enlist_C3_TP.png");

			populateCache("bra", "Upgrade_22_TP.png");
			populateCache("bra", "Upgrade_31_TP.png");
			populateCache("bra", "Upgrade_32_TP.png");
			populateCache("bra", "Upgrade_33_TP.png");
			populateCache("bra", "Upgrade_41_TP.png");
			populateCache("bra", "Upgrade_42_TP.png");
			populateCache("bra", "Upgrade_43_TP.png");
			populateCache("bra", "Upgrade_44_TP.png");
			populateCache("bra", "Upgrade_C0_TP.png");
			populateCache("bra", "Upgrade_C1_TP.png");
			populateCache("bra", "Upgrade_C2_TP.png");
			populateCache("bra", "Upgrade_C3_TP.png");
			*/
			
			populateCache("tra", "Bolster_0_TP.png");
			populateCache("tra", "Bolster_1_TP.png");
			populateCache("tra", "Bolster_2_TP.png");
			populateCache("tra", "Bolster_3_TP.png");
			populateCache("tra", "Move_0_TP.png");
			populateCache("tra", "Move_1_TP.png");
			populateCache("tra", "Move_2_TP.png");
			populateCache("tra", "Move_3_TP.png");
			populateCache("tra", "Produce_0_TP.png");
			populateCache("tra", "Produce_1_TP.png");
			populateCache("tra", "Produce_2_TP.png");
			populateCache("tra", "Produce_3_TP.png");
			populateCache("tra", "Trade_0_TP.png");
			populateCache("tra", "Trade_1_TP.png");
			populateCache("tra", "Trade_2_TP.png");
			populateCache("tra", "Trade_3_TP.png");		

		}
		catch (IOException e) {
			e.printStackTrace();
		}
    
    }
 
    /**
     * handles HTTP GET request
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
		PlayerMat mat = null;
		String fileNameWithoutExtn = null;
		boolean valid = true;
    	
    	
    	
    	try {    		
    		String uri = new String(request.getRequestURI());
    		int slashLoc = uri.lastIndexOf('/');

	    	int dotLoc = uri.lastIndexOf('.');
	    	if (dotLoc <= slashLoc || dotLoc == -1 || slashLoc == -1) {
	    		valid = false;
	    	}
	    	
	    	if (valid) {
	    		String fileName = uri.substring( uri.lastIndexOf('/') +1, uri.length() );
	    		String ext = fileName.substring(fileName.lastIndexOf('.')+1, fileName.length() );
	    		fileNameWithoutExtn = fileName.substring(0, fileName.lastIndexOf('.'));
	    		if (!ext.toLowerCase().equals("png")) {
	    			valid = false;
	    		}
	    	}
	    	    	
	    	if (valid) {
	    		mat = createPlayerMat(fileNameWithoutExtn);
	    		valid = mat.validatePlayerMat();
	    	}
	    	
	    	if (valid) {
	    		valid = (nameProperties.get(mat.name) != null);
	    	}
	    	
	    	if (!valid) {
	    		mat = PlayerMat.getRandomMat(nameProperties);
	    	}
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	BufferedImage image = getPlayerMatImage(mat);
     	
    	response.setContentType("image/png");  
    	ImageIO.write(image, "PNG", response.getOutputStream());
    	response.getOutputStream().close();
    }
 
    /**
     * handles HTTP POST request
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    	PlayerMat mat = PlayerMat.getRandomMat(nameProperties);
    	BufferedImage image = getPlayerMatImage(mat);
    	
    	response.setContentType("image/png");  
    	ImageIO.write(image, "PNG", response.getOutputStream());
    	response.getOutputStream().close();
    }
    
    private InputStream getInputStream(String fileName) {
    	System.err.println("Trying to return:::: /WEB-INF/" + fileName);
    	return context.getResourceAsStream("/WEB-INF/" + fileName);    	
    }
   
    private void populateCache(String imageDir, String imageFile) 
    throws IOException {
		String resPath = "images/" + imageDir + "/" + imageFile;
	    BufferedImage bg = ImageIO.read(getInputStream(resPath));
	    imageCache.put(resPath, bg);
    }
    
    private BufferedImage getImage(String path) 
    throws IOException {
    	BufferedImage image = imageCache.get(path);
    	if (image == null) {
    		image = ImageIO.read(getInputStream(path));
    	}
    	return image;
    }
    
    
    public static PlayerMat createPlayerMat(String encodedString) {
    	System.out.println("Encoded: " + encodedString);
    	String configString = new String(DatatypeConverter.parseBase64Binary(encodedString));
    	System.out.println("Decoded: " + configString);
    	PlayerMat mat = new PlayerMat();
    	try {
    		String[] configs = configString.split("\\|");
    		mat.name = configs[0];
    		mat.topRowAction = stringToArray(configs[1]);
    		mat.initialResourceCost = stringToArray(configs[2]);
    		mat.finalResourceCost = stringToArray(configs[3]);
    		mat.coins = stringToArray(configs[4]);
    		mat.matNumber = Integer.parseInt(configs[5]);
    		mat.bonusCoins = Integer.parseInt(configs[6]);
    		mat.bonusPop = Integer.parseInt(configs[7]);
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	return mat;
    }
	
    private static int[] stringToArray(String str) {
    	String[] strArr = str.split(",");
    	int[] rv = new int[strArr.length];
    	for (int i = 0; i < strArr.length; i++) {
    		rv[i] = Integer.parseInt(strArr[i]);
    	}
    	return rv;
    }    
    
    public static String playerMatToSting(PlayerMat mat) {
		String configStr = 
				mat.name + "|" +
				arrayToString(mat.topRowAction) + "|" +
				arrayToString(mat.initialResourceCost) + "|" +
				arrayToString(mat.finalResourceCost) + "|" +
				arrayToString(mat.coins) + "|" +
				mat.matNumber + "|" +
				mat.bonusCoins + "|" +
				mat.bonusPop;
		return configStr;
    }
    	
    public static String arrayToString(int[] arr) {
    	String rv = ""+ arr[0];
    	for (int i = 1; i < arr.length; i++) {
    		rv += "," + arr[i];
    	}
    	return rv;
    }

    
    
	private BufferedImage getPlayerMatImage(PlayerMat mat) 
	throws IOException {
		String artInfo = artProperties.getProperty(nameProperties.getProperty(mat.name));		
		String artFile = (artInfo == null) ? "Nature_Lake.png" : artInfo.split("\\|")[0];

		String resPath = "images/art/" + artFile;
	    BufferedImage bg = ImageIO.read(getInputStream(resPath));
	    Graphics graphics = bg.getGraphics();

	    
    	resPath = "images/bonus/Bonus_" + mat.matNumber +  "_TP.png";
		BufferedImage fg = getImage(resPath);
	    graphics.drawImage(fg,0,0,null,null);

    	resPath = "images/bonus/Coin_" + mat.bonusCoins +  "_TP.png";
    	fg = getImage(resPath);
	    graphics.drawImage(fg,0,0,null,null);

    	resPath = "images/bonus/Heart_" + mat.bonusPop +  "_TP.png";
    	fg = getImage(resPath);
	    graphics.drawImage(fg,0,0,null,null);
	    
    	resPath = "images/name/name_" + mat.name + ".png";
    	fg = ImageIO.read(getInputStream(resPath));
	    graphics.drawImage(fg,0,0,null,null);

	    for (int i = 0; i < 4; i++) {
	    	String tra = PlayerMat.tra(mat.topRowAction[i]);
			resPath = "images/tra/"+ tra + "_" + i + "_TP.png";
			fg = getImage(resPath);
		    graphics.drawImage(fg,0,0,null,null);
		    
		    
		    String bra = PlayerMat.bra(i+1);
	    	resPath = "images/bra/"+ bra + "_" + mat.initialResourceCost[i] + "" +mat.finalResourceCost[i] +  "_TP.png";
	    	fg = getImage(resPath);
		    graphics.drawImage(fg,0,0,null,null);

	    	resPath = "images/bra/"+ bra + "_C" + mat.coins[i] +  "_TP.png";
	    	fg = getImage(resPath);
		    graphics.drawImage(fg,0,0,null,null);			    
		}
	    
	    return bg;
	}
    
    
 }
