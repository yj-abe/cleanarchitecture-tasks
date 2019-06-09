package jp.cloudace.tech.clean.demo.tasks.application.usecases.ports;

import java.util.List;

import jp.cloudace.tech.clean.demo.tasks.domain.models.task.Task;

public interface ListTasksUseCaseOutputPort {
    void emitTasks(List<Task> tasks);
}
