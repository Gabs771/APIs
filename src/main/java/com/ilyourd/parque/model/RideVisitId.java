package com.ilyourd.parque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable 

public class RideVisitId implements Serializable {

    @Column(name = "id_visit")
    private Long idVisit;

    @Column(name = "visit_dt")
    private LocalDate visitDt;

    public RideVisitId() {}

    public RideVisitId(Long idVisit, LocalDate visitDt) {
        this.idVisit = idVisit;
        this.visitDt = visitDt;
    }

    public Long getIdVisit() { return idVisit; }
    public void setIdVisit(Long idVisit) { this.idVisit = idVisit; }

    public LocalDate getVisitDt() { return visitDt; }
    public void setVisitDt(LocalDate visitDt) { this.visitDt = visitDt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RideVisitId)) return false;
        RideVisitId that = (RideVisitId) o;
        return Objects.equals(idVisit, that.idVisit) &&
               Objects.equals(visitDt, that.visitDt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVisit, visitDt);
    }
}