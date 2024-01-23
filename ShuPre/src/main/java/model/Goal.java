package model;

import java.io.Serializable;
import java.util.Date;

public class Goal implements Serializable {
    private int goalId;
    private String goalName;
    private int userId;
    private Date dateStart;
    private Date dateEnd;
    private int statusTypeId;

    public Goal(int goalId, String goalName, int userId, Date dateStart, Date dateEnd, int statusTypeId) {
        this.goalId = goalId;
        this.goalName = goalName;
        this.userId = userId;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.statusTypeId = statusTypeId;
    }

    // ゲッターメソッド
    public int getGoalId() {
        return goalId;
    }

    public String getGoalName() {
        return goalName;
    }

    public int getUserId() {
        return userId;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public int getStatusTypeId() {
        return statusTypeId;
    }

    // セッターメソッド
    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setStatusTypeId(int statusTypeId) {
        this.statusTypeId = statusTypeId;
    }
}
