package com.sample.cloudapp.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CloudService {

    private Map<String, Map<String, String>> services = new HashMap<>();
    private Map<String, Map<String, Double>> pricing = new HashMap<>();

    public CloudService() {

        services.put("aws", Map.of(
                "Compute", "EC2",
                "Storage", "S3",
                "Database", "RDS",
                "Network", "VPC"
        ));

        services.put("gcp", Map.of(
                "Compute", "Compute Engine",
                "Storage", "Cloud Storage",
                "Database", "Cloud SQL",
                "Network", "VPC"
        ));

        services.put("azure", Map.of(
                "Compute", "Virtual Machines",
                "Storage", "Blob Storage",
                "Database", "SQL Database",
                "Network", "VNet"
        ));

        pricing.put("aws", Map.of("compute", 0.1, "storage", 0.02));
        pricing.put("gcp", Map.of("compute", 0.09, "storage", 0.025));
        pricing.put("azure", Map.of("compute", 0.11, "storage", 0.018));
    }

    public Map<String, String> getServices(String provider) {
        return services.get(provider);
    }

    public double calculateCost(String provider, double hours, double storage) {
        Map<String, Double> p = pricing.get(provider);
        return (hours * p.get("compute") + storage * p.get("storage"));
    }
}