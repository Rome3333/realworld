package io.realworld.demo.utils.properties;

public final class ConfigurationProperties {

    private static final String TARGET_WEBSITE_URL = "website.url";

    public static String getTargetWebsiteUrl() {
        return getFileProperty(TARGET_WEBSITE_URL);
    }

    private static String getFileProperty(String key) {
        return PropertiesHolder.getInstance().getProperty(key);
    }

}
