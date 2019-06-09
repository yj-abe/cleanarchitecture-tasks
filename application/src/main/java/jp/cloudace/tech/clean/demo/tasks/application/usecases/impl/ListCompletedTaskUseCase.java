package jp.cloudace.tech.clean.demo.tasks.application.usecases.impl;

import java.util.List;

import jp.cloudace.tech.clean.demo.tasks.application.usecases.ports.ListCompletedTaskUseCaseInputPort;
import jp.cloudace.tech.clean.demo.tasks.application.usecases.ports.ListCompletedTaskUseCaseOutputPort;
import jp.cloudace.tech.clean.demo.tasks.domain.models.task.CompletedTask;
import jp.cloudace.tech.clean.demo.tasks.domain.models.task.repositories.CompletedTaskRepository;


public class ListCompletedTaskUseCase implements ListCompletedTaskUseCaseInputPort {

    private final ListCompletedTaskUseCaseOutputPort outputPort;
    private final CompletedTaskRepository repository;

    public ListCompletedTaskUseCase(
            ListCompletedTaskUseCaseOutputPort outputPort,
            CompletedTaskRepository repository
    ) {
        this.outputPort = outputPort;
        this.repository = repository;
    }

    @Override
    public void execute() {
        List<CompletedTask> tasks = repository.listCompletedTask();
        outputPort.emitCompletedTasks(tasks);
    }

}
