import models.UsageReport;

import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

import static org.fluentlenium.core.filter.FilterConstructor.*;

public class IntegrationTest {

	// /**
	// * add your integration test here
	// * in this example we just check if the welcome page is being shown
	// */
	// @Test
	// public void test() {
	// running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT,
	// new Callback<TestBrowser>() {
	// public void invoke(TestBrowser browser) {
	// browser.goTo("http://localhost:3333");
	// assertThat(browser.pageSource()).contains("Your new application is ready.");
	// }
	// });
	// }

	@Test
	public void findById() {
		running(fakeApplication(inMemoryDatabase()), new Runnable() {
			public void run() {
				assertThat(UsageReport.all()).hasSize(0);

				UsageReport newReport = createReport("0");

				createReport("1");
				createReport("2");
				createReport("3");
				
				assertThat(UsageReport.all()).hasSize(4);
				UsageReport usageReport = UsageReport.all().get(0);
				assertThat(usageReport.getId()).isEqualTo(newReport.getId());
				
				assertThat(usageReport.getCOMMAND()).isEqualTo("0");
			}

			private UsageReport createReport(String param) {
				UsageReport newReport = new UsageReport();

				newReport.setCOMMAND(param);
				newReport.save();
				return newReport;
			}
		});
	}

}
