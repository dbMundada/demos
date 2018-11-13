/*
 * Copyright (c) 2017 Otávio Santana and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 * You may elect to redistribute this code under either of these licenses.
 *
 * Contributors:
 *
 * Otavio Santana
 */

package org.jnosql.artemis.demo.se.couchdb;


import org.jnosql.artemis.PreparedStatement;
import org.jnosql.artemis.document.DocumentTemplate;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.Collections;
import java.util.List;

public class App2 {



    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            Hero ironMan = Hero.builder().withRealName("Tony Stark").withName("iron_man")
                    .withAge(34).withPowers(Collections.singleton("rich")).build();
            DocumentTemplate template = container.select(DocumentTemplate.class).get();

            template.update(ironMan);

            PreparedStatement prepare = template.prepare("select * from Hero where realName =@name");
            List<Hero> heroes = prepare.bind("name", "Tony Stark").getResultList();
            System.out.println(heroes);
            System.out.println(template.query("select * from Hero where _id = 'iron_man'"));

        }
    }

    private App2() {
    }
}
