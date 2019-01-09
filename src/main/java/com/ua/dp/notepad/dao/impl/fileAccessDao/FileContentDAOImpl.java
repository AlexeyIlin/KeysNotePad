package com.ua.dp.notepad.dao.impl.fileAccessDao;

import com.ua.dp.notepad.dao.ContentDAO;
import com.ua.dp.notepad.dao.entity.Content;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileContentDAOImpl  implements ContentDAO{

    private List<Content> contents = new ArrayList<Content>();
    private FileReaderWriter frw = new FileReaderWriter();

    @Override
    public Long addContent(Content content){
        Long contentId = generateContentId();
        content.setContentId(contentId);
        contents.add(content);
        frw.writeData(contents);
        return contentId;
    }

    @Override
    public void updateContent(Content content){

        Content oldContent = getContent(content.getContentId());
            if (oldContent.getContentId().equals(content.getContentId())){
                oldContent.setName(content.getName());
                oldContent.setLogin(content.getLogin());
                oldContent.setPassword(content.getPassword());
                oldContent.setText(content.getText());
            }
            frw.writeData(contents);
    }

    @Override
    public void deleteContent(Long contentId){
        for(Iterator<Content> it = contents.iterator(); it.hasNext();){
            Content cnt = it.next();
            if (cnt.getContentId().equals(contentId)){
                it.remove();
            }
        }
        frw.writeData(contents);
    }

    @Override
    public Content getContent(Long contentId){
        for (Content content: contents) {
            if(content.getContentId().equals(contentId)){
                return content;
            }
        }
        return null;
    }


    @Override
    public List<Content> findContents(){
        FileReaderWriter frw = new FileReaderWriter();
        contents = frw.readData();
        return contents;
    }


    private Long generateContentId(){
        Long contactId = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        while(getContent(contactId) != null) {
            contactId = Math.round(Math.random() * 1000 + System.currentTimeMillis());
        }
        return contactId;
    }
}
