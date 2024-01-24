package model;

import dao.GoalDetailsDAO;

public class SetGoalDetailLogic {

	public GoalDetail execute(GoalDetail settingGoalDetail) {
		GoalDetailsDAO dao = new GoalDetailsDAO();
		GoalDetail goalDetail = dao.setGoalDetail(settingGoalDetail);
		return goalDetail;
	}

}
