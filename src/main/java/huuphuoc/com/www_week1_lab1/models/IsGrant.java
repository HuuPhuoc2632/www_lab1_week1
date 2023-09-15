package huuphuoc.com.www_week1_lab1.models;

public enum IsGrant {
    disable(0),
    enable(-1);

    private final int value;

    private IsGrant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
