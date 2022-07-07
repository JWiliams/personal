import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import javax.imageio.ImageIO;


public class ImageProcessing {
	public static void main(String[] args) {
    // The provided images are apple.jpg, flower.jpg, and kitten.jpg
		int[][] imageData = imgToTwoD("./media/apple.jpg");
    // Or load your own image using a URL! 
		//int[][] imageData = imgToTwoD("https://content.codecademy.com/projects/project_thumbnails/phaser/bug-dodger.png");
		viewImageData(imageData);
		int[][] trimmed = trimBorders(imageData, 60);
		//twoDToImage(trimmed, "./media/trimmed_apple.jpg");
		// int[][] allFilters = stretchHorizontally(shrinkVertically(colorFilter(negativeColor(trimBorders(invertImage(imageData), 50)), 200, 20, 40)));
		// Painting with pixels

		int[][] display = new int[500][500];
		/*  Methods paintRandomImage(int[][] canvas) - creates random colorful dots
					paintRectangle(canvas, width, height, rowPosition, colPosition, color) - paints a 
				    rectangle somewhere in the display*/
		twoDToImage(paintRectangle(display, 300, 200, 100, 200, getColorIntValFromRGBA(getRandomColor())), "./media/masterpieceRect.jpg");
		twoDToImage(generateRectangles(display, 1000), "./media/1000-rectangles.jpg");




		//negative
		int[][] neg2d = negativeColor(imageData);
		//twoDToImage(neg2d, "./media/neg_apple.jpg");

		//stretched
		int[][] strchdImage = stretchHorizontally(imageData);
		//twoDToImage(strchdImage, "./media/streched_apple.jpg");

		//shrink vertically
		int[][] shrinkVerImage = shrinkVertically(imageData);
		//twoDToImage(shrinkVerImage, "./media/shrinkVert_apple.jpg");

		//invert Image
		int[][] flippedImage = invertImage(imageData);
		//twoDToImage(flippedImage, "./media/flipped_apple.jpg");

		//color filter image
		int [][] coloredImage = colorFilter(imageData, 141, 189, 193);
		//twoDToImage(coloredImage, "./media/brown_apple.jpg");
	}
	// User methods	
	public int[] add(int[] arr, int val){
		int[] nArr = new int[arr.length];
		for (int i = 0;i<arr.length;i++){
			nArr[i] = arr[i] + val;

		}
		return nArr;

	}
	public static int check(int num){
		if (num <0 || num > 255){

			if (num > 1){
				num = 255;
			}else {
				num = 0;
			}
		}
		return num;
	}

	public static int[] getRandomColor(){
		int[] color = {0,0,0,255};
		Random random = new Random();
		for (int o=0; o<3;o++){
			color[o] = random.nextInt(256);
		}
		return color;

	}
	


	// Image Processing Methods
	public static int[][] trimBorders(int[][] imageTwoD, int pixelCount) {
		// Example Method
		if (imageTwoD.length > pixelCount * 2 && imageTwoD[0].length > pixelCount * 2) {
			int[][] trimmedImg = new int[imageTwoD.length - pixelCount * 2][imageTwoD[0].length - pixelCount * 2];
			for (int i = 0; i < trimmedImg.length; i++) {
				for (int j = 0; j < trimmedImg[i].length; j++) {
					trimmedImg[i][j] = imageTwoD[i + pixelCount][j + pixelCount];
				}
				//System.out.print(trimmedImg.length);

			}
			return trimmedImg;
		} else {
			System.out.println("Cannot trim that many pixels from the given image.");
			return imageTwoD;
		}
	}
	public static int[][] negativeColor(int[][] imageTwoD) {
		/*Negative effects happen when a pixel RGB value is subtracted
		from 255*/
	

		int[][] newArray = new int[imageTwoD.length][imageTwoD[0].length];
		
		 for (int o = 0; o<newArray.length; o++){

			for (int i=0; i<newArray[o].length; i++){

				//newArray[o][i] = imageTwoD[o][i];
				int[] rgba = getRGBAFromPixel(imageTwoD[o][i]);
				rgba[0] = 255 - rgba[0];
				rgba[1] = 255 - rgba[1];
				rgba[2] = 255 - rgba[2];
				int newValue = getColorIntValFromRGBA(rgba);
				newArray[o][i] = newValue;

			}


		 }

		return newArray;
	}
	public static int[][] stretchHorizontally(int[][] imageTwoD) {
		// TODO: Fill in the code for this method

		int[][] new2d = new int[imageTwoD.length][imageTwoD[0].length*2];

		for(int o=0; o<imageTwoD.length;o++){
			for(int i=0;i<imageTwoD[o].length;i++){
				int stretched = i*2;
				new2d[o][stretched] = imageTwoD[o][i];
				new2d[o][stretched+1] = imageTwoD[o][i]; 
			}
		}

		return new2d;
	}
	public static int[][] shrinkVertically(int[][] imageTwoD) {
		// TODO: Fill in the code for this method

		int[][] newArray = new int[imageTwoD.length/2][imageTwoD[0].length];

		for (int i=0;i<imageTwoD[0].length;i++){
			for (int o=0; o<imageTwoD.length;o++){
				if (o==imageTwoD.length-1){
					break;
				}
				o+=1;
				newArray[o/2][i] = imageTwoD[o][i];
				
			}
		}

		return newArray;
	}
	public static int[][] invertImage(int[][] imageTwoD) {
		// TODO: Fill in the code for this method

		int[][] newArray = new int[imageTwoD.length][imageTwoD[0].length];

		for (int o=0;o<imageTwoD.length;o++){
			for(int i=0;i<imageTwoD[0].length;i++){
				newArray[o][i] = imageTwoD[(imageTwoD.length-1)-o][(imageTwoD[0].length-1)-i];
			}
		}

		return newArray;
	}
	public static int[][] colorFilter(int[][] imageTwoD, int redChangeValue, int greenChangeValue, int blueChangeValue) {
		// TODO: Fill in the code for this method

		// New-array is called img
		int[][] img = new int[imageTwoD.length][imageTwoD[0].length];

		//looping thru pixels (row-major order)

		for (int o=0; o<imageTwoD.length;o++){
			for(int i=0;i<imageTwoD[o].length;i++){
				int[] rgba = getRGBAFromPixel(imageTwoD[o][i]);
				for (int k=0; k<3;k++){
					if (rgba[0] > 40 && rgba[1]<205){
					 switch (k) {
						case 0:
						  //red
						  int red = rgba[k] + redChangeValue;
						  rgba[k] = ImageProcessing.check(red);
						  break;
						case 1:
						  //green
						  int green = rgba[k] + greenChangeValue;
						  rgba[k] = ImageProcessing.check(green);
						  break;
						case 2:
						  //blue
						  int blue = rgba[k] + blueChangeValue;
						  rgba[k] = ImageProcessing.check(blue);
						  break;
					 }
					// Color every pixel
					// rgba[0] = redChangeValue;
					// rgba[1] = greenChangeValue;
					// rgba[2] = blueChangeValue;
					}else{
						continue;
					} 
				}
				int colInt = getColorIntValFromRGBA(rgba);
				img[o][i] = colInt;
			}

		}

		return img;
	}
	// Painting Methods
	public static int[][] paintRandomImage(int[][] canvas) {
		// TODO: Fill in the code for this method

		Random rand = new Random();
		// Row-major order
		for (int o=0;o<canvas.length;o++){
			for (int i=0; i<canvas[o].length; i++){
				int[] colorInts = new int[4];
				for (int numOfColors=0; numOfColors<3;numOfColors++){
					int x = rand.nextInt(256);
					colorInts[numOfColors] = x;
				}
				colorInts[3] = 255;
				canvas[o][i] = getColorIntValFromRGBA(colorInts);
			}
		}

		return canvas;
	}
	public static int[][] paintRectangle(int[][] canvas, int width, int height, int rowPosition, int colPosition, int colorNum) {
		// TODO: Fill in the code for this method
		int[] colorInts = {58,58,58,255};

		for (int o=0;o<canvas.length;o++){
			for (int i=0;i<canvas[o].length;i++){
				if (o>=rowPosition && o<=rowPosition+width){
					if (i>=colPosition && i<=colPosition+height){
						canvas[o][i] = colorNum;
					}
				}
			}
		}


		return canvas;
	}
	public static int[][] generateRectangles(int[][] canvas, int numRectangles) {
		// TODO: Fill in the code for this method
		Random randObj = new Random();
		for (int n=0; n<numRectangles; n++){
			int width = randObj.nextInt(canvas[0].length);
			int height = randObj.nextInt(canvas.length);
			int rowPos = randObj.nextInt(canvas.length - height);
			int columnPos = randObj.nextInt(canvas[0].length - width);
			int[] color = getRandomColor();
			paintRectangle(canvas, width, height, rowPos, columnPos, getColorIntValFromRGBA(color));
			


		}

		return canvas;
	}


	// Utility Methods
	public static int[][] imgToTwoD(String inputFileOrLink) {
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
			return pixelData;
		} catch (Exception e) {
			System.out.println("Failed to load image: " + e.getLocalizedMessage());
			return null;
		}
	}
	public static void twoDToImage(int[][] imgData, String fileName) {
		try {
			int imgRows = imgData.length;
			int imgCols = imgData[0].length;
			BufferedImage result = new BufferedImage(imgCols, imgRows, BufferedImage.TYPE_INT_RGB);
			for (int i = 0; i < imgRows; i++) {
				for (int j = 0; j < imgCols; j++) {
					result.setRGB(j, i, imgData[i][j]);
				}
			}
			File output = new File(fileName);
			ImageIO.write(result, "jpg", output);
		} catch (Exception e) {
			System.out.println("Failed to save image: " + e.getLocalizedMessage());
		}
	}
	public static int[] getRGBAFromPixel(int pixelColorValue) {
		Color pixelColor = new Color(pixelColorValue);
		return new int[] { pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue(), pixelColor.getAlpha() };
	}
	public static int getColorIntValFromRGBA(int[] colorData) {
		if (colorData.length == 4) {
			Color color = new Color(colorData[0], colorData[1], colorData[2], colorData[3]);
			return color.getRGB();
		} else {
			System.out.println("Incorrect number of elements in RGBA array.");
			return -1;
		}
	}
	public static void viewImageData(int[][] imageTwoD) {
		if (imageTwoD.length > 3 && imageTwoD[0].length > 3) {
			int[][] rawPixels = new int[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					rawPixels[i][j] = imageTwoD[i][j];
				}
			}
			System.out.println("Raw pixel data from the top left corner.");
			System.out.print(Arrays.deepToString(rawPixels).replaceAll("],", "],\n") + "\n");
			int[][][] rgbPixels = new int[3][3][4];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					rgbPixels[i][j] = getRGBAFromPixel(imageTwoD[i][j]);
				}
			}
			System.out.println();
			System.out.println("Extracted RGBA pixel data from top the left corner.");
			for (int[][] row : rgbPixels) {
				System.out.print(Arrays.deepToString(row) + System.lineSeparator());
			}
		} else {
			System.out.println("The image is not large enough to extract 9 pixels from the top left corner");
		}
	}
}