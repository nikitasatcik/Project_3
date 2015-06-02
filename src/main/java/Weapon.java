
/**
 * Class for storage entity of XML tags
 * @author Nikita Kolchiba
 */
public class Weapon {
    private String modelName;
    private String serialModel;
    private String origin;
    private int handy;
    protected TTC ttc;

    public Weapon() {
        ttc = new TTC();
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setSerialModel(String serialModel) {
        this.serialModel = serialModel;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setHandy(int handy) {
        this.handy = handy;
    }

    /**
     * Inner class for technical characteristics
     */

    public static class TTC {
        private int maxRange;
        private int deadRange;
        private boolean magazine;
        private boolean optic;

        private TTC() {

        }

        public void setMaxRange(int maxRange) {
            this.maxRange = maxRange;
        }

        public void setDeadRange(int deadRange) {
            this.deadRange = deadRange;
        }

        public void setMagazine(boolean magazine) {
            this.magazine = magazine;
        }

        public void setOptic(boolean optic) {
            this.optic = optic;
        }

        @Override
        public String toString() {
            return "TTC: {" +
                    "maxRange: " + maxRange +
                    ". deadRange: " + deadRange +
                    ". Magazine: " + magazine +
                    ". Optic: " + optic +
                    "}";
        }
    }

    @Override
    public String toString() {
        return "Type: " + this.modelName + ". " +
                "Model: " + serialModel + ". " +
                "Handy: " + this.handy + ". " +
                "Country: " + this.origin + ". " + ttc;
    }
}