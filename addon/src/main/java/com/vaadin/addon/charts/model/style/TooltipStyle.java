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

/**
 * Style options for tooltips
 */
public class TooltipStyle extends AbstractConfigurationObject {

    private Color backgroundColor;
    private Number borderWidth;
    private Number borderRadius;
    private Boolean followPointer = false;
    private Style style = new Style();

    /**
     * @return The background color of tooltips, null if not defined
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Sets the background color of tooltips
     * 
     * @param backgroundColor
     */
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * @return The width of the border of tooltips, or null if not defined
     */
    public Number getBorderWidth() {
        return borderWidth;
    }

    /**
     * Sets the width of the border of tooltips
     * 
     * @param borderWidth
     */
    public void setBorderWidth(Number borderWidth) {
        this.borderWidth = borderWidth;
    }

    /**
     * @return The style attributes for tooltips
     */
    public Style getStyle() {
        return style;
    }

    /**
     * Sets the style attributes for tooltips
     * 
     * @param style
     *            Style attributes
     */
    public void setStyle(Style style) {
        this.style = style;
    }

    /**
     * @return The border radius of tooltips
     */
    public Number getBorderRadius() {
        return borderRadius;
    }

    /**
     * Sets the border radius of tooltips
     * 
     * @param borderRadius
     *            the border radius in pixels
     */
    public void setBorderRadius(Number borderRadius) {
        this.borderRadius = borderRadius;
    }

    /**
     * @return the followPointer
     */
    public Boolean getFollowPointer() {
        return followPointer;
    }

    /**
     * @param followPointer
     *            the followPointer to set
     */
    public void setFollowPointer(Boolean followPointer) {
        this.followPointer = followPointer;
    }

}
