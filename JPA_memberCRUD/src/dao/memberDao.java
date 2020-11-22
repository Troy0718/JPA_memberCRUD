package dao;

import javax.persistence.EntityManager;

import model.Member;



public class memberDao implements implDao{
public static void main(String [] args) {
	Member m = new Member();
	
	m.setName("尹志平");
	m.setUsername("全真大弟子");
	m.setPassword("papap");
	m.setPhone("666");
	m.setAddress("終南山");
	new memberDao().add(m);
	
	//查詢
//	memberDao md = new  memberDao();
//	Member m1 =  new Member();
//	m1.setName("楊過");
//	m1.setUsername("神雕俠");
//	m1.setPassword("666");
//	m1.setPhone("666");
//	m1.setAddress("古墓");	
//	m1 = md.get(1);
//	System.out.println(m1.getName());
	
	//修改
//	Member m1 =  new Member();
//	m1.setId(1);
//	m1.setName("楊過");
//	m1.setUsername("神雕俠");
//	m1.setPassword("666");
//	m1.setPhone("777");
//	m1.setAddress("古墓");	
//	new  memberDao().update(m1);
	
	//刪除
//	new  memberDao().delete(1);
	
}
	
	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		EntityManager em = implDao.getDB();//取得資料庫連線
		em.getTransaction().begin(); //開啟交易模式
		em.persist(o); //傳入該筆資料
		em.getTransaction().commit(); //變更資料庫(新增)
		
		
	}

	@Override
	public Member get(int id) {
		// TODO Auto-generated method stub
		EntityManager em = implDao.getDB();
		Member m = em.find(Member.class , id); 
		//從Member資料表中透過id 找到該筆資料 包成Member物件 回傳給 m		
		return m;
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		EntityManager em = implDao.getDB();
		Member m = (Member)o; //傳入想要變更的該筆
		Member m1 = em.find(Member.class, m.getId()); 
		//m1 透過 entityManager從資料庫中查詢該筆物件 
				
		//如果該欄位有值 就改變m1中的欄位資料
		if(m.getName()!=null) m1.setName(m.getName());
		if(m.getUsername()!=null)m1.setUsername(m.getUsername());
		if(m.getPassword()!=null)m1.setPassword(m.getPassword());
		if(m.getPhone()!=null)m1.setPhone(m.getPhone());
		if(m.getAddress()!=null)m1.setAddress(m.getAddress());
		
		em.getTransaction().begin();
		em.merge(m1);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		EntityManager em = implDao.getDB();
		Member m = em.find(Member.class, id);
		em.getTransaction().begin(); 
		em.remove(m); //刪除
		em.getTransaction().commit(); //變更資料庫(刪除)
	}
	
	
	
	
}
