package com.vivian.dao;

import com.vivian.sql.model.LiveBoardModel;
import com.vivian.sql.model.LivePhotoDetailModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LiveDaoI {
    //获取所有照片墙列表
    List<LiveBoardModel> getAllLiveBoard();

    //获取所有照片墙当前列表
    List<LivePhotoDetailModel> getAllLiveList(int id);

    //插入用户最新帖子
    int insertLive(LivePhotoDetailModel livePhotoDetailModel);

    //插入最新话题
    int insertLiveBoard(LiveBoardModel liveBoardModel);

    //更新最新话题相关信息
    int updateLiveTopicBoard(LiveBoardModel liveBoardModel);

    //根据liveId获取相关的live
    LiveBoardModel getALiveBoard(int id);
}
