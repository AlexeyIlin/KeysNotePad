package com.ua.dp.notepad.dao.impl;

import com.ua.dp.notepad.dao.ContentDAO;
import com.ua.dp.notepad.dao.entity.Content;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContentDAOimpl implements ContentDAO {

    private final List<Content> contents = new ArrayList<Content>();

    public ContentDAOimpl(){

    }

    @Override
    public Long addContent(Content content){
        Long contentId = generateContentId();
        content.setContentId(contentId);
        contents.add(content);
        return contentId;
    }

    @Override
    public void updateContent(Content content){
        Content oldContent = getContent(content.getContentId());
        if (oldContent != null){
            oldContent.setName(content.getName());
            oldContent.setLogin(content.getLogin());
            oldContent.setPassword(content.getPassword());
            oldContent.setText(content.getText());
        }
    }

    @Override
    public void deleteContent(Long contentId){
        for(Iterator<Content> it = contents.iterator(); it.hasNext();){
            Content cnt = it.next();
            if (cnt.getContentId().equals(contentId)){
                it.remove();
            }
        }
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
