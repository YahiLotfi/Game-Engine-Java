package physicEngine;

public class Bounds {

        private float width;
        private float height;
        private float x;
        private float y;

        public Bounds(float width, float height, float x, float y) {
            this.width = width;
            this.height = height;
            this.x = x;
            this.y = y;
        }

        // Getters for the bounds variables
        public float getMiddleTopX() {
            return x + (width / 2);
        }

        public float getMiddleTopY() {
            return y ;
        }

        public float getMiddleLeftX() {
            return x;
        }

        public float getMiddleLeftY() {
            return y + (height / 2);
        }

        public float getMiddleRightX() {
            return x + width;
        }

        public float getMiddleRightY() {
            return y + (height / 2);
        }

        public float getMiddleDownX() {
            return x + (width / 2);
        }

        public float getMiddleDownY() {
            return y + height;
        }

        // Update bounds based on current properties
        public void updateBounds(float width, float height, float x, float y) {
            this.width = width;
            this.height = height;
            this.x = x;
            this.y = y;
        }

    public float getWidth() { return this.width;
    }

    public float getHeight() { return this.height;
    }
}

