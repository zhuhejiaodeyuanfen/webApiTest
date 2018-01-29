package com.vivian.dao;

import com.vivian.sql.model.CommentModel;
import com.vivian.sql.model.CommentModelOri;
import com.vivian.sql.model.HomeBoardDetailModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDaoI {

    List<CommentModelOri> getCommentList(int postId,int currIndex,int pageSize);


    int insertHomeComment(CommentModelOri commentModelOri);
}
