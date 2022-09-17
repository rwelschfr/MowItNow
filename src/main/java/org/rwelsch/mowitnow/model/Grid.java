package org.rwelsch.mowitnow.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Builder
@Value
@Getter
public class Grid {
    private Coordinates topRightCornerCoordinates;
}
