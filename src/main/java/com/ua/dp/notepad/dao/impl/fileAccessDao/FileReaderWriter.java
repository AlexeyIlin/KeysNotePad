package com.ua.dp.notepad.dao.impl.fileAccessDao;

import com.ua.dp.notepad.dao.entity.Content;
import com.ua.dp.notepad.dao.impl.fileAccessDao.crypro.CryproGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class FileReaderWriter {


    private CryproGenerator cryproGenerator = new CryproGenerator();
    private  File file = new File("my.data");

    void writeData(List<Content> contents){

        cryproGenerator.crypt(file, "decrypt");

        try (FileWriter fw = new FileWriter(file)){


            for (Content content:contents){
                String fullContent;
                fullContent = String.valueOf(content.getContentId()) + "\t"
                        + content.getName() + "\t"
                        + content.getLogin() + "\t"
                        + content.getPassword() + "\t"
                        + content.getText() + "\n";
                fw.write(fullContent);
            }

        }catch (IOException ex){
            ex.printStackTrace(System.out);
        }

        cryproGenerator.crypt(file , "encrypt");

    }


     List<Content> readData(){

        List<Content> contents = new ArrayList<>();

        try {
            file.createNewFile();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

        cryproGenerator.crypt(file, "decrypt");

        try (FileReader fr = new FileReader(file)) {
            BufferedReader reader = new BufferedReader(fr);

            String line;

            while ((line = reader.readLine()) != null) {



                StringTokenizer stk = new StringTokenizer(line,"\t");
                String []ar = new String[stk.countTokens()];
                Content content = new Content();

                for(int i = 0; i<ar.length; i++)
                {
                    ar[i] = stk.nextToken();
                }

                if (ar[0] != null) {
                    content.setContentId(Long.parseLong(ar[0]));
                }

                if (ar[1] != null){

                    content.setName(ar[1]);
                }

                if (ar[2] != null){
                    content.setLogin(ar[2]);
                }

                if (ar[3] != null){
                    content.setPassword(ar[3]);
                }

                if (ar[4] != null){
                    content.setText(ar[4]);
                }

                contents.add(content);

            }
            cryproGenerator.crypt(file , "encrypt");

        } catch (Exception e){
            e.printStackTrace();
        }

        return contents;
    }

}
