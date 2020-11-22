package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Dao 
public interface implDao {
	static EntityManager getDB() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Database");
		EntityManager em = emf.createEntityManager();
		return em;
	}
	
	//新增
	void add(Object o);
	
	//查詢
	Object get(int id);
	
	//修改
	void update(Object o);
	
	//刪除
	void delete(int id);
}
