package org.iot.mobsecure.attack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class FileDecoder {

    private String fileData ;
    private String filePath;
    private String fileName;
    private static final String FOLDER_NAME = "";
    private static final String IMG_FORMAT = ".jpeg";

    public FileDecoder(String fileData,String filePath,String fileName) {
        this.fileData = fileData;
        this.fileName = fileName;
        this.filePath =  filePath ;
    }

    public byte[] decode()
    {
        byte[] decodedImg=null;
        String partSeparator = ",";
        if (this.fileData.contains(partSeparator)) {
        String encodedImg = this.fileData.split(partSeparator)[1];
        decodedImg = Base64.getMimeDecoder().decode(encodedImg.getBytes(StandardCharsets.UTF_8));
        }
        else {
            decodedImg = Base64.getMimeDecoder().decode(this.fileData.getBytes(StandardCharsets.UTF_8));
        }
        return decodedImg;
    }

    public boolean createFile(byte[] filebytes){
        try {
            String outputFilePath = "";
            String file_separator = System.getProperty("file.separator");
            outputFilePath = this.filePath + file_separator + FOLDER_NAME + file_separator + this.fileName+IMG_FORMAT ;
            File file = new File(this.filePath + file_separator + FOLDER_NAME);
            if (!file.exists())
            {
                file.mkdir();
            }

            FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath);
            fileOutputStream.write(filebytes);
            return true;
        }
        catch (IOException e){
            System.out.println("Error Writing to a file");
            e.printStackTrace();
            return false;
        }
    }
}
