package com.vivian.service.impl;

import com.vivian.dao.HomeDaoI;
import com.vivian.service.IHomeService;
import com.vivian.sql.model.HomeBoardDetailModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomeServiceImpl implements IHomeService {

    @Resource
    public HomeDaoI homeDaoI;


    @Override
    public List<HomeBoardDetailModel> getHomeView() {
        return homeDaoI.getHomeView();
    }

    @Override
    public int insertHome(HomeBoardDetailModel homeBoardDetailModel) {
        return homeDaoI.insertHome(homeBoardDetailModel);
    }

    @Override
    public int updateHomeComment(HomeBoardDetailModel homeBoardDetailModel) {
        return homeDaoI.updateHomeComment(homeBoardDetailModel);
    }

    @Override
    public HomeBoardDetailModel findTopicById(int homePostId) {
        return homeDaoI.findTopicById(homePostId);
    }
}
