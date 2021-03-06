package com.example.packt.B04676_07_Code;

public class VacuumCleanerFactory {
    public static VacuumCleaner getInstance(String type) {
        VacuumCleaner vucuumCleaner = null;
        if("Dirt".equals(type)) {
            vucuumCleaner = new DirtVacuumCleaner();
        } else if("Water".equals(type)) {
            vucuumCleaner = new WaterVacuumCleaner();
        } else {
            // Handle bad type
        }
        return vucuumCleaner;
    }
}
