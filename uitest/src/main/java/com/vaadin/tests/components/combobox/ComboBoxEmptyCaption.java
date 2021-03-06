/*
 * Copyright 2000-2016 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.tests.components.combobox;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.vaadin.server.VaadinRequest;
import com.vaadin.tests.components.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;

/**
 * @author Vaadin Ltd
 *
 */
public class ComboBoxEmptyCaption extends AbstractTestUI {

    @Override
    protected void setup(VaadinRequest request) {
        ComboBox<String> combo = new ComboBox<>();
        combo.setItems(
                IntStream.range(1, 100).mapToObj(number -> "item" + number)
                        .collect(Collectors.toList()));
        addComponent(combo);
        Button setCaption = new Button("Set empty selection caption to 'empty'",
                event -> combo.setEmptySelectionCaption("empty"));
        Button resetCaption = new Button(
                "Set empty selection caption to empty string",
                event -> combo.setEmptySelectionCaption(""));
        Button disableCaption = new Button("Disable empty selection caption",
                event -> combo.setEmptySelectionAllowed(false));
        addComponents(setCaption, resetCaption, disableCaption);
    }
}
