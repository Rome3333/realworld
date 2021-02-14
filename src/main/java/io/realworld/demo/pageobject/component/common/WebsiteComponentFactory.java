package io.realworld.demo.pageobject.component.common;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;

public final class WebsiteComponentFactory {

    public static <T extends AbstractWebsiteComponent> T createComponent(Class<T> type, WebElement rootElement) {
        T instance = createComponent(type);
        instance.setRootElement(rootElement);
        return instance;
    }

    public static <T extends AbstractWebsiteComponent> List<T> createComponents(Class<T> type, List<WebElement> elements) {
        return elements.stream().map(element -> createComponent(type, element)).collect(Collectors.toList());
    }

    public static <T extends AbstractWebsiteComponent> T createComponent(Class<T> type) {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException("Unable to create an instance of class " + type.getSimpleName());
        }
    }

}
