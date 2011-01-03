/**
 *  Licensed to the OpenXdata Foundation (OXDF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The OXDF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at <p>
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  </p>
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and limitations under the License.
 *
 *  Copyright 2010 http://www.openxdata.org.
 */
package org.openxdata.server.admin.model;

import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author Jonny Heggheim
 */
public class UserTest {

    private static final int ROLE_COUNT = 100;
    private User dummyUser;
    private Set<Role> roles;

    @Before
    public void createUser() {
        dummyUser = new User("user", "password");
    }

    @Before
    public void createRoles() {
        roles = new HashSet<Role>(ROLE_COUNT);
        for (int i = 0; i < ROLE_COUNT; i++) {
            roles.add(new Role("Role" + i));
        }
    }

    @Test
    public void testRemoveRole() {
        dummyUser.setRoles(roles);
        assertEquals(ROLE_COUNT, dummyUser.getRoles().size());

        dummyUser.removeRole(new Role("Role50"));
        assertEquals(ROLE_COUNT - 1, dummyUser.getRoles().size());

        dummyUser.removeRole(new Role("Role1"));
        assertEquals(ROLE_COUNT - 2, dummyUser.getRoles().size());

        dummyUser.removeRole(new Role("Role99"));
        assertEquals(ROLE_COUNT - 3, dummyUser.getRoles().size());
    }

    public void testAddRole() {
        assertTrue(dummyUser.getRoles().isEmpty());
        dummyUser.addRole(new Role("Role1"));
        assertEquals(1, dummyUser.getRoles().size());

        dummyUser.addRole(new Role("Role2"));
        assertEquals(2, dummyUser.getRoles().size());

        dummyUser.addRole(new Role("Role2"));
        assertEquals(2, dummyUser.getRoles().size());
    }
}
