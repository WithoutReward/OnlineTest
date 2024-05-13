package com.rabbiter.oes.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rabbiter.oes.entity.EssayQuestion;
import com.rabbiter.oes.mapper.EssayQuestionMapper;
import com.rabbiter.oes.service.EssayQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EssayQuestionServiceImpl implements EssayQuestionService {

    @Autowired
    private EssayQuestionMapper essayQuestionMapper;

    @Override
    public List<EssayQuestion> findByIdAndType(Integer paperId) {
        return essayQuestionMapper.findByIdAndType(paperId);
    }

    @Override
    public IPage<EssayQuestion> findAll(Page<EssayQuestion> page) {
        return essayQuestionMapper.findAll(page);
    }

    @Override
    public EssayQuestion findOnlyQuestionId() {
        return essayQuestionMapper.findOnlyQuestionId();
    }

    @Override
    public int add(EssayQuestion essayQuestion) {
        return essayQuestionMapper.add(essayQuestion);
    }

    @Override
    public List<Integer> findBySubject(String subject, Integer pageNo) {
        return essayQuestionMapper.findBySubject(subject,pageNo);
    }

    @Override
    public int edit(EssayQuestion essayQuestion) {
        return essayQuestionMapper.edit(essayQuestion);
    }
}
