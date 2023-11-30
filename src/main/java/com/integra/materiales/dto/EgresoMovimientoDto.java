package com.integra.materiales.dto;

import java.util.List;

import com.integra.materiales.model.EgresoMovimiento;

public class EgresoMovimientoDto {
    private String status;
    private int totalResults;
    private List<EgresoMovimiento> items;
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;

    }
    public int getTotalResults() {
        return totalResults;
    }
    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    } 

    public List<EgresoMovimiento> getItems() {
        return items;
    }
    public void setItems(List<EgresoMovimiento> egresos) {
        this.items = egresos;
    }
}
