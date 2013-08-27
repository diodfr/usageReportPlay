package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class WakeUpModule extends Model {
	private static final long serialVersionUID = -5092186459321067868L;
	
	public static Finder<String,WakeUpModule> find = new Finder<String,WakeUpModule>(
			String.class, WakeUpModule.class
			);
	
	@Id
	public String STARTED_CLASS_NAME;

	public String moduleName;

	public String getSTARTED_CLASS_NAME() {
		return STARTED_CLASS_NAME;
	}

	public void setSTARTED_CLASS_NAME(String sTARTED_CLASS_NAME) {
		STARTED_CLASS_NAME = sTARTED_CLASS_NAME;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
}
