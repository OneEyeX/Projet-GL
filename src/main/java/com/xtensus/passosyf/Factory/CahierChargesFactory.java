public class CahierChargesFactory {
    public static CahierCharges createWithPrix(float prix) {
        CahierCharges c = new CahierCharges();
        c.setCahierChargesPrix(prix);
        return c;
    }
}
