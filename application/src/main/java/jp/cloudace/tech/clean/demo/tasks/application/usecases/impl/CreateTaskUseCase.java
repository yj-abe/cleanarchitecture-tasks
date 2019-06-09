package jp.cloudace.tech.clean.demo.tasks.application.usecases.impl;


import jp.cloudace.tech.clean.demo.tasks.application.usecases.ports.CreateTaskUseCaseInputPort;
import jp.cloudace.tech.clean.demo.tasks.application.usecases.ports.CreateTaskUseCaseOutputPort;
import jp.cloudace.tech.clean.demo.tasks.domain.models.task.Task;
import jp.cloudace.tech.clean.demo.tasks.domain.models.task.repositories.TaskRepository;
import jp.cloudace.tech.clean.demo.tasks.domain.models.task.valueobject.TaskDescription;
import jp.cloudace.tech.clean.demo.tasks.domain.models.task.valueobject.TaskName;

public final class CreateTaskUseCase implements CreateTaskUseCaseInputPort {

    private final CreateTaskUseCaseOutputPort outputPort;
    private final TaskRepository repository;

    public CreateTaskUseCase(CreateTaskUseCaseOutputPort outputPort, TaskRepository repository) {
        this.outputPort = outputPort;
        this.repository = repository;
    }

    @Override
    public void execute(String name, String description) {

        TaskName taskName = new TaskName(name);
        TaskDescription taskDescription = new TaskDescription(description);
        Task task = Task.Factory.createModelForRegister(taskName, taskDescription);
        String[] errors = task.validate();

        if (errors != null) {
            outputPort.showErrors(errors);
        } else {
            Task registeredTask = repository.create(task);
            outputPort.emitTask(registeredTask);
        }

    }

}
