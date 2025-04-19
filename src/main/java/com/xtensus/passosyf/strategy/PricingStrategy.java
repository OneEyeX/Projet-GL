package com.cims.candidature.strategy;

import com.cims.candidature.entities.CahierCharges;

public interface PricingStrategy {
    float calculatePrice(CahierCharges cahierCharges);
}
