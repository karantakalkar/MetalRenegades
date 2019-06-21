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
package org.terasology.metalrenegades.ai.component;

import com.google.common.collect.Lists;
import org.terasology.entitySystem.Component;
import org.terasology.entitySystem.entity.EntityRef;

import java.util.List;

/**
 * A component for buildings with the ability to spawn/provide shelter for residents.
 */
public class PotentialHomeComponent implements Component {

    /**
     * The list of resident characters inside this home.
     */
    public List<EntityRef> residents = Lists.newArrayList();

    /**
     * The maximum number of possible resident characters in this home.
     */
    public int maxResidents = 1;

}