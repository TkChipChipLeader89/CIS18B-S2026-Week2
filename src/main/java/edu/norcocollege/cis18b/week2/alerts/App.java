package edu.norcocollege.cis18b.week2.alerts;
import edu.norcocollege.cis18b.week2.alerts.SecurityAlert;
import edu.norcocollege.cis18b.week2.alerts.SecurityAlertManager;
import java.util.List;

/**
 * Entry point for Week 1.
 *
 * TODO:
 *  - Create at least 3 SecurityAlert objects
 *  - Add them to SecurityAlertManager
 *  - Print a formatted report using a text block
 *  - Demonstrate calling at least one manager method
 */
public class App {

    public static void main(String[] args) {

        // TODO: Create SecurityAlertManager instance
        SecurityAlertManager manager = new SecurityAlertManager();

        // TODO: Create multiple SecurityAlert records
        // Example:
        // var alert1 = new SecurityAlert(...);
        var alert1=new SecurityAlert("C1", "Network", "HIGH", "Unusual traffic detected", System.currentTimeMillis());
        var alert2=new SecurityAlert("D2", "Application", "MEDIUM", "Failed login attempts", System.currentTimeMillis());
        var alert3=new SecurityAlert("A3", "Database", "CRITICAL", "Data breach detected", System.currentTimeMillis());
        var alert4=new SecurityAlert("F4", "Endpoint", "LOW", "Outdated antivirus software", System.currentTimeMillis());

        // TODO: Add alerts to manager
        manager.addAlert(alert1);
        manager.addAlert(alert2);
        manager.addAlert(alert3);
        manager.addAlert(alert4);

        // TODO: Query by severity and print results
        List<SecurityAlert>highAlerts=manager.findBySeverity("HIGH");
        System.out.println("High Severity Alerts:");
        highAlerts.forEach(a->System.out.println("- "+a.description()));
        
        // TODO: Print formatted report using text block
        var total = manager.findBySeverity("LOW").size() + manager.findBySeverity("MEDIUM").size() + manager.findBySeverity("HIGH").size() + manager.findBySeverity("CRITICAL").size();
        var highCount = manager.findBySeverity("HIGH").size();
        System.out.println("""
            === SECURITY ALERT REPORT ===
            Total Alerts: %d
            High Severity Alerts: %d
            """.formatted(total, highCount));
    }
}