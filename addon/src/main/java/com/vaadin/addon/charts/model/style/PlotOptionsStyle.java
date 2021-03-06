package com.vaadin.addon.charts.model.style;

/*
 * #%L
 * Vaadin Charts
 * %%
 * Copyright (C) 2012 Vaadin Ltd
 * %%
 * This program is available under Commercial Vaadin Add-On License 2.0
 * (CVALv2).
 * 
 * See the file licensing.txt distributed with this software for more
 * information about licensing.
 * 
 * You should have received a copy of the CVALv2 along with this program.
 * If not, see <http://vaadin.com/license/cval-2.0>.
 * #L%
 */

import com.vaadin.addon.charts.model.AbstractConfigurationObject;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.PlotOptionsArea;
import com.vaadin.addon.charts.model.PlotOptionsAreaRange;
import com.vaadin.addon.charts.model.PlotOptionsAreaSpline;
import com.vaadin.addon.charts.model.PlotOptionsAreaSplineRange;
import com.vaadin.addon.charts.model.PlotOptionsBar;
import com.vaadin.addon.charts.model.PlotOptionsColumn;
import com.vaadin.addon.charts.model.PlotOptionsLine;
import com.vaadin.addon.charts.model.PlotOptionsPie;
import com.vaadin.addon.charts.model.PlotOptionsSeries;
import com.vaadin.addon.charts.model.PlotOptionsSpline;

/**
 * Styles for PlotOptions of different plot types
 */
@SuppressWarnings("serial")
public class PlotOptionsStyle extends AbstractConfigurationObject {
    private PlotOptionsBar bar = new PlotOptionsBar();
    private PlotOptionsArea area = new PlotOptionsArea();
    private PlotOptionsAreaRange arearange = new PlotOptionsAreaRange();
    private PlotOptionsAreaSpline areaspline = new PlotOptionsAreaSpline();
    private PlotOptionsAreaSplineRange areasplinerange = new PlotOptionsAreaSplineRange();
    private PlotOptionsPie pie = new PlotOptionsPie();
    private PlotOptionsLine line = new PlotOptionsLine();
    private PlotOptionsColumn column = new PlotOptionsColumn();
    private PlotOptionsSpline spline = new PlotOptionsSpline();
    private PlotOptionsSeries series = new PlotOptionsSeries();

    /**
     * @see #getBar()
     */
    public PlotOptionsBar getBar() {
        return bar;
    }

    /**
     * Sets the style options for {@link ChartType#BAR} charts
     * 
     * @param bar
     */
    public void setBar(PlotOptionsBar bar) {
        this.bar = bar;
    }

    /**
     * @see #getArea()
     */
    public PlotOptionsArea getArea() {
        return area;
    }

    /**
     * Sets the style options for {@link ChartType#AREA} charts
     * 
     * @param bar
     */
    public void setArea(PlotOptionsArea area) {
        this.area = area;
    }

    /**
     * @see #getPie()
     */
    public PlotOptionsPie getPie() {
        return pie;
    }

    /**
     * Sets the style options for {@link ChartType#PIE} charts
     * 
     * @param bar
     */
    public void setPie(PlotOptionsPie pie) {
        this.pie = pie;
    }

    /**
     * @see #getLine()
     */
    public PlotOptionsLine getLine() {
        return line;
    }

    /**
     * Sets the style options for {@link ChartType#LINE} charts
     * 
     * @param bar
     */
    public void setLine(PlotOptionsLine line) {
        this.line = line;
    }

    /**
     * @see #getColumn()
     */
    public PlotOptionsColumn getColumn() {
        return column;
    }

    /**
     * Sets the style options for {@link ChartType#COLUMN} charts
     * 
     * @param bar
     */
    public void setColumn(PlotOptionsColumn column) {
        this.column = column;
    }

    /**
     * @see #getSpline()
     */
    public PlotOptionsSpline getSpline() {
        return spline;
    }

    /**
     * Sets the style options for {@link ChartType#SPLINE} charts
     * 
     * @param bar
     */
    public void setSpline(PlotOptionsSpline spline) {
        this.spline = spline;
    }

    /**
     * @see #getSeries()
     */
    public PlotOptionsSeries getSeries() {
        return series;
    }

    /**
     * Sets the style rules for all chart types
     * 
     * @param series
     */
    public void setSeries(PlotOptionsSeries series) {
        this.series = series;
    }

    public PlotOptionsAreaRange getArearange() {
        return arearange;
    }

    public void setArearange(PlotOptionsAreaRange arearange) {
        this.arearange = arearange;
    }

    public PlotOptionsAreaSplineRange getAreasplinerange() {
        return areasplinerange;
    }

    public void setAreasplinerange(PlotOptionsAreaSplineRange areasplinerange) {
        this.areasplinerange = areasplinerange;
    }

    public PlotOptionsAreaSpline getAreaspline() {
        return areaspline;
    }

    public void setAreaspline(PlotOptionsAreaSpline areaspline) {
        this.areaspline = areaspline;
    }

}
