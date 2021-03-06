package com.vaadin.addon.charts.demoandtestapp;

import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Window;

public class TestUI extends Window {

    public TestUI(String name) {
        if (name == null) {
            name = "";
        }
        if (name.startsWith("/")) {
            name = name.substring(1);
        }
        if (!"".equals(name) && !name.contains(".ico")
                && name.matches("[A-Za-z/].*")) {
            try {

                String className;
                if (name.startsWith("com.")) {
                    className = name;
                } else {
                    className = getClass().getPackage().getName() + "."
                            + name.replace("/", ".");
                }
                @SuppressWarnings("unchecked")
                Class<? extends ComponentContainer> forName = (Class<? extends ComponentContainer>) Class
                        .forName(className);
                if (forName != null) {
                    setContent(forName.newInstance());
                }
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
