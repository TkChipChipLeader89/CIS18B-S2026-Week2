package edu.norcocollege.cis18b.week2.alerts;

/**
 * TODO:
 *  - Convert this class into a Java 17+ record
 *  - Include the following fields:
 *      String id
 *      String sourceSystem
 *      String severity
 *      String description
 *      long timestamp
 *
 *  - (Optional stretch) Add validation in a compact constructor
 */
public record SecurityAlert(
    String id,
    String sourceSystem,
    String severity,
    String description,
    long timestamp
) {
    //Validate fields in compact constructor
    public SecurityAlert {
        if(id==null||id.isBlank()){
            throw new IllegalArgumentException("ID cannot be null or blank");
        }
        if(sourceSystem==null||sourceSystem.isBlank()){
            throw new IllegalArgumentException("Source system cannot be null or blank");
        }
        if(severity==null||severity.isBlank()){
            throw new IllegalArgumentException("Severity cannot be null or blank");
        }
        if(description==null||description.isBlank()){
            throw new IllegalArgumentException("Description cannot be null or blank");
        }
        if(timestamp<=0){
            throw new IllegalArgumentException("Timestamp must be a positive value");
        }
    }
}
