package com.vivian.dao;

import com.vivian.sql.model.HomeBoardDetailModel;
import com.vivian.sql.model.LiveBoardModel;
import com.vivian.sql.model.LivePhotoDetailModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeDaoI {
    List<HomeBoardDetailModel> getHomeView();

    /**
     * 插入一条最新的热门话题
     *
     * @param homeBoardDetailModel
     */
    int insertHome(HomeBoardDetailModel homeBoardDetailModel);

    /**
     * 更新帖子评论数
     *
     * @param homeBoardDetailModel
     * @return
     */
    int updateHomeComment(HomeBoardDetailModel homeBoardDetailModel);

    HomeBoardDetailModel findTopicById(int homePostId);
}
