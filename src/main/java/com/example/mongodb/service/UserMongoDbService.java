package com.example.mongodb.service;

import com.example.mongodb.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: UserMongoDbService
 * @Author: xz
 * @CreateDate: 2019/3/4 15:15
 * @Version: 1.0
 */
@Service
public class UserMongoDbService {
    private static final Logger logger = LoggerFactory.getLogger(UserMongoDbService.class);
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存对象
     *
     * @param user
     * @return
     */
    public String saveObj(User user) {
        logger.info("--进入保存对象方法--");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        User u = mongoTemplate.save(user);
        logger.info(u.toString());
        return "添加成功";
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<User> findAll() {
        logger.info("--进入查询所有方法--");
        return mongoTemplate.findAll(User.class);
    }


    /***
     * 根据id查询
     * @param id
     * @return
     */
    public User getUserById(String id) {
        logger.info("--进入根据id查询方法--");
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, User.class);
    }

    /**
     * 根据名称查询
     *
     * @param name
     * @return
     */
    public User getUserByName(String name) {
        logger.info("--进入根据名称查询方法--");
        Query query = new Query(Criteria.where("userName").is(name));
        return mongoTemplate.findOne(query, User.class);
    }

    /**
     * 更新对象
     *
     * @param User
     * @return
     */
    public String updateUser(User User) {
        logger.info("--进入更新对象方法--");
        Query query = new Query(Criteria.where("_id").is(User.getId()));
        Update update = new Update().set("userName", User.getUserName())
                .set("passWord", User.getPassWord())
                .set("email", User.getEmail())
                .set("nickName", User.getNickName())
                .set("age", User.getAge())
                .set("updateTime", new Date());
        //updateFirst 更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, User.class);
        //updateMulti 更新查询返回结果集的全部
        //mongoTemplate.updateMulti(query,update,User.class);
        //upsert 更新对象不存在则去添加
        //mongoTemplate.upsert(query,update,User.class);
        return "success";
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    public String deleteUserById(String id) {
        logger.info("--进入根据id删除方法--");
        //findOne
        User user = getUserById(id);
        if (null == user) {
            return "fail";
        }
        //delete
        mongoTemplate.remove(user);
        return "success";
    }
}
