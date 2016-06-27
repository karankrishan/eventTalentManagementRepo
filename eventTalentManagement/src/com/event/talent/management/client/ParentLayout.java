package com.event.talent.management.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.IconProvider;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.examples.resources.client.TestData;
import com.sencha.gxt.examples.resources.client.images.ExampleImages;
import com.sencha.gxt.examples.resources.client.model.NameImageModel;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.AccordionLayoutAppearance;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.ExpandMode;
import com.sencha.gxt.widget.core.client.tree.Tree;

public class ParentLayout implements IsWidget {

	  protected static final int MIN_HEIGHT = 320;
	  protected static final int MIN_WIDTH = 200;

	  private ContentPanel panel;


@Override
public Widget asWidget() {
  if (panel == null) {
    AccordionLayoutAppearance appearance = GWT.<AccordionLayoutAppearance> create(AccordionLayoutAppearance.class);

    TreeStore<NameImageModel> store = new TreeStore<NameImageModel>(NameImageModel.KP);

    Tree<NameImageModel, String> tree = new Tree<NameImageModel, String>(store,
        new ValueProvider<NameImageModel, String>() {
          @Override
          public String getValue(NameImageModel object) {
            return object.getName();
          }

          @Override
          public void setValue(NameImageModel object, String value) {
          }

          @Override
          public String getPath() {
            return "name";
          }
        });
    tree.setIconProvider(new IconProvider<NameImageModel>() {
      public ImageResource getIcon(NameImageModel model) {
        if (null == model.getImage()) {
          return null;
        } else if ("user-girl" == model.getImage()) {
          return ExampleImages.INSTANCE.userFemale();
        } else if ("user-kid" == model.getImage()) {
          return ExampleImages.INSTANCE.userKid();
        } else {
          return ExampleImages.INSTANCE.user();
        }
      }
    });

    NameImageModel modelFamily = newItem("Family", null);
    store.add(modelFamily);
    store.add(modelFamily, newItem("John", "user"));
    store.add(modelFamily, newItem("Olivia", "user-girl"));
    store.add(modelFamily, newItem("Noah", "user-kid"));
    store.add(modelFamily, newItem("Emma", "user-kid"));
    store.add(modelFamily, newItem("Liam", "user-kid"));

    NameImageModel modelFriends = newItem("Friends", null);
    store.add(modelFriends);
    store.add(modelFriends, newItem("Mason", "user"));
    store.add(modelFriends, newItem("Sophia", "user-girl"));
    store.add(modelFriends, newItem("Isabella", "user-girl"));
    store.add(modelFriends, newItem("Jacob", "user"));

    tree.setExpanded(modelFamily, true);
    tree.setExpanded(modelFriends, true);

    ContentPanel cp1 = new ContentPanel(appearance);
    cp1.setAnimCollapse(false);
    cp1.setHeadingText("Online Users");
    cp1.add(tree);

    ContentPanel cp2 = new ContentPanel(appearance);
    cp2.setAnimCollapse(false);
    cp2.setBodyStyleName("pad-text");
    cp2.setHeadingText("Settings");
    cp2.add(new Label(TestData.DUMMY_TEXT_SHORT));

    ContentPanel cp3 = new ContentPanel(appearance);
    cp3.setAnimCollapse(false);
    cp3.setBodyStyleName("pad-text");
    cp3.setHeadingText("Stuff");
    cp3.add(new Label(TestData.DUMMY_TEXT_SHORT));

    ContentPanel cp4 = new ContentPanel(appearance);
    cp4.setAnimCollapse(false);
    cp4.setBodyStyleName("pad-text");
    cp4.setHeadingText("More Stuff");
    cp4.add(new Label(TestData.DUMMY_TEXT_SHORT));

    AccordionLayoutContainer accordion = new AccordionLayoutContainer();
    accordion.setExpandMode(ExpandMode.SINGLE_FILL);
    accordion.add(cp1);
    accordion.add(cp2);
    accordion.add(cp3);
    accordion.add(cp4);
    accordion.setActiveWidget(cp1);

    panel = new ContentPanel();
    panel.setHeadingText("Accordion Layout");
    panel.setBodyBorder(false);
    panel.add(accordion);
  }

  return panel;
}

private NameImageModel newItem(String text, String iconStyle) {
  return new NameImageModel(text, iconStyle);
}


}