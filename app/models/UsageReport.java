package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class UsageReport extends Model{
	private static final long serialVersionUID = -3913386824095519010L;

	@Id
	private Long id;
	@Required
	@Formats.DateTime(pattern="EEE MMM dd HH:mm:ss Z yyyy") //"dow mon dd hh:mm:ss zzz yyyy"
	private Date CREATION_DATE;
	@Required
	private String STARTED_CLASS_NAME;

	private String DATA_CLASS_NAME;

	private String ALIAS_NAME;
	@Required
	private String OWNER_CLASS_NAME;
	@Required
	private String COMMAND;
	@Required
	private String SOFTWARE_VERSION;
	@Required
	private String SOFTWARE_BUILD;
	@Required
	private String USER_ACCOUNT;
	@Required
	private String PROJECT_NAME;

	private String PROJECT_PATH;

	public WakeUpModule getModule() { 
		String data_CLASS_NAME2 = getDATA_CLASS_NAME();
		
		if (data_CLASS_NAME2 != null) {
			return WakeUpModule.find.byId(data_CLASS_NAME2);
		}
		
		return null;
	}

	public static Finder<Long,UsageReport> find = new Finder<Long,UsageReport>(
			Long.class, UsageReport.class
			);
	
	public static List<UsageReport> all() {
		return find.all();
	}
	
	public static List<UsageReport> tenRows() {
		return find.setMaxRows(10).findList();
	}

	public Date getCREATION_DATE() {
		return CREATION_DATE;
	}

	public void setCREATION_DATE(Date cREATION_DATE) {
		CREATION_DATE = cREATION_DATE;
	}

	public String getSTARTED_CLASS_NAME() {
		return STARTED_CLASS_NAME;
	}

	public void setSTARTED_CLASS_NAME(String sTARTED_CLASS_NAME) {
		STARTED_CLASS_NAME = sTARTED_CLASS_NAME;
	}

	public String getDATA_CLASS_NAME() {
		return DATA_CLASS_NAME;
	}

	public void setDATA_CLASS_NAME(String dATA_CLASS_NAME) {
		DATA_CLASS_NAME = dATA_CLASS_NAME;
	}

	public String getALIAS() {
		return ALIAS_NAME;
	}

	public void setALIAS(String aLIAS) {
		ALIAS_NAME = aLIAS;
	}

	public String getOWNER_CLASS_NAME() {
		return OWNER_CLASS_NAME;
	}

	public void setOWNER_CLASS_NAME(String oWNER_CLASS_NAME) {
		OWNER_CLASS_NAME = oWNER_CLASS_NAME;
	}

	public String getCOMMAND() {
		return COMMAND;
	}

	public void setCOMMAND(String cOMMAND) {
		COMMAND = cOMMAND;
	}

	public String getSOFTWARE_VERSION() {
		return SOFTWARE_VERSION;
	}

	public void setSOFTWARE_VERSION(String sOFTWARE_VERSION) {
		SOFTWARE_VERSION = sOFTWARE_VERSION;
	}

	public String getSOFTWARE_BUILD() {
		return SOFTWARE_BUILD;
	}

	public void setSOFTWARE_BUILD(String sOFTWARE_BUILD) {
		SOFTWARE_BUILD = sOFTWARE_BUILD;
	}

	public String getUSER_ACCOUNT() {
		return USER_ACCOUNT;
	}

	public void setUSER_ACCOUNT(String uSER_ACCOUNT) {
		USER_ACCOUNT = uSER_ACCOUNT;
	}

	public String getPROJECT_NAME() {
		return PROJECT_NAME;
	}

	public void setPROJECT_NAME(String pROJECT_NAME) {
		PROJECT_NAME = pROJECT_NAME;
	}

	public String getPROJECT_PATH() {
		return PROJECT_PATH;
	}

	public void setPROJECT_PATH(String pROJECT_PATH) {
		PROJECT_PATH = pROJECT_PATH;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		ToStringHelper helper = Objects.toStringHelper(this);
		helper.add("ID", getId());
		helper.add("ALIAS", getALIAS());
		helper.add("COMMAND", getCOMMAND());
		helper.add("CREATION_DATE", getCREATION_DATE());
		helper.add("DATA_CLASS_NAME", getDATA_CLASS_NAME());
		helper.add("Module", getModule());
		helper.add("OWNER_CLASS_NAME", getOWNER_CLASS_NAME());
		helper.add("PROJECT_NAME", getPROJECT_NAME());
		helper.add("PROJECT_PATH", getPROJECT_PATH());
		helper.add("SOFTWARE_BUILD", getSOFTWARE_BUILD());
		helper.add("SOFTWARE_VERSION", getSOFTWARE_VERSION());
		helper.add("USER_ACCOUNT", getUSER_ACCOUNT());
		helper.add("STARTED_CLASS_NAME", getSTARTED_CLASS_NAME());

		return helper.toString();
	}
}