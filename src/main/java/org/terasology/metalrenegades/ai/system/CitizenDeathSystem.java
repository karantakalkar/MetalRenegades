// Copyright 2020 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0

package org.terasology.metalrenegades.ai.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.terasology.entitySystem.entity.EntityRef;
import org.terasology.entitySystem.event.EventPriority;
import org.terasology.entitySystem.event.ReceiveEvent;
import org.terasology.entitySystem.systems.BaseComponentSystem;
import org.terasology.entitySystem.systems.RegisterMode;
import org.terasology.entitySystem.systems.RegisterSystem;
import org.terasology.logic.health.BeforeDestroyEvent;
import org.terasology.metalrenegades.ai.component.CitizenComponent;
import org.terasology.metalrenegades.ai.event.CitizenDeathEvent;
import org.terasology.metalrenegades.minimap.events.RemoveCharacterFromOverlayEvent;

/**
 * System to handle Citizen Deaths within Metal Renegades
 */

@RegisterSystem(value = RegisterMode.AUTHORITY)
public class CitizenDeathSystem extends BaseComponentSystem {

    Logger logger = LoggerFactory.getLogger(CitizenDeathSystem.class);


    @ReceiveEvent(priority = EventPriority.PRIORITY_HIGH)
    public void onEntityDestroyed(BeforeDestroyEvent event, EntityRef entityRef,
                                  CitizenComponent citizenComponent) {
        entityRef.send(new CitizenDeathEvent());
        event.consume();
    }

    @ReceiveEvent
    public void onCitizenDeath(CitizenDeathEvent event, EntityRef entityRef) {
        entityRef.send(new RemoveCharacterFromOverlayEvent());
        logger.info("{} has died ", entityRef.toString());
        entityRef.destroy();

    }
}
