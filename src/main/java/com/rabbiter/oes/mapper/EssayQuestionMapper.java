package com.rabbiter.oes.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rabbiter.oes.entity.EssayQuestion;
import org.apache.ibatis.annotations.*;

import java.util.List;

//填空题
@Mapper
public interface EssayQuestionMapper {

    @Select("select * from essay_question where questionId in (select questionId from paper_manage where questionType = 2 and paperId = #{paperId})")
    List<EssayQuestion> findByIdAndType(Integer paperId);

    @Select("select * from essay_question")
    IPage<EssayQuestion> findAll(Page page);

    /**
     * 查询最后一条questionId
     * @return EssayQuestion
     */
    @Select("select questionId from essay_question order by questionId desc limit 1")
    EssayQuestion findOnlyQuestionId();

    @Options(useGeneratedKeys = true,keyProperty ="questionId" )
    @Insert("insert into essay_question(subject,question,answer,analysis,level,section) values " +
            "(#{subject},#{question},#{answer},#{analysis},#{level},#{section})")
    int add(EssayQuestion essayQuestion);

    @Select("select questionId from essay_question where subject = #{subject} order by rand() desc limit #{pageNo}")
    List<Integer> findBySubject(@Param("subject") String subject, @Param("pageNo") Integer pageNo);

    @Options(useGeneratedKeys = true,keyProperty ="questionId" )
    @Update("update essay_question set section = #{section}, question = #{question}, answer = #{answer}, level = #{level}, analysis = #{analysis} where questionId = #{questionId}")
    int edit(EssayQuestion essayQuestion);
}
