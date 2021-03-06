/*
 * Copyright 2008-2009 Oliver Zoran
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vaadin.addon.timeline.gwt.canvas.client.impl;

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

import com.google.gwt.user.client.Element;
import com.vaadin.client.VConsole;

/**
 * The Opera implementation of the canvas widget.
 */
public class CanvasImplOpera extends CanvasImpl {

    @Override
    public void init(Element element) {
        super.init(element);
        VConsole.log("Using Opera canvas implementation");
    }

    @Override
    public void clear() {
        super.beginPath();
        super.clear();
    }

    @Override
    public void fillRect(double x, double y, double w, double h) {
        super.beginPath();
        super.fillRect(x, y, w, h);
    }

    @Override
    public void strokeRect(double x, double y, double w, double h) {
        super.beginPath();
        super.strokeRect(x, y, w, h);
    }
}
