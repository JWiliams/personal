import java.io.File;
import java.net.URL;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.Arrays;
import java.lang.Object;

public class test {
    
    //Utility Method 

    public static int[][] imgTwoD(String inputFileOrLink){

        try {
			BufferedImage image = null;
			if (inputFileOrLink.substring(0, 4).toLowerCase().equals("http")) {
				URL imageUrl = new URL(inputFileOrLink);
				image = ImageIO.read(imageUrl);
				if (image == null) {
					System.out.println("Failed to get image from provided URL.");
				}
			} else {
				image = ImageIO.read(new File(inputFileOrLink));
			}
			int imgRows = image.getHeight();
			int imgCols = image.getWidth();
			int[][] pixelData = new int[imgRows][imgCols];
			for (int i = 0; i < imgRows; i++) {
				for (int j = 0; j < imgCols; j++) {
					pixelData[i][j] = image.getRGB(j, i);
				}
                
			}
            //System.out.println(MoreObjects.ToStringHelper(pixelData));
			return pixelData;
		} catch (Exception e) {
			System.out.println("Failed to load image: " + e.getLocalizedMessage());
			e.printStackTrace();

			return null;
		}

    }

    public static void main(String[] args) {

        String m = "apple.jpg";
        int[][] mm = imgTwoD("./media/apple.jpg");



        //System.out.println(m.substring(0, 4)+"\n");

        
    }
    
}
