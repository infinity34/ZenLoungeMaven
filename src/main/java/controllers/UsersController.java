package controllers;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import dal.models.User;
import utilitaries.Hibernate;

public class UsersController {
	
	private static UsersController instance;
	public static UsersController instance(){
		if(instance == null){
			instance = new UsersController();
		}
		return instance;
	}
	
	private UsersController(){
		
	}
	
	@SuppressWarnings("rawtypes")
	public List getUsersProfile(){
		Criteria cr = Hibernate.instance().createCriteria(User.class);
		setPublicProfileProjection(cr);
		return Hibernate.instance().select(cr);
	}
	
	public Object getUserProfile(int userId){
		Criteria cr = Hibernate.instance().createCriteria(User.class);
		cr.add(Restrictions.eq("id",new Integer(userId)));
		setPublicProfileProjection(cr);
		return Hibernate.instance().selectOne(cr);
	}
	
	private void setPublicProfileProjection(Criteria cr){
		cr.setProjection(Projections.projectionList()
			      .add(Projections.property("id"), "id")
			      .add(Projections.property("firstname"), "firstname")
			      .add(Projections.property("lastname"), "lastname")
			      .add(Projections.property("phonenumber"), "phonenumber")
			      .add(Projections.property("mailadress"), "mailadress")
			      .add(Projections.property("login"), "login"));
	}
	private void setAccessRightsProjection(Criteria cr){
		cr.setProjection(Projections.projectionList()
			      .add(Projections.property("idmember"), "idmember")
			      .add(Projections.property("idspeaker"), "idspeaker")
			      .add(Projections.property("idmanager"), "idmanager")
			      .add(Projections.property("idadministrator"), "idadministrator"));
	}
}