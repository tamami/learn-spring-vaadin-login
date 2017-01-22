package lab.aikibo.ui;

import com.vaadin.navigator.View;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by tamami on 22/01/17.
 */
public class SkNjopParamView extends CustomComponent implements View {

    public static final String NAME = "skNjopParamView";

    public SkNjopParamView() {
        initComponent();
    }

    private void initComponent() {
        setSizeFull();
        VerticalLayout layout = new VerticalLayout();
        setContent(layout);

        layout.addComponent(new Label("Di Parameter SK NJOP "));
    }

}
