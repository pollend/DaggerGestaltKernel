/*
 * Copyright 2018 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.example;

import org.example.entitySystem.ComponentManagerModule;
import org.example.entitySystem.entityManager.DaggerInMemoryEntityManagerComponent;
import org.example.entitySystem.entityManager.InMemoryEntityManagerComponent;
import org.example.entitySystem.eventSystem.DaggerEventSystemComponent;
import org.example.entitySystem.eventSystem.EventSystemComponent;
import org.example.entitySystem.eventSystem.EventSystemModule;
import org.example.entitySystem.transactionManager.DaggerTransactionManagerComponent;
import org.example.entitySystem.transactionManager.TransactionManagerComponent;
import org.terasology.entitysystem.component.CodeGenComponentManager;
import org.terasology.entitysystem.event.impl.EventProcessor;
import org.terasology.valuetype.TypeLibrary;

public class Application {

    void onStart(){
        TransactionManagerComponent transactionManagerComponent = DaggerTransactionManagerComponent.builder().build();
        TypeLibrary typeLibrary = new TypeLibrary();
        CodeGenComponentManager codeGenComponentManager = new CodeGenComponentManager(typeLibrary);

        InMemoryEntityManagerComponent entityManagerComponent =  DaggerInMemoryEntityManagerComponent.builder()
                .transactionManagerComponent(transactionManagerComponent)
                .componentManagerModule(new ComponentManagerModule(typeLibrary,codeGenComponentManager)).build();

        EventSystemComponent eventSystem = DaggerEventSystemComponent.builder().eventSystemModule(
                new EventSystemModule(EventProcessor.newBuilder().build()))
                .transactionManagerComponent(transactionManagerComponent).build();

        // rendering backend
        // nui
        // etc ...

        ApplicationComponent app = DaggerApplicationComponent.builder()
                .setEntityManagerComponent(entityManagerComponent)
                .setEventSystemComponent(eventSystem).build();

        app.inject(this);

    }
}
