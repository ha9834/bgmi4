package com.amazonaws.regions;

/* loaded from: classes.dex */
public enum Regions {
    GovCloud("us-gov-west-1"),
    US_EAST_1("us-east-1"),
    US_EAST_2("us-east-2"),
    US_WEST_1("us-west-1"),
    US_WEST_2("us-west-2"),
    EU_WEST_1("eu-west-1"),
    EU_WEST_2("eu-west-2"),
    EU_CENTRAL_1("eu-central-1"),
    AP_SOUTH_1("ap-south-1"),
    AP_SOUTHEAST_1("ap-southeast-1"),
    AP_SOUTHEAST_2("ap-southeast-2"),
    AP_NORTHEAST_1("ap-northeast-1"),
    AP_NORTHEAST_2("ap-northeast-2"),
    SA_EAST_1("sa-east-1"),
    CA_CENTRAL_1("ca-central-1"),
    CN_NORTH_1("cn-north-1");

    private final String name;
    public static final Regions DEFAULT_REGION = US_WEST_2;

    Regions(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Regions fromName(String str) {
        for (Regions regions : values()) {
            if (str.equals(regions.getName())) {
                return regions;
            }
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
