package pt.iade.unimanager_db.models;

import java.io.Serializable;

public class PlanId implements Serializable {
    private static final long serialVersionUID = 3103463164387407729L;
    private int unitId;
    private int courseId;

    public PlanId(int unitId,int courseId) {
    }
    public int getUnitId(){
        return unitId;
    }
    public int getCourseId(){
        return courseId;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    @Override
    public boolean equals(Object obj) {
        return obj!=null &&
        obj.getClass() == PlanId.class &&
        ((PlanId)obj).courseId == courseId &&
        ((PlanId)obj).unitId == unitId ;
    }
}
