package com.vaadin.addon.charts.demoandtestapp.other;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.demoandtestapp.AbstractVaadinChartExample;
import com.vaadin.addon.charts.model.AxisType;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.RangeSeries;
import com.vaadin.addon.charts.model.Tooltip;
import com.vaadin.addon.charts.model.XAxis;
import com.vaadin.addon.charts.model.YAxis;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class ResizeInsideVaadinComponent extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Area Range";
    }

    @Override
    protected Component getChart() {

        VerticalSplitPanel verticalSplitPanel = new VerticalSplitPanel();
        HorizontalSplitPanel horizontalSplitPanel = new HorizontalSplitPanel();
        horizontalSplitPanel.setSecondComponent(verticalSplitPanel);
        verticalSplitPanel.setFirstComponent(createChart());

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setMargin(true);
        verticalLayout.setSpacing(true);
        verticalLayout
                .addComponent(new Label(
                        "Relatively sized components resize themselves automatically when in Vaadin component."));

        Button button = new Button("Open in a window");
        button.addListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                Window window = new Window("Chart windodw");
                VerticalLayout verticalLayout2 = new VerticalLayout();
                verticalLayout2.addComponent(createChart());
                verticalLayout2.setSizeFull();
                window.setContent(verticalLayout2);
                window.setWidth("50%");
                window.setHeight("50%");

                getWindow().addWindow(window);

            }
        });

        verticalLayout.addComponent(button);
        horizontalSplitPanel.setFirstComponent(verticalLayout);

        return horizontalSplitPanel;
    }

    private Chart createChart() {
        Chart chart = new Chart(ChartType.AREARANGE);
        chart.setSizeFull();

        Configuration conf = chart.getConfiguration();

        conf.setTitle("Temperature variation by day");

        XAxis axis = new XAxis();
        axis.setType(AxisType.DATETIME);
        conf.addxAxis(axis);
        conf.addyAxis(new YAxis());

        Tooltip tooltip = new Tooltip();
        tooltip.setCrosshairs(true);
        tooltip.setShared(true);
        tooltip.setValueSuffix("°C");
        conf.setTooltip(tooltip);

        RangeSeries data = new RangeSeries("Temperatures", getRawData());
        conf.setSeries(data);
        return chart;
    }

    private Number[][] getRawData() {
        return new Number[][] { /* 2009-01-01 */{ 1230771600000d, -5.8, 0.1 },
                { 1230858000000d, -4.1, 1.4 }, { 1230944400000d, -0.5, 4.1 },
                { 1231030800000d, -8.9, -0.7 }, { 1231117200000d, -9.7, -3.7 },
                { 1231203600000d, -3.4, 3.2 }, { 1231290000000d, -3.9, -0.2 },
                { 1231376400000d, -2.4, 6.7 }, { 1231462800000d, 3.8, 6.9 },
                { 1231549200000d, 3.1, 6.8 }, { 1231635600000d, 0.0, 7.6 },
                { 1231722000000d, 5.6, 9.4 }, { 1231808400000d, 3.6, 6.5 },
                { 1231894800000d, -3.6, 3.8 }, { 1231981200000d, -6.0, -1.5 },
                { 1232067600000d, -3.8, 2.4 }, { 1232154000000d, 1.5, 4.2 },
                { 1232240400000d, 0.0, 4.5 }, { 1232326800000d, -1.1, 3.6 },
                { 1232413200000d, 0.5, 5.1 }, { 1232499600000d, 0.0, 2.5 },
                { 1232586000000d, -0.6, 2.1 }, { 1232672400000d, 0.8, 4.7 },
                { 1232758800000d, 0.6, 4.4 }, { 1232845200000d, -3.9, 1.4 },
                { 1232931600000d, -4.3, 2.0 }, { 1233018000000d, -6.1, -0.4 },
                { 1233104400000d, -0.3, 1.9 }, { 1233190800000d, -2.9, 2.7 },
                { 1233277200000d, -4.0, -1.0 }, { 1233363600000d, -4.4, -1.9 }, /*
                                                                                 * 2009
                                                                                 * -
                                                                                 * 02
                                                                                 * -
                                                                                 * 01
                                                                                 */
                { 1233450000000d, -5.0, -2.7 }, { 1233536400000d, -5.2, -2.3 },
                { 1233622800000d, -6.3, -0.6 }, { 1233709200000d, -5.4, -0.6 },
                { 1233795600000d, -2.1, 1.4 }, { 1233882000000d, -4.6, 1.5 },
                { 1233968400000d, -5.4, 0.6 }, { 1234054800000d, -8.7, -2.6 },
                { 1234141200000d, -5.2, 1.3 }, { 1234227600000d, -8.6, -2.2 },
                { 1234314000000d, -8.5, 0.1 }, { 1234400400000d, -4.8, 1.7 },
                { 1234486800000d, -8.3, 1.4 }, { 1234573200000d, -8.6, 1.1 },
                { 1234659600000d, -3.2, 1.5 }, { 1234746000000d, -0.7, 4.1 },
                { 1234832400000d, 0.2, 3.2 }, { 1234918800000d, 0.0, 3.9 },
                { 1235005200000d, 1.2, 4.5 }, { 1235091600000d, 1.3, 5.7 },
                { 1235178000000d, 1.0, 2.3 }, { 1235264400000d, 1.1, 5.5 },
                { 1235350800000d, 1.0, 6.5 }, { 1235437200000d, 0.9, 3.7 },
                { 1235523600000d, 1.5, 4.3 }, { 1235610000000d, 0.5, 5.4 },
                { 1235696400000d, -4.9, 3.8 }, { 1235782800000d, -5.4, 1.4 }, /*
                                                                               * 2009
                                                                               * -
                                                                               * 03
                                                                               * -
                                                                               * 01
                                                                               */
                { 1235869200000d, -1.9, 4.0 }, { 1235955600000d, 0.9, 8.1 },
                { 1236042000000d, 1.7, 8.1 }, { 1236128400000d, 0.0, 9.1 },
                { 1236214800000d, 2.5, 7.7 }, { 1236301200000d, 2.1, 5.6 },
                { 1236387600000d, 1.5, 6.9 }, { 1236474000000d, 0.6, 7.9 },
                { 1236560400000d, 1.9, 9.4 }, { 1236646800000d, 1.8, 7.0 },
                { 1236733200000d, 0.2, 8.6 }, { 1236819600000d, -0.3, 5.9 },
                { 1236906000000d, 1.6, 8.3 }, { 1236992400000d, -0.4, 8.8 },
                { 1237078800000d, -2.0, 5.4 }, { 1237165200000d, 2.2, 6.7 },
                { 1237251600000d, 0.0, 7.2 }, { 1237338000000d, 0.8, 9.3 },
                { 1237424400000d, -1.7, 7.5 }, { 1237510800000d, -2.0, 6.3 },
                { 1237597200000d, -0.3, 5.7 }, { 1237683600000d, 1.7, 5.9 },
                { 1237770000000d, -0.8, 5.7 }, { 1237856400000d, -3.5, 5.7 },
                { 1237942800000d, -2.6, 5.0 }, { 1238029200000d, -0.7, 8.0 },
                { 1238115600000d, -2.8, 6.0 }, { 1238202000000d, -2.9, 6.1 },
                { 1238288400000d, 0.3, 7.0 }, { 1238371200000d, 0.5, 7.5 },
                { 1238457600000d, 1.6, 4.7 }, /* 2009-04-01 */
                { 1238544000000d, -1.4, 7.3 }, { 1238630400000d, 2.8, 6.8 },
                { 1238716800000d, 3.4, 12.0 }, { 1238803200000d, 0.6, 13.5 },
                { 1238889600000d, 5.5, 8.3 }, { 1238976000000d, 3.3, 8.3 },
                { 1239062400000d, 0.6, 13.5 }, { 1239148800000d, 3.0, 13.7 },
                { 1239235200000d, 6.6, 15.2 }, { 1239321600000d, 5.6, 10.3 },
                { 1239408000000d, 5.6, 15.2 }, { 1239494400000d, 4.1, 10.0 },
                { 1239580800000d, 0.4, 11.8 }, { 1239667200000d, 0.5, 13.6 },
                { 1239753600000d, 3.8, 15.6 }, { 1239840000000d, 6.0, 11.6 },
                { 1239926400000d, 3.9, 13.9 }, { 1240012800000d, 0.8, 14.3 },
                { 1240099200000d, 2.9, 17.3 }, { 1240185600000d, 7.1, 12.2 },
                { 1240272000000d, 2.4, 12.9 }, { 1240358400000d, 4.7, 12.9 },
                { 1240444800000d, 2.0, 16.3 }, { 1240531200000d, 9.5, 17.4 },
                { 1240617600000d, 3.4, 16.7 }, { 1240704000000d, 6.7, 19.1 },
                { 1240790400000d, 4.9, 15.8 }, { 1240876800000d, 8.4, 15.3 },
                { 1240963200000d, 4.1, 18.6 }, { 1241049600000d, 6.6, 19.9 }, /*
                                                                               * 2009
                                                                               * -
                                                                               * 05
                                                                               * -
                                                                               * 01
                                                                               */
                { 1241136000000d, 8.7, 21.4 }, { 1241222400000d, 9.2, 16.4 },
                { 1241308800000d, 6.2, 12.9 }, { 1241395200000d, 0.0, 13.4 },
                { 1241481600000d, 4.5, 11.2 }, { 1241568000000d, 3.2, 14.3 },
                { 1241654400000d, 3.1, 13.7 }, { 1241740800000d, 6.4, 14.6 },
                { 1241827200000d, 5.0, 13.5 }, { 1241913600000d, 4.8, 11.5 },
                { 1242000000000d, 3.5, 13.0 }, { 1242086400000d, 4.5, 15.0 },
                { 1242172800000d, 2.0, 17.0 }, { 1242259200000d, 4.3, 18.3 },
                { 1242345600000d, 4.5, 18.8 }, { 1242432000000d, 8.0, 20.7 },
                { 1242518400000d, 7.4, 20.7 }, { 1242604800000d, 8.4, 17.7 },
                { 1242691200000d, 8.3, 15.2 }, { 1242777600000d, 8.3, 17.9 },
                { 1242864000000d, 6.7, 17.0 }, { 1242950400000d, 7.6, 17.5 },
                { 1243036800000d, 6.6, 17.3 }, { 1243123200000d, 8.7, 17.7 },
                { 1243209600000d, 8.9, 17.7 }, { 1243296000000d, 8.4, 11.5 },
                { 1243382400000d, 5.9, 14.2 }, { 1243468800000d, 5.1, 16.9 },
                { 1243555200000d, 8.3, 16.0 }, { 1243641600000d, 6.2, 22.6 },
                { 1243728000000d, 7.8, 22.6 }, /* 2009-06-01 */
                { 1243814400000d, 7.3, 21.7 }, { 1243900800000d, 8.7, 16.2 },
                { 1243987200000d, 7.3, 13.9 }, { 1244073600000d, 3.9, 15.5 },
                { 1244160000000d, 6.4, 17.3 }, { 1244246400000d, 2.9, 17.9 },
                { 1244332800000d, 3.9, 17.9 }, { 1244419200000d, 6.5, 16.8 },
                { 1244505600000d, 8.0, 14.2 }, { 1244592000000d, 7.8, 16.2 },
                { 1244678400000d, 8.6, 15.3 }, { 1244764800000d, 8.2, 18.2 },
                { 1244851200000d, 9.5, 17.0 }, { 1244937600000d, 5.7, 18.7 },
                { 1245024000000d, 7.0, 16.9 }, { 1245110400000d, 4.3, 15.8 },
                { 1245196800000d, 3.6, 19.1 }, { 1245283200000d, 10.8, 15.0 },
                { 1245369600000d, 8.6, 16.3 }, { 1245456000000d, 10.7, 17.0 },
                { 1245542400000d, 9.7, 18.9 }, { 1245628800000d, 9.8, 20.6 },
                { 1245715200000d, 12.8, 19.5 }, { 1245801600000d, 8.6, 24.1 },
                { 1245888000000d, 10.9, 26.6 }, { 1245974400000d, 13.5, 28.0 },
                { 1246060800000d, 12.5, 23.2 }, { 1246147200000d, 14.0, 28.1 },
                { 1246233600000d, 14.9, 29.5 }, { 1246320000000d, 16.9, 22.5 }, /*
                                                                                 * 2009
                                                                                 * -
                                                                                 * 07
                                                                                 * -
                                                                                 * 01
                                                                                 */
                { 1246406400000d, 14.3, 27.7 }, { 1246492800000d, 14.5, 27.8 },
                { 1246579200000d, 15.5, 29.6 }, { 1246665600000d, 16.7, 30.7 },
                { 1246752000000d, 16.5, 25.0 }, { 1246838400000d, 17.8, 25.7 },
                { 1246924800000d, 13.5, 24.8 }, { 1247011200000d, 10.5, 21.4 },
                { 1247097600000d, 9.2, 23.8 }, { 1247184000000d, 11.6, 21.8 },
                { 1247270400000d, 10.7, 23.7 }, { 1247356800000d, 11.0, 23.3 },
                { 1247443200000d, 11.6, 23.7 }, { 1247529600000d, 11.8, 20.7 },
                { 1247616000000d, 12.6, 22.4 }, { 1247702400000d, 13.6, 19.6 },
                { 1247788800000d, 11.4, 22.6 }, { 1247875200000d, 13.2, 25.0 },
                { 1247961600000d, 14.2, 21.6 }, { 1248048000000d, 13.1, 17.1 },
                { 1248134400000d, 12.2, 15.5 }, { 1248220800000d, 12.0, 20.8 },
                { 1248307200000d, 12.0, 17.1 }, { 1248393600000d, 12.7, 18.3 },
                { 1248480000000d, 12.4, 19.4 }, { 1248566400000d, 12.6, 19.9 },
                { 1248652800000d, 11.9, 20.2 }, { 1248739200000d, 11.0, 19.3 },
                { 1248825600000d, 10.8, 17.8 }, { 1248912000000d, 11.8, 18.5 },
                { 1248998400000d, 10.8, 16.1 }, /* 2009-08-01 */
                { 1249084800000d, 9.0, 19.9 }, { 1249171200000d, 11.0, 20.2 },
                { 1249257600000d, 12.6, 22.5 }, { 1249344000000d, 14.5, 22.7 },
                { 1249430400000d, 11.9, 24.0 }, { 1249516800000d, 16.0, 21.5 },
                { 1249603200000d, 13.8, 24.8 }, { 1249689600000d, 13.7, 21.5 },
                { 1249776000000d, 13.6, 22.1 }, { 1249862400000d, 10.5, 22.3 },
                { 1249948800000d, 12.8, 18.4 }, { 1250035200000d, 11.9, 18.4 },
                { 1250121600000d, 10.9, 16.4 }, { 1250208000000d, 8.8, 16.8 },
                { 1250294400000d, 7.3, 13.6 }, { 1250380800000d, 10.7, 14.0 },
                { 1250467200000d, 12.3, 17.5 }, { 1250553600000d, 9.9, 18.4 },
                { 1250640000000d, 7.7, 16.0 }, { 1250726400000d, 12.7, 26.5 },
                { 1250812800000d, 12.8, 20.3 }, { 1250899200000d, 10.6, 17.7 },
                { 1250985600000d, 11.3, 18.5 }, { 1251072000000d, 11.3, 13.8 },
                { 1251158400000d, null, null }, { 1251244800000d, 10.0, 15.1 },
                { 1251331200000d, 9.6, 16.5 }, { 1251417600000d, 12.7, 13.8 },
                { 1251504000000d, 11.1, 17.1 }, { 1251590400000d, 11.9, 15.3 },
                { 1251676800000d, 10.8, 12.6 }, /*
                                                 * 2009 - 09 - 01
                                                 */
                { 1251763200000d, 11.5, 14.8 }, { 1251849600000d, 10.0, 13.7 },
                { 1251936000000d, 9.3, 16.8 }, { 1252022400000d, 11.1, 18.0 },
                { 1252108800000d, 10.4, 11.8 }, { 1252195200000d, null, null },
                { 1252281600000d, 10.8, 14.7 }, { 1252368000000d, 9.0, 13.1 },
                { 1252454400000d, 11.4, 16.6 }, { 1252540800000d, 9.7, 15.6 },
                { 1252627200000d, 10.4, 14.0 }, { 1252713600000d, 10.0, 13.6 },
                { 1252800000000d, 8.3, 17.5 }, { 1252886400000d, 6.1, 15.7 },
                { 1252972800000d, 5.5, 14.4 }, { 1253059200000d, 8.5, 13.6 },
                { 1253145600000d, 8.8, 12.8 }, { 1253232000000d, 9.4, 15.6 },
                { 1253318400000d, 6.7, 17.1 }, { 1253404800000d, 9.3, 14.9 },
                { 1253491200000d, 8.4, 15.0 }, { 1253577600000d, 9.5, 15.2 },
                { 1253664000000d, 7.7, 11.1 }, { 1253750400000d, 7.1, 11.9 },
                { 1253836800000d, 10.0, 15.8 }, { 1253923200000d, 13.9, 16.0 },
                { 1254009600000d, 8.0, 15.1 }, { 1254096000000d, 4.4, 8.9 },
                { 1254182400000d, 4.7, 6.9 }, { 1254268800000d, null, null }, /*
                                                                               * 2009
                                                                               * -
                                                                               * 10
                                                                               * -
                                                                               * 01
                                                                               */
                { 1254355200000d, null, null }, { 1254441600000d, 3.6, 3.6 },
                { 1254528000000d, 3.0, 6.8 }, { 1254614400000d, 2.8, 9.0 },
                { 1254700800000d, 1.5, 7.5 }, { 1254787200000d, 0.5, 5.8 },
                { 1254873600000d, 3.3, 9.1 }, { 1254960000000d, 3.4, 5.3 },
                { 1255046400000d, 0.7, 6.7 }, { 1255132800000d, -2.5, 6.2 },
                { 1255219200000d, 0.4, 8.5 }, { 1255305600000d, 0.2, 9.6 },
                { 1255392000000d, -2.5, 5.3 }, { 1255478400000d, -3.1, 5.4 },
                { 1255564800000d, 2.3, 8.5 }, { 1255651200000d, 4.4, 10.8 },
                { 1255737600000d, 0.2, 7.8 }, { 1255824000000d, -1.2, 7.2 },
                { 1255910400000d, 2.8, 6.4 }, { 1255996800000d, -0.8, 7.2 },
                { 1256083200000d, 1.0, 9.7 }, { 1256169600000d, 1.3, 4.2 },
                { 1256256000000d, 2.9, 11.4 }, { 1256342400000d, 4.7, 9.0 },
                { 1256428800000d, 3.3, 10.8 }, { 1256518800000d, 0.0, 7.1 },
                { 1256605200000d, 0.0, 2.0 }, { 1256691600000d, -1.1, 5.4 },
                { 1256778000000d, -1.3, 4.5 }, { 1256864400000d, 0.3, 4.3 },
                { 1256950800000d, -0.7, 4.9 }, /*
                                                * 2009 - 11 - 01
                                                */
                { 1257037200000d, 4.5, 7.3 }, { 1257123600000d, 0.0, 4.4 },
                { 1257210000000d, 0.0, 0.0 }, { 1257296400000d, 0.0, 6.7 },
                { 1257382800000d, -2.2, 5.2 }, { 1257469200000d, -2.6, 1.7 },
                { 1257555600000d, -1.7, 10.3 }, { 1257642000000d, 0.0, 5.2 },
                { 1257728400000d, -1.9, 0.8 }, { 1257814800000d, -2.6, -0.2 },
                { 1257901200000d, -2.6, 1.2 }, { 1257987600000d, -4.4, -1.7 },
                { 1258074000000d, -5.2, 0.2 }, { 1258160400000d, null, null },
                { 1258246800000d, 1.3, 8.9 }, { 1258333200000d, -0.1, 3.9 },
                { 1258419600000d, 1.7, 5.9 }, { 1258506000000d, 4.5, 6.3 },
                { 1258592400000d, 4.8, 5.9 }, { 1258678800000d, 4.9, 10.4 },
                { 1258765200000d, 2.4, 8.6 }, { 1258851600000d, 2.4, 4.6 },
                { 1258938000000d, 1.9, 5.2 }, { 1259024400000d, 2.9, 5.7 },
                { 1259110800000d, 2.9, 4.9 }, { 1259197200000d, 3.9, 7.6 },
                { 1259283600000d, 0.8, 5.7 }, { 1259370000000d, 0.0, 4.8 },
                { 1259456400000d, 1.5, 3.4 }, { 1259542800000d, -3.8, 1.5 }, /*
                                                                              * 2009
                                                                              * -
                                                                              * 12
                                                                              * -
                                                                              * 01
                                                                              */
                { 1259629200000d, -3.3, 1.7 }, { 1259715600000d, -2.8, -0.7 },
                { 1259802000000d, -2.7, 3.8 }, { 1259888400000d, -0.7, 4.2 },
                { 1259974800000d, 0.3, 6.1 }, { 1260061200000d, 2.9, 9.8 },
                { 1260147600000d, 0.0, 6.8 }, { 1260234000000d, 0.6, 2.8 },
                { 1260320400000d, 0.1, 5.1 }, { 1260406800000d, 2.8, 3.9 },
                { 1260493200000d, -1.2, 2.2 }, { 1260579600000d, -4.0, -0.4 },
                { 1260666000000d, -0.7, 0.7 }, { 1260752400000d, 0.5, 1.6 },
                { 1260838800000d, -1.0, 1.5 }, { 1260925200000d, -7.8, -1.0 },
                { 1261011600000d, -11.9, -7.9 },
                { 1261098000000d, -13.5, -7.9 },
                { 1261184400000d, -7.8, -1.7 },
                { 1261270800000d, -11.2, -0.6 },
                { 1261357200000d, -13.1, -7.2 },
                { 1261443600000d, -13.2, -5.2 },
                { 1261530000000d, -10.9, -7.7 },
                { 1261616400000d, -8.4, -1.5 }, { 1261702800000d, -6.1, -1.2 },
                { 1261789200000d, -2.6, -1.2 }, { 1261875600000d, -2.9, 0.7 },
                { 1261962000000d, -2.7, 0.7 }, { 1262048400000d, -10.8, -1.3 },
                { 1262134800000d, -11.1, -8.0 },
                { 1262221200000d, -12.2, -6.5 } };
    }
}
