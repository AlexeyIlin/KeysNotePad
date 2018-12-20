package com.ua.dp.notepad.dao;

import com.ua.dp.notepad.dao.entity.Content;

import java.util.List;

public interface ContentDAO {

     Long addContent(Content content);
     void updateContent(Content content);
     void deleteContent(Long contentId);
     Content getContent(Long contentId);
     List<Content> findContents();
}
