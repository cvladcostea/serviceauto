package com.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserEntity.class)
public abstract class UserEntity_ {

	public static volatile SingularAttribute<UserEntity, String> password;
	public static volatile SingularAttribute<UserEntity, Long> id;
	public static volatile ListAttribute<UserEntity, CarEntity> carList;
	public static volatile SingularAttribute<UserEntity, String> email;
	public static volatile SingularAttribute<UserEntity, Integer> enabled;
	public static volatile SingularAttribute<UserEntity, String> username;

}

