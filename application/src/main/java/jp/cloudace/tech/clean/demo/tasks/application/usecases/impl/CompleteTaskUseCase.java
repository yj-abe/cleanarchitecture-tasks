package jp.cloudace.tech.clean.demo.tasks.application.usecases.impl;


import jp.cloudace.tech.clean.demo.tasks.application.usecases.ports.CompleteTaskUseCaseInputPort;
import jp.cloudace.tech.clean.demo.tasks.application.usecases.ports.CompleteTaskUseCaseOutputPort;
import jp.cloudace.tech.clean.demo.tasks.domain.models.task.CompletedTask;
import jp.cloudace.tech.clean.demo.tasks.domain.models.task.Task;
import jp.cloudace.tech.clean.demo.tasks.domain.models.task.repositories.CompletedTaskRepository;
import jp.cloudace.tech.clean.demo.tasks.domain.models.task.repositories.TaskRepository;
import jp.cloudace.tech.clean.demo.tasks.domain.models.task.valueobject.TaskId;

public class CompleteTaskUseCase implements CompleteTaskUseCaseInputPort {

    private final CompleteTaskUseCaseOutputPort outputPort;
    private final TaskRepository taskRepository;
    private final CompletedTaskRepository completedTaskRepository;

    public CompleteTaskUseCase(
            CompleteTaskUseCaseOutputPort outputPort,
            TaskRepository taskRepository,
            CompletedTaskRepository completedTaskRepository
    ) {
        this.outputPort = outputPort;
        this.taskRepository = taskRepository;
        this.completedTaskRepository = completedTaskRepository;
    }

    @Override
    public void execute(String id) {

        TaskId taskId = new TaskId(id);
        Task task = taskRepository.get(taskId);

        if (task == null) {
            outputPort.showErrors(new String[]{"taskId:" + id + " is not found."});
            return;
        }

        CompletedTask completedTask = task.complete();
        taskRepository.delete(taskId);
        completedTaskRepository.create(completedTask);
        outputPort.emitCompletedTaskId(completedTask.getId().getValue());

    }
}
