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
package org.example.entitySystem.entityManager;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import org.example.entitySystem.ComponentManagerModule;
import org.terasology.entitysystem.component.CodeGenComponentManager;
import org.terasology.entitysystem.component.ComponentManager;
import org.terasology.entitysystem.core.EntityManager;
import org.terasology.entitysystem.entity.inmemory.InMemoryEntityManager;
import org.terasology.entitysystem.transaction.TransactionManager;
import org.terasology.valuetype.TypeLibrary;

import javax.inject.Singleton;
import java.lang.reflect.Type;

@Module(includes = {InMemoryEntityManagerModule.BindInMemoryEntityManager.class, ComponentManagerModule.class})
public class InMemoryEntityManagerModule {

    @Provides
    public static InMemoryEntityManager provideInMemoryEntityManager(ComponentManager componentManager,TransactionManager transactionManager){
        return new InMemoryEntityManager(componentManager,transactionManager);
    }

    @Module
    public interface BindInMemoryEntityManager {
        @Binds
        EntityManager bindEntityManager(InMemoryEntityManager entityManager);
    }
}

