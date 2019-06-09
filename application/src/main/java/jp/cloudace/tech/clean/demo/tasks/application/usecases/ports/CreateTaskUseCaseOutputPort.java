package jp.cloudace.tech.clean.demo.tasks.application.usecases.ports;


import jp.cloudace.tech.clean.demo.tasks.domain.models.task.Task;

public interface CreateTaskUseCaseOutputPort extends ErrorOutputPort {
    void emitTask(Task task);
}
