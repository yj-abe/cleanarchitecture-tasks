package jp.cloudace.tech.clean.demo.tasks.domain.models.task.repositories;

import java.util.List;

import jp.cloudace.tech.clean.demo.tasks.domain.models.task.Task;
import jp.cloudace.tech.clean.demo.tasks.domain.models.task.valueobject.TaskId;

public interface TaskRepository {

    List<Task> list();

    Task get(TaskId id);

    Task create(Task task);

    void delete(TaskId id);

}
