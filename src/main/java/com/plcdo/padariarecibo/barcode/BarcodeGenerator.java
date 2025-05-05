package com.plcdo.padariarecibo.barcode;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BarcodeGenerator {

    public BufferedImage generateBarcode(String barcodeText) throws Exception{
        Barcode barcode = BarcodeFactory.createEAN128("1*" + barcodeText);
        barcode.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        return BarcodeImageHandler.getImage(barcode);
    }

    public void saveImage(BufferedImage image) throws IOException {
        File file = new File("image.jpg");
        ImageIO.write(image, "jpg", file);
    }


    public BufferedImage saveImageWithTextForA6(BufferedImage barcodeImage, String productName, int quantity, String thankYouMessage) throws IOException {
        int a6Width = 1240; // A6 width in pixels at 300 DPI
        int a6Height = 1748; // A6 height in pixels at 300 DPI

        BufferedImage a6Image = new BufferedImage(a6Width, a6Height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = a6Image.createGraphics();

        // Fill background with white
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, a6Width, a6Height);

        // Add "Thank You" message at the top
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 59)); // Larger font size
        FontMetrics fm = g2d.getFontMetrics();
        int thankYouTextWidth = fm.stringWidth(thankYouMessage);
        int thankYouTextX = (a6Width - thankYouTextWidth) / 2;
        int thankYouTextY = 100; // Position "Thank You" message at the top
        g2d.drawString(thankYouMessage, thankYouTextX, thankYouTextY);

        // Add product name and quantity below the "Thank You" message
        g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50)); // Slightly smaller font size
        String productText = productName + " - Quantidade: " + quantity;
        int productTextWidth = fm.stringWidth(productText);
        int productTextX = (a6Width - productTextWidth) / 2;
        int productTextY = thankYouTextY + 60; // Position below "Thank You" message
        g2d.drawString(productText, productTextX, productTextY);

        // Scale and center the barcode image
        int barcodeWidth = barcodeImage.getWidth();
        int barcodeHeight = barcodeImage.getHeight();
        int scaledWidth = (int) (a6Width * 0.8); // Scale to 80% of A6 width
        int scaledHeight = (int) ((double) barcodeHeight / barcodeWidth * scaledWidth);
        int x = (a6Width - scaledWidth) / 2;
        int y = productTextY + 50; // Position barcode below product information
        g2d.drawImage(barcodeImage, x, y, scaledWidth, scaledHeight, null);

        g2d.dispose();

        // Save the image
        File file = new File("barcode_a6_with_message_above.jpg");
        ImageIO.write(a6Image, "jpg", file);
        return a6Image;

    }
}
