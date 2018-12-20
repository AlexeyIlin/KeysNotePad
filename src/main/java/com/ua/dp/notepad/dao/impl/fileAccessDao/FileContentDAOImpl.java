package com.ua.dp.notepad.dao.impl.fileAccessDao;

import com.ua.dp.notepad.dao.ContentDAO;
import com.ua.dp.notepad.dao.entity.Content;

import java.util.ArrayList;
import java.util.List;

public class FileContentDAOImpl  implements ContentDAO{


    private final List<Content> contents = new ArrayList<Content>();

    @Override
    public Long addContent(Content content){
        Long contentId = generateContentId();



        return contentId;
    }

    @Override
    public void updateContent(Content content){

    }

    @Override
    public void deleteContent(Long contentId){

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
