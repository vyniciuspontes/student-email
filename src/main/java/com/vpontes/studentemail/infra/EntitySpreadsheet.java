package com.vpontes.studentemail.infra;

import java.util.List;

abstract public class EntitySpreadsheet {
	
	protected String filePath;

	public EntitySpreadsheet(String filePath) {
		this.filePath = filePath;
	}
	
	abstract public <X extends Object> List<X> getEntityList();
		
}
