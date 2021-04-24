package com.liu.community.community.service;

import com.liu.community.community.dto.PaginationDTO;
import com.liu.community.community.dto.QuestionDTO;
import com.liu.community.community.mapper.QuestionMapper;
import com.liu.community.community.mapper.UserMapper;
import com.liu.community.community.model.Question;
import com.liu.community.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    public PaginationDTO list(Integer page, Integer size) {
        Integer offSet = size*(page-1);
        List<Question> questions = questionMapper.list(offSet,size);
        ArrayList<QuestionDTO> questionDTOArrayList = new ArrayList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : questions) {
           User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);//把question对象的属性快速copy到questionDTO中
            questionDTO.setUser(user);
            questionDTOArrayList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOArrayList);
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount,page,size);

        return paginationDTO;
    }



}
