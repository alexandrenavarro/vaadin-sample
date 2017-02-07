package com.github.alexandrenavarro.vaadinsample;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.themes.ValoTheme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.annotation.WebListener;

/**
 * Created by anavarro on 06/02/17.
 */
@SpringUI
@SpringViewDisplay
@Theme("valo")
@Slf4j
public class MainUI extends UI implements ViewDisplay {

    private Panel springViewDisplay;

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout root = new VerticalLayout();
        root.setSizeFull();
        root.setMargin(true);
        root.setSpacing(true);
        setContent(root);

        final HorizontalLayout navigationBar = new HorizontalLayout();
        navigationBar.addComponent(createNavigationButton("Country View",
                CountryView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("Currency View",
                CurrencyView.VIEW_NAME));

        root.addComponent(navigationBar);

        springViewDisplay = new Panel();
        springViewDisplay.setStyleName(ValoTheme.PANEL_BORDERLESS);


        springViewDisplay.setSizeFull();
        root.addComponent(springViewDisplay);
        root.setExpandRatio(springViewDisplay, 1.0f);

        // TODO

        // Builder
        // Test
        // Push

    }

    private Button createNavigationButton(String caption, final String viewName) {
        final Button button = new Button(caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));
        return button;
    }

    @Override
    public void showView(View view) {
        springViewDisplay.setContent((Component) view);
    }
}
