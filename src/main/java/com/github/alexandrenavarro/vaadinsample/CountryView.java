package com.github.alexandrenavarro.vaadinsample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by anavarro on 06/02/17.
 */
@Slf4j
@SpringView(name = CountryView.VIEW_NAME)
public class CountryView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "country-view";

    private final CountryResource countryResource;


    @Autowired
    public CountryView(final CountryResource countryResource) {
        this.countryResource = countryResource;
    }

    @PostConstruct
    private void init() {
        final List<Country> countryList = countryResource.findCountries();
        final BeanItemContainer<Country> container =
                new BeanItemContainer<Country>(Country.class, countryList);
        final Grid grid = new Grid(container);
        grid.setColumnOrder("name", "alpha2Code", "alpha3Code");
        //grid.getColumn("name").setWidth(1000);
        //grid.setWidth(100, Unit.PERCENTAGE);
        grid.setSizeFull();
        grid.addSelectionListener( e -> {
            log.info("e.getSelected():{}", e.getSelected());
        });

        // Create a header row to hold column filters
        Grid.HeaderRow filterRow = grid.appendHeaderRow();

        // Set up a filter for all columns
        for (Object pid: grid.getContainerDataSource()
                .getContainerPropertyIds()) {
            Grid.HeaderCell cell = filterRow.getCell(pid);

            // Have an input field to use for filter
            TextField filterField = new TextField();
            //filterField.setColumns(8);

            // Update filter When the filter input is changed
            filterField.addTextChangeListener(change -> {
                // Can't modify filters so need to replace
                container.removeContainerFilters(pid);

                // (Re)create the filter if necessary
                if (! change.getText().isEmpty())
                    container.addContainerFilter(
                            new SimpleStringFilter(pid,
                                    change.getText(), true, false));
            });
            cell.setComponent(filterField);
        }

        addComponent(grid);
//        final Button button = new Button("Go to Default View");
//        button.addClickListener(e -> {
//            getUI().getNavigator().navigateTo(DefaultView.VIEW_NAME);
//            // add / id if you want pass parameter
//        });
//        addComponent(button);

        setSizeFull();

    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        log.info("viewChangeEvent:{}", viewChangeEvent);
    }
}
