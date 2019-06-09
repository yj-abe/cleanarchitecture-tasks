package jp.cloudace.tech.clean.demo.tasks.application.usecases.impl;

import java.util.List;

import jp.cloudace.tech.clean.demo.tasks.application.usecases.ports.ListTasksUseCaseInputPort;
import jp.cloudace.tech.clean.demo.tasks.application.usecases.ports.ListTasksUseCaseOutputPort;
import jp.cloudace.tech.clean.demo.tasks.domain.models.task.Task;
import jp.cloudace.tech.clean.demo.tasks.domain.models.task.repositories.TaskRepository;

public class ListTasksUseCase implements ListTasksUseCaseInputPort {

    private final TaskRepository repository;
    private final ListTasksUseCaseOutputPort outputPort;

    public ListTasksUseCase(TaskRepository repository, ListTasksUseCaseOutputPort outputPort) {
        this.repository = repository;
        this.outputPort = outputPort;
    }

    @Override
    public void execute() {
        List<Task> tasks = repository.list();
        outputPort.emitTasks(tasks);
    }

}
