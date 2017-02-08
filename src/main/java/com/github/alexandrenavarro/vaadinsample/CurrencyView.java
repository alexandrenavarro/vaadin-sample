package com.github.alexandrenavarro.vaadinsample;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

/**
 * Created by anavarro on 06/02/17.
 */
@SpringView(name = CurrencyView.VIEW_NAME)
@Slf4j
public class CurrencyView extends CustomComponent implements View {

    public static final String VIEW_NAME = "currency-view";


    @PostConstruct
    public void init() {
        final Grid grid = new Grid();
        grid.addColumn("Currency", String.class);
        grid.addRow("EUR");
        grid.addRow("USD");
        grid.setSizeFull();

        setCompositionRoot(grid);

    }



    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        log.info("viewChangeEvent:{}", viewChangeEvent);


    }

//    @PostConstruct
//    void init() {
//        setMargin(true);
//        setSpacing(true);
//        addComponent(new Label("This is a view scoped view"));
//    }
//
//    @Override
//    public void enter(ViewChangeListener.ViewChangeEvent event) {
//        // This view is constructed in the init() method()
//    }

}
