package com.vivian.service;

import com.vivian.sql.model.HomeBoardDetailModel;

import java.util.List;

public interface IHomeService {

    List<HomeBoardDetailModel> getHomeView();

    int insertHome(HomeBoardDetailModel homeBoardDetailModel);


    int updateHomeComment(HomeBoardDetailModel homeBoardDetailModel);

    HomeBoardDetailModel findTopicById(int homePostId);

}
