package com.rabbiter.oes.controller;


import com.rabbiter.oes.entity.ApiResult;
import com.rabbiter.oes.entity.EssayQuestion;
import com.rabbiter.oes.service.EssayQuestionService;
import com.rabbiter.oes.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EssayQuestionController {

    @Autowired
    private EssayQuestionService essayQuestionService;

    /**
     * 添加简答题
     * @param essayQuestion
     * @return
     */
    @PostMapping("/essayQuestion")
    public ApiResult add(@RequestBody EssayQuestion essayQuestion){
        if(essayQuestion == null){
            throw new RuntimeException("问答题内容为空");
        }
        int res = essayQuestionService.add(essayQuestion);
        System.out.println("当前添加的问答题id为："+res);

        return ApiResultHandler.buildApiResult(200,"添加成功",null);
    }

    /**
     * 查询简答题最后一项id
     * @return
     */
    @GetMapping("/essayQuestionId")
    public ApiResult findLastQuestionId(){
        EssayQuestion res = essayQuestionService.findOnlyQuestionId();
        return ApiResultHandler.buildApiResult(200,"查询成功",res);
    }

    /**
     * 修改简单题
     * @param essayQuestion
     * @return
     */
    @PostMapping("/editEssayQuestion")
    public ApiResult edit(@RequestBody EssayQuestion essayQuestion){
        int res = essayQuestionService.edit(essayQuestion);
        if(res == 0) throw new RuntimeException("编辑的问答题不存在");
        System.out.println("当前修改的问答题id为："+res);
        return ApiResultHandler.buildApiResult(200,"修改成功",res);
    }

}
