package com.vivian.service.impl;

import com.vivian.dao.CommentDaoI;
import com.vivian.service.ICommentService;
import com.vivian.sql.model.CommentModelOri;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentImpl implements ICommentService {
    @Resource
    public CommentDaoI commentDaoI;

    @Override
    public List<CommentModelOri> getCommentList(int postId, int currIndex, int pageSize) {
        return commentDaoI.getCommentList(postId, currIndex, pageSize);
    }

    @Override
    public int insertHomeComment(CommentModelOri commentModelOri) {
        return commentDaoI.insertHomeComment(commentModelOri);
    }
}
