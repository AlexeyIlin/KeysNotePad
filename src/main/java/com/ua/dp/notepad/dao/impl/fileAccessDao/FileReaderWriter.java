package com.ua.dp.notepad.dao.impl.fileAccessDao;

import com.ua.dp.notepad.dao.entity.Content;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileReaderWriter {


    private final List<Content> contents = new ArrayList<Content>();

    public void writeData (List<Content> contents){

        try (FileWriter fw = new FileWriter("text.txt")){

            for (Content content:contents){
                fw.write(String.valueOf(content.getContentId()) + "\t");
                fw.write(content.getName() + "\t");
                fw.write(content.getLogin()+ "\t");
                fw.write(content.getPassword() + "\t");
                fw.write(content.getText()+ "\n");
            }

        }catch (IOException ex){
            ex.printStackTrace(System.out);
        }


    }


    public List<Content> readData(){

        try (FileReader fr = new FileReader("text.txt")) {
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

                if (ar[0] != null)
                content.setContentId(Long.parseLong(ar[0]));
                if (ar[1] != null)
                content.setName(ar[1]);
                if (ar[2] != null)
                content.setLogin(ar[2]);
                if (ar[3] != null)
                content.setPassword(ar[3]);
                if (ar[4] != null)
                content.setText(ar[4]);
                contents.add(content);


            }

        }catch (IOException ex){
            ex.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        return contents;
    }

}
