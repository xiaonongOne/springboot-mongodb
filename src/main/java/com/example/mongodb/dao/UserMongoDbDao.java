package com.example.mongodb.dao;

import com.example.mongodb.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @Description:创建UserMongoDbDao类继承MongoDbDao
 *      在service层通过@Autowired注解此类就可以实现增删改查。
 *      好处是不需要重复的编写CURD的方法。
 *      有兴趣的小伙伴可以尝试下
 * @Author: xz
 * @CreateDate: 2019/3/4 20:25
 * @Version: 1.0
 */
@Repository
public class UserMongoDbDao extends MongoDbDao<User>{
    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
