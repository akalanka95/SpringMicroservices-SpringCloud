package com.akalanka.springmicroservice.limitservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LimitConfiguration {

    private int min;
    private int max;

   /*public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public LimitConfiguration() {
    }

    public LimitConfiguration(int min, int max) {
        this.min = min;
        this.max = max;
    }*/
}
