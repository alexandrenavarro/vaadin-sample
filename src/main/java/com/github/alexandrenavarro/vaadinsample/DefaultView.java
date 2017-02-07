package com.github.alexandrenavarro.vaadinsample;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

/**
 * Created by anavarro on 07/02/17.
 */
@SpringView(name = DefaultView.VIEW_NAME)
@Slf4j
public class DefaultView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
    }
}
