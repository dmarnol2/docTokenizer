package com.document.tokenizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        final String TAG_EXTENSION = ".tag";

        ArrayList<String> documentData = new ArrayList<String>();
        Map<String, String> lexMap = new HashMap<String, String>();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter path of document to tag: ");
        String documentPath = scan.nextLine().trim();

        System.out.println("Enter path to lexicon: ");
        String lexiconPath = scan.nextLine().trim();

        File docToRead = createFile(documentPath);
        File lexiconToRead = createFile(lexiconPath);
        File outputDoc = createFile(changeExtension(documentPath, TAG_EXTENSION));

        Scanner docScanner = buildReader(docToRead);
        Scanner lexScanner = buildReader(lexiconToRead);

        while (docScanner.hasNextLine()) {
            documentData.add(docScanner.nextLine());
        }
        docScanner.close();

        while (lexScanner.hasNextLine()) {
            String[] temp = lexScanner.nextLine().split("\t");
            lexMap.put(temp[0], temp[1]);
        }
        lexScanner.close();

        buildOutputDoc(documentData, lexMap, outputDoc);
    }

    public static void buildOutputDoc(ArrayList<String> documentData, Map lexicon, File outputDoc){
        PrintWriter output = null;
        try{
            output = new PrintWriter(outputDoc.getPath());
            PrintWriter finalOutput = output;
            documentData.forEach(x -> {
                for (String s : x.split("(?=[\\W_])|(?<=[\\W_])")) {
                    String val = (String) lexicon.get(s.toUpperCase());
                    if (val != null) {
                        x = x.replace(s, s.concat("/" + val));
                    }
                }
                finalOutput.println(x);
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(output!=null) {
                output.close();
            }
        }
    }


    public static Scanner buildReader(File document){
        Scanner docReader = null;
        try {
            docReader = new Scanner(document);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return docReader;
    }

    public static String changeExtension(String fileName, String extension) {
        if (fileName.contains(".")) {
            fileName = fileName.substring(0, fileName.lastIndexOf('.'));
        }
        fileName += extension;
        return fileName;
    }

    public static File createFile(String url){
        File newFile = new File(url);
        try {
            if (newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return newFile;
    }
}
