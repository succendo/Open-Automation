package openautomation.OpenAutomation.Triggers;

import openautomation.OpenAutomation.Task;

public interface ITrigger {
	public Boolean isTriggered(Task task);
}
