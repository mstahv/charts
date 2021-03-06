package com.vaadin.addon.charts.model;

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

/**
 * Custom styles for various states.
 */
@SuppressWarnings("serial")
public class State extends AbstractConfigurationObject {

    private Boolean enabled;
    private Number radius;
    private Number lineWidth;
    private MarkerSymbol symbol;

    /**
     * Constructs a disabled State.
     */
    public State() {
    }

    /**
     * Constructs a State that is either enabled or disabled.
     * 
     * @param enabled
     *            true to enable, false to disable.
     */
    public State(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @see #setEnabled(Boolean)
     */
    public boolean isEnabled() {
        return enabled == null ? true : enabled;
    }

    /**
     * Enables separate styles for the hovered series to visualize that the user
     * hovers either the series itself or the legend. Defaults to true.
     * 
     * @param enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Sets the radius of the point marker. Defaults to 0.
     * 
     * @param radius
     */
    public void setRadius(Number radius) {
        this.radius = radius;
    }

    /**
     * @see #setRadius(Number)
     * @return The radius of the point marker.
     */
    public Number getRadius() {
        return radius;
    }

    /**
     * Sets the width of the point marker's outline. Defaults to 0.
     * 
     * @param lineWidth
     */
    public void setLineWidth(Number lineWidth) {
        this.lineWidth = lineWidth;
    }

    /**
     * @see #setLineWidth(Number)
     */
    public Number getLineWidth() {
        return lineWidth;
    }

    /**
     * Sets a predefined shape or symbol for the marker. When null, the symbol
     * is pulled from options.symbols. Defaults to null.
     * 
     * @see MarkerSymbolEnum
     * @see MarkerSymbolUrl
     * 
     * @param symbol
     */
    public void setSymbol(MarkerSymbol symbol) {
        this.symbol = symbol;
    }

    /**
     * @see #setSymbol(MarkerSymbol)
     */
    public MarkerSymbol getSymbol() {
        return symbol;
    }
}
