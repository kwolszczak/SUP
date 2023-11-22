package pl.kwolszczak.deprecated.selenium7_2_2.configuration.model;

public class Browser {
    private String name;
    private String version;
    private String downloadDir;
    private  boolean attachScreenshot;
    private boolean headless;
    private int webelementTimeout;

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getDownloadDir() {
        return downloadDir;
    }

    public boolean isAttachScreenshot() {
        return attachScreenshot;
    }

    public boolean isHeadless() {
        return headless;
    }

    public int getWebelementTimeout() {
        return webelementTimeout;
    }
}
