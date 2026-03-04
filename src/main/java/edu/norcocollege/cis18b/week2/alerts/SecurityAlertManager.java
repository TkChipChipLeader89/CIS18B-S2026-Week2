package edu.norcocollege.cis18b.week2.alerts;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

/**
 * TODO:
 *  - Store alerts in an internal List
 *  - Implement all required methods
 *  - Use Streams where appropriate
 *  - Use Optional instead of returning null
 *  - Use a modern switch expression
 */
public class SecurityAlertManager {

    // TODO: Declare a private List<SecurityAlert> to store alerts
    private List<SecurityAlert> alerts = new ArrayList<>();
    /**
     * TODO:
     *  - Reject null
     *  - Add alert to internal list
     */
    public void addAlert(SecurityAlert alert) {
        //validate alert & add to list
        if(alert==null){
            throw new IllegalArgumentException("Alert cannot be null");
        }
        alerts.add(alert);
    }

    /**
     * TODO:
     *  - Return Optional.empty() if id is null
     *  - Use streams to find first match
     */
    public Optional<SecurityAlert> findById(String id) {
        //validate id & find alert
        if(id==null){
            return Optional.empty();
        }
        return alerts.stream()
            .filter(a->a.id().equals(id))
            .findFirst();
    }

    /**
     * TODO:
     *  - Return empty list if severity is null
     *  - Use streams to filter by severity
     */
    public List<SecurityAlert> findBySeverity(String severity) {
        //validate severity & filter alerts
        if(severity==null){
            return List.of();
        }
        return alerts.stream()
            .filter(a->a.severity().equalsIgnoreCase(severity))
            .toList();
    }

    /**
     * TODO:
     *  - Remove alert by ID
     *  - Return true if removed, false otherwise
     */
    public boolean removeAlert(String id) {
        //validate id & remove alert
        if(id==null){
            return false;
        }
        return alerts.removeIf(a->a.id().equals(id));
    }

    /**
     * TODO:
     *  - Reject null alert
     *  - Use pattern matching with instanceof
     *  - Use modern switch expression
     *  - Throw IllegalArgumentException for unknown severity
     */
    public String getSeverityRecommendation(Object alert) {
        //validate alert
        if(alert==null){
            throw new IllegalArgumentException("Alert cannot be null");
        }
        //pattern match alert & determine recommendation
        if(alert instanceof SecurityAlert a){
            return switch(a.severity().toUpperCase()){
                case "LOW"->"Log and monitor.";
                case "MEDIUM"->"Investigate within 24 hours.";
                case "HIGH"->"Escalate to engineering.";
                case "CRITICAL"->"Immediate incident response required.";
                default -> throw new IllegalArgumentException("Unknown severity: "+a.severity());
            };
        }
        //the provided object wasn't a SecurityAlert
        throw new IllegalArgumentException("Expected SecurityAlert instance");
    }
}