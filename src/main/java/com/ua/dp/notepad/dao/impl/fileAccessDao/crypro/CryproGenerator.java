package com.ua.dp.notepad.dao.impl.fileAccessDao.crypro;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CryproGenerator  {

    private String secretKey = " ";
    private String param = "something1234567";

    private SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");
    private IvParameterSpec ivParams =  new IvParameterSpec(param.getBytes(StandardCharsets.UTF_8));


    public CryproGenerator() {
    }

    public void crypt(File fw, String mode){

        try{

            Path path = Paths.get(fw.getAbsolutePath());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            if (mode.equals("encrypt"))
            cipher.init(Cipher.ENCRYPT_MODE, this.key, this.ivParams);
            else cipher.init(Cipher.DECRYPT_MODE, this.key, this.ivParams);


            byte[] inputBytes = Files.readAllBytes(path);
            FileOutputStream outputStream = new FileOutputStream(fw);
            byte[] outputBytes = cipher.doFinal(inputBytes);
            outputStream.write(outputBytes);


            outputStream.close();

        } catch (Exception e){
            e.printStackTrace();
        }


    }


}
