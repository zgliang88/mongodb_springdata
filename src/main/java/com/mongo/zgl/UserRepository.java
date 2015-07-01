package com.mongo.zgl;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.DB;

@Repository
public class UserRepository {

	@Autowired
	private MongoTemplate mongoTemplate;
	Logger logger =LoggerFactory.getLogger(UserRepository.class);
	public void test() {
		Set<String> colls = this.mongoTemplate.getCollectionNames();
		for (String coll : colls) {
			System.out.println("CollectionName=" + coll);
		}
		DB db = this.mongoTemplate.getDb();
		logger.debug("db=" + db.toString());
	}

	public void createCollection() {
		if (!this.mongoTemplate.collectionExists(User.class)) {
			this.mongoTemplate.createCollection(User.class);
		}
	}

	public List<User> findList(int skip, int limit) {
		Query query = new Query();
		//query.with(new Sort(new Order(Direction.ASC, "id")));
		query.skip(skip).limit(limit);
		List<User> find = this.mongoTemplate.find(query, User.class);
		logger.debug(String.valueOf(find.size()));
		return find;
	}

	public List<User> findListByName(String name) {
		Query query = new Query();
		query.addCriteria(new Criteria("name").is(name));
		return this.mongoTemplate.find(query, User.class);
	}

	public User findOne(String id) {
		Query query = new Query();
		query.addCriteria(new Criteria("_id").is(id));
		return this.mongoTemplate.findOne(query, User.class);
	}

	public void insert(User entity) {
		this.mongoTemplate.insert(entity);

	}

	public void update(User entity) {
		Query query = new Query();
		query.addCriteria(new Criteria("_id").is(entity.getId()));
		Update update = new Update();
		update.set("birthday", entity.getBirthday());
		update.set("name", entity.getName());
		this.mongoTemplate.updateFirst(query, update, User.class);
	}
	
	public void deleteByName(String name){
		Query query = new Query();
		query.addCriteria(new Criteria("name").is(name));
		this.mongoTemplate.remove(query, User.class);
	}
}