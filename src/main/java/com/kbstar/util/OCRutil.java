package com.kbstar.util;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Slf4j
public class OCRutil {
    @Value("${uploadimgdir}")
    String imgpath;

    public static Object getResult(String imgpath, String imgname){
        // Return 은 object
        JSONObject obj = null;

        String apiURL = "https://uhucar79op.apigw.ntruss.com/custom/v1/22516/f25bbea0b95de9161368217f2857190a6041ddc29b74f92d9737660c139aa1ac/infer";
        String secretKey = "UFRZSGNTc2JJTkZ5bXZBRkxhYkVQekN6Vk52eFBySXA=";
        String imageFile = imgpath+imgname;

        try {
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setReadTimeout(30000);
            con.setRequestMethod("POST");
            String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            con.setRequestProperty("X-OCR-SECRET", secretKey);

            JSONObject json = new JSONObject();
            json.put("version", "V2");
            json.put("requestId", UUID.randomUUID().toString());
            json.put("timestamp", System.currentTimeMillis());
            JSONObject image = new JSONObject();
            image.put("format", "jpg");
            image.put("name", "demo");
            JSONArray images = new JSONArray();
            images.add(image);
            json.put("images", images);
            String postParams = json.toString();

            con.connect();
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            long start = System.currentTimeMillis();
            File file = new File(imageFile);
            writeMultiPart(wr, postParams, file, boundary);
            wr.close();

            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            JSONParser parser = new JSONParser();
            obj = (JSONObject) parser.parse(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }

        return obj;
    }

    private static void writeMultiPart(OutputStream out, String jsonMessage, File file, String boundary)
            throws IOException {

        StringBuilder sb = new StringBuilder();
        sb.append("--").append(boundary).append("\r\n");
        sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
        sb.append(jsonMessage);
        sb.append("\r\n");

        out.write(sb.toString().getBytes("UTF-8"));
        out.flush();

            if (file != null && file.isFile()) {
                out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
                StringBuilder fileString = new StringBuilder();
                fileString
                        .append("Content-Disposition:form-data; name=\"file\"; filename=");
                fileString.append("\"" + file.getName() + "\"\r\n");
                fileString.append("Content-Type: application/octet-stream\r\n\r\n");
                out.write(fileString.toString().getBytes("UTF-8"));
                out.flush();

                try (FileInputStream fis = new FileInputStream(file)) {
                    byte[] buffer = new byte[8192];
                    int count;
                    while ((count = fis.read(buffer)) != -1) {
                        out.write(buffer, 0, count);
                    }
                    out.write("\r\n".getBytes());
                }

                out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
            }

        out.flush();
    }

    public static Map getData(JSONObject obj){

            Map<String, String> map = new HashMap<>();
            JSONArray images =(JSONArray) obj.get("images");
            JSONObject jo1 = (JSONObject) images.get(0);
            JSONArray fields = (JSONArray) jo1.get("fields");

            JSONObject biznum_obj = (JSONObject)fields.get(0);
            String biznum = (String)biznum_obj.get("inferText");

            JSONObject bizname_obj = (JSONObject)fields.get(1);
            String bizname = (String)bizname_obj.get("inferText");

            JSONObject bizowner_obj = (JSONObject)fields.get(2);
            String bizowner = (String)bizowner_obj.get("inferText");

            JSONObject bizdate_obj = (JSONObject)fields.get(3);
            String bizdate = (String)bizdate_obj.get("inferText");

            JSONObject bizadd_obj = (JSONObject)fields.get(4);
            String bizadd = (String)bizadd_obj.get("inferText");

            map.put("biznum",biznum);
            map.put("bizname",bizname);
            map.put("bizowner",bizowner);
            map.put("bizdate",bizdate);
            map.put("bizadd",bizadd);

            return map;
        }

    public static Map getData2(JSONObject obj){

        Map<String, String> map = new HashMap<>();

        JSONArray images =(JSONArray) obj.get("images");
        JSONObject jo1 = (JSONObject) images.get(0);
        JSONArray fields = (JSONArray) jo1.get("fields");

        JSONObject country_obj = (JSONObject)fields.get(0);
        String country = (String)country_obj.get("inferText");

        JSONObject num_obj = (JSONObject)fields.get(1);
        String num = (String)num_obj.get("inferText");

        JSONObject surname_obj = (JSONObject)fields.get(2);
        String surname = (String)surname_obj.get("inferText");

        JSONObject givenname_obj = (JSONObject)fields.get(3);
        String givenname = (String)givenname_obj.get("inferText");

        JSONObject korname_obj = (JSONObject)fields.get(4);
        String korname = (String)korname_obj.get("inferText");

        JSONObject birth_obj = (JSONObject)fields.get(5);
        String birth = (String)birth_obj.get("inferText");

        JSONObject start_obj = (JSONObject)fields.get(6);
        String start = (String)start_obj.get("inferText");

        JSONObject end_obj = (JSONObject)fields.get(7);
        String end = (String)end_obj.get("inferText");

        JSONObject gender_obj = (JSONObject)fields.get(8);
        String gender = (String)gender_obj.get("inferText");

        map.put("country",country);
        map.put("num",num);
        map.put("surname",surname);
        map.put("givenname",givenname);
        map.put("korname",korname);
        map.put("birth",birth);
        map.put("start",start);
        map.put("end",end);
        map.put("gender",gender);

        return map;
    }
}
