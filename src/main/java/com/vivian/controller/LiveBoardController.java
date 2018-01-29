package com.vivian.controller;


import com.vivian.jsonModel.IdEntity;
import com.vivian.service.ILiveService;
import com.vivian.service.IUserService;
import com.vivian.sql.model.LiveBoardModel;
import com.vivian.sql.model.LivePhotoDetailModel;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/live")
@Scope("prototype")
public class LiveBoardController extends BaseController {

    private static Logger logger = Logger.getLogger(LiveBoardController.class.getName());
    @Resource
    ILiveService iLiveService;


    @RequestMapping(value = "/getAllLive", method = RequestMethod.POST)
    public @ResponseBody
    String getAllLive() {
        List<LiveBoardModel> allLiveBoard = iLiveService.getAllLiveBoard();
        if (allLiveBoard != null && allLiveBoard.size() > 0) {
            return onSuccess(allLiveBoard);
        } else {
            return onFailed(100, "查找失败");
        }

    }

    @RequestMapping(value = "/queryLive", method = RequestMethod.POST)
    public @ResponseBody
    String getAllLiveList(@RequestBody IdEntity idEntity) {

        List<LivePhotoDetailModel> allLiveList = iLiveService.getAllLiveList(idEntity.getId());
        System.out.println("getAllLiveList" + "执行的liveId" + idEntity.getId());
        if (allLiveList != null && allLiveList.size() > 0) {
            return onSuccess(allLiveList);
        } else {
            return onFailed(100, "查找失败");
        }
    }


    @RequestMapping(value = "/addLivePost", method = RequestMethod.POST)
    public @ResponseBody
    String addLiveBoard(@RequestBody LivePhotoDetailModel livePhotoDetailModel) {
        int i = iLiveService.insertLive(livePhotoDetailModel);
        if (i > 0) {
            String postParentId = livePhotoDetailModel.getPostParentId();
            LiveBoardModel aLiveBoard = iLiveService.getALiveBoard(Integer.parseInt(postParentId));
            if (aLiveBoard != null) {
                aLiveBoard.setInCount(aLiveBoard.getInCount() + 1);
                int updateNum = iLiveService.updateLiveTopicBoard(aLiveBoard);
                if (updateNum > 0) {
                    return onSuccess("添加成功");
                } else {
                    return onFailed(10008, "添加失败");
                }
            } else {
                return onFailed(10008, "添加失败");
            }

        } else {
            return onFailed(10008, "添加失败");
        }

    }

    @RequestMapping(value = "/addTopicLive", method = RequestMethod.POST)
    public @ResponseBody
    String insertLiveBoard(@RequestBody LiveBoardModel liveBoardModel) {
        int i = iLiveService.insertLiveBoard(liveBoardModel);
        if (i > 0) {
            return onSuccess("添加成功");
        } else {
            return onFailed(10008, "添加失败");
        }
    }


}
