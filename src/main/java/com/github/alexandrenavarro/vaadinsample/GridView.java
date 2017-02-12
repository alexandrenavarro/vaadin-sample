package com.github.alexandrenavarro.vaadinsample;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

/**
 * Created by anavarro on 06/02/17.
 */
@SpringView(name = GridView.VIEW_NAME)
@Slf4j
public class GridView extends CustomComponent implements View {

    public static final String VIEW_NAME = "grid-view";


    @PostConstruct
    public void init() {
        final GridLayout gridLayout = new GridLayout(4, 7);
        gridLayout.addComponent(new Button("b00:1x1"), 0, 0);
        gridLayout.addComponent(new Button("b10:1x1"), 1, 0);
        gridLayout.addComponent(new Button("b20:1x1"), 2, 0);
        gridLayout.addComponent(new Button("b30:1x1"), 3, 0);
        gridLayout.addComponent(new Button("b01:1x1"), 0, 1);
        gridLayout.addComponent(new Button("b11:1x1"), 1, 1);
        gridLayout.addComponent(new Button("b21:1x1"), 2, 1);
        gridLayout.addComponent(new Button("b31:1x1"), 3, 1);
        Button button = new Button("b02:4x1");
        button.setSizeFull();
        gridLayout.addComponent(button, 0, 2, 3, 2);
        gridLayout.addComponent(new Label("b03:4x1"), 0, 3, 0, 5);
        gridLayout.addComponent(new Button("b50:1x1"));
        gridLayout.addComponent(new Button("b#1"));
        gridLayout.addComponent(new Button("b2"));
        Button button1 = new Button("b02:4x1");
        button1.setSizeFull();
        gridLayout.addComponent(button1, 0, 6, 3, 6);

        setCompositionRoot(gridLayout);
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
