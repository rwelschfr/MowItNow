package org.rwelsch.mowitnow.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Mower {
    private Orientation orientation;
    private Coordinates coordinates;
}
