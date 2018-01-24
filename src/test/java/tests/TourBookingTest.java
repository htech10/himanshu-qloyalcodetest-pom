package tests;

import org.testng.annotations.Test;

import base.TestInit;
import junit.framework.Assert;
import pages.HomePage;
import pages.InvoicePage;
import pages.SignInPage;
import pages.ToursPackagePage;
import pages.ToursPage;

public class TourBookingTest extends TestInit {
	


@Test
public void searchAndBookTourTest() throws InterruptedException {
	HomePage hp = new HomePage(driver);
	ToursPage tp = hp.goToToursPage();
	ToursPackagePage tpp = tp.getDetailsOfFirstSearchResult();
	SignInPage sip = tpp.clickBookNowWithDefaultEntries();
	InvoicePage ip = sip.signInAsDemoUser();
	String status = ip.getBookingStatusMsg();
//	System.out.println("Status -> "+status);
	Assert.assertTrue(status.contains("YOUR BOOKING STATUS IS RESERVED"));
}


}
