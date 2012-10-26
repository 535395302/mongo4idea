/*
 * Copyright (c) 2012 David Boissier
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codinjutsu.tools.mongo.view;

import com.mongodb.DBObject;
import org.codinjutsu.tools.mongo.model.MongoCollectionResult;
import org.codinjutsu.tools.mongo.view.model.JsonTreeModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MongoRunnerPanel extends JPanel {
    private JPanel rootPanel;
    private final JsonTreeView jsonResultTree = new JsonTreeView();

    public MongoRunnerPanel() {
        rootPanel.setLayout(new BorderLayout());
        rootPanel.add(new JScrollPane(jsonResultTree), BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(rootPanel);

        jsonResultTree.setVisible(false);
    }

    public void showResults(MongoCollectionResult mongoCollectionResult) {
        jsonResultTree.invalidate();
        jsonResultTree.setVisible(true);
        jsonResultTree.setModel(new JsonTreeModel(mongoCollectionResult));
        jsonResultTree.validate();
    }
}
