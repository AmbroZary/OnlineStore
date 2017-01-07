package warehouse.domain.ProductAggregate;

public enum Size {
    UNI, XS, S, M, L, XL, XXl, XXXl, XXXXL;

    public static int evaluateSize(Size size) {
        switch (size) {
            case UNI:
                return 0;
            case XS:
                return 1;
            case S:
                return 2;
            case M:
                return 3;
            case L:
                return 4;
            case XL:
                return 5;
            case XXl:
                return 6;
            case XXXl:
                return 7;
            case XXXXL:
                return 8;
            default:
                return 0;
        }
    }
}
