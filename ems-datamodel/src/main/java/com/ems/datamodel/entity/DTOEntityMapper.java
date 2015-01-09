package com.ems.datamodel.entity;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

public class DTOEntityMapper {
 
	private static DTOEntityMapper instance;
	private Mapper beanMapper;
	
	private DTOEntityMapper() {
		beanMapper = DozerBeanMapperSingletonWrapper.getInstance();
	}
	
	public static DTOEntityMapper getInstance() {
		if (instance == null) {
			instance = new DTOEntityMapper();
		}
		
		return instance;
	}

	public static Mapper getMapper() {
		return getInstance().beanMapper;
	}
}
