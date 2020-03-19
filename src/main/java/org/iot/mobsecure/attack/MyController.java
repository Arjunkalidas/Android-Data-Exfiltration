package org.iot.mobsecure.attack;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.util.*;

@RestController
public class MyController {

    private static final String template = "%s";
    private final AtomicLong counter = new AtomicLong();
    private static String decoded_file = "Decoded_File";
    String file_separator = File.separator;
    String output_dir = System.getProperty("user.home")+file_separator+"/Desktop/";
    String final_path = output_dir + file_separator;
    OutputFile file = new OutputFile("output.txt", final_path);


    @RequestMapping(value="/createOutputFile", method=RequestMethod.POST)
    @ResponseBody
    public WebResponse createOutputFile(@RequestParam Map<String, String> params) throws IOException {
        Iterator<Map.Entry<String, String>> iter = params.entrySet().iterator();
        String out_data = "";
        while (iter.hasNext()) {
            Map.Entry entrySet = (Map.Entry)iter.next();
            out_data = file.outputToFile(out_data, entrySet.getKey().toString(), entrySet.getValue().toString());
        }
        file.createFile(out_data);

        String base64EncodedData = file.base64String(out_data);

        return new WebResponse(counter.incrementAndGet(), base64EncodedData, "Success", params);
    }



    @RequestMapping(value = "/decodeFile", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse decodeFile(@RequestParam String str) throws IOException {
        FileDecoder decodeFile = new FileDecoder(str, final_path , decoded_file);
        byte [] filebyes = decodeFile.decode();
        if (decodeFile.createFile(filebyes)){
            return new WebResponse(counter.incrementAndGet(), "Success");
        }
        else
        {
            return new WebResponse(counter.incrementAndGet(), "Failure");
        }
    }
}
