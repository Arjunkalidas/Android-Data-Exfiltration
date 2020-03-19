package org.iot.mobsecure.attack;

import java.io.*;
import org.apache.commons.codec.binary.Base64;

public class OutputFile {

    private String fileName;
    private String filePath;

    public OutputFile(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public String outputToFile(String fname, String paramName, String paramValue) throws IOException {
        if (fname.equals(""))
        {
            fname = fname + paramName+ " : "+paramValue;
        } else {
            fname = fname + System.lineSeparator() + paramName + " : " +paramValue;
        }
        return fname;
    }

    public void createFile(String data) throws IOException {
        String file_path = "";
        String file_separator = System.getProperty("file.separator");
        file_path = this.filePath +file_separator+this.fileName;
        File file = new File(this.filePath);
        if(!file.exists())
            file.mkdir();
        File newFile = new File(file_path);
        FileOutputStream fostream = new FileOutputStream(newFile);
        byte[] toBytes = data.getBytes();
        fostream.write(toBytes);
        fostream.close();
    }

    public String base64String(String source) throws IOException {
        Base64 base64 = new Base64();
        String base64str = new String(base64.encode(source.getBytes()));
        return base64str;
    }
}
