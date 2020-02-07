package Config;

import Utils.TestUtil;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestResultLoggerExtension extends TestBase  implements TestWatcher, AfterAllCallback
{
    private List<TestResultStatus> testResultsStatus = new ArrayList<>();
    public static String screenshotPath;
    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception
    {
        Map<TestResultStatus, Long> summary = testResultsStatus.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //LOG.info("Test result summary for {} {}", context.getDisplayName(), summary.toString());
    }
    @Override
    public void testDisabled(ExtensionContext extensionContext, Optional<String> optional)
    {
        //LOG.info("Test Disabled for test {}: with reason :- {}", context.getDisplayName(), reason.orElse("No reason"));
        testResultsStatus.add(TestResultStatus.DISABLED);
    }
    @Override
    public void testSuccessful(ExtensionContext extensionContext)
    {
        testResultsStatus.add(TestResultStatus.SUCCESSFUL);
        try
        {
            //screenshotPath = TestUtil.captureScreenshotBASE64(arg0.getName().toLowerCase().toString());
            System.out.println("Inside testSuccessful block in ResultLogger Base Class...");
            screenshotPath = TestUtil.captureScreenshotBASE64(extensionContext.getDisplayName().toLowerCase().toString());
        } catch (IOException | InterruptedException | AWTException e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void testAborted(ExtensionContext extensionContext, Throwable throwable)
    {
        testResultsStatus.add(TestResultStatus.ABORTED);
    }
    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable)
    {
        testResultsStatus.add(TestResultStatus.FAILED);
        try
        {
             //screenshotPath = TestUtil.captureScreenshotBASE64(arg0.getName().toLowerCase().toString());
            System.out.println("Inside testFailed block in ResultLogger Base Class...");
             screenshotPath = TestUtil.captureScreenshotBASE64(extensionContext.getDisplayName().toLowerCase().toString());
        } catch (IOException | InterruptedException | AWTException e)
        {
            e.printStackTrace();
        }
    }
    private enum TestResultStatus
    {
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }
    //...
}
