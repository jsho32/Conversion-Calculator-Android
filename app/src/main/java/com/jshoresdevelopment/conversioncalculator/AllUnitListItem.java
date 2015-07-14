package com.jshoresdevelopment.conversioncalculator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllUnitListItem {
    private String value;
    private String unit;

    public AllUnitListItem(String value, String unit) {
        this.value = value;
        this.unit = unit;
    }
}
