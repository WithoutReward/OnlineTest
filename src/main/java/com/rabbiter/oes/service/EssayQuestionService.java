package com.rabbiter.oes.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rabbiter.oes.entity.EssayQuestion;

import java.util.List;

public interface EssayQuestionService {

    List<EssayQuestion> findByIdAndType(Integer paperId);

    IPage<EssayQuestion> findAll(Page<EssayQuestion> page);

    EssayQuestion findOnlyQuestionId();

    int add(EssayQuestion essayQuestion);

    List<Integer> findBySubject(String subject,Integer pageNo);

    int edit(EssayQuestion essayQuestion);
}
