package com.example.administrador.pvsegalmex.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.widget.Toast;

import com.example.administrador.pvsegalmex.view.PdfViewer;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import static com.itextpdf.text.BaseColor.BLACK;

public class TemplatePDF {

    private Document document;
    private File pdf;
    private Context context;
    PdfWriter pdfWriter;
    PdfPCell pdfPCell;
    private Paragraph paragraph;
    private Font ftitle = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
    private Font fSubtitle = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD);
    private Font fText = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL, BLACK);
    private Font fSmallText = new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BLACK);
    private Font fHightText = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL);

    public TemplatePDF(Context context) {
        this.context = context;
    }

    public void openDocumente() {
        createFile();
        try {
            document = new Document(PageSize.A7);
            pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(pdf));
            document.open();

        } catch (Exception e) {
            Log.e("openDocument", e.toString());
        }
    }

    private void createFile() {
        File folder = new File(Environment.getExternalStorageDirectory().toString(), "PDF");
        if (!folder.exists())
            folder.mkdirs();
        pdf = new File(folder, "TemplatePDF.pdf");
    }

    public void closeDocumente() {
        document.close();
    }

    public void addMetaData(String title, String subject, String author) {
        document.addTitle(title);
        document.addSubject(subject);
        document.addAuthor(author);
    }

    public void addTicketInformation(String titles, String folio, String date, String user){
        try {
            paragraph = new Paragraph();
            addChildP(new Paragraph(titles, ftitle));
            addChildP(new Paragraph(folio, fHightText));
            addChildP(new Paragraph(date, fHightText));
            addChildP(new Paragraph(user, fHightText));
            document.add(paragraph);
        }catch (Exception e){
            Log.e("addTicketInformation", e.toString());
        }
    }

    public void addTitles(String title, String subtitle) {
        try {
            paragraph = new Paragraph();
            addChildP(new Paragraph(title, ftitle));
            addChildP(new Paragraph(subtitle, fSubtitle));
            paragraph.setSpacingAfter(10);
            document.add(paragraph);
        } catch (Exception e) {
            Log.e("addTitles", e.toString());
        }
    }

    public void addClientInformation(String title, String clientName){
        try {
            paragraph = new Paragraph();
            addChildP(new Paragraph(title, ftitle));
            addChildP(new Paragraph(clientName, fSubtitle));
            document.add(paragraph);
        }catch (Exception e){
            Log.e("addClientInformation", e.toString());
        }
    }

    public void addImage(String d) {
        try {
            document.open();
            File image = new File(d);
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            Bitmap bmp = BitmapFactory.decodeFile(image.getAbsolutePath(), bmOptions);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bmp.getScaledWidth(70);
            Image images = Image.getInstance(stream.toByteArray());
            images.scaleToFit(35, 35);
            images.setAlignment(Element.ALIGN_CENTER);
            images.setBottom(10);
            document.add(images);
            // document.close();
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    private void addChildP(Paragraph childParagraph) {
        childParagraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.add(childParagraph);
    }

    public void addParagraph(String text) {
        try {
            paragraph = new Paragraph(text, fText);
            paragraph.setSpacingAfter(1);
            paragraph.setSpacingBefore(1);
            paragraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(paragraph);
        } catch (Exception e) {
            Log.e("addParagraph", e.toString());
        }
    }

    public void addSmallParagraph(String title, String phone) {
        try {
            paragraph = new Paragraph();
            addChildP(new Paragraph(title, fSmallText));
            addChildP(new Paragraph(phone, fSmallText));
            paragraph.setSpacingAfter(3);
            paragraph.setSpacingBefore(2);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
        } catch (Exception e) {
            Log.e("addSmallParagraph", e.toString());
        }
    }

    public void createTable(String[] header, ArrayList<String[]> purchase) {
        try {
            paragraph = new Paragraph();
            paragraph.setFont(fText);
            PdfPTable pdfPTable = new PdfPTable(header.length);
            pdfPTable.setWidthPercentage(100);

            int indexC = 0;
            while (indexC < header.length) {
                pdfPCell = new PdfPCell(new Phrase(header[indexC++], fSubtitle));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfPCell.setBackgroundColor(BaseColor.WHITE);
                pdfPCell.setBorder(0);
                pdfPTable.addCell(pdfPCell);
            }
            for (int indexRow = 0; indexRow < purchase.size(); indexRow++) {
                String[] row = purchase.get(indexRow);
                for (indexC = 0; indexC < header.length; indexC++) {
                    pdfPCell = new PdfPCell(new Phrase(row[indexC], fText));
                    pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfPCell.setFixedHeight(15);
                    pdfPCell.setBorder(0);
                    pdfPTable.addCell(pdfPCell);
                }
            }
            paragraph.add(pdfPTable);
            document.add(paragraph);
        } catch (Exception e) {
            Log.e("createTable", e.toString());
        }
    }

    public void viewPDF() {
        Intent intent = new Intent(context, PdfViewer.class);
        intent.putExtra("path", pdf.getAbsolutePath());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void appViewPDF(Activity activity) {
        if (pdf.exists()) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Uri uri = FileProvider.getUriForFile(activity.getApplicationContext(), activity.getPackageName() + ".provider", pdf);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(uri);
                    intent.setFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    activity.startActivity(intent);
                } else {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    Uri uri = Uri.fromFile(pdf);
                    intent.setDataAndType(uri, "application/pdf");
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    activity.startActivity(intent);
                }

            } catch (ActivityNotFoundException e) {
                activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.adobe.reader&hl=es_419")));
                Toast.makeText(activity.getApplicationContext(), "No cuentas con una aplicacion para visualizar PDF", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(activity.getApplicationContext(), "No se encontró el archivo", Toast.LENGTH_SHORT).show();
        }
    }
}