package controllers;

import static play.data.Form.form;

import java.util.List;
import java.util.Locale;

import models.UsageReport;

import org.codehaus.jackson.JsonNode;
import org.springframework.context.i18n.LocaleContextHolder;

import com.google.common.base.Objects;

import play.Logger;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

	public static Result receiveReports() {
		Logger.debug("REQUEST");

		LocaleContextHolder.setLocale(new Locale("us")); // pour le parse de la date

		Form<UsageReport> form = form(UsageReport.class).bindFromRequest();
		if(form.hasErrors()) {
			Logger.warn("form contains errors"  + form.errorsAsJson().toString());

			return badRequest();
		} else {

			UsageReport report = form.get();

			report.save();

			Logger.info("UsageReport Added! " + report.getId());
			Logger.trace(report.toString());
			return ok();
		}
	}

	public static Result dynResult() {
		List<UsageReport> reports = UsageReport.tenRows();
		Logger.debug("here");
		List<UsageReport> all = UsageReport.all();
		
		if(all.size() > 0) {
			
			Logger.debug("ICI " + Objects.firstNonNull(all.get(all.size()-1), "NULL USER REPORT").toString());
		}
		JsonNode node = Json.toJson(reports);
		return ok(node);
	}

}
