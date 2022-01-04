/*
 * Copyright (c) 2021 Otávio Santana and others
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
package org.jnosql.artemis.demo.se.work;

import java.math.BigDecimal;

public class WorkerBuilder {

    private String name;
    private String occupation;
    private BigDecimal salary;

    public WorkerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public WorkerBuilder occupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    public WorkerBuilder salary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public Worker build() {
        return new Worker(name, occupation, salary);
    }
}