package com.plcdo.padariarecibo.barcode;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;

public class PrintRecipe {
    public static void printImagePrinter(BufferedImage image) throws Exception {
        PrinterJob job = PrinterJob.getPrinterJob();
        PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();

        // Definir tamanho A6
        MediaSizeName mediaSizeName = MediaSize.findMedia(105, 148, MediaSize.MM);
        attributes.add(mediaSizeName);

        if (job.printDialog(attributes)) {
            job.setPrintable((graphics, pageFormat, pageIndex) -> {
                if (pageIndex > 0) return Printable.NO_SUCH_PAGE;

                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                // Ajustar imagem ao tamanho da página
                double scale = Math.min(
                        pageFormat.getImageableWidth() / image.getWidth(),
                        pageFormat.getImageableHeight() / image.getHeight()
                );

                g2d.scale(scale, scale);
                g2d.drawImage(image, 0, 0, null);
                return Printable.PAGE_EXISTS;
            });

            job.print(attributes);
        }
    }
}
