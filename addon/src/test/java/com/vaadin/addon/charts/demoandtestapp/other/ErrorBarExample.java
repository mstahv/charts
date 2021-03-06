package com.vaadin.addon.charts.demoandtestapp.other;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.demoandtestapp.AbstractVaadinChartExample;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.DataSeriesItem;
import com.vaadin.addon.charts.model.PlotOptionsColumn;
import com.vaadin.addon.charts.model.PlotOptionsErrorBar;
import com.vaadin.addon.charts.model.PlotOptionsSpline;
import com.vaadin.addon.charts.model.Title;
import com.vaadin.addon.charts.model.Tooltip;
import com.vaadin.addon.charts.model.YAxis;
import com.vaadin.addon.charts.model.ZoomType;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.addon.charts.model.style.Style;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
public class ErrorBarExample extends AbstractVaadinChartExample {

    @Override
    public String getDescription() {
        return "Combined chart with error bars";
    }

    @Override
    protected Component getChart() {
        Chart chart = new Chart();

        Configuration conf = chart.getConfiguration();

        // Enable xy zooming, test also with touch devices
        conf.getChart().setZoomType(ZoomType.XY);

        conf.setTitle("Temperature vs Rainfall");

        conf.getxAxis().setCategories("Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

        YAxis primaryAxis = conf.getyAxis();

        Title title = new Title("Temperature");
        Style style = new Style();
        style.setColor(new SolidColor("#89A54E"));
        title.setStyle(style);
        primaryAxis.setTitle(title);

        primaryAxis.getLabels().setFormatter("this.value + '°C'");

        YAxis secondaryAxis = new YAxis();
        conf.getyAxes().addAxis(secondaryAxis);
        title = new Title("Rainfall");
        secondaryAxis.setTitle(title);
        style = new Style();
        style.setColor(new SolidColor("#4572A7"));
        title.setStyle(style);
        secondaryAxis.getLabels().setFormatter("this.value + ' mm'");
        secondaryAxis.getLabels().setStyle(style);
        secondaryAxis.setOpposite(true);

        conf.getTooltip().setShared(true);

        DataSeries rainfall = new DataSeries("Rainfall");

        PlotOptionsColumn column = new PlotOptionsColumn();
        column.setColor(new SolidColor("#4572A7"));
        Tooltip tooltip = new Tooltip();
        tooltip.setPointFormat("<span style='font-weight: bold; color: {series.color}'>{series.name}</span>: <b>{point.y:.1f} mm</b> ");
        column.setTooltip(tooltip);
        rainfall.setPlotOptions(column);
        conf.addSeries(rainfall);
        rainfall.setyAxis(secondaryAxis);

        DataSeries rainfallError = new DataSeries("Rainfall");
        conf.addSeries(rainfallError);
        rainfallError.setyAxis(secondaryAxis);
        PlotOptionsErrorBar rainErrorOptions = new PlotOptionsErrorBar();
        tooltip = new Tooltip();
        tooltip.setPointFormat("(error range: {point.low}-{point.high} mm)<br/>");
        rainErrorOptions.setTooltip(tooltip);
        rainfallError.setPlotOptions(rainErrorOptions);

        DataSeries temperature = new DataSeries("Temperature");
        conf.addSeries(temperature);
        PlotOptionsSpline tempOptions = new PlotOptionsSpline();
        tempOptions.setColor(new SolidColor("#89a54e"));
        tooltip = new Tooltip();
        tooltip.setPointFormat("<span style='font-weight: bold; color: {series.color}'>{series.name}</span>: <b>{point.y:.1f}°C");
        tempOptions.setTooltip(tooltip);
        temperature.setPlotOptions(tempOptions);

        DataSeries temperatureErrors = new DataSeries("Temperature error");
        conf.addSeries(temperatureErrors);
        PlotOptionsErrorBar tempErrorOptions = new PlotOptionsErrorBar();
        SolidColor green = new SolidColor("green");
        tempErrorOptions.setStemColor(green);
        tempErrorOptions.setWhiskerColor(green);
        tooltip = new Tooltip();
        tooltip.setPointFormat("(error range: {point.low}-{point.high}°C)<br/>");
        tempErrorOptions.setTooltip(tooltip);
        temperatureErrors.setPlotOptions(tempErrorOptions);

        // Populate series
        for (Data d : DATA) {
            DataSeriesItem item = new DataSeriesItem();
            item.setY(d.rainfall);
            rainfall.add(item);

            item = new DataSeriesItem();
            item.setLow(d.rainfallErrorLow);
            item.setHigh(d.rainfallErrorHigh);
            rainfallError.add(item);

            item = new DataSeriesItem();
            item.setY(d.temperature);
            temperature.add(item);

            item = new DataSeriesItem();
            item.setLow(d.temperatureErrorLow);
            item.setHigh(d.temperatureErrorHigh);
            temperatureErrors.add(item);

        }

        return chart;
    }

    public static class Data {
        public Number temperature;
        public Number rainfall;
        public Number temperatureErrorLow;
        public Number temperatureErrorHigh;
        public Number rainfallErrorLow;
        public Number rainfallErrorHigh;

        public Data(Number temperature, Number rainfall, Number tempErrorLow,
                Number tempErrorHigh, Number rainErrorLow, Number rainErrorHigh) {
            this.temperature = temperature;
            this.rainfall = rainfall;
            temperatureErrorLow = tempErrorLow;
            temperatureErrorHigh = tempErrorHigh;
            rainfallErrorLow = rainErrorLow;
            rainfallErrorHigh = rainErrorHigh;
        }
    }

    static Data[] DATA = new Data[] { new Data(7.0, 49.9, 6, 8, 48, 51),
            new Data(6.9, 71.5, 5.9, 7.6, 68, 73),
            new Data(9.5, 106.4, 9.4, 10.4, 92, 110),
            new Data(14.5, 129.2, 14.1, 15.9, 128, 136),
            new Data(18.2, 144.0, 18.0, 20.1, 140, 150),
            new Data(21.5, 176.0, 21.0, 24.0, 171, 179),
            new Data(25.2, 135.6, 23.2, 25.3, 135, 143),
            new Data(26.5, 148.5, 26.1, 27.8, 142, 149),
            new Data(23.3, 216.4, 23.2, 23.9, 204, 220),
            new Data(18.3, 194.1, 18.0, 21.1, 189, 199),
            new Data(13.9, 95.6, 12.9, 14.0, 95, 110),
            new Data(9.6, 54.4, 7.6, 10.0, 52, 56),

    };

}
