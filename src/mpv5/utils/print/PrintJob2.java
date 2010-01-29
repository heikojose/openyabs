/*
 *  This file is part of YaBS.
 *
 *      YaBS is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      (at your option) any later version.
 *
 *      YaBS is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with YaBS.  If not, see <http://www.gnu.org/licenses/>.
 */
package mpv5.utils.print;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPrintPage;
import java.awt.HeadlessException;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.*;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import mpv5.globals.Messages;
import mpv5.logging.Log;

/**
 *
 * @author Torsten Horn, Andreas Weber
 */
public class PrintJob2 {
    /* PrintWithJ2SE14Document.java: Drucken eines Dokuments mit J2SE 1.4 */

    /**
     * Set up a new printjob.
     * @param file
     * @param fileType
     * @throws Exception
     */
    public PrintJob2(File file, String fileType) throws Exception {
        if (fileType.toUpperCase().equals("PDF")) {
            printPdf(file);
        } else {
            print(new FileInputStream(file), fileType);
        }
    }

    /**
     * Send an InputStream to a printer
     * @param resourceAsStream
     * @param fileType
     * @throws Exception
     */
    public static void print(InputStream resourceAsStream, String fileType) throws Exception {

        final String[] ssFileExtensionsAccepted = {"JPEG", "JPG", "PNG", "GIF", "TXT", "HTM", "HTML", "PS"};
        final DocFlavor[] docFlavorsAccepted = {
            DocFlavor.INPUT_STREAM.JPEG,
            DocFlavor.INPUT_STREAM.JPEG,
            DocFlavor.INPUT_STREAM.PNG,
            DocFlavor.INPUT_STREAM.GIF,
            DocFlavor.INPUT_STREAM.TEXT_PLAIN_HOST,
            DocFlavor.INPUT_STREAM.TEXT_HTML_HOST,
            DocFlavor.INPUT_STREAM.TEXT_HTML_HOST,
            DocFlavor.INPUT_STREAM.POSTSCRIPT};
        DocFlavor flavor = null;
        int i, idxPrintService = -1;

        String sInputFilenameExtension = fileType.toUpperCase();
        for (i = 0; i < ssFileExtensionsAccepted.length; i++) {
            if (ssFileExtensionsAccepted[i].equals(sInputFilenameExtension)) {
                flavor = docFlavorsAccepted[i];
                break;
            }
        }

        if (null == flavor) {
            throw new UnsupportedOperationException("Type not printable here: " + fileType);
        }

        // Set print attributes:
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(MediaSizeName.ISO_A4);

        // Print to PrintService (e.g. to Printer):
        PrintService prservDflt = PrintServiceLookup.lookupDefaultPrintService();
        PrintService[] prservices = PrintServiceLookup.lookupPrintServices(flavor, aset);
        if (null == prservices || 0 >= prservices.length) {
            if (null != prservDflt) {
                prservices = new PrintService[]{prservDflt};
            } else {
                mpv5.ui.dialogs.Notificator.raiseNotification(Messages.PRINT_NOT_POSSIBLE + " " + fileType);
            }
        }
        Log.Debug(PrintJob2.class, "Print-Services:");
        for (i = 0; i < prservices.length; i++) {
            Log.Debug(PrintJob2.class, "  " + i + ":  " + prservices[i]
                    + ((prservDflt != prservices[i]) ? "" : " (Default)"));
        }
        PrintService prserv = null;
        if (0 <= idxPrintService && idxPrintService < prservices.length) {
            prserv = prservices[idxPrintService];
        } else {
            if (!Arrays.asList(prservices).contains(prservDflt)) {
                prservDflt = null;
            }
            try {
                prserv = ServiceUI.printDialog(null, 50, 50, prservices, prservDflt, null, aset);
            } catch (Exception exception) {
                Log.Debug(exception);
            }
        }
        if (null != prserv) {
            Log.Debug(PrintJob2.class, "Choosen Print-Service:");
            Log.Debug(PrintJob2.class, "      " + prserv);
            printPrintServiceAttributesAndDocFlavors(prserv);
            DocPrintJob pj = prserv.createPrintJob();
            Doc doc = new SimpleDoc(resourceAsStream, flavor, null);
            pj.print(doc, aset);
            Log.Debug(PrintJob2.class, "Document '" + resourceAsStream + "' printed.");
        }
    }

    private static void printPrintServiceAttributesAndDocFlavors(PrintService prserv) {
        String s1 = null, s2;
        Attribute[] prattr = prserv.getAttributes().toArray();
        DocFlavor[] prdfl = prserv.getSupportedDocFlavors();
        if (null != prattr && 0 < prattr.length) {
            for (int i = 0; i < prattr.length; i++) {
                Log.Debug(PrintJob2.class, "      PrintService-Attribute[" + i + "]: "
                        + prattr[i].getName() + " = " + prattr[i]);
            }
        }
        if (null != prdfl && 0 < prdfl.length) {
            for (int i = 0; i < prdfl.length; i++) {
                s2 = prdfl[i].getMimeType();
                if (null != s2 && !s2.equals(s1)) {
                    Log.Debug(PrintJob2.class, "      PrintService-DocFlavor-Mime[" + i + "]: " + s2);
                }
                s1 = s2;
            }
        }
    }

    private void printPdf(File file) throws Exception {

        // set up the PDF reading
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        FileChannel channel = raf.getChannel();
        ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
        PDFFile pdfFile = new PDFFile(buf); // Create PDF Print Page

        // Create Print Job
        PrinterJob pjob = PrinterJob.getPrinterJob();
        PageFormat pf = PrinterJob.getPrinterJob().defaultPage();

        Paper paper = new Paper();
        paper.setSize(594.936, 841.536);
        paper.setImageableArea(0, 0, 594.936, 841.536);
        pf.setPaper(paper);

        Book book = new Book();
        PDFPrintPage pages = new PDFPrintPage(pdfFile);

        book.append(pages, pf, pdfFile.getNumPages());
        pjob.setPageable(book);

        // Set print attributes:
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(MediaSizeName.ISO_A4);

        try {
            // Send print job to printer
            if (pjob.printDialog(aset)) {
                pjob.print(aset);
                Log.Debug(PrintJob2.class, "Document '" + file + "' printed.");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            raf.close();
        }
    }
}
//
//class PrintUtilities implements Printable {
//
//    private Component componentToBePrinted;
//
//    public static void printComponent(Component c) {
//        new PrintUtilities(c).print();
//    }
//
//    public static void printObject(Graphics2D c) {
//        new PrintUtilities(c).print();
//    }
//
//    public PrintUtilities(Component componentToBePrinted) {
//        this.componentToBePrinted = componentToBePrinted;
//    }
//
//    private PrintUtilities(Graphics2D c) {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
//
//    public void print() {
//        PrinterJob printJob = PrinterJob.getPrinterJob();
//        printJob.setPrintable((Printable) this);
//        if (printJob.printDialog()) {
//            try {
//                printJob.print();
//            } catch (PrinterException pe) {
//                System.out.println("Error printing: " + pe);
//            }
//        }
//    }
//
//    @Override
//    public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
//        if (pageIndex > 0) {
//            return (NO_SUCH_PAGE);
//        } else {
//            Graphics2D g2d = (Graphics2D) g;
//            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
//            disableDoubleBuffering(componentToBePrinted);
//            componentToBePrinted.paint(g2d);
//            enableDoubleBuffering(componentToBePrinted);
//            return (PAGE_EXISTS);
//        }
//    }
//
//    public static void disableDoubleBuffering(Component c) {
//        RepaintManager currentManager = RepaintManager.currentManager(c);
//        currentManager.setDoubleBufferingEnabled(false);
//    }
//
//    public static void enableDoubleBuffering(Component c) {
//        RepaintManager currentManager = RepaintManager.currentManager(c);
//        currentManager.setDoubleBufferingEnabled(true);
//    }
//}
