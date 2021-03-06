package com.vaadin.addon.charts.testbenchtests;

import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;

import org.eclipse.jetty.server.Server;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.vaadin.addon.charts.demoandtestapp.TServer;
import com.vaadin.testbench.Parameters;
import com.vaadin.testbench.ScreenshotOnFailureRule;
import com.vaadin.testbench.TestBench;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.commands.TestBenchCommands;

public abstract class AbstractTestBenchTest extends TestBenchTestCase {

    protected static int TESTPORT;
    protected static String BASEURL = getTestUrl();

    private static String getTestUrl() {
        return "http://localhost:" + TESTPORT + "/";
    }

    private static final File REF_IMAGE_ROOT = new File(
            "src/test/resources/screenshots/reference");
    protected WebDriver driver;
    protected TestBenchCommands testBench;
    private Server server;
    protected WebDriver rawDriver;
    protected static final String ERROR_IMAGE_ROOT = "target/testbench/errors/";
    @Rule
    public ScreenshotOnFailureRule screenshotOnFailure = new ScreenshotOnFailureRule(
            this, true);

    public AbstractTestBenchTest() {
        super();
    }

    @Before
    public void setUp() {
        new File(ERROR_IMAGE_ROOT).mkdirs();
        Parameters.setScreenshotErrorDirectory(ERROR_IMAGE_ROOT);
        Parameters.setScreenshotComparisonTolerance(0.01);
        try {
            server = TServer.startServer(null);
            TESTPORT = server.getConnectors()[0].getLocalPort();
            BASEURL = getTestUrl();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() {
        if (server != null) {
            try {
                server.stop();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                // Remote web driver fails with error:
                // Error communicating with the remote browser. It may have
                // died.
                // e.printStackTrace();
            }
        }
    }

    protected void startBrowser() {
        prepareDriver();
        testBench = (TestBenchCommands) driver;
        // dimension includes browser chrome, use TestBench utility to fix
        // actual viewport size -> survive from browser upgrades and varying
        // settings
        driver.get("about:blank");
        testBench.resizeViewPortTo(800, 513);

    }

    protected void prepareDriver() {
        String hubhost = System.getProperty("tb.hub");
        if (hubhost == null || hubhost.isEmpty())
            hubhost = "tb3-hub.intra.itmill.com";

        try {
            String ip = System.getProperty("host.ip");
            if (ip == null || ip.isEmpty()) {
                ip = findAutoHostname();
            }
            BASEURL = "http://" + ip + ":" + TESTPORT + "/";
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setPlatform(Platform.WINDOWS);
            cap.setVersion("33");
            URL remoteAddress = new URL("http://" + hubhost + ":4444/wd/hub");
            rawDriver = new RemoteWebDriver(remoteAddress, cap);
            driver = new Augmenter().augment(TestBench.createDriver(rawDriver));
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e1);
        }
    }

    /**
     * Tries to automatically determine the IP address of the machine the test
     * is running on.
     * 
     * @return An IP address of one of the network interfaces in the machine.
     * @throws RuntimeException
     *             if there was an error or no IP was found
     */
    private String findAutoHostname() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface
                    .getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface current = interfaces.nextElement();
                if (!current.isUp() || current.isLoopback()
                        || current.isVirtual()) {
                    continue;
                }
                Enumeration<InetAddress> addresses = current.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress current_addr = addresses.nextElement();
                    if (current_addr.isLoopbackAddress()) {
                        continue;
                    }
                    if (current_addr.isSiteLocalAddress()) {
                        return current_addr.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException("Could not enumerate ");
        }

        throw new RuntimeException(
                "No compatible (192.168.*) ip address found.");
    }

    public File getReferenceImage(String name) {
        return new File(REF_IMAGE_ROOT, name);
    }

    protected void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}