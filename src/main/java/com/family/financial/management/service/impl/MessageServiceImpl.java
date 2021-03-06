package com.family.financial.management.service.impl;

import com.family.financial.management.dao.entity.*;
import com.family.financial.management.dao.mapper.AnswerMapper;
import com.family.financial.management.dao.mapper.GroupRequestMapper;
import com.family.financial.management.dao.mapper.MessageMapper;
import com.family.financial.management.exception.FFMException;
import com.family.financial.management.service.interfaces.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangyiping on 2017/12/17.
 */
@Service
public class MessageServiceImpl implements MessageService{

    @Resource
    private MessageMapper messageMapper;
    @Resource
    private AnswerMapper answerMapper;

    @Override
    public int getMessagePage() throws FFMException {
        long count = messageMapper.countByExample(new MessageExample());
        return (int) (count/20)+1;
    }

    @Override
    public List<Message> getMessages(int pageNum) throws FFMException {
        int page = getMessagePage();
        if (pageNum>page){
            throw new FFMException(112325,"页数超出范围");
        }
        MessageExample example = new MessageExample();
        example.setOrderByClause("id desc");
        example.setLimit(20);
        example.setOffset((pageNum-1)*20);
        List<Message> messages = messageMapper.selectByExample(example);
        return messages;
    }

    @Override
    public void addMessage(Message message) throws FFMException {
        messageMapper.insertSelective(message);
    }

    @Override
    public void deleteMessage(int id) throws FFMException {
        Message message = messageMapper.selectByPrimaryKey((long) id);
        if (null == message){
            throw new FFMException(253123,"无此信息");
        }
        messageMapper.deleteByPrimaryKey(message.getId());
    }

    @Override
    public void answerMessage(String message) throws FFMException {
    }

    @Override
    public List<Answer> getAnswers(Long userId) throws FFMException {
        AnswerExample example = new AnswerExample();
        example.createCriteria().andUserIdBetween(userId,userId);
        List<Answer> answers = answerMapper.selectByExample(example);
        return answers;
    }
}
