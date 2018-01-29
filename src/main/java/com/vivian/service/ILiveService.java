package com.vivian.service;

import com.vivian.sql.model.LiveBoardModel;
import com.vivian.sql.model.LivePhotoDetailModel;

import java.util.List;

public interface ILiveService {

    //获取所有照片墙列表
    List<LiveBoardModel> getAllLiveBoard();

    List<LivePhotoDetailModel> getAllLiveList(int id);


    //插入用户最新帖子
    int insertLive(LivePhotoDetailModel livePhotoDetailModel);


    int insertLiveBoard(LiveBoardModel liveBoardModel);

    int updateLiveTopicBoard(LiveBoardModel liveBoardModel);

    LiveBoardModel getALiveBoard(int id);


}
