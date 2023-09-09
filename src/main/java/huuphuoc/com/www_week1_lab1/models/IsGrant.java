package huuphuoc.com.www_week1_lab1.models;

public enum IsGrant {
    VALUE_ONE(1),
    VALUE_ZERO(0),
    VALUE_MINUS_ONE(-1);

    private final int value;

    private IsGrant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
