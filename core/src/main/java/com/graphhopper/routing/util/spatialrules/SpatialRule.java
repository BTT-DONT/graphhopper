/*
 *  Licensed to GraphHopper GmbH under one or more contributor
 *  license agreements. See the NOTICE file distributed with this work for
 *  additional information regarding copyright ownership.
 *
 *  GraphHopper GmbH licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except in
 *  compliance with the License. You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.graphhopper.routing.util.spatialrules;

import com.graphhopper.routing.ev.RoadAccess;
import com.graphhopper.routing.ev.RoadClass;

import java.util.List;

import com.graphhopper.routing.util.TransportationMode;
import org.locationtech.jts.geom.Polygon;

/**
 * Defines rules that are valid for a certain region, e.g. a country.
 * A rule defines access, max-speed, etc. dependent on this region.
 * <p>
 * Every SpatialRule has a set of borders. The rules are valid inside of these borders.
 *
 * @author Robin Boldt
 */
public interface SpatialRule {

    /**
     * Returns the borders in which the SpatialRule is valid
     */
    List<Polygon> getBorders();

    /**
     * Returns the priority of the rule. If multiple rules overlap they're
     * processed in natural order of their priority.
     * 
     * @return the priority as an integer value between
     *         {@link Integer#MIN_VALUE} (minimum priority) and
     *         {@link Integer#MAX_VALUE} (maximum priority)
     */
    int getPriority();

    /**
     * Returns the id for this rule, e.g. the ISO name of the country. The id has to be unique.
     */
    String getId();
}
