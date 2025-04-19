package com.cims.candidature.strategy;

import com.cims.candidature.entities.CahierCharges;
import org.springframework.stereotype.Component;

@Component("fixedPricingStrategy")
public class FixedPricingStrategy implements PricingStrategy {
    @Override
    public float calculatePrice(CahierCharges cahierCharges) {
        return cahierCharges.getCahierChargesPrix();
    }
}
