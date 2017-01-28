package lab.aikibo.ui;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

/**
 * Created by tamami on 22/01/17.
 */
public class MainView extends CustomComponent implements View {

    public static final String NAME = "";

    Label text = new Label();
    MenuBar menuBar;
    Panel panel = new Panel();
    Navigator navigator = new Navigator(UI.getCurrent(), panel);

    Button logout = new Button("Logout", new Button.ClickListener() {
        @Override
        public void buttonClick(Button.ClickEvent event) {

            // "Logout" the user
            getSession().setAttribute("user", null);

            // Refresh this view, should redirect to login view
            getUI().getNavigator().navigateTo(NAME);
        }
    });

    public MainView() {
        VerticalLayout verLayout = new VerticalLayout();
        HorizontalLayout credLayout = new HorizontalLayout(text, logout);

        //setCompositionRoot(new CssLayout(text, logout));
        verLayout.addComponent(credLayout);
        verLayout.setComponentAlignment(credLayout, Alignment.MIDDLE_RIGHT);

        menuBar = new MenuBar();
        verLayout.addComponent(menuBar);

        MenuBar.MenuItem laporanMI = menuBar.addItem("Laporan", null, null);
        laporanMI.addItem("SK NJOP", null, skNjopCommand);

        verLayout.addComponent(panel);
        setCompositionRoot(verLayout);

        navigator.addView(SkNjopParamView.NAME, SkNjopParamView.class);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // Get the user name from the session
        String username = String.valueOf(getSession().getAttribute("user"));

        // And show the username
        text.setValue("Hello " + username);

    }

    MenuBar.Command skNjopCommand = new MenuBar.Command() {
        public void menuSelected(MenuBar.MenuItem selectedItem) {
            //getSession().setAttribute("user", username);
            //getUI().getNavigator().navigateTo(SkNjopParamView.NAME);
            navigator.navigateTo(SkNjopParamView.NAME);
        }
    };

}
