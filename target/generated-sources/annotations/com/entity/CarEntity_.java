package com.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CarEntity.class)
public abstract class CarEntity_ {

	public static volatile ListAttribute<CarEntity, DefectionEntity> defection;
	public static volatile SingularAttribute<CarEntity, String> model;
	public static volatile SingularAttribute<CarEntity, Long> id;
	public static volatile SingularAttribute<CarEntity, String> brand;
	public static volatile SingularAttribute<CarEntity, UserEntity> user;
	public static volatile SingularAttribute<CarEntity, Long> manufactureYear;

}

