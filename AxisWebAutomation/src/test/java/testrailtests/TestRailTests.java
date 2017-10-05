package testrailtests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testrail.TestRail;
import testrail.TestRailAPI;

@Listeners(listeners.TestListener.class)
public class TestRailTests
{
    @Test (priority = 10)
    public void testAPI() throws Exception
    {
        TestRailAPI api = new TestRailAPI();
        @SuppressWarnings("static-access")
		String testRailCase = api.getCase(595545).toString();
        System.out.println("typing here......." + testRailCase);
    }

    @Test (priority = 20)
    @TestRail(testCaseId = {602617})
    public void passTest()
    {
        Assert.assertTrue(true);
    }

    @Test(enabled = true)
    @TestRail(testCaseId = {595545})
    public void failTest()
    {
        Assert.assertTrue(false);
    }

    @Test(enabled = false)
    @TestRail(testCaseId = {8617, 8618})
    public void failMultipleTests()
    {
        Assert.assertTrue(false);
    }

    @Test (enabled = false)
    public void dontPostToTestRail()
    {
        Assert.assertTrue(true);
    }
}
