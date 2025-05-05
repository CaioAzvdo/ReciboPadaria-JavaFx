package com.plcdo.padariarecibo.barcode;

import java.awt.image.BufferedImage;

public class RecipeGenerator {
    public static void main(String[] args) throws Exception {
        String barcode = "12";
        String productName = "Pão Francês";
        int quantity = 5;

        generateRecipe(barcode, productName, quantity);
    }
    public static void generateRecipe(String barcode,String productName, int quantity) throws Exception {
        BarcodeGenerator bc = new BarcodeGenerator();
        BufferedImage barcodeImage = bc.generateBarcode(barcode);
        BufferedImage Image = bc.saveImageWithTextForA6(barcodeImage,productName,quantity,"Obrigado Volte Sempre!");
        PrintRecipe.printImagePrinter(Image);

    }
}
