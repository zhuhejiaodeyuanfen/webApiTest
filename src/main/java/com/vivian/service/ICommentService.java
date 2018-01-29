package com.vivian.service;

import com.vivian.sql.model.CommentModel;
import com.vivian.sql.model.CommentModelOri;
import com.vivian.sql.model.HomeBoardDetailModel;

import java.util.List;

public interface ICommentService {

    List<CommentModelOri> getCommentList(int postId,int currIndex,int pageSize);

    int insertHomeComment(CommentModelOri commentModelOri);
}
