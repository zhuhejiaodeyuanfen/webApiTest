package com.vivian.service.impl;

import com.vivian.dao.LiveDaoI;
import com.vivian.service.ILiveService;
import com.vivian.sql.model.LiveBoardModel;
import com.vivian.sql.model.LivePhotoDetailModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LiveServiceImpl implements ILiveService {

    @Resource
    public LiveDaoI liveDaoI;

    @Override
    public List<LiveBoardModel> getAllLiveBoard() {
        return liveDaoI.getAllLiveBoard();
    }

    @Override
    public List<LivePhotoDetailModel> getAllLiveList(int id) {
        return liveDaoI.getAllLiveList(id);
    }

    @Override
    public int insertLive(LivePhotoDetailModel livePhotoDetailModel) {
        return liveDaoI.insertLive(livePhotoDetailModel);

    }

    @Override
    public int insertLiveBoard(LiveBoardModel liveBoardModel) {
        return liveDaoI.insertLiveBoard(liveBoardModel);
    }

    @Override
    public int updateLiveTopicBoard(LiveBoardModel liveBoardModel) {
        return liveDaoI.updateLiveTopicBoard(liveBoardModel);
    }

    @Override
    public LiveBoardModel getALiveBoard(int id) {
        return liveDaoI.getALiveBoard(id);
    }


}
